//
package Model;

import DAO.DBConnection;
import Object.StudentJoinRoom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JoinTableModel {

    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<StudentJoinRoom> getAllStudentJoinRoom() {
        List<StudentJoinRoom> list = new ArrayList<>();
        String sql = "SELECT S.Student_ID, S.Room_ID, S.Student_RollNumber, S.Student_FullName, "
                + "S.Student_Email, S.Student_Mobile, S.Student_Address, S.Student_Gender, S.Student_StartDate, R.Room_RoomNumber\n"
                + "FROM Students S, Room R \n"
                + "WHERE S.Room_ID = R.Room_ID ORDER BY Room_ID ASC";
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                StudentJoinRoom sjr = new StudentJoinRoom();
                sjr.setId(rs.getInt(1));
                sjr.setRoomId(rs.getInt(2));
                sjr.setRollNumber(rs.getString(3));
                sjr.setFullName(rs.getString(4));
                sjr.setEmail(rs.getString(5));
                sjr.setMobile(rs.getString(6));
                sjr.setAddress(rs.getString(7));
                sjr.setGender(rs.getBoolean(8));
                sjr.setStartDate(rs.getDate(9));
                sjr.setRoomNumber(rs.getString(10));
                list.add(sjr);
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

    public StudentJoinRoom getOneStudentJoinRoomById(int studentId) {
        String sql = "SELECT S.Student_ID, S.Room_ID, S.Student_RollNumber, S.Student_FullName, "
                + "S.Student_Email, S.Student_Mobile, S.Student_Address, S.Student_Gender, S.Student_StartDate, R.Room_RoomNumber\n"
                + "FROM Students S, Room R \n"
                + "WHERE S.Room_ID = R.Room_ID AND S.Student_ID = ?";
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, studentId);
            rs = ps.executeQuery();
            rs.next();
            StudentJoinRoom sjr = new StudentJoinRoom();
            sjr.setId(rs.getInt(1));
            sjr.setRoomId(rs.getInt(2));
            sjr.setRollNumber(rs.getString(3));
            sjr.setFullName(rs.getString(4));
            sjr.setEmail(rs.getString(5));
            sjr.setMobile(rs.getString(6));
            sjr.setAddress(rs.getString(7));
            sjr.setGender(rs.getBoolean(8));
            sjr.setStartDate(rs.getDate(9));
            sjr.setRoomNumber(rs.getString(10));
            return sjr;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeResultSet(rs);
            DBConnection.closePreparedStatement(ps);
            DBConnection.closeConnection(connection);
        }
        return null;
    }

    public StudentJoinRoom getOneStudentJoinRoomByEmail(String rollnumber) {
        String sql = "SELECT S.Student_ID, S.Room_ID, S.Student_RollNumber, S.Student_FullName, "
                + "S.Student_Email, S.Student_Mobile, S.Student_Address, S.Student_Lead, S.Student_StartDate, R.Room_RoomNumber\n"
                + "FROM Students S, Room R \n"
                + "WHERE S.Room_ID = R.Room_ID AND S.Student_RollNumber = ?";
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, rollnumber);
            rs = ps.executeQuery();
            rs.next();
            StudentJoinRoom sjr = new StudentJoinRoom();
            sjr.setId(rs.getInt(1));
            sjr.setRoomId(rs.getInt(2));
            sjr.setRollNumber(rs.getString(3));
            sjr.setFullName(rs.getString(4));
            sjr.setEmail(rs.getString(5));
            sjr.setMobile(rs.getString(6));
            sjr.setAddress(rs.getString(7));
            sjr.setGender(rs.getBoolean(8));
            sjr.setStartDate(rs.getDate(9));
            sjr.setRoomNumber(rs.getString(10));
            return sjr;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeResultSet(rs);
            DBConnection.closePreparedStatement(ps);
            DBConnection.closeConnection(connection);
        }
        return null;
    }

//    public static void main(String[] args) throws SQLException {
//        JoinTableModel fm = new JoinTableModel();
//        List<StudentJoinRoom> list = new ArrayList<>();        
//        list = fm.getAllStudentJoinRoom();
//        for(StudentJoinRoom s : list){
//            System.out.println(s);
//        }
//        
////        StudentJoinRoom sjr = new StudentJoinRoom();
////        sjr = fm.getOneStudentJoinRoomByEmail("se03435");
////        System.out.println(sjr);
//        
//    }  
}
