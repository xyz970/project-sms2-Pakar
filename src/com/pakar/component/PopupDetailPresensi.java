/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pakar.component;

import com.pakar.db.Select;
import com.pakar.koneksi.koneksi;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author mhmmdadi21
 */
public class PopupDetailPresensi extends javax.swing.JFrame {

    /**
     * Creates new form PopupDetailPresensi
     * @throws java.sql.SQLException
     */
    public PopupDetailPresensi(){
        initComponents();
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);

    }
    DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

    public void load_table(String nama) throws SQLException{
        model.addColumn("Status");
        model.addColumn("Jam");
        model.addColumn("Kehadiran");
        model.addColumn("Keterangan");
        TableRowSorter myTableRowSorter = new TableRowSorter(model);
        jTable1.setRowSorter(myTableRowSorter);
         String sql2 = "SELECT karyawan.nik, presensi.id FROM `presensi` \n"
                    + " JOIN karyawan\n"
                    + " ON karyawan_nik = karyawan.nik where karyawan.nama = '"+nama+"'";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet User = stm.executeQuery(sql2);
            User.next();
        
        try {
            int no = 1;
            String sql = "SELECT jenis_presensi.ket_jenis_presensi,jam,keterangan FROM `detail_presensi` \n"
                    + "JOIN jenis_presensi\n"
                    + " ON id_jenis_presensi = jenis_presensi.id where detail_presensi.id_presensi = '"+User.getString(2)+"'";
            java.sql.ResultSet rs = stm.executeQuery(sql);

//            ResultSet rs = new Select().all("presensi");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1),
                    rs.getString(2), rs.getString(3)});
                jTable1.setModel(model);
                jTable1.validate();
                jTable1.repaint();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_nama = new javax.swing.JLabel();
        txt_tanggal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txt_nama.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        txt_nama.setText("Nama..");

        txt_tanggal.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        txt_tanggal.setText("Tanggal");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(txt_nama))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_tanggal))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_nama)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_tanggal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PopupDetailPresensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PopupDetailPresensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PopupDetailPresensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PopupDetailPresensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                    new PopupDetailPresensi().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public javax.swing.JLabel txt_nama;
    public javax.swing.JLabel txt_tanggal;
    // End of variables declaration//GEN-END:variables
}
