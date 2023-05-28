package cm.stu.dao;

import java.util.List;

public class TeacherDaoImpl implements TeacherDao{

    @Override
    public List AllStudentsByTeacherAccount(String userAccount) {
        String sql = "Select * FROM person WHERE userAccount IN (SELECT userAccount FROM userteacher WHERE teacherAccount='"+userAccount+"')";
        return Deal.getAllPerson(sql);
    }
}
