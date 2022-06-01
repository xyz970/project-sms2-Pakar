/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pakar.component;

import com.formdev.flatlaf.FlatLightLaf;
import com.pakar.db.Insert;
import com.pakar.koneksi.koneksi;
import com.pakar.form.Form1;
import com.pakar.form.Form4;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Akbar Ramadhani Firdaus
 */
public class PopupInsertHariLibur extends javax.swing.JDialog {

    /**
     * Creates new form PopupInsertPegawai
     */
    public void close(){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    private void clear(){
        txt_id.setText(null);
        txt_hari.setText(null);
        txt_keterangan.setText(null);
    }
    
    public PopupInsertHariLibur(JFrame fr) {
        super(fr, true);
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {

        }
        initComponents();
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 40, 40));
        txt_id.setBackground(new java.awt.Color(0,0,0,1));
        txt_hari.setBackground(new java.awt.Color(0,0,0,1));
        txt_keterangan.setBackground(new java.awt.Color(0,0,0,1));
//        initiateDropdownJk();
//        initiateDropdownPekerjaan();
//        txt_nik.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_keterangan = new javax.swing.JTextField();
        txt_tanggal = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_hari = new javax.swing.JTextField();
        rounded3 = new com.pakar.component.Rounded();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        rounded2 = new com.pakar.component.Rounded();
        jLabel17 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(39, 211, 249));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        jLabel6.setText("Keterangan       :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jLabel11.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        jLabel11.setText("____________________");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 220, 40));

        jLabel5.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        jLabel5.setText("Tanggal              :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, 30));

        txt_keterangan.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        txt_keterangan.setBorder(null);
        getContentPane().add(txt_keterangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 200, 30));

        txt_tanggal.setDateFormatString("yyyy-M-dd");
        txt_tanggal.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        getContentPane().add(txt_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 200, 30));

        jLabel4.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        jLabel4.setText("ID                        :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel10.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        jLabel10.setText("____________________");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 200, 40));

        jLabel2.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        jLabel2.setText("Hari                     :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel9.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        jLabel9.setText("____________________");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 200, -1));

        txt_id.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        txt_id.setBorder(null);
        txt_id.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        txt_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_idKeyPressed(evt);
            }
        });
        getContentPane().add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 200, 30));

        txt_hari.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        txt_hari.setBorder(null);
        getContentPane().add(txt_hari, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 200, 30));

        rounded3.setBackground(new java.awt.Color(204, 204, 204));
        rounded3.setRoundBottomLeft(40);
        rounded3.setRoundBottomRight(40);
        rounded3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("CLEAR");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        rounded3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 100, 30));

        jButton2.setBackground(new java.awt.Color(64, 194, 255));
        jButton2.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("SIMPAN");
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        rounded3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 100, 30));

        getContentPane().add(rounded3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 480, 390));

        rounded2.setBackground(new java.awt.Color(64, 194, 255));
        rounded2.setRoundBottomLeft(40);
        rounded2.setRoundBottomRight(40);
        rounded2.setRoundTopLeft(40);
        rounded2.setRoundTopRight(40);
        rounded2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel17.setText("X");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        rounded2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 20, 20));

        jLabel3.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel3.setText("Tambah Jadwal Libur");
        rounded2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 290, 40));

        jLabel16.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("________________________________________________");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rounded2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, 40));

        getContentPane().add(rounded2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clear();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/raven/icon/check.png"));
        try{
            Insert insert = new Insert();
            String pattern = "YYYY-M-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String[] id = {"id","hari","keterangan","tanggal"};
            String tanggal = simpleDateFormat.format(txt_tanggal.getDateEditor().getDate());
            String[] rowData = {txt_id.getText(),txt_hari.getText(),txt_keterangan.getText(),tanggal};
            insert.Table("jadwal_libur", id, rowData);
//            String sql = "INSERT INTO jadwal_libur VALUES ('"+txt_id.getText()+"','"
//            +txt_hari.getText()+"','"+txt_keterangan.getText()+"')";
//            java.sql.Connection conn=(Connection)koneksi.configDB();
//            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
//            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil", "Pesan Pemberitahuan", JOptionPane.PLAIN_MESSAGE, icon);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        this.setVisible(false);
        new Form4().load_table();
        new Form4().repaint();
        clear();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void txt_idKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idKeyPressed

    }//GEN-LAST:event_txt_idKeyPressed

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        close();
    }//GEN-LAST:event_jLabel17MouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(PopupInsertHariLibur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PopupInsertHariLibur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PopupInsertHariLibur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PopupInsertHariLibur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PopupInsertHariLibur().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private com.pakar.component.Rounded rounded2;
    private com.pakar.component.Rounded rounded3;
    public javax.swing.JTextField txt_hari;
    public javax.swing.JTextField txt_id;
    public javax.swing.JTextField txt_keterangan;
    public com.toedter.calendar.JDateChooser txt_tanggal;
    // End of variables declaration//GEN-END:variables
}
