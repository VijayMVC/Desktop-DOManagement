/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.DBConnection;
import Object.EmailContent;
import Object.EmailInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Shado
 */
public class EmailContentModel {
    
    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public boolean addEmailContent(EmailContent ec) {
        int check = 0;
        String sql = "INSERT INTO EmailContent(Email_Id, Email_Subject, Email_Content, Email_Note)"
                + " VALUES(?, ?, ?, ?)";
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, ec.getEmailId());
            ps.setString(2, ec.getSubject());
            ps.setString(3, ec.getContent());
            ps.setString(4, ec.getNote());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closePreparedStatement(ps);
            DBConnection.closeConnection(connection);
        }
        return check > 0;
    }
    
    public EmailContent getOneEmailContentById(int id) {
        String sql = "SELECT * FROM EmailContent WHERE Email_Id = ?";
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            EmailContent email = new EmailContent();
            email.setId(rs.getInt(1));
            email.setEmailId(rs.getInt(2));
            email.setSubject(rs.getString(3));
            email.setContent(rs.getString(4));
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
    
//    public static void main(String[] args) {
//        EmailContentModel ecm = new EmailContentModel();
//        System.out.println(ecm.getOneEmailContentById(2).getContent());
//    }
}
