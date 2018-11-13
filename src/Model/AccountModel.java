//
package Model;

import DAO.DBConnection;
import Object.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountModel {

    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public Account login(String username, String password) {
        String sql = "SELECT * FROM Account WHERE Account_UseName = ? AND Account_Password = ?";
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (!rs.next()) {
                return null;
            }
            Account acc = new Account();
            acc.setId(rs.getInt(1));
            acc.setFullName(rs.getString(2));
            acc.setEmail(rs.getString(3));
            acc.setMobile(rs.getString(4));
            acc.setUsername(rs.getString(5));
            acc.setPassword(rs.getString(6));
            acc.setType(rs.getString(7));
            acc.setCreated(rs.getDate(8));
            acc.setStatus(rs.getInt(9));
            return acc;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeResultSet(rs);
            DBConnection.closePreparedStatement(ps);
            DBConnection.closeConnection(connection);
        }
        return null;
    }

    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT * FROM Account";
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt(1));
                account.setFullName(rs.getString(2));
                account.setEmail(rs.getString(3));
                account.setMobile(rs.getString(4));
                account.setUsername(rs.getString(5));
                account.setPassword(rs.getString(6));
                account.setType(rs.getString(7));
                account.setCreated(rs.getDate(8));
                account.setStatus(rs.getInt(9));
                list.add(account);
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

    public boolean updateStatusAccount(int accoountId, int status) {
        String sql = "UPDATE Account SET Account_Status = ? WHERE Account_ID = ?";
        int check = 0;
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setInt(2, accoountId);
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

    public boolean addAccount(Account account) {
        int check = 0;
        String sql = "INSERT INTO Account(Account_FullName, Account_Email, Account_Mobile, Account_UseName, Account_Password, Account_Type, Account_Status)"
                + " VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, account.getFullName());
            ps.setString(2, account.getEmail());
            ps.setString(3, account.getMobile());
            ps.setString(4, account.getUsername());
            ps.setString(5, account.getPassword());
            ps.setString(6, account.getType());
            ps.setInt(7, account.getStatus());
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

    public Account getOneAccountById(int accountId) {
        String sql = "SELECT * FROM Account WHERE Account_ID = ?";
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, accountId);
            rs = ps.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt(1));
                account.setFullName(rs.getString(2));
                account.setEmail(rs.getString(3));
                account.setMobile(rs.getString(4));
                account.setUsername(rs.getString(5));
                account.setPassword(rs.getString(6));
                account.setType(rs.getString(7));
                account.setCreated(rs.getDate(8));
                account.setStatus(rs.getInt(9));
                return account;
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

    public Account getOneAccountByEmail(String email) {
        String sql = "SELECT * FROM Account WHERE Account_Email = ?";
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt(1));
                account.setFullName(rs.getString(2));
                account.setEmail(rs.getString(3));
                account.setMobile(rs.getString(4));
                account.setUsername(rs.getString(5));
                account.setPassword(rs.getString(6));
                account.setType(rs.getString(7));
                account.setCreated(rs.getDate(8));
                account.setStatus(rs.getInt(9));
                return account;
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

    public boolean deleteAccount(int accountId) {
        String sql = "DELETE FROM Account WHERE Account_ID = ?";
        int check = 0;
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, accountId);
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

//    public static void main(String[] args) {
//        AccountModel am = new  AccountModel();
//        
//        System.out.println(am.getOneAccount(4));
//    }
}
