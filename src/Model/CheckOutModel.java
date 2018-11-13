//
package Model;

import DAO.DBConnection;
import Object.TransferRoom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CheckOutModel {
    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public boolean addRequestCheckOutRoom(TransferRoom tr){
        int check = 0;
        String sql = "INSERT INTO CheckOut(Student_ID, Room_ID, CheckOut_Status)"
                + " VALUES(?, ?, ?)"; 
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, tr.getStudentId());
            ps.setInt(2, tr.getRoomId());
            ps.setBoolean(3, tr.isStatus());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.closePreparedStatement(ps);
            DBConnection.closeConnection(connection);
        }
        if(check > 0) return true;
        else return false;
    }
    
    
}
