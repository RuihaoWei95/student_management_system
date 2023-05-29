package cm.stu.service;

import cm.stu.bean.Person;

import java.util.List;

public interface ManageService {

    List<Person> getAllPerson();


    List<Person> getSearch(String matchText);

    void addPerson(Person newPerson) throws Exception;

    void sureUpPassword(String userAccount, String userPassword) throws Exception;

    void delThisPerson(String delAccount, String userIdentify) throws Exception;

    void editThisPerson(String userAccount, String userName, String userBirthday, String userIdCard, int userIdentify) throws Exception;

    void addThisPerson(String userAccount, String userName, String userBirthday, String userIdCard, int userIdentify) throws Exception;

}
