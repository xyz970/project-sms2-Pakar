/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pakar.component;

import com.pakar.com.main.*;
import com.pakar.form.Form3;
import com.pakar.com.chart.ModelPolarAreaChart;
import com.pakar.koneksi.koneksi;
import java.awt.Color;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author RAVEN
 */
public class PolarChart extends javax.swing.JFrame {


    /**
     * Creates new form Test
     */
    public PolarChart() {
        initComponents();
        getContentPane().setBackground(new Color(255, 255, 255));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        refresh_button = new javax.swing.JButton();
        polarAreaChart = new com.pakar.com.chart.PolarAreaChart();
        jLabel1 = new javax.swing.JLabel();
        txt_hadir = new javax.swing.JLabel();
        txt_izin = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_sakit = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_alpha = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_nik = new javax.swing.JLabel();
        txt_nama = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_jabatan = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pilih_bulan = new com.toedter.calendar.JMonthChooser();
        pilih_tahun = new com.toedter.calendar.JYearChooser();
        button_submit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_lembur = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        refresh_button.setBackground(new java.awt.Color(255, 255, 255));
        refresh_button.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        refresh_button.setText("Refresh");
        refresh_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_buttonActionPerformed(evt);
            }
        });

        polarAreaChart.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel1.setText("Hadir              :");

        txt_hadir.setBackground(new java.awt.Color(255, 255, 255));
        txt_hadir.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N

        txt_izin.setBackground(new java.awt.Color(255, 255, 255));
        txt_izin.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel2.setText("Izin                 :");

        jLabel3.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel3.setText("Sakit               :");

        txt_sakit.setBackground(new java.awt.Color(255, 255, 255));
        txt_sakit.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel4.setText("Tidak Hadir    :");

        txt_alpha.setBackground(new java.awt.Color(255, 255, 255));
        txt_alpha.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel9.setText("NIK          :");

        txt_nik.setBackground(new java.awt.Color(255, 255, 255));
        txt_nik.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N

        txt_nama.setBackground(new java.awt.Color(255, 255, 255));
        txt_nama.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel10.setText("Nama       :");

        txt_jabatan.setBackground(new java.awt.Color(255, 255, 255));
        txt_jabatan.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel11.setText("Jabatan   :");

        button_submit.setBackground(new java.awt.Color(255, 255, 255));
        button_submit.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        button_submit.setText("Submit");
        button_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_submitActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel5.setText(" Lembur         :");

        txt_lembur.setBackground(new java.awt.Color(255, 255, 255));
        txt_lembur.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(polarAreaChart, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(txt_izin, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_hadir, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pilih_bulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pilih_tahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(104, 104, 104)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(refresh_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button_submit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_lembur, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_alpha, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_sakit, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txt_nik, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txt_jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(309, 309, 309)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pilih_bulan, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                            .addComponent(pilih_tahun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(refresh_button)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel1)
                                .addGap(8, 8, 8)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_hadir, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_izin, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_sakit, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_alpha, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(11, 11, 11)
                                .addComponent(jLabel5))
                            .addComponent(txt_lembur, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(polarAreaChart, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txt_nik, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txt_jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        polarAreaChart.start();
    }//GEN-LAST:event_formWindowOpened

    private void refresh_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_buttonActionPerformed
         int select_month = pilih_bulan.getMonth()+1; //get value from monthchooser
       int select_year = pilih_tahun.getYear(); //get value from yearchooser
       polarAreaChart.clear();
    
        //total_hadir
        try {
            String sql = "SELECT COUNT(keterangan) as total_hadir from presensi WHERE MONTH(tanggal) = "+select_month+" AND YEAR(tanggal) = "+select_year+" AND karyawan_nik='"+txt_nik.getText()+"' AND keterangan='Hadir'";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                txt_hadir.setText(String.valueOf(rs.getInt("total_hadir")));
                System.out.println(rs.getInt("total_hadir"));
                System.out.println(""+sql);
                polarAreaChart.addItem(new ModelPolarAreaChart(new Color(9, 91, 255), "Hadir", rs.getInt("total_hadir")));
                polarAreaChart.repaint();
            }
            System.out.println(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        
    }
        //total_sakit
         try {
            String sql = "SELECT COUNT(keterangan) as total_sakit from presensi WHERE MONTH(tanggal) = "+select_month+" AND YEAR(tanggal) = "+select_year+" AND karyawan_nik='"+txt_nik.getText()+"' AND keterangan='Sakit'";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                txt_sakit.setText(String.valueOf(rs.getInt("total_sakit")));
                System.out.println(rs.getInt("total_sakit"));
                System.out.println(""+sql);
                polarAreaChart.addItem(new ModelPolarAreaChart(new Color(255, 255, 0), "Sakit", rs.getInt("total_sakit")));
            }
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        
    }
         //total_izin
         try {
            String sql = "SELECT COUNT(keterangan) as total_izin from presensi WHERE MONTH(tanggal) = "+select_month+" AND YEAR(tanggal) = "+select_year+" AND karyawan_nik='"+txt_nik.getText()+"' AND keterangan='Izin'";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                txt_izin.setText(String.valueOf(rs.getInt("total_izin")));
                System.out.println(rs.getInt("total_izin"));
                System.out.println(""+sql);
                polarAreaChart.addItem(new ModelPolarAreaChart(new Color(33, 255, 9), "Izin", rs.getInt("total_izin")));
            }
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        
    }
         //total_alpha
         try {
            String sql = "SELECT COUNT(keterangan) as total_alpha from presensi WHERE MONTH(tanggal) = "+select_month+" AND YEAR(tanggal) = "+select_year+" AND karyawan_nik='"+txt_nik.getText()+"' AND keterangan='Tidak Hadir'";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                txt_alpha.setText(String.valueOf(rs.getInt("total_alpha")));
                System.out.println(rs.getInt("total_alpha"));
                System.out.println(""+sql);
                polarAreaChart.addItem(new ModelPolarAreaChart(new Color(255, 0, 0), "Alpha", rs.getInt("total_alpha")));
            }
          
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        
    } 
         //total_lembur
         try {
            String sql = "SELECT COUNT(id_jenis_presensi) as total_lembur from detail_presensi "
                    + " JOIN presensi "
                    + " ON presensi.id = id_presensi "
                    + " WHERE MONTH(presensi.tanggal) = "+select_month+" AND "
                    + " YEAR(presensi.tanggal) = "+select_year+" AND "
                    + " presensi.karyawan_nik='"+txt_nik.getText()+"' AND "
                    + " detail_presensi.id_jenis_presensi='LMBR'";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                txt_lembur.setText(String.valueOf(rs.getInt("total_lembur")));
                System.out.println(rs.getInt("total_lembur"));
                System.out.println(""+sql);
                polarAreaChart.addItem(new ModelPolarAreaChart(new Color(153, 50, 204), "Lembur", rs.getInt("total_lembur")));
            }
          
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        
    } 
       polarAreaChart.start();
        
    }//GEN-LAST:event_refresh_buttonActionPerformed

    private void button_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_submitActionPerformed
       int select_month = pilih_bulan.getMonth()+1; //get value from monthchooser
       int select_year = pilih_tahun.getYear(); //get value from yearchooser
       polarAreaChart.clear();
    
        //total_hadir
        try {
            String sql = "SELECT COUNT(keterangan) as total_hadir from presensi WHERE MONTH(tanggal) = "+select_month+" AND YEAR(tanggal) = "+select_year+" AND karyawan_nik='"+txt_nik.getText()+"' AND keterangan='Hadir'";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                txt_hadir.setText(String.valueOf(rs.getInt("total_hadir")));
                System.out.println(rs.getInt("total_hadir"));
                System.out.println(""+sql);
                polarAreaChart.addItem(new ModelPolarAreaChart(new Color(9, 91, 255), "Hadir", rs.getInt("total_hadir")));
                polarAreaChart.repaint();
            }
            System.out.println(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        
    }
        //total_sakit
         try {
            String sql = "SELECT COUNT(keterangan) as total_sakit from presensi WHERE MONTH(tanggal) = "+select_month+" AND YEAR(tanggal) = "+select_year+" AND karyawan_nik='"+txt_nik.getText()+"' AND keterangan='Sakit'";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                txt_sakit.setText(String.valueOf(rs.getInt("total_sakit")));
                System.out.println(rs.getInt("total_sakit"));
                System.out.println(""+sql);
                polarAreaChart.addItem(new ModelPolarAreaChart(new Color(255, 255, 0), "Sakit", rs.getInt("total_sakit")));
            }
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        
    }
         //total_izin
         try {
            String sql = "SELECT COUNT(keterangan) as total_izin from presensi WHERE MONTH(tanggal) = "+select_month+" AND YEAR(tanggal) = "+select_year+" AND karyawan_nik='"+txt_nik.getText()+"' AND keterangan='Izin'";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                txt_izin.setText(String.valueOf(rs.getInt("total_izin")));
                System.out.println(rs.getInt("total_izin"));
                System.out.println(""+sql);
                polarAreaChart.addItem(new ModelPolarAreaChart(new Color(33, 255, 9), "Izin", rs.getInt("total_izin")));
            }
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        
    }
         //total_alpha
         try {
            String sql = "SELECT COUNT(keterangan) as total_alpha from presensi WHERE MONTH(tanggal) = "+select_month+" AND YEAR(tanggal) = "+select_year+" AND karyawan_nik='"+txt_nik.getText()+"' AND keterangan='Tidak Hadir'";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                txt_alpha.setText(String.valueOf(rs.getInt("total_alpha")));
                System.out.println(rs.getInt("total_alpha"));
                System.out.println(""+sql);
                polarAreaChart.addItem(new ModelPolarAreaChart(new Color(255, 0, 0), "Alpha", rs.getInt("total_alpha")));
            }
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        
    } 
       polarAreaChart.start();
    }//GEN-LAST:event_button_submitActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(PolarChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PolarChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PolarChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PolarChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PolarChart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_submit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JMonthChooser pilih_bulan;
    private com.toedter.calendar.JYearChooser pilih_tahun;
    public com.pakar.com.chart.PolarAreaChart polarAreaChart;
    private javax.swing.JButton refresh_button;
    public javax.swing.JLabel txt_alpha;
    public javax.swing.JLabel txt_hadir;
    public javax.swing.JLabel txt_izin;
    public javax.swing.JLabel txt_jabatan;
    public javax.swing.JLabel txt_lembur;
    public javax.swing.JLabel txt_nama;
    public javax.swing.JLabel txt_nik;
    public javax.swing.JLabel txt_sakit;
    // End of variables declaration//GEN-END:variables
}
