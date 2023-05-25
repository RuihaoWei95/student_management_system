package cm.stu.servlet;

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
        // admin
        if(userAccount.equals("admin") && userPassword.equals("admin")){
            // get into admin page
            System.out.println("Enger the admin page!");
        }
        else{
            req.setAttribute("tip", "wrong password");
            req.getRequestDispatcher("userLogin.jsp").forward(req, resp);
        }
    }
}
