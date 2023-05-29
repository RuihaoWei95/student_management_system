package cm.stu.service;

import cm.stu.bean.Person;

public interface UserLoginService {
    Person getLogin(Person person);

    Person checkAccount(Person account);
}
