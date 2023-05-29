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

    @Override
    public List<Person> getSearch(String matchText) {
        return md.getSearch(matchText);
    }
    @Override
    public void addPerson(Person newPerson) throws Exception {
        md.addPerson(newPerson);
    }

    @Override
    public void sureUpPassword(String userAccount, String userPassword) throws Exception {
        md.sureUpPassword(userAccount,userPassword);
    }


    @Override
    public void delThisPerson(String delAccount, String userIdentify) throws Exception {
        md.delThisPerson(delAccount,userIdentify);
    }

    @Override
    public void editThisPerson(String userAccount, String userName, String userBirthday, String userIdCard,int userIdentify) throws Exception {
        md.editThisPerson(userAccount, userName, userBirthday, userIdCard, userIdentify);
    }


    @Override
    public void addThisPerson(String userAccount, String userName, String userBirthday, String userIdCard,int userIdentify) throws Exception {
        md.addThisPerson(userAccount, userName, userBirthday, userIdCard, userIdentify);
    }

}
