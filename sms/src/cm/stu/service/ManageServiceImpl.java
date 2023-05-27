package cm.stu.service;

import cm.stu.bean.Person;
import cm.stu.dao.ManageDao;
import cm.stu.dao.ManageDaoImpl;

import java.util.List;

public class ManageServiceImpl implements ManageService{
    ManageDao md = new ManageDaoImpl();
    @Override
    public List<Person> getAllPerson() {
        return md.getAllPerson();
    }
}
