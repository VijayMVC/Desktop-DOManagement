//
package Model;

import DAO.DBConnection;
import Object.Dom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DomModel {

    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<Dom> getAllDom() {
        List<Dom> list = new ArrayList<>();
        String sql = "SELECT * FROM Dom";
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Dom dom = new Dom();
                dom.setId(rs.getInt(1));
                dom.setName(rs.getString(2));
                dom.setAcronym(rs.getString(3));
                dom.setStatus(rs.getInt(4));
                list.add(dom);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeResultSet(rs);
            DBConnection.closePreparedStatement(ps);
            DBConnection.closeConnection(connection);
        }
        return null;
    }
    
    public Dom getOneDomByName(String name) {
        List<Dom> list = new ArrayList<>();
        String sql = "SELECT * FROM Dom WHERE Dom_Name = ?";
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            rs.next();
            Dom dom = new Dom();
            dom.setId(rs.getInt(1));
            dom.setName(rs.getString(2));
            dom.setAcronym(rs.getString(3));
            dom.setStatus(rs.getInt(4));           
            return dom;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeResultSet(rs);
            DBConnection.closePreparedStatement(ps);
            DBConnection.closeConnection(connection);
        }
        return null;
    }
    

    public int countTotalDom() {
        String sql = "SELECT COUNT(Dom_ID) FROM Dom";
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeResultSet(rs);
            DBConnection.closePreparedStatement(ps);
            DBConnection.closeConnection(connection);
        }
        return 0;
    }

//    public static void main(String[] args) {
//        DomModel dm = new DomModel();
//        System.out.println(dm.getOneDomByName("Dom A"));
//    }
}
