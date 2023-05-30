package cm.stu.dao;

import cm.stu.bean.Course;
import cm.stu.bean.StudentCourse;

import java.util.List;

public class StudentDaoImpl implements StudentDao{
    //jiahui  edit here
    @Override
    public List<StudentCourse>getCourseGrades(String userAccount){
        String sql = "SELECT * FROM studentcourse WHERE userAccount = '" + userAccount + "' AND score IS NOT NULL";
        return Deal.getStudentCourse(sql);
    }

    @Override
    public List<StudentCourse>getEnrolledCourse(String userAccount){
        String sql = "SELECT * FROM studentcourse WHERE userAccount = '" + userAccount + "'";
        return Deal.getStudentCourse(sql);
    }

    @Override
    public void addClass(String uid, String userAccount, String courseId, Double score) throws Exception {
        String sql = "insert into studentcourse values('"+uid+"','"+userAccount+"','"+courseId+"','"+0+"')";
        Deal.deal(sql);
    }

    @Override
    public List<Course> getAllCourse() {
        String sql = "SELECT * FROM course";
        return Deal.getAllCourse(sql);
    }

    @Override
    public List<Course> getSearchCourse(String matchText) {
        String sql =  "SELECT * FROM course WHERE CourseName = '" + matchText + "' OR CourseTime LIKE '%" + matchText + "%';";
        return Deal.getAllCourse(sql);
    }

    @Override
    public void deleteMyClass(String userAccount, String courseId) throws Exception {
        String sql = "DELETE FROM `studentCourse` WHERE `userAccount`='"+userAccount+"'AND `courseId`='"+ courseId+"'";
        //System.out.println(sql);
        Deal.deal(sql);
    }

    @Override
    public List<Course> getMyClass(String userAccount) {
        String sql = "SELECT c.CourseId, c.CourseName, c.CourseTime FROM studentcourse sc INNER JOIN course c ON sc.courseId = c.courseId WHERE userAccount = ?;";
        return Deal.getAllSCourse(sql, userAccount);
    }
}
