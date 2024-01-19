package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import DAO.DBUtil;
import bean.AgeRecord;
import bean.LoginBean;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// Declare AgeListServlet that responds to "/ageList" paths
@WebServlet(name = "AgeListServlet", value = "/ageList")
public class AgeListServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve session object
        HttpSession session = request.getSession(false); // We pass false as the argument to the method, which means that the method won't create a new session if one doesn't already exist.

        // Retrieve username and password from session object
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

        // Create LoginBean object with retrieved username and password
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);

        // Create DBUtil object to access data
        DBUtil dao = new DBUtil();
        List<AgeRecord> ageList = dao.getAgeList(loginBean);

        // Forward the request object and response object to JSP page for rendering
        request.setAttribute("ageRecordList", ageList);
        request.getRequestDispatcher("ageList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
