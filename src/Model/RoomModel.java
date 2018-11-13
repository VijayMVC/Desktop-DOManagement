//
package Model;

import DAO.DBConnection;
import Object.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomModel {

    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<Room> getAllRoomByDom(int domId, int status) {
        List<Room> list = new ArrayList<>();
        String sql = "";
        if (status == -1) {
            sql = "SELECT * FROM Room WHERE Dom_ID = " + domId;
        } else {
            sql = "SELECT * FROM Room WHERE Dom_ID = " + domId + " AND Room_Status = " + status;
        }

        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt(1));
                room.setDomId(rs.getInt(2));
                room.setRoomNumber(rs.getString(3));
                room.setNumberStudent(rs.getInt(4));
                room.setFreeSlot(rs.getInt(5));
                room.setElectricityNumberLastSemester(rs.getInt(6));
                room.setElectricityNumberThisSemester(rs.getInt(7));
                room.setWaterNumberLastSemester(rs.getInt(8));
                room.setWaterNumberThisSemester(rs.getInt(9));
                room.setPaystatus(rs.getBoolean(10));
                room.setStatus(rs.getInt(11));
                room.setType(rs.getInt(12));
                list.add(room);
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

    public List<Room> getAllRoomByDomFreeSlot(int domId) {
        List<Room> list = new ArrayList<>();
        String sql = "SELECT * FROM Room WHERE Dom_ID = ? AND Room_FreeSlot > ?";
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, domId);
            ps.setInt(2, 0);
            rs = ps.executeQuery();
            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt(1));
                room.setDomId(rs.getInt(2));
                room.setRoomNumber(rs.getString(3));
                room.setNumberStudent(rs.getInt(4));
                room.setFreeSlot(rs.getInt(5));
                room.setElectricityNumberLastSemester(rs.getInt(6));
                room.setElectricityNumberThisSemester(rs.getInt(7));
                room.setWaterNumberLastSemester(rs.getInt(8));
                room.setWaterNumberThisSemester(rs.getInt(9));
                room.setPaystatus(rs.getBoolean(10));
                room.setStatus(rs.getInt(11));
                room.setType(rs.getInt(12));
                list.add(room);
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

    public int getCountRoomStatus(int domId, int status) {
        String sql = "";
        if (status == -1) {
            sql = "SELECT COUNT(Room_Status) FROM Room WHERE Dom_ID = " + domId;
        } else {
            sql = "SELECT COUNT(Room_Status) FROM Room WHERE Dom_ID = " + domId + " AND Room_Status = " + status;
        }
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
        return -1;
    }

    public Room getRoomById(int roomId) {
        String sql = "SELECT * FROM Room WHERE Room_ID = ?";
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, roomId);
            rs = ps.executeQuery();
            Room room = new Room();
            rs.next();
            room.setId(rs.getInt(1));
            room.setDomId(rs.getInt(2));
            room.setRoomNumber(rs.getString(3));
            room.setNumberStudent(rs.getInt(4));
            room.setFreeSlot(rs.getInt(5));
            room.setElectricityNumberLastSemester(rs.getInt(6));
            room.setElectricityNumberThisSemester(rs.getInt(7));
            room.setWaterNumberLastSemester(rs.getInt(8));
            room.setWaterNumberThisSemester(rs.getInt(9));
            room.setPaystatus(rs.getBoolean(10));
            room.setStatus(rs.getInt(11));
            room.setType(rs.getInt(12));

            return room;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeResultSet(rs);
            DBConnection.closePreparedStatement(ps);
            DBConnection.closeConnection(connection);
        }
        return null;
    }

    public int countTotalRoom() {
        String sql = "SELECT COUNT(Room_ID) FROM Room";
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

    public int countFreeSlot() {
        String sql = "SELECT SUM(Room_FreeSlot) FROM Room";
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

    public boolean updateRoomFromModalRoomDetails(int electricityNumberThisSemester, int waterNumberThisSemester, boolean pay, int status, int roomId) {
        String sql = "";
        int check = 0;
        if (electricityNumberThisSemester == 0 && waterNumberThisSemester != 0) {
            sql = "UPDATE Room SET Room_WaterNumberThisSemester = ?, Room_PayStatus = ?, Room_Status = ? "
                    + "WHERE Room_ID = ?";
            try {
                connection = DBConnection.getConnection();
                ps = connection.prepareStatement(sql);
                ps.setInt(1, waterNumberThisSemester);
                ps.setBoolean(2, pay);
                ps.setInt(3, status);
                ps.setInt(4, roomId);
                check = ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.closePreparedStatement(ps);
                DBConnection.closeConnection(connection);
            }
        } else if (electricityNumberThisSemester != 0 && waterNumberThisSemester == 0) {
            sql = "UPDATE Room SET Room_ElectricityNumberThisSemester = ?, Room_PayStatus = ?, Room_Status = ? "
                    + "WHERE Room_ID = ?";
            try {
                connection = DBConnection.getConnection();
                ps = connection.prepareStatement(sql);
                ps.setInt(1, electricityNumberThisSemester);
                ps.setBoolean(2, pay);
                ps.setInt(3, status);
                ps.setInt(4, roomId);
                check = ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.closePreparedStatement(ps);
                DBConnection.closeConnection(connection);
            }
        } else if (electricityNumberThisSemester == 0 && waterNumberThisSemester == 0) {
            sql = "UPDATE Room SET Room_PayStatus = ?, Room_Status = ? "
                    + "WHERE Room_ID = ?";
            try {
                connection = DBConnection.getConnection();
                ps = connection.prepareStatement(sql);
                ps.setBoolean(1, pay);
                ps.setInt(2, status);
                ps.setInt(3, roomId);
                check = ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.closePreparedStatement(ps);
                DBConnection.closeConnection(connection);
            }
        } else {
            sql = "UPDATE Room SET Room_ElectricityNumberThisSemester = ?, Room_WaterNumberThisSemester = ?, Room_PayStatus = ?, Room_Status = ? "
                    + "WHERE Room_ID = ?";
            try {
                connection = DBConnection.getConnection();
                ps = connection.prepareStatement(sql);
                ps.setInt(1, electricityNumberThisSemester);
                ps.setInt(2, waterNumberThisSemester);
                ps.setBoolean(3, pay);
                ps.setInt(4, status);
                ps.setInt(5, roomId);
                check = ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.closePreparedStatement(ps);
                DBConnection.closeConnection(connection);
            }
        }
        if (check > 0) {
            return true;
        } else {
            return false;
        }
    }

//    public static void main(String[] args) {
//        RoomModel d = new RoomModel();
//        List<Room> list = new ArrayList<>();
//        Room room = new Room();
//        list = d.getAllRoomByDom(1, "0");
//        for(Room r : list){
//            System.out.println(r);
//        }     
//    }
}
