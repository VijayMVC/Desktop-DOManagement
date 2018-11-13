//
package DAO;

import config.DBConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() {
        Connection con = null;
        String connectionUrl = "jdbc:sqlserver://" + DBConfig.hostname + ":" + DBConfig.port + ";"
                + "databaseName=" + DBConfig.databaseName + ";integratedSecurity=" + DBConfig.integratedSecurity + ";";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Where is your MySQL JDBC Driver?");
            return con;
        }
        System.out.println("MySQL JDBC Driver Registered!");

        try {
            con = DriverManager.getConnection(connectionUrl, DBConfig.username, DBConfig.password);
        } catch (SQLException ex) {
            System.err.println("Connection Failed! Check output console");
            return con;
        }
        return con;
    }
    
    public static void main(String[] args) throws SQLException{
        Connection con = getConnection();
        if (con != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }

    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
    }

    public static void closePreparedStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
    }
}
