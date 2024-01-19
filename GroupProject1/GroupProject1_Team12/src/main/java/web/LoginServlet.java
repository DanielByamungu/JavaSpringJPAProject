package web;

import bean.LoginBean;
import DAO.LoginDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;

// Declare LoginServlet that responds to "/login" paths
@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    // Initialize DAO login new object
    private LoginDAO loginDAO = new LoginDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieves the username and password from the request parameters
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        // Create a LoginBean object with the username and password
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(userName);
        loginBean.setPassword(password);

        // Validate it using the LoginDAO object we created
        try {
            if(!loginDAO.validate(loginBean))
            {
                request.setAttribute("error", "Username or Password is wrong");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("username", loginBean.getUsername());

        // Create HttpSession object with the username and password
        HttpSession session = request.getSession(false); // We pass false as the argument to the method, which means that the method won't create a new session if one doesn't already exist.
        session.setAttribute("username", loginBean.getUsername());
        session.setAttribute("password", loginBean.getPassword());

        // Redirect
        response.sendRedirect(request.getContextPath() + "/canada");
    }
}
