package DAO;
import bean.AgeRecord;
import bean.GeographicArea;
import bean.LoginBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {
    // static variables for the JDBC driver, database URL, and login info
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/census";
    private static final String USER = "";
    private static final String PASS = "";

    // Method for getting connection to the database using the provided login credentials
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

    // Method for getting a list of geographic areas at the specified level
    public List<GeographicArea> getGeographicAreaByLevel(LoginBean loginBean, Integer levelCode) {
        List<GeographicArea> geographicAreas = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Get a connection to the database
            conn = getConnection(loginBean);
            String query = "SELECT geographicAreaID, code, level, name, alternativeCode FROM geographicarea WHERE level = ?";

            // manipulating a statement using the SQL query
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, levelCode);
            System.out.println(stmt);

            // Execute the statement and get the result set
            rs = stmt.executeQuery();

            // Loop through the result set and add each geographic area to the list
            while (rs.next()) {
                GeographicArea geographicArea = new GeographicArea();
                geographicArea.setGeographicAreaID(rs.getInt("geographicAreaID"));
                geographicArea.setCode(rs.getInt("code"));
                geographicArea.setLevel(rs.getInt("level"));
                geographicArea.setName(rs.getString("name"));
                geographicArea.setAlternativeCode(rs.getInt("alternativeCode"));
                System.out.println(rs);
                geographicAreas.add(geographicArea);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // Throw a runtime exception if the JDBC driver is not found
            throw new RuntimeException(e);
        } finally {
            try {
                // Close the result set, prepared statement, and database connection
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return geographicAreas;
    }


    // Method for getting a geographic area by ID along with its total population
    public GeographicArea getGeographicAreaById(LoginBean loginBean, Integer id) {
        List<GeographicArea> geographicAreas = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        GeographicArea geographicArea = new GeographicArea();
        try {
            conn = getConnection(loginBean);
            String query = "SELECT geographicAreaID, code, level, name, alternativeCode, SUM(combined) AS 'totalPopulation' \n" +
                    "FROM geographicarea g \n" +
                    "INNER JOIN age a ON a.geographicArea = g.geographicAreaID \n" +
                    "INNER JOIN agegroup ag ON a.ageGroup = ag.ageGroupID\n" +
                    "WHERE a.geographicArea = ? AND a.censusYear = 1 AND LENGTH(ag.description) <= 2";

            stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            System.out.println(stmt);


            rs = stmt.executeQuery();

            while (rs.next()) {
                geographicArea.setGeographicAreaID(rs.getInt("geographicAreaID"));
                geographicArea.setCode(rs.getInt("code"));
                geographicArea.setLevel(rs.getInt("level"));
                geographicArea.setName(rs.getString("name"));
                geographicArea.setAlternativeCode(rs.getInt("alternativeCode"));
                geographicArea.setTotalPopulation(rs.getInt("totalPopulation"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println(geographicArea.getTotalPopulation());
        return geographicArea;
    }




// Method for returning a list of Age Record objects based on the parameters provided in the Login
    public List<AgeRecord> getAgeList(LoginBean loginBean) {
        List<AgeRecord> ageList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection(loginBean);
            String query = "WITH stat2016 AS (SELECT ag.description AS descr, a.male, a.female, cy.censusYear\n" +
                    "FROM age a\n" +
                    "INNER JOIN agegroup ag ON a.ageGroup = ag.ageGroupID\n" +
                    "INNER JOIN censusyear cy ON a.censusYear = cy.censusYearID \n" +
                    "WHERE a.geographicArea = 1 AND cy.censusYearID = 2) \n" +
                    "\n" +
                    "SELECT ag.description, a.male AS 'male2021', a.female  AS 'female2021', stat2016.male  AS 'male2016', stat2016.female AS 'female2016'\n" +
                    "FROM age a\n" +
                    "INNER JOIN agegroup ag ON a.ageGroup = ag.ageGroupID\n" +
                    "INNER JOIN censusyear cy ON a.censusYear = cy.censusYearID \n" +
                    "INNER JOIN stat2016 ON stat2016.descr = ag.description\n" +
                    "WHERE a.geographicArea = 1 AND cy.censusYearID = 1";

            stmt = conn.prepareStatement(query);
            System.out.println(stmt);


            rs = stmt.executeQuery();
            // Iterate through the ResultSet and create a new Age Record for each row
            while (rs.next()) {
                AgeRecord ageRecord = new AgeRecord();
                ageRecord.setDescription(rs.getString("description"));
                ageRecord.setFemale2016(rs.getInt("female2016"));
                ageRecord.setMale2016(rs.getInt("male2016"));
                ageRecord.setFemale2021(rs.getInt("female2021"));
                ageRecord.setMale2021(rs.getInt("male2021"));
                ageList.add(ageRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return ageList;
    }


}
