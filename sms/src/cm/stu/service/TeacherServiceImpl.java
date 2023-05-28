package cm.stu.service;

import cm.stu.bean.StudentAnswer;
import cm.stu.bean.Task;
import cm.stu.dao.TeacherDao;
import cm.stu.dao.TeacherDaoImpl;

import java.util.List;

public class TeacherServiceImpl implements TeacherService{
    TeacherDao td = new TeacherDaoImpl();
    @Override
    public List AllStudentsByTeacherAccount(String userAccount) {
        return td.AllStudentsByTeacherAccount(userAccount);
    }

    @Override
    public List<Task> getAllMyTask(String userAccount) {
        return td.getAllMyTask(userAccount);
    }

    @Override
    public List<StudentAnswer> getTaskDetail(String taskAccount) {
        return td.getTaskDetail(taskAccount);
    }
}
