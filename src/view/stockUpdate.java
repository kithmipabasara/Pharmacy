/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.sun.glass.events.KeyEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logic.StockUpdateLogic;
import models.StockInfo;

/**
 *
 * @author User
 */
public class stockUpdate extends javax.swing.JFrame {

    /**
     * Creates new form stockUpdate
     */
    public stockUpdate() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        drugid = new javax.swing.JTextField();
        drugname = new javax.swing.JTextField();
        lotnum = new javax.swing.JTextField();
        pricePerUnit = new javax.swing.JTextField();
        numOfItem = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        cancle = new javax.swing.JButton();
        date = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("DrugId");

        jLabel2.setText("DrugName");

        jLabel3.setText("Lot Num");

        jLabel4.setText("Price per Item");

        jLabel5.setText("Number of Item");

        jLabel6.setText("Date");

        drugid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drugidActionPerformed(evt);
            }
        });
        drugid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                drugidKeyPressed(evt);
            }
        });

        drugname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drugnameActionPerformed(evt);
            }
        });

        lotnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lotnumActionPerformed(evt);
            }
        });

        numOfItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numOfItemActionPerformed(evt);
            }
        });

        save.setText("save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        cancle.setText("cancel");
        cancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(save)
                        .addGap(77, 77, 77)
                        .addComponent(cancle))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(numOfItem)
                            .addComponent(pricePerUnit)
                            .addComponent(lotnum)
                            .addComponent(drugname)
                            .addComponent(drugid)
                            .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(drugid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(drugname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lotnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pricePerUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(numOfItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(cancle))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void drugidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drugidActionPerformed

    }//GEN-LAST:event_drugidActionPerformed

    private void drugnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drugnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_drugnameActionPerformed

    private void lotnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lotnumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lotnumActionPerformed

    private void cancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancleActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        String drugid1 = drugid.getText();
        String drugname1 = drugname.getText();
        String lotnum1 = lotnum.getText();
        String priceperunit = pricePerUnit.getText();
        String numberofitem = numOfItem.getText();
        SimpleDateFormat dFormat = new SimpleDateFormat("YYYY-MM-dd");
        String date1 = dFormat.format(date.getDate());
        StockInfo stockInfo = new StockInfo();
        stockInfo.setDrugId(drugid1);
        stockInfo.setDrugName(drugname1);
        stockInfo.setLotnum(lotnum1);
        stockInfo.setNumOfItem(Integer.valueOf(numberofitem));
        stockInfo.setPricePerUnit(Double.valueOf(priceperunit));
        stockInfo.setDate(date1);
        StockUpdateLogic stockUpdateLogic = new StockUpdateLogic();
        int numOfItem = Integer.valueOf(numberofitem);
        double pricePerUnit = Double.valueOf(priceperunit);

        boolean result = false;
        boolean result2 = false;
        try {
            result = stockUpdateLogic.saveDrugInfo(stockInfo);
            result2 = stockUpdateLogic.drugInfoTableUpdate(drugid1, numOfItem, pricePerUnit);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        if (result && result2) {
            JOptionPane.showMessageDialog(null, "data entered Sucsessfully");
        } else {
            JOptionPane.showMessageDialog(null, "there is error while entering data ");
        }

        result2 = stockUpdateLogic.drugInfoTableUpdate(drugid1, numOfItem, pricePerUnit);


    }//GEN-LAST:event_saveActionPerformed

    private void drugidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_drugidKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String drugId = drugid.getText();
            String drugName;
            StockUpdateLogic stockUpdateLogic = new StockUpdateLogic();
            drugName = stockUpdateLogic.getDrugNameById(drugId);
            if (drugName == null) {
                drugname.setText("drug name not found");
                JOptionPane.showMessageDialog(null, "Drug name not found");
            } else {
                drugname.setText(drugName);
            }

        }
    }//GEN-LAST:event_drugidKeyPressed

    private void numOfItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numOfItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numOfItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(stockUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(stockUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(stockUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(stockUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new stockUpdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancle;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JTextField drugid;
    private javax.swing.JTextField drugname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField lotnum;
    private javax.swing.JTextField numOfItem;
    private javax.swing.JTextField pricePerUnit;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
}
