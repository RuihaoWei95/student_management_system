package cm.stu.servlet;

import cm.stu.bean.Person;
import cm.stu.service.UserLoginService;
import cm.stu.service.UserLoginServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/userLogin")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get Front Page messages
        String userAccount = req.getParameter("userAccount");
        String userPassword = req.getParameter("userPassword");
        Person person = new Person(userAccount, userPassword);
        UserLoginService ul = new UserLoginServiceImpl();
        Person newPerson = ul.getLogin(person);

        // login Success
        if(newPerson!=null){
            req.setAttribute("person", person);
            req.setAttribute("mainRight", "blank.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
        else{
            req.setAttribute("tip", "wrong password");
            req.getRequestDispatcher("userLogin.jsp").forward(req, resp);
        }
    }
}
