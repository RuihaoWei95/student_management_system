package cm.stu.dao;

import cm.stu.bean.*;


import java.util.List;

public class TeacherDaoImpl implements TeacherDao{

    @Override
    public List AllStudentsByTeacherAccount(String userAccount) {
        String sql = "Select * FROM person WHERE userAccount IN (SELECT userAccount FROM userteacher WHERE teacherAccount='"+userAccount+"')";
        return Deal.getAllPerson(sql);
    }

    @Override
    public List<Task> getAllMyTask(String userAccount) {
        String sql = "SELECT * FROM task WHERE teacherAccount = '" + userAccount+"'";
        return Deal.getAllTask(sql);
    }

    @Override
    public List<StudentAnswer> getTaskDetail(String taskAccount) {
        String sql ="SELECT s.*,p.`userName`,`taskName` FROM `studenttask` s  INNER JOIN person p ON s.`studentAccount`=p.`userAccount` INNER JOIN task t ON s.`taskAccount`=t.taskAccount WHERE s.`taskAccount`='"+taskAccount+"'";
        return Deal.getTaskDetail(sql);
    }

    @Override
    public List<Course> getAllMyCourse(String userAccount) {
        String sql = "SELECT c.* FROM course c WHERE c.CourseId IN (SELECT courseId FROM `teachercourse` WHERE userAccount='"+userAccount+"')";
        return Deal.getAllCourse(sql);
    }

    @Override
    public List<CourseGrade> getAllMyCourseGrade(String userAccount) {
        String sql = "SELECT c.courseName, c.courseTime, c.courseId, MIN(sc.score) as low, AVG(sc.score) as mean, MAX(sc.score) as high FROM course c LEFT JOIN teachercourse tc ON c.CourseId = tc.courseID LEFT JOIN studentcourse sc ON tc.courseID = sc.courseId GROUP BY c.courseID, tc.userAccount HAVING userAccount = '"+ userAccount + "'";
        return Deal.getAllCourseGrade(sql);
    }

    @Override
    public List<StudentGrade> getStudentGrade(String courseId) {
        String sql = "SELECT p.userName, p.userIdCard, sc.score FROM course c INNER JOIN studentcourse sc ON c.courseId = sc.courseId INNER JOIN person p ON sc.userAccount = p.userAccount WHERE c.courseId = '" + courseId + "' ORDER BY sc.score DESC";
        System.out.println(sql);
        return Deal.getStudentGrade(sql);
    }
}
