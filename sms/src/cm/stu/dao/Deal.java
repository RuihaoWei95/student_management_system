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
                newPerson.setUserSex(res.getString("userSex"));
                newPerson.setUserBirthday(res.getString("userBirthday"));
                newPerson.setUserIdCard(res.getString("userIdCard"));
                newPerson.setUserPassword(res.getString("userPassword"));
                newPerson.setUserIdentify(res.getInt("userIdentify"));
                newPerson.setUserOtherName(res.getString("userOtherName"));
                list.add(newPerson);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
        return list;

    }

    public static List<Task> getAllTask(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        List<Task> list = new ArrayList<>();
        try{
            pre = connection.prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                Task task = new Task();
                task.setTaskAccount(res.getString("taskAccount"));
                task.setTaskDate(res.getString("taskDate"));
                task.setTaskName(res.getString("taskName"));
                task.setTeacherAccount(res.getString("teacherAccount"));

                list.add(task);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
        return list;
    }

    public static List<StudentAnswer> getTaskDetail(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        List<StudentAnswer> list = new ArrayList<>();
        try{
            pre = connection.prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                StudentAnswer sa = new StudentAnswer();
                sa.setTaskAccount(res.getString("taskAccount"));
                sa.setStudentAccount(res.getString("studentAccount"));
                sa.setStudentAnswer(res.getString("studentAnswer"));
                sa.setIsFinish(res.getInt("isFinish"));
                sa.setIsScore(res.getInt("isScore"));
                sa.setUserName(res.getString("userName"));
                sa.setTaskName(res.getString("taskName"));
                list.add(sa);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
        return list;
    }

    public static List<Course> getAllCourse(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        List<Course> list = new ArrayList<>();
        try{
            pre = connection.prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                Course course = new Course();
                course.setCourseName(res.getString("CourseName"));
                course.setCourseId(res.getString("CourseId"));
                course.setCourseTime(res.getString("CourseTime"));
                list.add(course);
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
                //'userName', 'userIdCard', 'score'
                studentGrade.setUserAccount(res.getString("userName"));
                studentGrade.setUserIdCard(res.getString("userIdCard"));
                studentGrade.setGrade(res.getDouble("score"));
                list.add(studentGrade);
            }
            System.out.println(list);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
        return list;
    }
}
