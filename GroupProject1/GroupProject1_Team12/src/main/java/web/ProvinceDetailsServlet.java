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

// Declare ProvinceDetailsServlet that responds to "/provinceDetails/*" paths
@WebServlet(name = "ProvinceDetailsServlet", value = "/provinceDetails/*")
public class ProvinceDetailsServlet extends HttpServlet {
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
        Integer id = -1;
        String pathInfo = request.getPathInfo(); // get the part of the URL after the servlet path
        if (pathInfo != null) {
            String[] pathParts = pathInfo.split("/"); // split the path into its parts
            if (pathParts.length > 1) {
                id = Integer.parseInt(pathParts[1]); // the id parameter is the second part of the path
                // use the id parameter in your code
            }
        }

        System.out.println("1 -" + id);

        // Create geographicArea object
        GeographicArea geographicArea = dao.getGeographicAreaById(loginBean, id);

        // Redirect with the geographicArea object along the way we created
        request.setAttribute("geographicArea", geographicArea);
        request.getRequestDispatcher("/provinceDetails.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
