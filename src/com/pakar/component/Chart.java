package com.pakar.component;

import com.pakar.com.raven.chart.LegendItem;
import com.pakar.com.raven.chart.ModelChart;
import com.pakar.com.raven.chart.ModelLegend;
import com.pakar.com.raven.chart.blankchart.BlankPlotChart;
import com.pakar.com.raven.chart.blankchart.BlankPlotChatRender;
import com.pakar.com.raven.chart.blankchart.SeriesSize;
import com.pakar.component.BarChart;
import com.pakar.koneksi.koneksi;
import java.awt.Color;
import java.awt.Graphics2D;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.SwingConstants;

public class Chart extends javax.swing.JPanel {

    private List<ModelLegend> legends = new ArrayList<>();
    private List<ModelChart> model = new ArrayList<>();
    private final int seriesSize = 12;
    private final int seriesSpace = 6;
    Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy", Locale.US);
        String getCurrentYear = dateFormat.format(now);

    public Chart() {
        initComponents();
        txt_tahun.setText(getCurrentYear);
//        txt_tahun.setHorizontalAlignment(SwingConstants.CENTER);
//        LocalDate dateObject = LocalDate.now();
//        DateTimeFormatter format =  DateTimeFormatter.ofPattern("yyyy");
//        txt_tahun.setText(dateObject.format(format));
        blankPlotChart.setBlankPlotChatRender(new BlankPlotChatRender() {
            @Override
            public String getLabelText(int index) {
                return model.get(index).getLabel();
            }

            @Override
            public void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index) {
                double totalSeriesWidth = (seriesSize * legends.size()) + (seriesSpace * (legends.size() - 1));
                double x = (size.getWidth() - totalSeriesWidth) / 2;
                for (int i = 0; i < legends.size(); i++) {
                    ModelLegend legend = legends.get(i);
                    g2.setColor(legend.getColor());
                    double seriesValues = chart.getSeriesValuesOf(model.get(index).getValues()[i], size.getHeight());
                    g2.fillRect((int) (size.getX() + x), (int) (size.getY() + size.getHeight() - seriesValues), seriesSize, (int) seriesValues);
                    x += seriesSpace + seriesSize;
                }
            }
        });
        Tampil();
    }

    public void Tampil() {
        addLegend("Hadir", new Color(9, 91, 255));
        addLegend("Izin", new Color(33, 255, 9));
        addLegend("Sakit", new Color(255, 255, 0));
        addLegend("Lembur", new Color(204, 0, 204));
        addLegend("Alpha", new Color(255, 0, 0));

        loadData();
    }

    public void loadData() {
        addData(new ModelChart("Januari", new double[]{getBln("Hadir", 1), getBln("Izin", 1), getBln("Sakit", 1), getLembur("Lembur", 1), getBln("Tidak Hadir", 1)}));
        addData(new ModelChart("Februari", new double[]{getBln("Hadir", 2), getBln("Izin", 2), getBln("Sakit", 2), getLembur("Lembur", 2), getBln("Tidak Hadir", 1)}));
        addData(new ModelChart("Maret", new double[]{getBln("Hadir", 3), getBln("Izin", 3), getBln("Sakit", 3), getLembur("Lembur", 3), getBln("Tidak Hadir", 1)}));
        addData(new ModelChart("April", new double[]{getBln("Hadir", 4), getBln("Izin", 4), getBln("Sakit", 4), getLembur("Lembur", 4), getBln("Tidak Hadir", 1)}));
        addData(new ModelChart("Mei", new double[]{getBln("Hadir", 5), getBln("Izin", 5), getBln("Sakit", 5), getLembur("Lembur", 5), getBln("Tidak Hadir", 1)}));
        addData(new ModelChart("Juni", new double[]{getBln("Hadir", 6), getBln("Izin", 6), getBln("Sakit", 6), getLembur("Lembur", 6), getBln("Tidak Hadir", 1)}));
        addData(new ModelChart("Juli", new double[]{getBln("Hadir", 7), getBln("Izin", 7), getBln("Sakit", 7), getLembur("Lembur", 7), getBln("Tidak Hadir", 1)}));
        addData(new ModelChart("Agustus", new double[]{getBln("Hadir", 8), getBln("Izin", 8), getBln("Sakit", 8), getLembur("Lembur", 8), getBln("Tidak Hadir", 1)}));
        addData(new ModelChart("September", new double[]{getBln("Hadir", 9), getBln("Izin", 9), getBln("Sakit", 9), getLembur("Lembur", 9), getBln("Tidak Hadir", 1)}));
        addData(new ModelChart("Oktober", new double[]{getBln("Hadir", 10), getBln("Izin", 10), getBln("Sakit", 10), getLembur("Lembur", 10), getBln("Tidak Hadir", 1)}));
        addData(new ModelChart("November", new double[]{getBln("Hadir", 11), getBln("Izin", 11), getBln("Sakit", 11), getLembur("Lembur", 11), getBln("Tidak Hadir", 1)}));
        addData(new ModelChart("Desember", new double[]{getBln("Hadir", 12), getBln("Izin", 12), getBln("Sakit", 12), getLembur("Lembur", 12), getBln("Tidak Hadir", 1)}));


    }

    public double getFieldMonth(String ket, int bulan) {
        Date now = new Date();
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy", Locale.US);
        String getCurrentYear = dateFormat.format(now);
       
        String sql = "select count(*) from presensi where keterangan = '" + ket + "' && month(tanggal) = " + bulan + " "
                + " && year(tanggal) = year(current_year)";
        double Bln = 0;
        try {
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);
            System.out.println(sql);
            if (rs.next()) {
                Bln = rs.getDouble(1);
                System.out.println(rs.getDouble(1));
            }
        } catch (SQLException ex) {

        }
        return Bln;
    }

    public double getBln(String ket, int bulan) {
        Date now = new Date();
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy", Locale.US);
        String getCurrentYear = dateFormat.format(now);
        String sql = "select count(*) from presensi where keterangan = '" + ket + "' && month(tanggal) = " + bulan + " "
                + " && year(tanggal) = year(current_date)";
        double Bln = 0;
        try {
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);
//            System.out.println(sql);
            if (rs.next()) {
                Bln = rs.getDouble(1);
                System.out.println(rs.getDouble(1));
            }
        } catch (SQLException ex) {

        }
        return Bln;
    }
    
    public double getLembur(String ket, int bulan) {
        Date now = new Date();
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy", Locale.US);
        String getCurrentYear = dateFormat.format(now);
        String sql = "select count(*) from detail_presensi JOIN presensi "
                + " ON id_presensi = presensi.id "
                + " where id_jenis_presensi = 'LMBR' "
                + " && month(presensi.tanggal) = " + bulan + " "
                + " && year(presensi.tanggal) = year(current_date)";
        double Bln = 0;
        try {
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);
//            System.out.println(sql);
            if (rs.next()) {
                Bln = rs.getDouble(1);
                System.out.println(rs.getDouble(1));
            }
        } catch (SQLException ex) {

        }
        return Bln;
    }

    public void addLegend(String name, Color color) {
        ModelLegend data = new ModelLegend(name, color);
        legends.add(data);
        panelLegend.add(new LegendItem(data));
        panelLegend.repaint();
        panelLegend.revalidate();
    }

    public void addData(ModelChart data) {

        model.add(data);
        blankPlotChart.setLabelCount(model.size());
        double max = data.getMaxValues();
        if (max > blankPlotChart.getMaxValues()) {
            blankPlotChart.setMaxValues(max);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLegend = new javax.swing.JPanel();
        blankPlotChart = new com.pakar.com.raven.chart.blankchart.BlankPlotChart();
        txt_tahun = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        panelLegend.setOpaque(false);
        panelLegend.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));

        blankPlotChart.setForeground(new java.awt.Color(51, 51, 51));
        blankPlotChart.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N

        txt_tahun.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        txt_tahun.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blankPlotChart, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
                    .addComponent(panelLegend, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_tahun)
                .addGap(423, 423, 423))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(blankPlotChart, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(txt_tahun)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelLegend, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.pakar.com.raven.chart.blankchart.BlankPlotChart blankPlotChart;
    private javax.swing.JPanel panelLegend;
    private javax.swing.JLabel txt_tahun;
    // End of variables declaration//GEN-END:variables
}
