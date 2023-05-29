package cm.stu.service;

import cm.stu.bean.StudentCourse;
import cm.stu.dao.StudentDao;
import cm.stu.dao.StudentDaoImpl;

import java.util.List;

public class StudentServiceImpl implements StudentService{
    StudentDao sd = new StudentDaoImpl();

    @Override
    public List<StudentCourse> getCourseGrades(String userAccount) {
        return sd.getCourseGrades(userAccount);
    }

    @Override
    public List<StudentCourse> getEnrolledCourse(String userAccount) {
        return sd.getEnrolledCourse(userAccount);
    }
}
