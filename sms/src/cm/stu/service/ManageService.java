package cm.stu.service;

import cm.stu.bean.Person;

import java.util.List;

public interface ManageService {

    List<Person> getAllPerson();

    void addPerson(Person newPerson) throws Exception;
}
