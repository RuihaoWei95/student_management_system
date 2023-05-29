package cm.stu.dao;

import cm.stu.bean.Person;
import cm.stu.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageDaoImpl implements ManageDao{
    @Override
    public List<Person> getAllPerson() {
        String sql = "Select * from person where userIdentify!=2";
        return Deal.getAllPerson(sql);
    }

    @Override
    public void addPerson(Person newPerson) throws Exception {
        String sql = "INSERT INTO person (userAccount, userName, userBirthday, userIdCard, userIdentify, userPassword) values('"+newPerson.getUserAccount()+"','"+newPerson.getUserName()+"','"+newPerson.getUserBirthday()+"','"+newPerson.getUserIdCard()+"','"+newPerson.getUserIdentify()+"','"+newPerson.getUserPassword()+"')";
        System.out.println(sql);
        Deal.deal(sql);
    }

}
