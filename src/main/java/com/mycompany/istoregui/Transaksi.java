/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.istoregui;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tiara Calista
 */
public class Transaksi extends javax.swing.JFrame {
    String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=iStore;user=tiara;password=tiara;encrypt=true;trustServerCertificate=true;loginTimeout=30";
    ResultSet resultSet = null;
    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;
    private String userEmail;
    private String provinsi;
    private int nextIdP;

    /**
     * Creates new form Transaksi
     */
    
    public Transaksi(String userEmail) {
        initComponents();
        this.userEmail = userEmail;
        populateComboBoxProv();
        
        Runtime.getRuntime().addShutdownHook(new Thread(() -> closeDatabaseConnection()));
    }
    public void closeDatabaseConnection(){
            try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
   
    private String getTotal() {
    try {
        int idPelanggan = getIdPelangganByEmail(connection, userEmail);
        int idKeranjang = getIdKeranjangByIdPelanggan(connection, idPelanggan);

        String query = "SELECT SUM(sub_total) AS total FROM Keranjang WHERE id_keranjang = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idKeranjang);

        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            int total = resultSet.getInt("total");
            double diskonTotal = total + getTarifForProvinsi(provinsi);
            diskonTotal -= diskonTotal * getPersenPromo();
            long ttl = (long) diskonTotal;
            return Long.toString(ttl);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return null;
}
private String getSubTotal() {
    try {
        int idPelanggan = getIdPelangganByEmail(connection, userEmail);
        int idKeranjang = getIdKeranjangByIdPelanggan(connection, idPelanggan);

        String query = "SELECT SUM(sub_total) AS total FROM Keranjang WHERE id_keranjang = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idKeranjang);

        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            int total = resultSet.getInt("total");
            
            return Long.toString(total);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return null;
}
    
    private void populateComboBoxProv() {
       cbProv.removeAllItems();

        try {
            connection = DriverManager.getConnection(connectionUrl);
            String query = "SELECT provinsi FROM Ongkir";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String provName = resultSet.getString("provinsi");
                        cbProv.addItem(provName);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void showRecordStruk(){
        try {
        int idPelanggan = getIdPelangganByEmail(connection, userEmail);
        int idKeranjang = getIdKeranjangByIdPelanggan(connection, idPelanggan);

        String query = "SELECT P.nama_produk, K.jumlah_produk, P.harga, K.sub_total " +
                       "FROM Keranjang K " +
                       "JOIN Produk P ON K.id_produk = P.id_produk " +
                       "WHERE K.id_keranjang = ?";
        
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idKeranjang);

        resultSet = preparedStatement.executeQuery();

        ResultSetMetaData rsm = (ResultSetMetaData) resultSet.getMetaData();
        int n = rsm.getColumnCount();

        DefaultTableModel df = (DefaultTableModel) tblStruk.getModel();
        df.setRowCount(0);
        
        while (resultSet.next()) {
            Vector obj = new Vector();
            for (int i = 1; i <= n; i++) {
                obj.add(resultSet.getString(i));
            }
            df.addRow(obj);
        }
        
    } catch (SQLException ex) {
        System.out.println(ex);
    }
}
    
    private void populateComboBoxPromo() {
       cbProv.removeAllItems();
       Date nowDate = new Date(System.currentTimeMillis());
       
        try {
            connection = DriverManager.getConnection(connectionUrl);
            String query = "SELECT kode_promo " +
                    "FROM Promo " +
                    "WHERE tanggal_awal <= ? " +
                    "AND tanggal_berakhir >= ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setDate(1, nowDate);
                preparedStatement.setDate(2, nowDate);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String promoName = resultSet.getString("kode_promo");
                        comBoxPromo.addItem(promoName);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void populateComboBoxMetode() {
       cbProv.removeAllItems();

        try {
            connection = DriverManager.getConnection(connectionUrl);
            String query = "SELECT nama_bank FROM MetodePembayaran";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String metName = resultSet.getString("nama_bank");
                        comboBoxMetodeBayar.addItem(metName);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private int getOngkirIdForProvinsi(String provinsi) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT id_ongkir FROM Ongkir WHERE provinsi=?");
        preparedStatement.setString(1, provinsi);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt("id_ongkir");
        } else {
            throw new SQLException("Ongkir data not found for provinsi: " + provinsi);
        }
}
    private int getTarifForProvinsi(String provinsi) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT tarif FROM Ongkir WHERE provinsi = ?");
        preparedStatement.setString(1, provinsi);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt("tarif");
        } else {
            throw new SQLException("Ongkir data not found for provinsi: " + provinsi);
        }
}
    private double getPersenPromo()throws SQLException{
        preparedStatement = connection.prepareStatement("SELECT persen_potongan FROM Promo WHERE kode_promo=?");
//        if(comBoxPromo.getSelectedItem() == null){
//            return 0;
//        }
        preparedStatement.setString(1, comBoxPromo.getSelectedItem().toString());
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt("persen_potongan");
        } else {
            throw new SQLException("Tidak ada");
        }
    }

    private int getIdPelangganByEmail(Connection connection1, String emailPelanggan) throws SQLException {
    try (PreparedStatement preparedStatement = connection.prepareStatement(
            "SELECT id_pelanggan FROM Pelanggan WHERE email_pelanggan = ?")) {
        preparedStatement.setString(1, emailPelanggan);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("id_pelanggan");
            }
        }
    }
    return -1;
}

private int getIdKeranjangByIdPelanggan(Connection connection1, int idPelanggan) throws SQLException {
    try (PreparedStatement preparedStatement = connection.prepareStatement(
            "SELECT id_keranjang FROM KepemilikanKeranjang WHERE id_pelanggan = ?")) {
        preparedStatement.setInt(1, idPelanggan);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("id_keranjang");
            }
        }
    }
    return -1; 
}

private int getIdProdukByNamaProduk(Connection connection1, String namaProduk) throws SQLException {
    try (PreparedStatement preparedStatement = connection.prepareStatement(
            "SELECT id_produk FROM Produk WHERE nama_produk = ?")) {
        preparedStatement.setString(1, namaProduk);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("id_produk");
            }
        }
    }
    return -1;  
}

private int getHargaProdukById(Connection connection1, int idProduk) throws SQLException {
    try (PreparedStatement preparedStatement = connection.prepareStatement(
            "SELECT harga FROM Produk WHERE id_produk = ?")) {
        preparedStatement.setInt(1, idProduk);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("harga");
            }
        }
    }
    return -1;  
}

public int getIDMetodePembayaran(Connection connection, String namaMetodePembayaran) throws SQLException {
    int idMetodePembayaran = -1;
    String query = "SELECT id_metode_pembayaran FROM MetodePembayaran WHERE nama_bank = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, namaMetodePembayaran);
        
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                idMetodePembayaran = resultSet.getInt("id_metode_pembayaran");
            }
        }
    }
    
    return idMetodePembayaran;
}

public String getKodePembayaran(Connection connection, String namaMetodePembayaran) throws SQLException {
    String kode_pembayaran = null;
    String query = "SELECT kode_pembayaran FROM MetodePembayaran WHERE nama_bank = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, namaMetodePembayaran);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                kode_pembayaran = resultSet.getString("kode_pembayaran");
            }
        }
    }

    return kode_pembayaran;
}


public int getIDPengiriman(Connection connection) throws SQLException {
    int idPengiriman = -1;
    
    String query = "SELECT MAX(id_pengiriman) FROM Pengiriman";
    
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                idPengiriman = resultSet.getInt(1) + 1;
            }
        }
    }
    
    return idPengiriman;
}








 public void showRecordKeranjang() {
    try {
        int idPelanggan = getIdPelangganByEmail(connection, userEmail);
        int idKeranjang = getIdKeranjangByIdPelanggan(connection, idPelanggan);

        String query = "SELECT P.nama_produk, K.jumlah_produk, P.harga, K.sub_total " +
                       "FROM Keranjang K " +
                       "JOIN Produk P ON K.id_produk = P.id_produk " +
                       "WHERE K.id_keranjang = ?";
        
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idKeranjang);

        resultSet = preparedStatement.executeQuery();

        ResultSetMetaData rsm = (ResultSetMetaData) resultSet.getMetaData();
        int n = rsm.getColumnCount();

        DefaultTableModel df = (DefaultTableModel) tabelKeranjang.getModel();
        df.setRowCount(0);

        while (resultSet.next()) {
            Vector obj = new Vector();
            for (int i = 1; i <= n; i++) {
                obj.add(resultSet.getString(i));
            }
            df.addRow(obj);
        }
    } catch (SQLException ex) {
        System.out.println(ex);
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

        jPanel5 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        aturAlamat = new javax.swing.JPanel();
        jalanTujuan = new javax.swing.JTextField();
        kotaTujuan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        selanjutnya = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbProv = new javax.swing.JComboBox<>();
        pilihProduk = new javax.swing.JPanel();
        cbProduk = new javax.swing.JComboBox<>();
        addToCart = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnSmartphone = new javax.swing.JRadioButton();
        btnTablet = new javax.swing.JRadioButton();
        btnJamTangan = new javax.swing.JRadioButton();
        btnLaptop = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        spinnerJumlah = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        keranjang = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelKeranjang = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        struk = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnSelesai = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStruk = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        comboBoxMetodeBayar = new javax.swing.JComboBox<>();
        comBoxPromo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setLayout(new java.awt.CardLayout());

        jButton7.setBackground(new java.awt.Color(45, 106, 79));
        jButton7.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Klik untuk Belanja");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton7, "card2");

        aturAlamat.setBackground(new java.awt.Color(45, 106, 79));
        aturAlamat.setForeground(new java.awt.Color(255, 255, 255));
        aturAlamat.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                aturAlamatComponentHidden(evt);
            }
        });

        jalanTujuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jalanTujuanActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Jalan");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Provinsi");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kota");

        selanjutnya.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        selanjutnya.setForeground(new java.awt.Color(45, 106, 79));
        selanjutnya.setText("Selanjutnya");
        selanjutnya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selanjutnyaActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(45, 106, 79));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ATUR ALAMAT TUJUAN");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jLabel2)
                .addContainerGap(153, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout aturAlamatLayout = new javax.swing.GroupLayout(aturAlamat);
        aturAlamat.setLayout(aturAlamatLayout);
        aturAlamatLayout.setHorizontalGroup(
            aturAlamatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aturAlamatLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(selanjutnya)
                .addGap(50, 50, 50))
            .addGroup(aturAlamatLayout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addGroup(aturAlamatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(69, 69, 69)
                .addGroup(aturAlamatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(kotaTujuan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                    .addComponent(jalanTujuan, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbProv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        aturAlamatLayout.setVerticalGroup(
            aturAlamatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aturAlamatLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(aturAlamatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jalanTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(aturAlamatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kotaTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(aturAlamatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(selanjutnya, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );

        jPanel5.add(aturAlamat, "card3");

        pilihProduk.setBackground(new java.awt.Color(45, 106, 79));
        pilihProduk.setToolTipText("");

        cbProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProdukActionPerformed(evt);
            }
        });

        addToCart.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addToCart.setText("Add to cart");
        addToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("Lihat Keranjang");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnSmartphone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSmartphone.setForeground(new java.awt.Color(255, 255, 255));
        btnSmartphone.setText("Smartphone");
        btnSmartphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSmartphoneActionPerformed(evt);
            }
        });

        btnTablet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnTablet.setForeground(new java.awt.Color(255, 255, 255));
        btnTablet.setText("Tablet");
        btnTablet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTabletActionPerformed(evt);
            }
        });

        btnJamTangan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnJamTangan.setForeground(new java.awt.Color(255, 255, 255));
        btnJamTangan.setText("Jam Tangan");
        btnJamTangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJamTanganActionPerformed(evt);
            }
        });

        btnLaptop.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLaptop.setForeground(new java.awt.Color(255, 255, 255));
        btnLaptop.setText("Laptop");
        btnLaptop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaptopActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Pilih Kategori");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Pilih Produk");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(45, 106, 79));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("PILIH PRODUK");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Jumlah Produk");

        javax.swing.GroupLayout pilihProdukLayout = new javax.swing.GroupLayout(pilihProduk);
        pilihProduk.setLayout(pilihProdukLayout);
        pilihProdukLayout.setHorizontalGroup(
            pilihProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pilihProdukLayout.createSequentialGroup()
                .addGap(0, 160, Short.MAX_VALUE)
                .addGroup(pilihProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pilihProdukLayout.createSequentialGroup()
                        .addGroup(pilihProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel17))
                        .addGap(28, 28, 28)
                        .addGroup(pilihProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbProduk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spinnerJumlah)
                            .addGroup(pilihProdukLayout.createSequentialGroup()
                                .addGroup(pilihProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnJamTangan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSmartphone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(3, 3, 3)
                                .addGroup(pilihProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnTablet, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLaptop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(pilihProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                        .addComponent(addToCart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(218, 218, 218))
        );
        pilihProdukLayout.setVerticalGroup(
            pilihProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pilihProdukLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(pilihProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSmartphone)
                    .addComponent(btnTablet)
                    .addComponent(jLabel10))
                .addGap(15, 15, 15)
                .addGroup(pilihProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnJamTangan)
                    .addComponent(btnLaptop))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pilihProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbProduk))
                .addGap(16, 16, 16)
                .addGroup(pilihProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(addToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
        );

        jPanel5.add(pilihProduk, "card4");

        keranjang.setBackground(new java.awt.Color(45, 106, 79));

        tabelKeranjang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Produk", "Jumlah", "Harga", "Sub Total"
            }
        ));
        jScrollPane1.setViewportView(tabelKeranjang);

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(45, 106, 79));
        jButton4.setText("Checkout");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(45, 106, 79));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("KERANJANG");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(45, 106, 79));
        jButton5.setText("Kembali");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout keranjangLayout = new javax.swing.GroupLayout(keranjang);
        keranjang.setLayout(keranjangLayout);
        keranjangLayout.setHorizontalGroup(
            keranjangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(keranjangLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(keranjangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(keranjangLayout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        keranjangLayout.setVerticalGroup(
            keranjangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keranjangLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(keranjangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
        );

        jPanel5.add(keranjang, "card5");

        struk.setBackground(new java.awt.Color(45, 106, 79));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("STRUK BELANJA");

        btnSelesai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSelesai.setText("Selesai");
        btnSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelesaiActionPerformed(evt);
            }
        });

        tblStruk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Produk", "Jumlah", "Harga", "Sub Total"
            }
        ));
        jScrollPane2.setViewportView(tblStruk);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Kode Promo");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Metode Bayar");

        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("TOTAL");

        javax.swing.GroupLayout strukLayout = new javax.swing.GroupLayout(struk);
        struk.setLayout(strukLayout);
        strukLayout.setHorizontalGroup(
            strukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(strukLayout.createSequentialGroup()
                .addGroup(strukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(strukLayout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jLabel8))
                    .addGroup(strukLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(strukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(strukLayout.createSequentialGroup()
                                .addGroup(strukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addGroup(strukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(comboBoxMetodeBayar, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTotal)
                                    .addComponent(comBoxPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(108, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, strukLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        strukLayout.setVerticalGroup(
            strukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, strukLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(strukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(strukLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(strukLayout.createSequentialGroup()
                        .addComponent(comBoxPromo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxMetodeBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btnSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jPanel5.add(struk, "card6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void selanjutnyaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selanjutnyaActionPerformed
        System.out.println(userEmail);
        
        aturAlamat.setVisible(false);
        pilihProduk.setVisible(true);
        keranjang.setVisible(false);
        struk.setVisible(false);
        try {
            connection = DriverManager.getConnection(connectionUrl);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            nextIdP = getIDPengiriman(connection); 
            Date currentDate = new Date(System.currentTimeMillis());
            String defaultStatus = "Dikirim";
            provinsi = (String) cbProv.getSelectedItem();
            int selectedOngkirId = getOngkirIdForProvinsi(provinsi);

            preparedStatement = connection.prepareStatement("INSERT INTO Pengiriman VALUES(?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, nextIdP);
            preparedStatement.setDate(2, currentDate);
            preparedStatement.setString(3, jalanTujuan.getText());
            preparedStatement.setString(4, kotaTujuan.getText());
            preparedStatement.setString(5, cbProv.getSelectedItem().toString());
            preparedStatement.setString(6, defaultStatus);
            preparedStatement.setInt(7, selectedOngkirId);
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows + " " + "affected row(s)");

        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }//GEN-LAST:event_selanjutnyaActionPerformed

    private void jalanTujuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jalanTujuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jalanTujuanActionPerformed

    private void addToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartActionPerformed
        String emailPelanggan = this.userEmail;
        String selectedProduct = (String) cbProduk.getSelectedItem();
        int jumlahProduk = (int) spinnerJumlah.getValue();

            try {
            Connection connection = DriverManager.getConnection(connectionUrl);
            int idPelanggan = getIdPelangganByEmail(connection, emailPelanggan);
            int idKeranjang = getIdKeranjangByIdPelanggan(connection, idPelanggan);
            int idProduk = getIdProdukByNamaProduk(connection, selectedProduct);
            int hargaProduk = getHargaProdukById(connection, idProduk);
            int subTotal = hargaProduk * jumlahProduk;
            String insertQuery = "INSERT INTO Keranjang (id_keranjang, id_produk, jumlah_produk, sub_total) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, idKeranjang);
                preparedStatement.setInt(2, idProduk);
                preparedStatement.setInt(3, jumlahProduk);
                preparedStatement.setInt(4, subTotal);

                int affectedRows = preparedStatement.executeUpdate();
                System.out.println(affectedRows + " affected row(s)");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_addToCartActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        aturAlamat.setVisible(false);
        pilihProduk.setVisible(false); 
        keranjang.setVisible(true);
        struk.setVisible(false);
        jButton7.setVisible(false);
        showRecordKeranjang();
         
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        aturAlamat.setVisible(false);
        keranjang.setVisible(false);
        struk.setVisible(true);
        pilihProduk.setVisible(false);   
        jButton7.setVisible(false);
        showRecordStruk();
        populateComboBoxPromo();
        populateComboBoxMetode();
        txtTotal.setText(getTotal());
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelesaiActionPerformed
        try {
            Connection connection = DriverManager.getConnection(connectionUrl);
            ResultSet maxIdResult = statement.executeQuery("SELECT MAX(id_pesanan) FROM Pesanan");
            int nextId = 1;
            if (maxIdResult.next()) {
                nextId = maxIdResult.getInt(1) + 1;
            }
            int idPelanggan = getIdPelangganByEmail(connection, userEmail);
            int idKeranjang = getIdKeranjangByIdPelanggan(connection, idPelanggan);
            Date currentDate = new Date(System.currentTimeMillis());
            
            String kodePromo = (String) comBoxPromo.getSelectedItem();
            int idMetodePembayaran = getIDMetodePembayaran(connection, (String) comboBoxMetodeBayar.getSelectedItem());
            String kode_pembayaran = getKodePembayaran(connection, (String) comboBoxMetodeBayar.getSelectedItem());
            String totalHargaBarang = getSubTotal().toString();
            String totalHarga = getTotal().toString();
            int idPegawai = 2001;
            String statusPembayaran = "BERHASIL";
            String insertQuery = "INSERT INTO Pesanan (id_pesanan, id_keranjang, kode_promo, id_metode_pembayaran, id_pengiriman, tanggal_pesanan, total_harga_barang, total_harga, id_pegawai, status_pembayaran) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, nextId);
                preparedStatement.setInt(2, idKeranjang);
                preparedStatement.setString(3, kodePromo);
                preparedStatement.setInt(4, idMetodePembayaran);
                preparedStatement.setInt(5, nextIdP);
                preparedStatement.setDate(6, currentDate);
                preparedStatement.setInt(7, Integer.parseInt(totalHargaBarang));
                preparedStatement.setInt(8, Integer.parseInt(totalHarga));
                preparedStatement.setInt(9, idPegawai);
                preparedStatement.setString(10, statusPembayaran);

                int affectedRows = preparedStatement.executeUpdate();
                System.out.println(affectedRows + " affected row(s)");
                System.out.println("nextId: " + nextId);
                String successMessage = "Pesanan berhasil dibuat. Silahkan melakukan pembayaran ke Virtual Account (VA) berikut: " + kode_pembayaran;
                JOptionPane.showMessageDialog(null, successMessage, "Pesanan Berhasil", JOptionPane.INFORMATION_MESSAGE);
                
//System.out.println("idKeranjang: " + idKeranjang);
//System.out.println("kodePromo: " + kodePromo);
//System.out.println("idMetodePembayaran: " + idMetodePembayaran);
//System.out.println("nextIdP: " + nextIdP);
//System.out.println("currentDate: " + currentDate);
//System.out.println("totalHargaBarang: " + totalHargaBarang);
//System.out.println("totalHarga: " + totalHarga);
//System.out.println("idPegawai: " + idPegawai);
//System.out.println("statusPembayaran: " + statusPembayaran);

            }
} catch (SQLException e) {
    e.printStackTrace();
}
        this.dispose();
        
    }//GEN-LAST:event_btnSelesaiActionPerformed

    private void aturAlamatComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_aturAlamatComponentHidden
    // TODO add your handling code here:
    }//GEN-LAST:event_aturAlamatComponentHidden
    
    
    private void populateComboBox(String category) {
       cbProduk.removeAllItems();

    try {
        connection = DriverManager.getConnection(connectionUrl);
        String query = "SELECT nama_produk FROM Produk WHERE kategori = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, category);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String productName = resultSet.getString("nama_produk");
                    cbProduk.addItem(productName);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    private void cbProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbProdukActionPerformed

    private void btnSmartphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSmartphoneActionPerformed
        populateComboBox("Smartphone");
    }//GEN-LAST:event_btnSmartphoneActionPerformed

    private void btnTabletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTabletActionPerformed
        populateComboBox("Tablet");
    }//GEN-LAST:event_btnTabletActionPerformed

    private void btnJamTanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJamTanganActionPerformed
        populateComboBox("Jam Tangan");
    }//GEN-LAST:event_btnJamTanganActionPerformed

    private void btnLaptopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaptopActionPerformed
        populateComboBox("Laptop");
    }//GEN-LAST:event_btnLaptopActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        aturAlamat.setVisible(true);
        keranjang.setVisible(false);
        struk.setVisible(false);
        pilihProduk.setVisible(false);
        jButton7.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        aturAlamat.setVisible(false);
        keranjang.setVisible(false);
        struk.setVisible(false);
        pilihProduk.setVisible(true);
        jButton7.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

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
//            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Transaksi().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToCart;
    private javax.swing.JPanel aturAlamat;
    private javax.swing.JRadioButton btnJamTangan;
    private javax.swing.JRadioButton btnLaptop;
    private javax.swing.JButton btnSelesai;
    private javax.swing.JRadioButton btnSmartphone;
    private javax.swing.JRadioButton btnTablet;
    private javax.swing.JComboBox<String> cbProduk;
    private javax.swing.JComboBox<String> cbProv;
    private javax.swing.JComboBox<String> comBoxPromo;
    private javax.swing.JComboBox<String> comboBoxMetodeBayar;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jalanTujuan;
    private javax.swing.JPanel keranjang;
    private javax.swing.JTextField kotaTujuan;
    private javax.swing.JPanel pilihProduk;
    private javax.swing.JButton selanjutnya;
    private javax.swing.JSpinner spinnerJumlah;
    private javax.swing.JPanel struk;
    private javax.swing.JTable tabelKeranjang;
    private javax.swing.JTable tblStruk;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

}
