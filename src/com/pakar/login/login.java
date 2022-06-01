/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pakar.login;
import com.formdev.flatlaf.FlatLightLaf;
import com.pakar.component.Header;
import com.pakar.component.Header2;
import com.pakar.component.PopupRegister;
import com.pakar.koneksi.Select;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import com.pakar.koneksi.koneksi;
import com.raven.main.Main;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 *
 * @author Akbar Ramadhani Firdaus
 */
public class login extends javax.swing.JFrame {
    // deklarasi

    public login() {
        initComponents();
         try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {

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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        txtbtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Montserrat", 1, 30)); // NOI18N
        jLabel2.setText("Password   :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, -1, 50));

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/close.png"))); // NOI18N
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        jPanel1.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 10, 100, 90));

        jLabel5.setFont(new java.awt.Font("Montserrat", 1, 30)); // NOI18N
        jLabel5.setText("Username  :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, -1, 50));

        txtusername.setFont(new java.awt.Font("Montserrat", 1, 30)); // NOI18N
        txtusername.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtusername.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        jPanel1.add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 420, 290, 30));

        txtpass.setFont(new java.awt.Font("Montserrat", 1, 30)); // NOI18N
        txtpass.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtpass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        txtpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpassActionPerformed(evt);
            }
        });
        jPanel1.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 480, 290, 30));

        jLabel3.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Login");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 570, -1, 40));

        txtbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Button.png"))); // NOI18N
        txtbtn.setBorder(null);
        txtbtn.setContentAreaFilled(false);
        txtbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbtnActionPerformed(evt);
            }
        });
        jPanel1.add(txtbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 560, -1, -1));

        jLabel4.setFont(new java.awt.Font("Montserrat", 1, 80)); // NOI18N
        jLabel4.setText("Login");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Login.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtpassActionPerformed

    private void txtbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbtnActionPerformed
                                        
                
        try {
            Select select = new Select();
            String[] condition = {
            "username = '"+txtusername.getText()+"'",
            "password = '"+txtpass.getText()+"'",
            };
            ResultSet rs = select.getWhere("admin",condition);
            if(rs.next()){
                txtusername.setText(rs.getString("Username"));
                if(txtpass.getText().equals(rs.getString("Password")) && txtusername.getText().equals(rs.getString("Username"))){
                    JOptionPane.showMessageDialog(null, "berhasil login");
                    this.setVisible(false);
                    Header hd = new Header();
                    hd.lbUserName.setText(txtusername.getText());
//                    UserSession us = UserSession();
                    Main utm = new Main();
                    utm.setVisible(true);
                    dispose();
                }
            }else{
                    JOptionPane.showMessageDialog(null, "Username atau Password Salah", "Pesan Pemberitahuan", JOptionPane.WARNING_MESSAGE);
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtbtnActionPerformed

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
       this.setVisible(false);
    }//GEN-LAST:event_closeMouseClicked

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton txtbtn;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}