/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.DBConnection;
import Object.EmailInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SunCho
 */
public class EmailInfoModel {

    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<EmailInfo> getAllEmail() {
        List<EmailInfo> list = new ArrayList<>();
        String sql = "SELECT * FROM EmailInfo";
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                EmailInfo email = new EmailInfo();
                email.setId(rs.getInt(1));
                email.setEmail(rs.getString(2));
                email.setPassword(rs.getString(3));
                email.setRule(rs.getString(4));
                email.setNote(rs.getString(5));
                list.add(email);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeResultSet(rs);
            DBConnection.closePreparedStatement(ps);
            DBConnection.closeConnection(connection);
        }
        return null;
    }

    public EmailInfo getOneEmailByName(String name) {
        String sql = "SELECT * FROM EmailInfo WHERE Email = ?";
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            rs.next();
            EmailInfo email = new EmailInfo();
            email.setId(rs.getInt(1));
            email.setEmail(rs.getString(2));
            email.setPassword(rs.getString(3));
            email.setRule(rs.getString(4));
            email.setNote(rs.getString(5));
            return email;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeResultSet(rs);
            DBConnection.closePreparedStatement(ps);
            DBConnection.closeConnection(connection);
        }
        return null;
    }

    public boolean addEmail(EmailInfo ei) {
        int check = 0;
        String sql = "INSERT INTO EmailInfo(Email, Email_Password, Email_Rule, Email_Note)"
                + " VALUES(?, ?, ?, ?)";
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, ei.getEmail());
            ps.setString(2, ei.getPassword());
            ps.setString(3, ei.getRule());
            ps.setString(4, ei.getNote());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closePreparedStatement(ps);
            DBConnection.closeConnection(connection);
        }
        return check > 0;
    }
//
//    public static void main(String[] args) {
//        EmailInfoModel eim = new EmailInfoModel();
//        System.out.println(eim.getAllEmail());
//    }
}
