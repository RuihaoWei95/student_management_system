package cm.stu.dao;

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
}
