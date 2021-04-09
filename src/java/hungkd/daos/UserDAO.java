/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungkd.daos;

import hungkd.dtos.UserDTO;
import hungkd.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author PC
 */
public class UserDAO {

    public UserDTO checkLogin(String userID, String password) throws ClassNotFoundException, SQLException {
        UserDTO user = null;
        String sql = "select fullName, roleID from tblUsers where userID='" + userID + "' and password='" + password + "'";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            pstm = conn.prepareStatement(sql);
//            pstm.setString(1, userID);
//            pstm.setString(2, password);
            rs = pstm.executeQuery();
            if (rs.next()) {
                String fullName = rs.getNString("fullName");
                String roleID = rs.getNString("roleID");
                user = new UserDTO(userID, fullName, "", roleID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (pstm != null) pstm.close();
            if (conn != null) conn.close();
        }
        return user;
    }
    
    public List<UserDTO> getListUser(String search) throws SQLException{
        List<UserDTO> list = new ArrayList<>();
        String sql = "select userID, fullName, roleID from tblUsers where fullName like ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, "%" + search + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                String userID = rs.getNString("userID");
                String fullName = rs.getNString("fullName");
                String roleID = rs.getNString("roleID");
                list.add(new UserDTO(userID, fullName, "*********", roleID));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (pstm != null) pstm.close();
            if (conn != null) conn.close();
        }
        return list;
    }
    
    public void deleteUser(String userID) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Delete tblUsers where userID=?";
                pstm=conn.prepareStatement(sql);
                pstm.setString(1, userID);
                pstm.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
            if (pstm != null) pstm.close();
            if (conn != null) conn.close();
        }
    }
    
    public void updateUser(UserDTO user) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        String sql = "update tblUsers set fullName=?, roleID=? where userID=?";
        try {
            conn = DBUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, user.getFullName());
            pstm.setString(2, user.getRoleID());
            pstm.setString(3, user.getUserID());
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstm != null) pstm.close();
            if (conn != null) conn.close();
        }
    }
    
    public boolean checkDuplicate(String userID) throws SQLException {
        boolean result=true;
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Select userID from tblUsers where userID=?";
                pstm=conn.prepareStatement(sql);
                pstm.setString(1, userID);
                rs=pstm.executeQuery();
                if(rs.next())
                    result=false;
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) rs.close();
            if (pstm != null) pstm.close();
            if (conn != null) conn.close();
        }
        return result;
    }
    
    public void insertUser(UserDTO user) throws SQLException {
        String sql = "insert into tblUsers(userID,fullName,password,roleID) values(?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, user.getUserID());
            pstm.setString(2, user.getFullName());
            pstm.setString(3, user.getPassword());
            pstm.setString(4, user.getRoleID());
            pstm.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstm != null) pstm.close();
            if (conn != null) conn.close();
        }
    }
    
    public void insertUser_Throw(UserDTO user) throws SQLException, ClassNotFoundException, NamingException {
        String sql = "insert into tblUsers(userID,fullName,password,roleID) values(?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, user.getUserID());
            pstm.setString(2, user.getFullName());
            pstm.setString(3, user.getPassword());
            pstm.setString(4, user.getRoleID());
            pstm.executeUpdate();
            }
        } finally {
            if (pstm != null) pstm.close();
            if (conn != null) conn.close();
        }
    }
}
