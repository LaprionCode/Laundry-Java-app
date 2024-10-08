/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.HeadlessException;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.*;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import static main.customer.statusSearching;
/**
 *
 * @author Favaa_
 */
public class order extends javax.swing.JFrame {
   private DefaultTableModel model;
    
    
    String selectedItemStrNama,selectedItemStr,KDID,jcnya,stat;
    int harganya,hargahitung,totalnya,kgnya,totalfix,mayarnya,totalhitung,kembaliannya;
    String IDnya = "";

    Connection con;
    Statement st;
    private int xx;
    private int xy;

    public order() {
        initComponents();
        dbkoneksi data = new dbkoneksi();
        data.config();
        con = data.con;
        st = data.st;
       model = (DefaultTableModel)jTable1.getModel();

    }

 private void ubah_data() {
        int index = jTable1.getSelectedRow();
        String id = jTable1.getValueAt(index, 0).toString();
        
        String Bayarr = bayar_pen.getText();
        String Beratt = berat_pen.getText();
        String Keterangann = ket_pen.getText();
        String Statuss = status_pen.getText();
        
        try {
            String sql = "UPDATE orderm SET bayar='" + Bayarr
                    + "', berat='" + Beratt
                    + "', keterangan='" + Keterangann
                    + "', status='" + Statuss
                    + "' WHERE no_order='" + id + "'";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil di ubah");
            String sql2 = "SELECT no_order,id_customer,nama_customer,"
                        + "bayar,kd_jenis, jenis_cucian, harga, berat, "
                        + "keterangan,status FROM orderm WHERE no_order='"+no_pen.getText()+"'";
            PreparedStatement pst = con.prepareStatement(sql2);
            pst.execute();
            tampil_tabel();
        } catch (HeadlessException | SQLException e) {
            System.err.println(e);
        }
 }
private void cari_data_pel()  {
    DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("No Order");
        tbl.addColumn("ID Customer");
        tbl.addColumn("Nama Customer");
        tbl.addColumn("Bayar");
        tbl.addColumn("KD Jenis");
        tbl.addColumn("Jenis Cucian");
        tbl.addColumn("Harga");
        tbl.addColumn("Berat");
        tbl.addColumn("Keterangan");
        try {
            String sql="SELECT * FROM orderm WHERE id_customer like '%"+txtCariPel.getText()+"%' OR nama_customer "
                    + "like '%"+txtCariPel.getText()+"%' ORDER BY id_customer";
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                tbl.addRow(new Object[]{
                    rs.getString("no_order"),
                    rs.getString("id_customer"),
                    rs.getString("nama_customer"),
                    rs.getString("bayar"),
                    rs.getString("kd_jenis"),
                    rs.getString("jenis_cucian"),
                    rs.getString("harga"),
                    rs.getString("berat"),
                    rs.getString("keterangan"),
                });
                jTable1.setModel(tbl);
            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
}

    private void tampil_tabel() {
        try {
                st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT no_order,id_customer,nama_customer,"
                        + "bayar,kd_jenis, jenis_cucian, harga, berat, "
                        + "keterangan,status FROM orderm");
                ResultSetMetaData rsmd = rs.getMetaData();
                    int columnCount = rsmd.getColumnCount();
               DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
                tm.setColumnCount(8);
                    for (int i = 9; i <= columnCount; i++ ) {
                    tm.addColumn(rsmd.getColumnName(i));
                }
                    tm.setRowCount(0);
                    while (rs.next()) {
                    String[] a = new String[columnCount];
                        for(int i = 0; i < columnCount; i++) {
                        a[i] = rs.getString(i+1);
                    }
                    tm.addRow(a);
                }
                tm.fireTableDataChanged();
                rs.close();
                st.close();
                } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex, ex.getMessage(), WIDTH, null);
                }
       }

    public void customer_pen() {
        try {
                st = con.createStatement();
                String sql = "SELECT * FROM laundry.customer";
                ResultSet rs = st.executeQuery(sql);
                    while(rs.next()) {
                        idcus_pen.addItem((rs.getString(2)));
                        IDnya = rs.getString(1);
                    }
                    rs.close();
                    st.close();
                        } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex, ex.getMessage(), WIDTH, null);
                        }
       }
    
    public void jenis_cucian_pen() {
        try {
                st = con.createStatement();
                String sql = "SELECT * FROM laundry.jenis_cucian";
                ResultSet rs = st.executeQuery(sql);
                    while(rs.next()) {
                        idjc_pen.addItem((rs.getString(2)));  
                    }
                    rs.close();
                    st.close();
                        } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex, ex.getMessage(), WIDTH, null);
                        }
       }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        tambah_cus = new javax.swing.JButton();
        simpan_cus = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        no_pen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        idcus_pen = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        idjc_pen = new javax.swing.JComboBox<>();
        harga_pen = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        berat_pen = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ket_pen = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        total_pen = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        bayar_pen = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        sisa_pen = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        status_pen = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ubah_pel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        txtCariPel = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Icon/purchase.png"))); // NOI18N
        jLabel1.setText("ORDER ");

        jPanel4.setBackground(new java.awt.Color(102, 153, 255));

        tambah_cus.setBackground(new java.awt.Color(255, 255, 255));
        tambah_cus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tambah_cus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Icon/plus.png"))); // NOI18N
        tambah_cus.setText("TAMBAH");
        tambah_cus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambah_cusActionPerformed(evt);
            }
        });

        simpan_cus.setBackground(new java.awt.Color(255, 255, 255));
        simpan_cus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        simpan_cus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Icon/save.png"))); // NOI18N
        simpan_cus.setText("SIMPAN");
        simpan_cus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpan_cusActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(51, 102, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Order"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("No Order :");

        no_pen.setEditable(false);
        no_pen.setBackground(new java.awt.Color(153, 153, 153));
        no_pen.setForeground(new java.awt.Color(255, 255, 255));
        no_pen.setText("Auto Generate");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Customer :");

        idcus_pen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih Customer" }));
        idcus_pen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idcus_penActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Jenis Cucian :");

        idjc_pen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih Jenis Cucian" }));
        idjc_pen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idjc_penActionPerformed(evt);
            }
        });

        harga_pen.setText("Harga");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Berat :");

        berat_pen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                berat_penKeyReleased(evt);
            }
        });

        jLabel7.setText("/ Kg");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Keterangan :");

        ket_pen.setColumns(20);
        ket_pen.setRows(5);
        jScrollPane2.setViewportView(ket_pen);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Total :");

        total_pen.setEditable(false);
        total_pen.setBackground(new java.awt.Color(153, 153, 153));
        total_pen.setForeground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Bayar  :");

        bayar_pen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bayar_penKeyReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Sisa :");

        sisa_pen.setEditable(false);
        sisa_pen.setBackground(new java.awt.Color(153, 153, 153));
        sisa_pen.setForeground(new java.awt.Color(255, 255, 255));
        sisa_pen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sisa_penKeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Status :");

        status_pen.setEditable(false);
        status_pen.setBackground(new java.awt.Color(153, 153, 153));
        status_pen.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sisa_pen, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(berat_pen, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addComponent(idcus_pen, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(no_pen, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idjc_pen, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(harga_pen))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(total_pen, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel14))))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(bayar_pen, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(status_pen, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(bayar_pen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sisa_pen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(status_pen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(total_pen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(no_pen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(idcus_pen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(idjc_pen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(harga_pen))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(berat_pen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Icon/close.png"))); // NOI18N
        jButton2.setText("TUTUP");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(51, 51, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Order"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Order", "ID Customer", "Nama Customer", "Bayar", "Kd_jenis", "Jenis Cucian", "Harga", "Berat", "Keterangan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1046, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        ubah_pel.setBackground(new java.awt.Color(255, 255, 255));
        ubah_pel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ubah_pel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Icon/edit.png"))); // NOI18N
        ubah_pel.setText("UBAH");
        ubah_pel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubah_pelActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 0, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Data"));

        btnSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCariPel)
                .addGap(18, 18, 18)
                .addComponent(btnSearch)
                .addGap(123, 123, 123))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(txtCariPel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tambah_cus)
                .addGap(18, 18, 18)
                .addComponent(ubah_pel)
                .addGap(18, 18, 18)
                .addComponent(simpan_cus)
                .addGap(140, 140, 140))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambah_cus)
                    .addComponent(simpan_cus, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(ubah_pel)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addContainerGap(821, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tambah_cusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah_cusActionPerformed
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM orderm ORDER BY no_order DESC";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                int hmmmm = Integer.parseInt(rs.getString("no_order"))+1;
                no_pen.setText(Integer.toString(hmmmm));
            } else {
                no_pen.setText("0001");
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        idcus_pen.setSelectedIndex(0);
        idjc_pen.setSelectedIndex(0);
        harga_pen.setText("Harga");
        berat_pen.setText("");
        ket_pen.setText("");
        total_pen.setText("");
        bayar_pen.setText("");
        sisa_pen.setText("");
    }//GEN-LAST:event_tambah_cusActionPerformed

    private void simpan_cusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpan_cusActionPerformed

        String Bayarr = bayar_pen.getText();
        String Beratt = berat_pen.getText();
        String Keterangann = ket_pen.getText();
        String Statuss = status_pen.getText();
        try {
            st = con.createStatement();
            String sqlSimpan = "insert into orderm values (NULL,'"+IDnya+"','"+selectedItemStrNama
                    +"','"+Bayarr+"','"+KDID+"','"+jcnya+"','"+hargahitung+"','"+Beratt+"','"
                    +Keterangann+"','"+Statuss+"') ";
            if (stat.equals("belum lunas")) {
            JOptionPane.showMessageDialog(null, "Pembayaran belum Lunas!! ");
        }
            st.executeUpdate(sqlSimpan);
            JOptionPane.showMessageDialog(null, "Data Berhasil Masuk!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Tak Masuk " + e.getMessage());
        }
        tampil_tabel();
    }//GEN-LAST:event_simpan_cusActionPerformed

    private void idcus_penActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idcus_penActionPerformed
                    Object selectedItem = idcus_pen.getSelectedItem();
                    if (selectedItem != null){
                        selectedItemStrNama = selectedItem.toString();
                    }
    }//GEN-LAST:event_idcus_penActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tampil_tabel();
        customer_pen();
        jenis_cucian_pen();
    }//GEN-LAST:event_formWindowOpened

    private void idjc_penActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idjc_penActionPerformed
                    Object selectedItem = idjc_pen.getSelectedItem();
                    if (selectedItem != null)
                    {
                       selectedItemStr = selectedItem.toString();
                            try {
                            st = con.createStatement();
                            String sql = "SELECT * FROM laundry.jenis_cucian WHERE jenis_cucian='"+selectedItemStr+"'";
                            ResultSet rs = st.executeQuery(sql);
                                while(rs.next()) {
                                    KDID = rs.getString(1);
                                    jcnya = rs.getString(2);
                                    harga_pen.setText(rs.getString(3));
                                    total_pen.setText(harga_pen.getText());
                                }
                                rs.close();
                                st.close();
                                    } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(this, ex, ex.getMessage(), WIDTH, null);
                                    }
                    }
    }//GEN-LAST:event_idjc_penActionPerformed

    private void berat_penKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_berat_penKeyReleased
        kgnya = Integer.parseInt(berat_pen.getText());
        hargahitung = Integer.parseInt(harga_pen.getText());
        totalnya = kgnya * hargahitung;
        total_pen.setText(String.valueOf(totalnya));
    }//GEN-LAST:event_berat_penKeyReleased

    private void bayar_penKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bayar_penKeyReleased
        mayarnya = Integer.parseInt(bayar_pen.getText());
        totalhitung = Integer.parseInt(total_pen.getText());
        kembaliannya = mayarnya - totalhitung;
        sisa_pen.setText(String.valueOf(kembaliannya));
        
        
        int Sisanya = Integer.parseInt(sisa_pen.getText());
        if (Sisanya > -1) {
            status_pen.setText("Lunas");
            stat ="lunas";
        } else if(Sisanya < 0) {
            status_pen.setText("Belum Lunas");
            stat ="belum lunas";
        }
            
        
    }//GEN-LAST:event_bayar_penKeyReleased

    private void sisa_penKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sisa_penKeyReleased
        
    }//GEN-LAST:event_sisa_penKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void ubah_pelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubah_pelActionPerformed
        // TODO add your handling code here:
        ubah_data();
    }//GEN-LAST:event_ubah_pelActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        cari_data_pel();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        no_pen.setEditable(false);

        int baris = jTable1.rowAtPoint(evt.getPoint());
        
        String no = jTable1.getValueAt(baris, 0).toString();
        no_pen.setText(no);
        String nCustomer = jTable1.getValueAt(baris, 2).toString();
        idcus_pen.setSelectedItem(nCustomer);
        String jCucian = jTable1.getValueAt(baris, 5).toString();
        idjc_pen.setSelectedItem(jCucian);
        String berat = jTable1.getValueAt(baris, 7).toString();
        berat_pen.setText(berat);
        String keterangan = jTable1.getValueAt(baris, 8).toString();
        ket_pen.setText(keterangan);
        String bayar = jTable1.getValueAt(baris, 3).toString();
        bayar_pen.setText(bayar);
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bayar_pen;
    private javax.swing.JTextField berat_pen;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel harga_pen;
    private javax.swing.JComboBox<String> idcus_pen;
    private javax.swing.JComboBox<String> idjc_pen;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea ket_pen;
    private javax.swing.JTextField no_pen;
    private javax.swing.JButton simpan_cus;
    private javax.swing.JTextField sisa_pen;
    private javax.swing.JTextField status_pen;
    private javax.swing.JButton tambah_cus;
    private javax.swing.JTextField total_pen;
    private javax.swing.JTextField txtCariPel;
    private javax.swing.JButton ubah_pel;
    // End of variables declaration//GEN-END:variables

    
    }