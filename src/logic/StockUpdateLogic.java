/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import db.DBConection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.StockInfo;

/**
 *
 * @author User
 */
public class StockUpdateLogic {

    public String getDrugNameById(String drugid) {
        String sql = "SELECT Drug_name FROM `drug_info` WHERE Drug_ID = ?";
        String drugname = null;
        try {
            PreparedStatement ps = DBConection.getConnection().prepareStatement(sql);
            ps.setString(1, drugid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                drugname = rs.getString("Drug_name");
                return drugname;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return drugname;
    }

    public boolean saveDrugInfo(StockInfo stockInfo) throws ParseException {

        String sql = "INSERT INTO `information` (`Drug_ID`, `Lot_no`, `Price_per_item`,`Date`) VALUES (?,?,?,?)";
        PreparedStatement ps;
        boolean result = false;
        try {
            ps = DBConection.getConnection().prepareStatement(sql);
            ps.setString(1, stockInfo.getDrugId());
            ps.setString(2, stockInfo.getLotnum());
            ps.setDouble(3, stockInfo.getPricePerUnit());
            Date mydate = new SimpleDateFormat("YYYY-MM-dd").parse(stockInfo.getDate());
            java.sql.Date sqlDate = new java.sql.Date(mydate.getTime());
            ps.setDate(4, sqlDate);
            ps.execute();
            result = true;

        } catch (MySQLIntegrityConstraintViolationException e) {

            String sql1 = "UPDATE `information` SET `Lot_no`=?,`Price_per_item`=?,`Date`=? WHERE `Drug_ID` = ?";
            try {
                ps = DBConection.getConnection().prepareStatement(sql1);
                ps.setString(1, stockInfo.getLotnum());
                ps.setDouble(2, stockInfo.getPricePerUnit());
                Date mydate = new SimpleDateFormat("YYYY-MM-dd").parse(stockInfo.getDate());
                java.sql.Date sqlDate = new java.sql.Date(mydate.getTime());
                ps.setDate(3, sqlDate);
                ps.setString(4, stockInfo.getDrugId());
                ps.executeUpdate();
                result = true;

            } catch (SQLException ex) {
                ex.printStackTrace();
                result = false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            result = false;

        }
        return result;
    }

    public boolean drugInfoTableUpdate(String drugId, int numberOfItems, double pricePerItem) {

        String sql1 = "SELECT Number_of_items  FROM `drug_info` WHERE Drug_ID = ?";
        String sql2 = "UPDATE `drug_info` SET `Number_of_items`=?,`Price_per_item`=? WHERE Drug_ID = ?";
        PreparedStatement ps;
        boolean result;
        try {
            ps = DBConection.getConnection().prepareStatement(sql1);
            ps.setString(1, drugId);
            ResultSet rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt("Number_of_items");
            }
            int totalNumItems = count + numberOfItems;
            ps = DBConection.getConnection().prepareStatement(sql2);
            ps.setInt(1, totalNumItems);
            ps.setDouble(2, pricePerItem);
            ps.setString(3, drugId);
            ps.executeUpdate();
            result = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            result = false;

        }
        
       

        return result;
    }
    
    
}
