package cm.stu.servlet;

import cm.stu.bean.Person;
import cm.stu.service.UserLoginService;
import cm.stu.service.UserLoginServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/userLogin")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        UserLoginService ul = new UserLoginServiceImpl();
        // Get Front Page messages
        String userAccount = req.getParameter("userAccount");
        String userPassword = req.getParameter("userPassword");
        Person person = new Person(userAccount, userPassword);
        Person newPerson = ul.getLogin(person);

        // login Success
        if (newPerson != null) {
            HttpSession session = req.getSession();
            session.setAttribute("session_person", newPerson);

            req.setAttribute("mainRight", "blank.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        } else {
            req.setAttribute("tip", "account and password doesn't exist!");
            req.getRequestDispatcher("userLogin.jsp").forward(req, resp);
        }

    }
}
