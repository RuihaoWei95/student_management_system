package cm.stu.dao;

import cm.stu.bean.*;


import java.util.List;

public class TeacherDaoImpl implements TeacherDao{

    @Override
    public List<CourseGrade> getAllMyCourseGrade(String userAccount) {
        String sql = "SELECT c.courseName, c.courseTime, c.courseId, MIN(sc.score) as low, AVG(sc.score) as mean, MAX(sc.score) as high FROM course c LEFT JOIN teachercourse tc ON c.CourseId = tc.courseID LEFT JOIN studentcourse sc ON tc.courseID = sc.courseId GROUP BY c.courseID, tc.userAccount HAVING userAccount = '"+ userAccount + "'";
        return Deal.getAllCourseGrade(sql);
    }

    @Override
    public List<StudentGrade> getStudentGrade(String courseId) {
        String sql = "SELECT p.userAccount, p.userName, p.userIdCard, sc.score FROM course c INNER JOIN studentcourse sc ON c.courseId = sc.courseId INNER JOIN person p ON sc.userAccount = p.userAccount WHERE c.courseId = '" + courseId + "' ORDER BY sc.score DESC";
        //System.out.println(sql);
        return Deal.getStudentGrade(sql);
    }

    @Override
    public void editScore(String studentAccount, String courseId, double score) throws Exception {
        String sql = "UPDATE studentcourse SET score = '"+score+"' WHERE userAccount = '"+studentAccount+"' AND courseId = '"+courseId+ "'";
        //System.out.println(sql);
        Deal.deal(sql);
    }
}
