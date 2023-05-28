package cm.stu.dao;

import cm.stu.bean.StudentAnswer;
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

    @Override
    public List<StudentAnswer> getTaskDetail(String taskAccount) {
        String sql ="SELECT s.*,p.`userName`,`taskName` FROM `studenttask` s  INNER JOIN person p ON s.`studentAccount`=p.`userAccount` INNER JOIN task t ON s.`taskAccount`=t.taskAccount WHERE s.`taskAccount`='"+taskAccount+"'";
        return Deal.getTaskDetail(sql);
    }
}
