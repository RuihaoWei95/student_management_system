package cm.stu.servlet;

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

        if(action.equals("list")){
            List<Person> arr = ms.getAllPerson();
            req.setAttribute("arr", arr);
            req.setAttribute("mainRight", "person.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }else if (action.equals("addThisPerson")) {
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
