//
package Model;

import DAO.DBConnection;
import Object.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentModel {

    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<Student> getStudentsByRoom(int roomId) {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM Students WHERE Room_ID = ?";
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, roomId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt(1));
                student.setRoomId(rs.getInt(2));
                student.setRollNumber(rs.getString(3));
                student.setFullName(rs.getString(4));
                student.setEmail(rs.getString(5));
                student.setMobile(rs.getString(6));
                student.setAddress(rs.getString(7));
                student.setGender(rs.getBoolean(8));
                student.setStartDate(rs.getDate(9));
                list.add(student);
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

    public Student getStudentsByEmail(String email) {
        String sql = "SELECT * FROM Students WHERE Student_Email = ?";
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt(1));
                student.setRoomId(rs.getInt(2));
                student.setRollNumber(rs.getString(3));
                student.setFullName(rs.getString(4));
                student.setEmail(rs.getString(5));
                student.setMobile(rs.getString(6));
                student.setAddress(rs.getString(7));
                student.setGender(rs.getBoolean(8));
                student.setStartDate(rs.getDate(9));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeResultSet(rs);
            DBConnection.closePreparedStatement(ps);
            DBConnection.closeConnection(connection);
        }
        return null;
    }

    public Student getStudentsById(int studentId) {
        String sql = "SELECT * FROM Students WHERE Student_ID = ?";
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, studentId);
            rs = ps.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt(1));
                student.setRoomId(rs.getInt(2));
                student.setRollNumber(rs.getString(3));
                student.setFullName(rs.getString(4));
                student.setEmail(rs.getString(5));
                student.setMobile(rs.getString(6));
                student.setAddress(rs.getString(7));
                student.setGender(rs.getBoolean(8));
                student.setStartDate(rs.getDate(9));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeResultSet(rs);
            DBConnection.closePreparedStatement(ps);
            DBConnection.closeConnection(connection);
        }
        return null;
    }

    public int countTotalStudent() {
        String sql = "SELECT COUNT(Student_ID) FROM Students";
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

    public boolean deleteStudentById(int studentId) {
        String sql = "DELETE FROM Students WHERE Student_ID = ?";
        int check = 0;
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, studentId);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closePreparedStatement(ps);
            DBConnection.closeConnection(connection);
        }
        if (check > 0) {
            return true;
        } else {
            return false;
        }
    }

    public String getSemester(String date) {
        String[] temp = date.split("/");
        int day = Integer.parseInt(temp[0]);
        int month = Integer.parseInt(temp[1]);
        int year = Integer.parseInt(temp[2]);
        if (day >= 1 && month >= 1) {
            return "Spring";
        } else if (day >= 1 && month >= 5) {
            return "Summer";
        } else {
            return "Fall";
        }
    }

    public boolean updateRoomId(int roomId, int studentId) {
        String sql = "UPDATE Students SET Room_ID = ? "
                + "WHERE Student_ID = ?";
        int check = 0;
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, roomId);
            ps.setInt(2, studentId);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.closePreparedStatement(ps);
            DBConnection.closeConnection(connection);
        }
        if (check > 0) {
            return true;
        } else {
            return false;
        }
    }

//    public static void main(String[] args) {
//        StudentModel sm = new StudentModel();
////        List<Student> list = new ArrayList<>();
////        list = sm.getStudentsByRoom(1);
////        for(Student s : list){
////            System.out.println(s);
////        }
//        
//        Student s = sm.getStudentsByEmail("anhdtse03435@fpt.edu.vn");
//        System.out.println(s);
//    }
}
