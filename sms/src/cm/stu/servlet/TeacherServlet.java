package cm.stu.servlet;

import cm.stu.bean.*;
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
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        TeacherService ts = new TeacherServiceImpl();
        Person person = (Person) req.getSession().getAttribute("session_person");
        String userAccount = person.getUserAccount();

        if (action.equals("studentGrades")) {
            //tea.action?action=studentGrades
            List<CourseGrade> arr = ts.getAllMyCourseGrade(userAccount);
            req.setAttribute("arr", arr);
            req.setAttribute("mainRight", "courseGrade.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);


        } else if (action.equals("gradeDetails")) {
            //tea.action?action=gradeDetails&courseId=courseId
            String courseId = req.getParameter("courseId");
            List<StudentGrade> arr = ts.getStudentGrade(courseId);
            req.setAttribute("arr", arr);
            req.setAttribute("courseId", courseId);
            req.setAttribute("mainRight", "studentGrade.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);


        } else if(action.equals("editScore")){
            String studentAccount = req.getParameter("userAccount");
            String sutdentCourseId = req.getParameter("courseId");
            double studentScore = Double.parseDouble(req.getParameter("score"));
            try {
                ts.editScore(studentAccount,sutdentCourseId, studentScore);
            } catch (Exception e) {

            }
            List<CourseGrade> arr = ts.getAllMyCourseGrade(userAccount);
            req.setAttribute("arr", arr);
            req.setAttribute("mainRight", "courseGrade.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
    }
}
