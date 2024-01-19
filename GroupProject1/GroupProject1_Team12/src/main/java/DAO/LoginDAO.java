package DAO;
import bean.LoginBean;

import java.sql.*;
// Public class that manages connections to a MySQL database for a LoginBean
public class LoginDAO {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/census";

    private static final String USER = ""; //root
    private static final String PASS = ""; //12345

    // Returns a connection to the database using the LoginBean credentials
    public static Connection getConnection(LoginBean loginBean) throws ClassNotFoundException, SQLException {
        try {// Load the driver class
            System.out.println("Loading Class driver");
            Class.forName(JDBC_DRIVER);
        }
        catch (ClassNotFoundException cnfe) {
            System.err.println(cnfe);
        }
        return DriverManager.getConnection(DB_URL, loginBean.getUsername(), loginBean.getPassword());
    }


    // Validates the LoginBean credentials by executing a query
    public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
        boolean status = false;
        Class.forName(JDBC_DRIVER);

        try (Connection connection = getConnection(loginBean);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection
                     .prepareStatement("select * from agegroup")) {

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return status;
    }

    // Prints detailed information about the SQL exception
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: "+ ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while(t != null)
                {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
