//
package Model;

import DAO.DBConnection;
import Object.TransferRoom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransferRoomModel {
    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public boolean addRequestTransferRoom(TransferRoom tr){
        int check = 0;
        String sql = "INSERT INTO TransferRoom(Student_ID, Room_ID, TransferRoom_Status)"
                + " VALUES(?, ?, ?)"; 
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, tr.getStudentId());
            ps.setInt(2, tr.getRoomId());
            ps.setBoolean(3, tr.isStatus());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closePreparedStatement(ps);
            DBConnection.closeConnection(connection);
        }
        return check > 0;
    }
    
    public List<TransferRoom> getAllApplication(){
        List<TransferRoom> list = new ArrayList<>();
        String sql = "SELECT * FROM TransferRoom";
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                TransferRoom tr = new TransferRoom();
                tr.setId(rs.getInt(1));
                tr.setStudentId(rs.getInt(2));
                tr.setRoomId(rs.getInt(3));
                tr.setStatus(rs.getBoolean(4));
                list.add(tr);
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
    
    public List<TransferRoom> getAllApplicationByStudentId(int studentId){
        List<TransferRoom> list = new ArrayList<>();
        String sql = "SELECT * FROM TransferRoom WHERE Student_ID = ?";
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, studentId);
            rs = ps.executeQuery();
            while (rs.next()) {
                TransferRoom tr = new TransferRoom();
                tr.setId(rs.getInt(1));
                tr.setStudentId(rs.getInt(2));
                tr.setRoomId(rs.getInt(3));
                tr.setStatus(rs.getBoolean(4));
                list.add(tr);
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
    
    public TransferRoom getRoomByTransId(int transId){
        String sql = "SELECT * FROM TransferRoom WHERE TransferRoom_ID = ?";
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, transId);
            rs = ps.executeQuery();
            rs.next();
            TransferRoom tr = new TransferRoom();
            tr.setId(rs.getInt(1));
            tr.setStudentId(rs.getInt(2));
            tr.setRoomId(rs.getInt(3));
            tr.setStatus(rs.getBoolean(4));           
            return tr;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeResultSet(rs);
            DBConnection.closePreparedStatement(ps);
            DBConnection.closeConnection(connection);
        }
        return null;
    }
    
    public boolean checkRequestTransferRoom(int studentId, int roomId){
        String sql = "SELECT * FROM TransferRoom WHERE Student_ID = ? AND Room_ID = ?";
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, studentId);
            ps.setInt(2, roomId);
            rs = ps.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closePreparedStatement(ps);
            DBConnection.closeConnection(connection);
        }
        return false;
    }
    
    public boolean updateTransferRoom(boolean status, int transId){
        String sql = "UPDATE TransferRoom SET TransferRoom_Status = ? "
                + "WHERE TransferRoom_ID = ?";
        int check = 0;
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setBoolean(1, status);
            ps.setInt(2, transId);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closePreparedStatement(ps);
            DBConnection.closeConnection(connection);
        }
        return check > 0;
    }
    
    public boolean deleteTransferRoom(int studentId, boolean status){
        String sql = "DELETE FROM TransferRoom WHERE Student_ID = ? AND TransferRoom_Status = ?";
        int check = 0;
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);           
            ps.setInt(1, studentId);
            ps.setBoolean(2, status);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closePreparedStatement(ps);
            DBConnection.closeConnection(connection);
        }
        if(check > 0) return true;
        else return false;
    }
    
    public boolean deleteTransferRoomById(int transId){
        String sql = "DELETE FROM TransferRoom WHERE TransferRoom_ID = ?";
        int check = 0;
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);           
            ps.setInt(1, transId);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closePreparedStatement(ps);
            DBConnection.closeConnection(connection);
        }
        if(check > 0) return true;
        else return false;
    }
    
    public int countTotalApplicationFalse(){
        String sql = "SELECT COUNT(TransferRoom_ID) FROM TransferRoom WHERE TransferRoom_Status = 0";
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeResultSet(rs);
            DBConnection.closePreparedStatement(ps);
            DBConnection.closeConnection(connection);
        }
        return 0;
    }
}
