/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pakar.component;

import com.pakar.com.raven.chart.Chart;
import com.pakar.com.raven.main.*;
import com.pakar.com.raven.chart.ModelChart;
import com.pakar.koneksi.koneksi;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author RAVEN
 */
public class BarChart extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    public BarChart() {
        initComponents();
        setTitle("Tampilan Statistik Perbulan Untuk Semua Pegawai");
        getContentPane().setBackground(new Color(250, 250, 250));
        chart.addLegend("Hadir", new Color(9, 91, 255));
        chart.addLegend("Izin", new Color(33, 255, 9));
        chart.addLegend("Sakit", new Color(255, 255, 0));
        chart.addLegend("Alpha", new Color(255, 0, 0));
        chart.addData(new ModelChart("Januari", new double[]{getBln("Hadir", 1), getBln("Izin", 1), getBln("Tidak Hadir", 1), getBln("Lembur", 1)}));
        chart.addData(new ModelChart("Februari", new double[]{getBln("Hadir", 2), getBln("Izin", 2), getBln("Tidak Hadir", 2), getBln("Lembur", 2)}));
        chart.addData(new ModelChart("Maret", new double[]{getBln("Hadir", 3), getBln("Izin", 3), getBln("Tidak Hadir", 3), getBln("Lembur", 3)}));
        chart.addData(new ModelChart("April", new double[]{getBln("Hadir", 4), getBln("Izin", 4), getBln("Tidak Hadir", 4), getBln("Lembur", 4)}));
        chart.addData(new ModelChart("Mei", new double[]{getBln("Hadir", 5), getBln("Izin", 5), getBln("Tidak Hadir", 5), getBln("Lembur", 5)}));
        chart.addData(new ModelChart("Juni", new double[]{getBln("Hadir", 6), getBln("Izin", 6), getBln("Tidak Hadir", 6), getBln("Lembur", 6)}));
        chart.addData(new ModelChart("Juli", new double[]{getBln("Hadir", 7), getBln("Izin", 7), getBln("Tidak Hadir", 7), getBln("Lembur", 7)}));
        chart.addData(new ModelChart("Agustus", new double[]{getBln("Hadir", 8), getBln("Izin", 8), getBln("Tidak Hadir", 8), getBln("Lembur", 8)}));
        chart.addData(new ModelChart("September", new double[]{getBln("Hadir", 9), getBln("Izin", 9), getBln("Tidak Hadir", 9), getBln("Lembur", 9)}));
        chart.addData(new ModelChart("Oktober", new double[]{getBln("Hadir", 10), getBln("Izin", 10), getBln("Tidak Hadir", 10), getBln("Lembur", 10)}));
        chart.addData(new ModelChart("November", new double[]{getBln("Hadir", 11), getBln("Izin", 11), getBln("Tidak Hadir", 11), getBln("Lembur", 11)}));
        chart.addData(new ModelChart("Desember", new double[]{getBln("Hadir", 12), getBln("Izin", 12), getBln("Tidak Hadir", 12), getBln("Lembur", 12)}));
        TampilTH();
    }
//    select month(tanggal) as bulan, year(tanggal) as tahun, count(*) as total, keterangan from presensi group by tahun;
    public void TampilTH(){
        Chart ch = new Chart();
        java.util.Date date= new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        String strDate = DateFormat.getDateInstance().format(date);
    }
    private double getBln(String ket, int bulan){
        String sql = "select count(*) from presensi where keterangan = '" + ket + "' && month(tanggal) = "+ bulan +" && year(tanggal) = year(current_date)";
        double Bln = 0;
        try{
            java.sql.Connection conn=(Connection)koneksi.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet rs=stm.executeQuery(sql);
            System.out.println(sql);
            if(rs.next()){
                Bln = rs.getDouble(1);
                System.out.println(rs.getDouble(1));
            }
        }catch(SQLException ex){
            
        }
        return Bln;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chart = new com.pakar.com.raven.chart.Chart();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(BarChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BarChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BarChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BarChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BarChart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.pakar.com.raven.chart.Chart chart;
    // End of variables declaration//GEN-END:variables
}