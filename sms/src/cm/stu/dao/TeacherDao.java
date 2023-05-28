package cm.stu.dao;

import cm.stu.bean.Task;

import java.util.List;

public interface TeacherDao {
    List AllStudentsByTeacherAccount(String userAccount);

    List<Task> getAllMyTask(String userAccount);
}
