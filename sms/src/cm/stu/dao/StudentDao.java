package cm.stu.dao;

import cm.stu.bean.StudentCourse;

import java.util.List;

public interface StudentDao {
    List<StudentCourse> getCourseGrades(String userAccount);

    List<StudentCourse> getEnrolledCourse(String userAccount);
}
