package cm.stu.service;

import cm.stu.dao.TeacherDao;
import cm.stu.dao.TeacherDaoImpl;

import java.util.List;

public class TeacherServiceImpl implements TeacherService{
    TeacherDao td = new TeacherDaoImpl();
    @Override
    public List AllStudentsByTeacherAccount(String userAccount) {
        return td.AllStudentsByTeacherAccount(userAccount);
    }
}
