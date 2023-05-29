package cm.stu.servlet;

import cm.stu.bean.Course;
import cm.stu.bean.Person;
import cm.stu.service.ManageService;
import cm.stu.service.ManageServiceImpl;
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
        } else if (action.equals("signUp")) {
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
