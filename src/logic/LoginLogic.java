/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import db.DBConection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.User;

/**
 *
 * @author User
 */
public class LoginLogic {

    public boolean checkUsercredentials(User user) throws SQLException {
        
        String sql = "SELECT User_password FROM `user` WHERE User_name = ?";
        PreparedStatement ps = DBConection.getConnection().prepareStatement(sql);
        ps.setString(1,user.getUsername());
        ResultSet rs = ps.executeQuery();
        String storedpassword = "";
          if (rs.next()){
            storedpassword = rs.getString("User_password");
        }
        if ( storedpassword.equals(user.getPassword())){
            return true;
        }
        return false;
    }
}
