package cm.stu.service;

import cm.stu.bean.Course;
import cm.stu.bean.StudentCourse;

import java.util.List;

public interface StudentService {
    List<StudentCourse> getCourseGrades(String userAccount1);

    List<StudentCourse> getEnrolledCourse(String userAccount1);

    void addClass(String uid, String userAccount, String courseId, Double score) throws Exception;

    List<Course> getAllCourse();

    List<Course> getSearchCourse(String matchText);

    void deleteMyClass(String userAccount, String courseId) throws Exception;

    List<Course> getMyClass(String userAccount);
}
