package cm.stu.service;

import cm.stu.bean.*;
import cm.stu.dao.TeacherDao;
import cm.stu.dao.TeacherDaoImpl;

import java.util.List;

public class TeacherServiceImpl implements TeacherService{
    TeacherDao td = new TeacherDaoImpl();

    @Override
    public List<CourseGrade> getAllMyCourseGrade(String userAccount) {
        return td.getAllMyCourseGrade(userAccount);
    }

    @Override
    public List<StudentGrade> getStudentGrade(String courseId) {
        return td.getStudentGrade(courseId);
    }

}
