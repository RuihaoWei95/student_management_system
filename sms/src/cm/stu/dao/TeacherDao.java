package cm.stu.dao;

import cm.stu.bean.*;

import java.util.List;

public interface TeacherDao {

    List<CourseGrade> getAllMyCourseGrade(String userAccount);

    List<StudentGrade> getStudentGrade(String courseId);

    void editScore(String studentAccount, String courseId, double score) throws Exception;
}
