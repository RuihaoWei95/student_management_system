package cm.stu.service;

import cm.stu.bean.Course;
import cm.stu.bean.Person;
import cm.stu.bean.StudentCourse;
import cm.stu.dao.ManageDao;
import cm.stu.dao.ManageDaoImpl;

import java.util.List;

public class ManageServiceImpl implements ManageService{
    ManageDao md = new ManageDaoImpl();
    @Override
    public List<Person> getAllPerson() {
        return md.getAllPerson();
    }

    @Override
    public List<Person> getSearch(String matchText) {
        return md.getSearch(matchText);
    }
    @Override
    public void addPerson(Person newPerson) throws Exception {
        md.addPerson(newPerson);
    }

    @Override
    public void sureUpPassword(String userAccount, String userPassword) throws Exception {
        md.sureUpPassword(userAccount,userPassword);
    }


    @Override
    public void delThisPerson(String delAccount, String userIdentify) throws Exception {
        md.delThisPerson(delAccount,userIdentify);
    }

    @Override
    public void editThisPerson(String userAccount, String userName, String userBirthday, String userIdCard,int userIdentify) throws Exception {
        md.editThisPerson(userAccount, userName, userBirthday, userIdCard, userIdentify);
    }


    @Override
    public void addThisPerson(String userAccount, String userName, String userBirthday, String userIdCard,int userIdentify) throws Exception {
        md.addThisPerson(userAccount, userName, userBirthday, userIdCard, userIdentify);
    }
    @Override
    public void delThisCourse(String courseId) throws Exception {
        md.delThisCourse(courseId);
    };

    @Override
    public void editThisCourse(String courseName,String courseId,String courseTime) throws Exception {
        md.editThisCourse(courseName,courseId,courseTime);
    };

    @Override
    public void addThisCourse(String courseName,String courseId,String courseTime) throws Exception {
        md.addThisCourse(courseName,courseId,courseTime);
    };

    @Override
    public List<Course> getAllCourse() {
        return md.getAllCourse();
    }

    @Override
    public void delThisStudentCourse(String UID) throws Exception {
        md.delThisStudentCourse(UID);
    }

    @Override
    public void editThisStudentCourse(String uid, String userAccount, String courseId, double score) throws Exception {
        md.editThisStudentCourse(uid,userAccount,courseId,score);
    }

    @Override
    public void addThisStudentCourse(String userAccount, String courseId, double score) throws Exception {
        md.addThisStudentCourse(userAccount,courseId,score);
    }

    @Override
    public List<StudentCourse> getAllCourseGrades() {
        return md.getAllCourseGrades();
    }

    @Override
    public List<Person> getAllStudent() {
        return md.getAllStudent();
    }


}
