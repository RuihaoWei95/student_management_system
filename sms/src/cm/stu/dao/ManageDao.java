package cm.stu.dao;

import cm.stu.bean.Person;

import java.util.List;

public interface ManageDao {
    List<Person> getAllPerson();

    void addPerson(Person newPerson) throws Exception;

    List<Person> getSearch(String matchText);

    void sureUpPassword(String userAccount, String userPassword) throws Exception;

    void delThisPerson(String delAccount, String userIdentify) throws Exception;

    void editThisPerson(String userAccount, String userName, String userBirthday, String userIdCard, int userIdentify) throws Exception;

    void addThisPerson(String userAccount, String userName, String userBirthday, String userIdCard, int userIdentify) throws Exception;
}
