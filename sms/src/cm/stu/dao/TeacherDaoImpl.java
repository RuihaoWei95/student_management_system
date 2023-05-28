package cm.stu.dao;

import cm.stu.bean.Task;

import java.util.List;

public class TeacherDaoImpl implements TeacherDao{

    @Override
    public List AllStudentsByTeacherAccount(String userAccount) {
        String sql = "Select * FROM person WHERE userAccount IN (SELECT userAccount FROM userteacher WHERE teacherAccount='"+userAccount+"')";
        return Deal.getAllPerson(sql);
    }

    @Override
    public List<Task> getAllMyTask(String userAccount) {
        String sql = "SELECT * FROM task WHERE teacherAccount = '" + userAccount+"'";
        return Deal.getAllTask(sql);
    }
}
