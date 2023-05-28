package cm.stu.service;

import cm.stu.bean.*;

import java.util.List;

public interface TeacherService {
    List AllStudentsByTeacherAccount(String userAccount);

    List<Task> getAllMyTask(String userAccount);

    List<StudentAnswer> getTaskDetail(String taskAccount);

    List<Course> getAllMyCourse(String userAccount);

    List<CourseGrade> getAllMyCourseGrade(String userAccount);

    List<StudentGrade> getStudentGrade(String courseId);
}
