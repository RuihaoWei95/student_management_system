package cm.stu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/common.action")
public class CommonServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        if(action.equals("index")){
            //jump to main page
            req.setAttribute("mainRight", "blank.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
    }
}
