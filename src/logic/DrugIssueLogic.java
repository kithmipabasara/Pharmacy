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
import javafx.util.Pair;
import models.StockInfo;

/**
 *
 * @author User
 */
public class DrugIssueLogic {

    

    public StockInfo getDrugDetailsById(String drugid) {
        String sql = "SELECT Drug_name,Price_per_item FROM `drug_info` WHERE Drug_ID = ?";

        try {
            PreparedStatement ps = DBConection.getConnection().prepareStatement(sql);
            ps.setString(1, drugid);
            ResultSet rs = ps.executeQuery();
            String drugname = null;
            double pricePerItem;
            if (rs.next()) {
                drugname = rs.getString("Drug_name");
                pricePerItem = rs.getDouble("Price_per_item");
                StockInfo stockinfo = new StockInfo();
                stockinfo.setDrugName(drugname);
                stockinfo.setPricePerUnit(pricePerItem);
                return stockinfo;

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return null;
    }

    public double calculateTotal(int numberOfItems, double pricePerItem) {
        double total = pricePerItem * numberOfItems;
        return total;
    }

    public double calculateFullTotal(double currenttotal) {

        return 3;
    }

}
