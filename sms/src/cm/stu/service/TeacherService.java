package cm.stu.service;

import cm.stu.bean.Task;

import java.util.List;

public interface TeacherService {
    List AllStudentsByTeacherAccount(String userAccount);

    List<Task> getAllMyTask(String userAccount);
}
