package cm.stu.dao;

import cm.stu.bean.Course;
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

    @Override
    public List<Person> getSearch(String matchText) {
        String sql = "select * from person where userIdentify!=2 and (userAccount='' or userName like '%"+matchText+"%' or userIdCard='"+matchText+"')";
        return Deal.getAllPerson(sql);
    }

    @Override
    public void sureUpPassword(String userAccount, String userPassword) throws Exception {
        String sql = "update person set userPassword = '"+userPassword+"' where userAccount='"+userAccount+"'";
        Deal.deal(sql);
    }

    @Override
    public void delThisPerson(String delAccount, String userIdentify) throws Exception {
        if(Integer.parseInt(userIdentify)==0){
            //delete student
            String sql = "DELETE FROM studentcourse WHERE `userAccount` = '"+delAccount+"'";
            Deal.deal(sql);
        }else{
            //delte teacher
            String sql = "DELETE FROM teachercourse WHERE userAccount = '"+delAccount+"'";
            Deal.deal(sql);
        }
        String sql = "DELETE FROM person WHERE userAccount = '"+delAccount+"'";
        Deal.deal(sql);
    }

    @Override
    public void editThisPerson(String userAccount, String userName, String userBirthday, String userIdCard, int userIdentify) throws Exception {
        String sql = "UPDATE person SET userName = '"+userName+"', userBirthday = '"+userBirthday+"', userIdCard = '"+userIdCard+"', userIdentify = '"+userIdentify+"' WHERE userAccount = '"+userAccount+"'";
        Deal.deal(sql);
    }

    @Override
    public void addThisPerson(String userAccount, String userName, String userBirthday, String userIdCard, int userIdentify) throws Exception {
        String sql = "INSERT INTO person (userAccount, userName, userBirthday, userIdCard, userIdentify, userPassword) VALUES ('" + userAccount + "', '" + userName + "', '" + userBirthday + "', '" + userIdCard + "', '" + userIdentify + "', '1')";
        Deal.deal(sql);
    }

    @Override
    public void delThisCourse(String courseId) throws Exception {
        String sql = "DELETE FROM course WHERE courseId = '"+courseId+"'";
        Deal.deal(sql);
    };

    @Override
    public void editThisCourse(String courseName,String courseId,String courseTime) throws Exception {
        String sql = "UPDATE course SET courseName = '"+courseName+"', courseTime = '"+courseTime+"' WHERE courseId = '"+courseId+"'";
        Deal.deal(sql);
    };

    @Override
    public void addThisCourse(String courseName,String courseId,String courseTime) throws Exception {
        String sql = "INSERT INTO course (courseName, courseId, courseTime) VALUES ('" + courseName + "', '" + courseId + "', '" + courseTime + "')";
        Deal.deal(sql);
    };

    @Override
    public List<Course> getAllCourse() {
        String sql = "select * from course";
        return Deal.getAllCourse(sql);
    }

}
