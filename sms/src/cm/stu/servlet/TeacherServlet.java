package cm.stu.servlet;

import cm.stu.bean.Person;
import cm.stu.service.TeacherService;
import cm.stu.service.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tea.action")
public class TeacherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        TeacherService ts = new TeacherServiceImpl();
        Person person = (Person) req.getSession().getAttribute("session_person");
        String userAccount = person.getUserAccount();

        if(action.equals("list")){
            //get all students
            List arr = ts.AllStudentsByTeacherAccount(userAccount);
            req.setAttribute("arr", arr);
            req.setAttribute("mainRight", "person.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);

        }
    }
}