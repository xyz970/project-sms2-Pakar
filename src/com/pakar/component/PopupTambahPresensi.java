package com.pakar.component;

import com.pakar.db.Select;
import com.pakar.db.Settings;
import com.pakar.koneksi.koneksi;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mhmmdadi21
 */
public class PopupTambahPresensi extends javax.swing.JFrame {

    /**
     * Creates new form PopupTambahPresensi
     */
    public PopupTambahPresensi() {
        initComponents();
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
        status_option.removeAllItems();
        String[] option = {"Sakit", "Izin", "Lembur", "Hadir","Tidak Hadir"};
        for (String option1 : option) {
            status_option.addItem(option1);
        }
    }

    public void close() {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    private String SearchNIK(String nama) throws SQLException {
//        Select select = new Select();
        String sql = "Select * from karyawan where nama LIKE '%" + nama + "%'";
        java.sql.Connection conn = (Connection) koneksi.configDB();
        java.sql.Statement stm = conn.createStatement();
        java.sql.ResultSet rs = stm.executeQuery(sql);
        int count = 0;
        rs.next();
//        while (rs.next()) {            
//          count++;   
//        }
//        if (count >= 2) {
//            JOptionPane.showMessageDialog(new PopupTambahPresensi(), "Data dengan nama"
//                    + " "+nama+" terdapat duplikasi, mohon untuk memasukkan nama dengan lengkap");
//        }
//        System.out.println(rs.getString(2));
        return rs.getString(1);
    }

    private void InsertPresensi(String nama) throws SQLException {
        String pattern = "YYYY-M-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String[] id = {"id", "hari", "keterangan", "tanggal"};
        String tanggal = simpleDateFormat.format(txt_tanggal.getDateEditor().getDate());
        java.sql.Connection con = (Connection) Settings.MyConfig();
        Select slct = new Select();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(txt_tanggal.getDateEditor().getDate());
        String idformat = date + "_" + SearchNIK(nama);
        String status = status_option.getSelectedItem().toString();

        if (status.equals("Lembur")) {
            InsertDetail(idformat);
        } else {
            String[] condition = {" id = '" + idformat + "'"};
            ResultSet checkPresensi = slct.getWhere("presensi", condition);
            if (checkPresensi.next()) {
                JOptionPane.showMessageDialog(this, "Anda Telah presensi pada hari tersebut","Terjadi kesalahan",JOptionPane.ERROR_MESSAGE);
            } else {
                

            String sqlInsert = "INSERT INTO `presensi`\n"
                    + "(`id`, `tanggal`, `karyawan_nik`, `keterangan`) \n"
                    + "VALUES \n"
                    + " ('" + idformat + "','" + tanggal + "','" + SearchNIK(nama) + "','" + status + "')";
            java.sql.PreparedStatement pst2 = con.prepareStatement(sqlInsert);
            pst2.execute();
            dialog();
            }
        }

    }

    private void dialog() {
        JOptionPane.showMessageDialog(this, "Data presensi berhasil dimasukkan");
    }

    private void InsertDetail(String format) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date dateDate = new Date();
        String timeNow = dateFormat.format(dateDate);

        try {
            String[] condition = {" id = '" + format + "'"};
            ResultSet rs = new Select().getWhere("presensi", condition);
            if (rs.next()) {
                java.sql.Connection con = (Connection) Settings.MyConfig();
                String sqlInsert = "INSERT INTO `detail_presensi`\n"
                        + "(`id_presensi`, `id_jenis_presensi`, `jam`, `keterangan`) \n"
                        + "VALUES ('" + format + "','LMBR','" + timeNow + "','Toleransi')";
                java.sql.PreparedStatement pst2 = con.prepareStatement(sqlInsert);
                pst2.execute();
                dialog();
            } else {
                 JOptionPane.showMessageDialog(this, "Lembur tidak tersedia, dikarenakan anda tidak presensi pada hari tersebut","Terjadi kesalahan",JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

//        try {
//            java.sql.Connection con = (Connection) Settings.MyConfig();
//        String sqlInsert = "INSERT INTO `detail_presensi`\n"
//                + "(`id_presensi`, `id_jenis_presensi`, `jam`, `keterangan`) \n"
//                + "VALUES ('" + format + "','LMBR','" + timeNow + "','Toleransi')";
//        java.sql.PreparedStatement pst2 = con.prepareStatement(sqlInsert);
//        pst2.execute();
//        dialog();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(this, e.getMessage());
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_nama = new javax.swing.JTextField();
        status_option = new javax.swing.JComboBox<>();
        btn_simpan = new javax.swing.JButton();
        txt_tanggal = new com.toedter.calendar.JDateChooser();
        rounded2 = new com.pakar.component.Rounded();
        rounded1 = new com.pakar.component.Rounded();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel3.setText("Tanggal");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 149, -1, -1));

        jLabel2.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel2.setText("Nama");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 106, -1, -1));

        jLabel4.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel4.setText("Status");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 190, -1, -1));
        getContentPane().add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 108, 333, -1));

        status_option.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(status_option, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 192, 333, -1));

        btn_simpan.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 279, -1, -1));

        txt_tanggal.setDateFormatString("yyyy-M-dd");
        getContentPane().add(txt_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 149, 333, -1));

        rounded2.setBackground(new java.awt.Color(255, 255, 255));
        rounded2.setRoundBottomLeft(40);
        rounded2.setRoundBottomRight(40);
        rounded2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(rounded2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 480, 330));

        rounded1.setBackground(new java.awt.Color(64, 194, 255));
        rounded1.setRoundBottomLeft(40);
        rounded1.setRoundBottomRight(40);
        rounded1.setRoundTopLeft(40);
        rounded1.setRoundTopRight(40);
        rounded1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel1.setText("Tambah Presensi");
        rounded1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel5.setText("________________________________________");
        rounded1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, 20));

        jLabel6.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel6.setText("X");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        rounded1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, -1));

        getContentPane().add(rounded1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        if (txt_nama.getText() == null || txt_tanggal.getDate() == null) {
            JOptionPane.showMessageDialog(new PopupTambahPresensi(), "Dimohon untuk mengisi field yang tersedia");
        } else {
            try {
                InsertPresensi(txt_nama.getText());

//                this.setVisible(false);
//                throw new Exception("Data sudah ada, Anda sudah melakukan absen pada hari tersebut");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        close();
    }//GEN-LAST:event_jLabel6MouseClicked

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
            java.util.logging.Logger.getLogger(PopupTambahPresensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PopupTambahPresensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PopupTambahPresensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PopupTambahPresensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PopupTambahPresensi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_simpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private com.pakar.component.Rounded rounded1;
    private com.pakar.component.Rounded rounded2;
    private javax.swing.JComboBox<String> status_option;
    public javax.swing.JTextField txt_nama;
    private com.toedter.calendar.JDateChooser txt_tanggal;
    // End of variables declaration//GEN-END:variables
}
