package web;

import DAO.DBUtil;
import bean.GeographicArea;
import bean.LoginBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

// Declare CanadaDetailsServlet that responds to "/canadaDetails" paths
@WebServlet(name = "CanadaDetailsServlet", value = "/canadaDetails/*")
public class CanadaDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve user session
        HttpSession session = request.getSession(false); // We pass false as the argument to the method, which means that the method won't create a new session if one doesn't already exist.

        // Get username and password from the session
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

        // Create a LoginBean object with the retrieved credentials
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);

        // Create a DBUtil object to retrieve data
        DBUtil dao = new DBUtil();

        // Initialize the id parameter
        Integer id = -1;
        String pathInfo = request.getPathInfo(); // get the part of the URL after the servlet path

        // Extract the id parameter from the URL path
        if (pathInfo != null) {
            String[] pathParts = pathInfo.split("/"); // split the path into its parts
            if (pathParts.length > 1) {
                id = Integer.parseInt(pathParts[1]); // the id parameter is the second part of the path
                // use the id parameter in your code
            }
        }

        System.out.println("1 -" + id);


        // Retrieve the Geographic Area object
        GeographicArea geographicArea = dao.getGeographicAreaById(loginBean, id);

        // Set the geographicArea object as an attribute to the request object and dispatch the request to the JSP page
        request.setAttribute("geographicArea", geographicArea);
        request.getRequestDispatcher("/canadaDetails.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
