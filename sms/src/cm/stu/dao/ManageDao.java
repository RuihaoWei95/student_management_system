package cm.stu.dao;

import cm.stu.bean.Course;
import cm.stu.bean.Person;
import cm.stu.bean.StudentCourse;

import java.util.List;

public interface ManageDao {
    List<Person> getAllPerson();

    void addPerson(Person newPerson) throws Exception;

    List<Person> getSearch(String matchText);

    void sureUpPassword(String userAccount, String userPassword) throws Exception;

    void delThisPerson(String delAccount, String userIdentify) throws Exception;

    void editThisPerson(String userAccount, String userName, String userBirthday, String userIdCard, int userIdentify) throws Exception;

    void addThisPerson(String userAccount, String userName, String userBirthday, String userIdCard, int userIdentify) throws Exception;

    void delThisCourse(String courseId) throws Exception;

    void editThisCourse(String courseName, String courseId, String courseTime) throws Exception;

    void addThisCourse(String courseName, String courseId, String courseTime) throws Exception;

    List<Course> getAllCourse();

    void delThisStudentCourse(String uid) throws Exception;

    void editThisStudentCourse(String uid, String userAccount, String courseId, Double score) throws Exception;

    void addThisStudentCourse(String userAccount, String courseId, Double score) throws Exception;

    List<StudentCourse> getAllCourseGrades();

    List<Person> getAllStudent();
}
