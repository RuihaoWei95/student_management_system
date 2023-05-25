package cm.stu.util;

import cm.stu.bean.Person;
import cm.stu.dao.TestDao;

public class Test {
    public static void main(String[] args) {
        Person p = new Person();
        p.setUserAccount("17365896");
        p.setUserPassword("1");
        Person person = TestDao.Login(p);

        if(person==null){
            System.out.println("login fail");
        }else{
            System.out.println("login success:" + person);
        }

    }

}
