package cm.stu.service;

import cm.stu.bean.*;

import java.util.List;

public interface TeacherService {

    List<CourseGrade> getAllMyCourseGrade(String userAccount);

    List<StudentGrade> getStudentGrade(String courseId);

    void editScore(String studentAccount, String courseId, double score) throws Exception;
}
