/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.sql.PreparedStatement;
import models.DrugInfo;
import db.DBConection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class DrugLogic {

    public boolean saveDrugInfo(DrugInfo druginfo) {
        String sql = "INSERT INTO `drug_info`(`Drug_ID`, `Drug_name`, `Comment`) VALUES (?,?,?)";
        PreparedStatement ps;
        boolean result = false;
        try {
            ps = DBConection.getConnection().prepareStatement(sql);
            ps.setString(1, druginfo.getDrugId());
            ps.setString(2, druginfo.getDrugName());
            ps.setString(3, druginfo.getComment());

            ps.execute();
            result = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = false;
        }

        return result;
    }
}
