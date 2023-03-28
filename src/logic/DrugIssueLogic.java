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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.swing.JOptionPane;
import models.DrugIsueeInfo;
import models.StockInfo;

/**
 *
 * @author User
 */
public class DrugIssueLogic {

    private double currentTotal;
    double fullTotal = 0.0;

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

   /* public double calculateTotal(int numberOfItems, double pricePerItem) {
        double total = pricePerItem * numberOfItems;
        currentTotal = total;
        return total;
    }*/

    /*  public double calculateFullTotal() {

        fullTotal = fullTotal + currentTotal;
        return fullTotal;
    }*/
    /*public double calculatebalance(double cashIn) {

        double balance;
        balance = cashIn - fullTotal;
        return balance;
    }*/

    public boolean saveIsueeSummery(DrugIsueeInfo drugIsueeinfo) throws ParseException {

        String sql = "INSERT INTO `issue_summery`(`Oder_ID`, `Total`, `Cashin`, `balance`, `date`) VALUES (?,?,?,?,?) ";
        PreparedStatement ps;
        boolean result = false;
        try {
            ps = DBConection.getConnection().prepareStatement(sql);
            ps.setString(1, drugIsueeinfo.getOderId());
            ps.setDouble(2, drugIsueeinfo.getFullTotal());
            ps.setDouble(3, drugIsueeinfo.getBalance());
            ps.setDouble(4, drugIsueeinfo.getBalance());
            Date mydate = new SimpleDateFormat("YYYY-MM-dd").parse(drugIsueeinfo.getDate());
            java.sql.Date sqlDate = new java.sql.Date(mydate.getTime());
            ps.setDate(5, sqlDate);
            ps.execute();
            result = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = false;
        }

        return result;
    }

    public boolean saveIsueTable(String drugId, int numberOfItems, double total) {
        String sql = "SELECT Drug_name,Price_per_item FROM `drug_info` WHERE Drug_ID = ?";
        String sql1 = "INSERT INTO `issue`(`Drug_ID`, `Drug_name`, `Price_per_item`, `Number_of_Item`, `Total`) VALUES (?,?,?,?,?) ";
        PreparedStatement ps;
        PreparedStatement ps1 = null;
        String drugname = null;
        double pricePerItem = 0;
        try {
            ps = DBConection.getConnection().prepareStatement(sql);
            ps.setString(1, drugId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                drugname = rs.getString("Drug_name");
                pricePerItem = rs.getDouble("Price_per_item");

            }

            ps1 = DBConection.getConnection().prepareStatement(sql1);
            ps1.setString(1, drugId);
            ps1.setString(2, drugname);
            ps1.setDouble(3, pricePerItem);
            ps1.setInt(4, numberOfItems);
            ps1.setDouble(5, total);
            ps1.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public boolean checkNumberOfItems(int numberOfItems, String drugId) {
        String sql = "SELECT  Number_of_Items FROM `drug_info` WHERE Drug_ID = ?";
        int items = 0;
        PreparedStatement ps;
        PreparedStatement ps1;
        double Total = 0;
        try {
            ps = DBConection.getConnection().prepareStatement(sql);
            ps.setString(1, drugId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                items = rs.getInt("Number_of_Items");
            }
            if (items > numberOfItems) {
                int currentItems = items - numberOfItems;
                String sql2 = "UPDATE `drug_info` SET `Number_of_items`= ? WHERE Drug_ID = ?";
                ps1 = DBConection.getConnection().prepareStatement(sql2);
                ps1.setInt(1, currentItems);
                ps1.setString(2, drugId);
                ps1.execute();
                return true;

            } else {
                JOptionPane.showMessageDialog(null, "there is no enough quntity");
                return false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }
}
