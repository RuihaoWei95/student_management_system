package cm.stu.servlet;

import cm.stu.bean.Course;
import cm.stu.bean.Person;
import cm.stu.bean.StudentCourse;
import cm.stu.dao.Generate;
import cm.stu.service.StudentService;
import cm.stu.service.StudentServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@WebServlet("/student.action")
public class StudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        StudentService ss = new StudentServiceImpl();
        Person person = (Person) req.getSession().getAttribute("session_person");
        String userAccount = person.getUserAccount();

        if(action.equals("list1")||action.equals("searchCourse")){
            List<Course> arr ;
            if(action.equals("list1")){
                arr = ss.getAllCourse();
            }else {
                String matchText = req.getParameter("matchText");
                arr = ss.getSearchCourse(matchText);
            }

            req.setAttribute("arr",arr);
            req.setAttribute("mainRight","course.jsp");
            req.getRequestDispatcher("main.jsp").forward(req,resp);

        }

        else if(action.equals("addClass")){
            String courseId = req.getParameter("courseId");
            Double score = 0.0;
            // convert timestamp to string as UID
            // Convert the timestamp to an Instant
            long timestamp = System.currentTimeMillis();
            Instant instant = Instant.ofEpochMilli(timestamp);
            // Convert the Instant to a LocalDateTime
            LocalDateTime dateTime = LocalDateTime.ofInstant(instant, java.time.ZoneId.systemDefault());
            // Define the desired date-time format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            // Format the LocalDateTime using the formatter
            String UID = dateTime.format(formatter);
            int flag = Generate.IsExistCourse(userAccount,courseId,"0");
            if(flag==0){
                try {
                    ss.addClass(UID,userAccount,courseId,score);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                req.setAttribute("tip","add successfully");
                //System.out.println("flag is" + flag);
            }else {
                req.setAttribute("tip","already chosen, failed！");
                //System.out.println("flag2 is" + flag);
            }
            req.setAttribute("mainRight","blank.jsp");
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }

        else if(action.equals("goMyClass")||action.equals("deleteThisCourse")){
            if(action.equals("deleteThisCourse")){
                String courseId = req.getParameter("courseId");
                try {
                    ss.deleteMyClass(userAccount,courseId);
                } catch (Exception e) {
                }
            }
            List<Course> arr = ss.getMyClass(userAccount);
            //System.out.println(arr);
            req.setAttribute("arr",arr);
            req.setAttribute("mainRight","myCourse.jsp");
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }
    }
}
