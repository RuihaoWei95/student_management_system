package cm.stu.service;

import cm.stu.bean.StudentCourse;

import java.util.List;

public interface StudentService {
    List<StudentCourse> getCourseGrades(String userAccount1);

    List<StudentCourse> getEnrolledCourse(String userAccount1);
}
