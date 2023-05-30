package cm.stu.servlet;

import cm.stu.bean.*;
import cm.stu.service.ManageService;
import cm.stu.service.ManageServiceImpl;
import cm.stu.service.StudentService;
import cm.stu.service.StudentServiceImpl;
import cm.stu.util.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/man.action")
public class ManageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        ManageService ms = new ManageServiceImpl();

        //manage the person list
        if (action.equals("personlist") || action.equals("delThisPerson") || action.equals("editThisPerson") || action.equals("addThisPerson")) {
            List<Person> personArr;
            if(action.equals("delThisPerson")){
                String delAccount = req.getParameter("userAccount");
                String userIdentify =  req.getParameter("userIdentify");
                try {
                    ms.delThisPerson(delAccount,userIdentify);
                } catch (Exception e) {

                }
            }else if(action.equals("editThisPerson")){
                String userAccount = req.getParameter("userAccount");
                String userName = req.getParameter("userName");
                String userBirthday = req.getParameter("userBirthday");
                String userIdCard = req.getParameter("userIdCard");
                int userIdentify = Integer.parseInt(req.getParameter("userIdentify"));
                try {
                    ms.editThisPerson(userAccount,userName,userBirthday,userIdCard,userIdentify);
                } catch (Exception e) {

                }
            }else if(action.equals("addThisPerson")){
                String userAccount = req.getParameter("userAccount");
                String userName = req.getParameter("userName");
                String userBirthday = req.getParameter("userBirthday");
                String userIdCard = req.getParameter("userIdCard");
                int userIdentify = Integer.parseInt(req.getParameter("userIdentify"));
                try {
                    ms.addThisPerson(userAccount,userName,userBirthday,userIdCard,userIdentify);
                } catch (Exception e) {

                }
            }
            personArr = ms.getAllPerson();
            req.setAttribute("arr", personArr);
            req.setAttribute("mainRight", "person.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);

            //manage the course list
        } else if (action.equals("courselist")|| action.equals("delThisCourse") || action.equals("editThisCourse") || action.equals("addThisCourse")) {
            if(action.equals("delThisCourse")){
                String courseId = req.getParameter("courseId");
                try {
                    ms.delThisCourse(courseId);
                } catch (Exception e) {

                }
            }else if(action.equals("editThisCourse")){
                String courseName = req.getParameter("courseName");
                String courseId = req.getParameter("courseId");
                String courseTime = req.getParameter("courseTime");
                try {
                    ms.editThisCourse(courseName,courseId,courseTime);
                } catch (Exception e) {

                }
            }else if(action.equals("addThisCourse")){
                String courseName = req.getParameter("courseName");
                String courseId = req.getParameter("courseId");
                String courseTime = req.getParameter("courseTime");
                try {
                    ms.addThisCourse(courseName,courseId,courseTime);
                } catch (Exception e) {

                }
            }
            List<Course> courseArr;
            courseArr = ms.getAllCourse();
            req.setAttribute("arr", courseArr);
            req.setAttribute("mainRight", "manageCourse.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        } else if (action.equals("studentcourse")|| action.equals("delThisStudentCourse") || action.equals("editThisStudentCourse") || action.equals("addThisStudentCourse")) {
            if(action.equals("delThisStudentCourse")){
                String UID = req.getParameter("UID");
                try {
                    ms.delThisStudentCourse(UID);
                } catch (Exception e) {

                }
            }else if(action.equals("editThisStudentCourse")){
                String UID = req.getParameter("UID");
                String userAccount = req.getParameter("userAccount");
                String courseId = req.getParameter("courseId");
                double score = Double.parseDouble(req.getParameter("score"));
                try {
                    //System.out.println(UID);
                    //System.out.println(userAccount);
                    //System.out.println(courseId);
                    //System.out.println(score);
                    ms.editThisStudentCourse(UID,userAccount,courseId,score);
                } catch (Exception e) {

                }
            }else if(action.equals("addThisStudentCourse")){
                String userAccount = req.getParameter("userAccount");
                String courseId = req.getParameter("courseId");
                double score = Double.parseDouble(req.getParameter("score"));
                try {
                    ms.addThisStudentCourse(userAccount,courseId,score);
                } catch (Exception e) {

                }
            }
            List<StudentCourse> studentCourseArr;
            studentCourseArr = ms.getAllCourseGrades();
            List<Course> courseArr;
            courseArr = ms.getAllCourse();
            List<Person> studentArr;
            studentArr = ms.getAllStudent();
            req.setAttribute("studentArr", studentArr);
            req.setAttribute("courseArr", courseArr);
            req.setAttribute("arr", studentCourseArr);
            req.setAttribute("mainRight", "studentcourse.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
        // signUp
        else if (action.equals("signUp")) {
            String userAccount = req.getParameter("userAccount");
            String userName = req.getParameter("userName");
            String userBirthday = req.getParameter("userBirthday");
            String userIdCard = req.getParameter("userIdCard");
            String userPassword = req.getParameter("userPassword");
            int userIdentify = Integer.parseInt(req.getParameter("userIdentify"));
            Person newPerson = new Person(userAccount, userName, userBirthday, userIdCard, userPassword, userIdentify);
            try {
                ms.addPerson(newPerson);
            } catch (Exception e) {
                req.setAttribute("tip","sign up fails, account already exist!");
                req.getRequestDispatcher("userLogin.jsp").forward(req, resp);
            }
            req.setAttribute("tip","finish adding");
            req.getRequestDispatcher("userLogin.jsp").forward(req, resp);

        }
    }
}
