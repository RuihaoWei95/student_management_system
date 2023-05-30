package cm.stu.service;

import cm.stu.bean.Course;
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

    @Override
    public void addClass(String uid, String userAccount, String courseId, Double score) throws Exception {
        sd.addClass(uid,userAccount,courseId,score);
    }

    @Override
    public List<Course> getAllCourse() {
        return sd.getAllCourse();
    }

    @Override
    public List<Course> getSearchCourse(String matchText) {
        return sd.getSearchCourse(matchText);
    }

    @Override
    public void deleteMyClass(String userAccount, String courseId) throws Exception {
        sd.deleteMyClass(userAccount,courseId);
    }

    @Override
    public List<Course> getMyClass(String userAccount) {
        return sd.getMyClass(userAccount);
    }



}
