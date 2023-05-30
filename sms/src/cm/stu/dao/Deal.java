package cm.stu.dao;

import cm.stu.bean.*;
import cm.stu.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Deal {
    public static List<Person> getAllPerson(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        List<Person> list = new ArrayList<>();
        try{
            pre = connection.prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                Person newPerson = new Person();
                //`userAccount``userName``userSex``userBirthday``userIdCard``userPassword``userIdentify``userOtherName`
                newPerson.setUserAccount(res.getString("userAccount"));
                newPerson.setUserName(res.getString("userName"));
                newPerson.setUserBirthday(res.getString("userBirthday"));
                newPerson.setUserIdCard(res.getString("userIdCard"));
                newPerson.setUserPassword(res.getString("userPassword"));
                newPerson.setUserIdentify(res.getInt("userIdentify"));
                list.add(newPerson);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
        return list;

    }

    public static List<CourseGrade> getAllCourseGrade(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        List<CourseGrade> list = new ArrayList<>();
        try{
            pre = connection.prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                CourseGrade courseGrade = new CourseGrade();
                courseGrade.setCourseName(res.getString("CourseName"));
                courseGrade.setCourseTime(res.getString("CourseTime"));
                courseGrade.setCourseId(res.getString("CourseID"));
                courseGrade.setLow(res.getDouble("low"));
                courseGrade.setMedian(res.getDouble("mean"));
                courseGrade.setHigh(res.getDouble("high"));
                list.add(courseGrade);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
        return list;
    }

    public static List<StudentGrade> getStudentGrade(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        List<StudentGrade> list = new ArrayList<>();
        try{
            pre = connection.prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                StudentGrade studentGrade = new StudentGrade();
                //'userAccount','userName', 'userIdCard', 'score'
                studentGrade.setUserAccount(res.getString("userAccount"));
                studentGrade.setUserName(res.getString("userName"));
                studentGrade.setUserIdCard(res.getString("userIdCard"));
                studentGrade.setGrade(res.getDouble("score"));
                list.add(studentGrade);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
        return list;
    }

    public static void deal(String sql) throws Exception{
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            pre = connection.prepareStatement(sql);
            pre.execute();
        } catch (Exception e) {
            throw e;
        }finally {

        }
    }

    public static int isExist(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        int num=0;
        try {
            pre =connection.prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                num = res.getInt("num");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {

        }
        return num;
    }

    public static List<StudentCourse> getStudentCourse(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        List<StudentCourse> list = new ArrayList<>();
        try {
            pre =connection.prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                StudentCourse record = new StudentCourse();
                record.setUID(res.getString("UID"));
                record.setUserAccount(res.getString("userAccount"));
                record.setCourseId(res.getString("courseId"));
                record.setScore(res.getDouble("score"));
                list.add(record);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
        }
        return list;
    }

    public static List<Course> getAllCourse(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        List<Course> list = new ArrayList<>();
        try {
            pre =connection.prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                Course newCourse = new Course();
                newCourse.setCourseName(res.getString("CourseName"));
                newCourse.setCourseId(res.getString("CourseId"));
                newCourse.setCourseTime(res.getString("CourseTime"));
                list.add(newCourse);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
        }
        return list;
    }

    public static List<Course> getAllSCourse(String sql, String userAccount) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        List<Course> list = new ArrayList<>();
        try {
            pre =connection.prepareStatement(sql);
            pre.setString(1, userAccount);
            res = pre.executeQuery();
            while(res.next()){
                Course course = new Course();
                course.setCourseId(res.getString("courseId"));
                course.setCourseName(res.getString("courseName"));
                course.setCourseTime(res.getString("courseTime"));
                list.add(course);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
        }
        return list;
    }
}

