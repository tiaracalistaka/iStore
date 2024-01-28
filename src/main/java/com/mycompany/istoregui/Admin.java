/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.istoregui;

import java.awt.Color;
import java.sql.*;
import java.util.Vector;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Tiara Calista
 */
public class Admin extends javax.swing.JFrame {
    String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=iStore;user=tiara;password=tiara;encrypt=true;trustServerCertificate=true;loginTimeout=30";
    ResultSet resultSet = null;
    Connection connection ;
    Statement statement;
    PreparedStatement preparedStatement;
    

    /**
     * Creates new form NewJFrame
     */
    public Admin() throws ClassNotFoundException {
        initComponents();
        
        Runtime.getRuntime().addShutdownHook(new Thread(() -> closeDatabaseConnection()));

    }

   public void populateAllPelangganFields(){
            try{
                connection = DriverManager.getConnection(connectionUrl);
                showRecordPelanggan();
                statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                resultSet = statement.executeQuery("select * from Pelanggan");
                if(resultSet.next()){
                idPelanggan.setText(resultSet.getString(1));
                emailPelanggan.setText(resultSet.getString(2));
                sandiPelanggan.setText(resultSet.getString(3));
                namaPelanggan.setText(resultSet.getString(4));
                jalanPelanggan.setText(resultSet.getString(5));
                kotaPelanggan.setText(resultSet.getString(6));
                provPelanggan.setText(resultSet.getString(7));
                telpPelanggan.setText(resultSet.getString(8));
                kelaminPelanggan.setSelectedItem(resultSet.getString(9));}
                }
                
            catch (SQLException e){
                e.printStackTrace();
                System.out.print("halo");
                      
            }
    
   }
   public void showRecordPelanggan(){
        try{
            preparedStatement=connection.prepareStatement("select * from Pelanggan");
            resultSet=preparedStatement.executeQuery();
            ResultSetMetaData rsm=(ResultSetMetaData) resultSet.getMetaData();
            int n=rsm.getColumnCount();
            DefaultTableModel df=(DefaultTableModel) tblPelanggan.getModel();
            df.setRowCount(0);
            while(resultSet.next()){
                Vector obj=new Vector();
                for(int i=1;i<=n;i++){    
                obj.add(resultSet.getString(1));
                obj.add(resultSet.getString(2));
                obj.add(resultSet.getString(3));
                obj.add(resultSet.getString(4));
                obj.add(resultSet.getString(5));   
                obj.add(resultSet.getString(6)); 
                obj.add(resultSet.getString(7)); 
                obj.add(resultSet.getString(8)); 
                obj.add(resultSet.getString(9)); 
                }
                df.addRow(obj);
            }
                          
        }
        catch(SQLException ex){
            System.out.println(ex);
            System.out.print("halo");
        }
    }
      public void populateAllPegawaiFields(){
            try{
                connection = DriverManager.getConnection(connectionUrl);
                showRecordPegawai();
                statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                resultSet = statement.executeQuery("select * from Pegawai");
                if(resultSet.next()){
                idPegawai.setText(resultSet.getString(1));
                emailPegawai.setText(resultSet.getString(2));
                sandiPegawai.setText(resultSet.getString(3));
                namaPegawai.setText(resultSet.getString(4));
                jalanPegawai.setText(resultSet.getString(5));
                kotaPegawai.setText(resultSet.getString(6));
                provPegawai.setText(resultSet.getString(7));
                telpPegawai.setText(resultSet.getString(8));
                posisiPegawai.setSelectedItem(resultSet.getString(10));
                gajiPegawai.setText(resultSet.getString(9));
                kelaminPegawai.setSelectedItem(resultSet.getString(11));
                }
                }
            catch (SQLException e){
                e.printStackTrace();
            }
    
   }
   public void showRecordPegawai(){
        try{
            preparedStatement=connection.prepareStatement("select * from Pegawai");
            resultSet=preparedStatement.executeQuery();
            ResultSetMetaData rsm=(ResultSetMetaData) resultSet.getMetaData();
            int n=rsm.getColumnCount();
            DefaultTableModel df=(DefaultTableModel) tblPegawai.getModel();
            df.setRowCount(0);
            while(resultSet.next()){
                Vector obj=new Vector();
                for(int i=1;i<=n;i++){    
                obj.add(resultSet.getString(1));
                obj.add(resultSet.getString(2));
                obj.add(resultSet.getString(3));
                obj.add(resultSet.getString(4));
                obj.add(resultSet.getString(5));   
                obj.add(resultSet.getString(6)); 
                obj.add(resultSet.getString(7)); 
                obj.add(resultSet.getString(8)); 
                obj.add(resultSet.getString(9)); 
                obj.add(resultSet.getString(10));
                obj.add(resultSet.getString(11));
                }
                df.addRow(obj);
            }
                          
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
   public void populateAllProdukFields(){
            try{
                connection = DriverManager.getConnection(connectionUrl);
                showRecordProduk();
                statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                resultSet = statement.executeQuery("select * from Produk");
                if(resultSet.next()){
                idProduk.setText(resultSet.getString(1));
                namaProduk.setText(resultSet.getString(2));
                kategoriProduk.setSelectedItem(resultSet.getString(3));
                hargaProduk.setText(resultSet.getString(4));
                stokProduk.setText(resultSet.getString(5));
                warnaProduk.setText(resultSet.getString(6));
                terjualProduk.setText(resultSet.getString(7));}
                }
                
            catch (SQLException e){
                e.printStackTrace();
            }
    
   }
   public void showRecordProduk(){
        try{
            preparedStatement=connection.prepareStatement("select * from Produk");
            resultSet=preparedStatement.executeQuery();
            ResultSetMetaData rsm=(ResultSetMetaData) resultSet.getMetaData();
            int n=rsm.getColumnCount();
            DefaultTableModel df=(DefaultTableModel) tblProduk.getModel();
            df.setRowCount(0);
            while(resultSet.next()){
                Vector obj=new Vector();
                for(int i=1;i<=n;i++){    
                obj.add(resultSet.getString(1));
                obj.add(resultSet.getString(2));
                obj.add(resultSet.getString(3));
                obj.add(resultSet.getString(4));
                obj.add(resultSet.getString(5));   
                obj.add(resultSet.getString(6)); 
                obj.add(resultSet.getString(7)); 
                }
                df.addRow(obj);
            }
                          
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
   public void populateAllMetodeFields(){
            try{
                connection = DriverManager.getConnection(connectionUrl);
                showRecordMetode();
                statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                resultSet = statement.executeQuery("select * from MetodePembayaran");
                if(resultSet.next()){
                idMetode.setText(resultSet.getString(1));
                namaMetode.setText(resultSet.getString(2));
                kodePembayaran.setText(resultSet.getString(3));}
                }
                
            catch (SQLException e){
                e.printStackTrace();
            }
    
   }
   public void showRecordMetode(){
        try{
            preparedStatement=connection.prepareStatement("select * from MetodePembayaran");
            resultSet=preparedStatement.executeQuery();
            ResultSetMetaData rsm=(ResultSetMetaData) resultSet.getMetaData();
            int n=rsm.getColumnCount();
            DefaultTableModel df=(DefaultTableModel) tblMetode.getModel();
            df.setRowCount(0);
            while(resultSet.next()){
                Vector obj=new Vector();
                for(int i=1;i<=n;i++){    
                obj.add(resultSet.getString(1));
                obj.add(resultSet.getString(2));
                obj.add(resultSet.getString(3));
                
                }
                df.addRow(obj);
            }
                          
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
public void populateAllPromoFields(){
            try{
                connection = DriverManager.getConnection(connectionUrl);
                showRecordPromo();
                statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                resultSet = statement.executeQuery("select * from Promo");
                if(resultSet.next()){
                    idPromo.setText(resultSet.getString(1));
                potonganPromo.setText(resultSet.getString(2));
                tanggalAwal.setText(resultSet.getString(3));
                tanggalBerakhir.setText(resultSet.getString(4));}
                }
                
            catch (SQLException e){
                e.printStackTrace();
            }
    
   }
   public void showRecordPromo(){
        try{
            preparedStatement=connection.prepareStatement("select * from Promo");
            resultSet=preparedStatement.executeQuery();
            ResultSetMetaData rsm=(ResultSetMetaData) resultSet.getMetaData();
            int n=rsm.getColumnCount();
            DefaultTableModel df=(DefaultTableModel) tblPromo.getModel();
            df.setRowCount(0);
            while(resultSet.next()){
                Vector obj=new Vector();
                for(int i=1;i<=n;i++){    
                obj.add(resultSet.getString(1));
                obj.add(resultSet.getString(2));
                obj.add(resultSet.getString(3));
                obj.add(resultSet.getString(4));
                
               
                }
                df.addRow(obj);
            }
                          
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
   public void populateAllOngkirFields(){
            try{
                connection = DriverManager.getConnection(connectionUrl);
                showRecordOngkir();
                statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                resultSet = statement.executeQuery("select * from Ongkir");
                if(resultSet.next()){
                idOngkir.setText(resultSet.getString(1));
            provOngkir.setText(resultSet.getString(2));
            tarifOngkir.setText(resultSet.getString(3));}
                }
                
            catch (SQLException e){
                e.printStackTrace();
            }
    
   }
   public void showRecordOngkir(){
        try{
            preparedStatement=connection.prepareStatement("select * from Ongkir");
            resultSet=preparedStatement.executeQuery();
            ResultSetMetaData rsm=(ResultSetMetaData) resultSet.getMetaData();
            int n=rsm.getColumnCount();
            DefaultTableModel df=(DefaultTableModel) tblOngkir.getModel();
            df.setRowCount(0);
            while(resultSet.next()){
                Vector obj=new Vector();
                for(int i=1;i<=n;i++){    
                obj.add(resultSet.getString(1));
                obj.add(resultSet.getString(2));
                obj.add(resultSet.getString(3));
                
               
                }
                df.addRow(obj);
            }
                          
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
 public void populateAllPesananFields(){
            try{
                connection = DriverManager.getConnection(connectionUrl);
                showRecordPesanan();
                statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                resultSet = statement.executeQuery("select * from Pesanan");
                if(resultSet.next()){
                idPesanan.setText(resultSet.getString(1));
                keranjangPesanan.setText(resultSet.getString(2));
                promoPesanan.setText(resultSet.getString(3));
                metodePesanan.setText(resultSet.getString(4));
                pengirimanPesanan.setText(resultSet.getString(5));
                tanggalPesanan.setText(resultSet.getString(6));
                totalHargaBarang.setText(resultSet.getString(7));
                totalHarga.setText(resultSet.getString(8));
                pegawaiPesanan.setText(resultSet.getString(9));
                statusPembayaran.setText(resultSet.getString(10));
                }
                }
                
            catch (SQLException e){
                e.printStackTrace();
            }
    
   }
   public void showRecordPesanan(){
        try{
            preparedStatement=connection.prepareStatement("select * from Pesanan");
            resultSet=preparedStatement.executeQuery();
            ResultSetMetaData rsm=(ResultSetMetaData) resultSet.getMetaData();
            int n=rsm.getColumnCount();
            DefaultTableModel df=(DefaultTableModel) tblPesanan.getModel();
            df.setRowCount(0);
            while(resultSet.next()){
                Vector obj=new Vector();
                for(int i=1;i<=n;i++){    
                obj.add(resultSet.getString(1));
                obj.add(resultSet.getString(2));
                obj.add(resultSet.getString(3));
                obj.add(resultSet.getString(4));
                obj.add(resultSet.getString(5));   
                obj.add(resultSet.getString(6)); 
                obj.add(resultSet.getString(7)); 
                obj.add(resultSet.getString(8)); 
                obj.add(resultSet.getString(9)); 
                obj.add(resultSet.getString(10)); 
                }
                df.addRow(obj);
            }
                          
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
    public void populateAllKeranjangFields(){
            try{
                connection = DriverManager.getConnection(connectionUrl);
                showRecordKeranjang();
                statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                resultSet = statement.executeQuery("select * from Keranjang");
                if(resultSet.next()){
                idKeranjang.setText(resultSet.getString(1));
                produkKeranjang.setText(resultSet.getString(2));
                jumlahProduk.setText(resultSet.getString(3));
                subTotal.setText(resultSet.getString(4));
                }
                }
                
            catch (SQLException e){
                e.printStackTrace();
                System.out.println("hkhk");
            }
    
   }
   public void showRecordKeranjang(){
        try{
            preparedStatement=connection.prepareStatement("select * from Keranjang");
            resultSet=preparedStatement.executeQuery();
            ResultSetMetaData rsm=(ResultSetMetaData) resultSet.getMetaData();
            int n=rsm.getColumnCount();
            DefaultTableModel df=(DefaultTableModel) tblKeranjang.getModel();
            df.setRowCount(0);
            while(resultSet.next()){
                Vector obj=new Vector();
                for(int i=1;i<=n;i++){    
                obj.add(resultSet.getString(1));
                obj.add(resultSet.getString(2));
                obj.add(resultSet.getString(3));
                obj.add(resultSet.getString(4));
                  
                
                }
                df.addRow(obj);
            }
                          
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
   public void populateAllPengirimanFields(){
            try{
                connection = DriverManager.getConnection(connectionUrl);
                showRecordPengiriman();
                statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                resultSet = statement.executeQuery("select * from Pengiriman");
                if(resultSet.next()){
                idPengiriman.setText(resultSet.getString(1));
                tanggalPengiriman.setText(resultSet.getString(2));
                jalanPengiriman.setText(resultSet.getString(3));
                kotaPengiriman.setText(resultSet.getString(4));
                provPengiriman.setText(resultSet.getString(5));
                statusPengiriman.setSelectedItem(resultSet.getString(6));
                ongkirPengiriman.setText(resultSet.getString(7));
                }
                }
                
            catch (SQLException e){
                e.printStackTrace();
            }
    
   }
   public void showRecordPengiriman(){
        try{
            preparedStatement=connection.prepareStatement("select * from Pengiriman");
            resultSet=preparedStatement.executeQuery();
            ResultSetMetaData rsm=(ResultSetMetaData) resultSet.getMetaData();
            int n=rsm.getColumnCount();
            DefaultTableModel df=(DefaultTableModel) tblPengiriman.getModel();
            df.setRowCount(0);
            while(resultSet.next()){
                Vector obj=new Vector();
                for(int i=1;i<=n;i++){    
                obj.add(resultSet.getString(1));
                obj.add(resultSet.getString(2));
                obj.add(resultSet.getString(3));
                obj.add(resultSet.getString(4));
                obj.add(resultSet.getString(5));   
                obj.add(resultSet.getString(6));   
                obj.add(resultSet.getString(7));   
                
                }
                df.addRow(obj);
            }
                          
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
   
   public void populateAllKepemilikanFields(){
            try{
                connection = DriverManager.getConnection(connectionUrl);
                showRecordKepemilikan();
                statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                resultSet = statement.executeQuery("select * from KepemilikanKeranjang");
                if(resultSet.next()){
                keranjangKepemilikan.setText(resultSet.getString(1));
                pelangganKepemilikan.setText(resultSet.getString(2));
                
                }
                }
                
            catch (SQLException e){
                e.printStackTrace();
            }
    
   }
   public void showRecordKepemilikan(){
        try{
            preparedStatement=connection.prepareStatement("select * from KepemilikanKeranjang");
            resultSet=preparedStatement.executeQuery();
            ResultSetMetaData rsm=(ResultSetMetaData) resultSet.getMetaData();
            int n=rsm.getColumnCount();
            DefaultTableModel df=(DefaultTableModel) tblKepemilikan.getModel();
            df.setRowCount(0);
            while(resultSet.next()){
                Vector obj=new Vector();
                for(int i=1;i<=n;i++){    
                obj.add(resultSet.getString(1));
                obj.add(resultSet.getString(2));
                }
                df.addRow(obj);
            }
                          
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
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
    
            
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        sitePanel = new javax.swing.JPanel();
        btnPelanggan = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnPegawai = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnProduk = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnPesanan = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btnPengiriman = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        btnKeranjang = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        btnPromo = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        btnOngkir = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        btnMetode = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnKepemilikan = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        main = new javax.swing.JPanel();
        masuk = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pnlPelanggan = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jScroll = new javax.swing.JScrollPane();
        tblPelanggan = new javax.swing.JTable();
        idPelanggan = new javax.swing.JTextField();
        sandiPelanggan = new javax.swing.JTextField();
        namaPelanggan = new javax.swing.JTextField();
        jalanPelanggan = new javax.swing.JTextField();
        kotaPelanggan = new javax.swing.JTextField();
        provPelanggan = new javax.swing.JTextField();
        telpPelanggan = new javax.swing.JTextField();
        kelaminPelanggan = new javax.swing.JComboBox<>();
        txtCariPelanggan = new javax.swing.JTextField();
        cancelPelanggan = new javax.swing.JButton();
        savePelanggan = new javax.swing.JButton();
        editPelanggan = new javax.swing.JButton();
        deletePelanggan = new javax.swing.JButton();
        newPelanggan = new javax.swing.JButton();
        lastPelanggan = new javax.swing.JButton();
        prevPelanggan = new javax.swing.JButton();
        firstPelanggan = new javax.swing.JButton();
        nextPelanggan = new javax.swing.JButton();
        cariPelanggan = new javax.swing.JButton();
        reloadtblPelanggan = new javax.swing.JButton();
        emailPelanggan = new javax.swing.JTextField();
        pnlPegawai = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jScroll1 = new javax.swing.JScrollPane();
        tblPegawai = new javax.swing.JTable();
        idPegawai = new javax.swing.JTextField();
        sandiPegawai = new javax.swing.JTextField();
        namaPegawai = new javax.swing.JTextField();
        jalanPegawai = new javax.swing.JTextField();
        kotaPegawai = new javax.swing.JTextField();
        provPegawai = new javax.swing.JTextField();
        gajiPegawai = new javax.swing.JTextField();
        kelaminPegawai = new javax.swing.JComboBox<>();
        txtCariPegawai = new javax.swing.JTextField();
        cancelPegawai = new javax.swing.JButton();
        savePegawai = new javax.swing.JButton();
        editPegawai = new javax.swing.JButton();
        deletePegawai = new javax.swing.JButton();
        newPegawai = new javax.swing.JButton();
        lastPegawai = new javax.swing.JButton();
        prevPegawai = new javax.swing.JButton();
        firstPegawai = new javax.swing.JButton();
        nextPegawai = new javax.swing.JButton();
        cariPegawai = new javax.swing.JButton();
        reloadtblPegawai = new javax.swing.JButton();
        emailPegawai = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        telpPegawai = new javax.swing.JTextField();
        posisiPegawai = new javax.swing.JComboBox<>();
        pnlPesanan = new javax.swing.JPanel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jScroll3 = new javax.swing.JScrollPane();
        tblPesanan = new javax.swing.JTable();
        idPesanan = new javax.swing.JTextField();
        keranjangPesanan = new javax.swing.JTextField();
        promoPesanan = new javax.swing.JTextField();
        metodePesanan = new javax.swing.JTextField();
        pengirimanPesanan = new javax.swing.JTextField();
        tanggalPesanan = new javax.swing.JTextField();
        totalHarga = new javax.swing.JTextField();
        txtCariPesanan = new javax.swing.JTextField();
        cancelPesanan = new javax.swing.JButton();
        savePesanan = new javax.swing.JButton();
        editPesanan = new javax.swing.JButton();
        deletePesanan = new javax.swing.JButton();
        newPesanan = new javax.swing.JButton();
        lastPesanan = new javax.swing.JButton();
        prevPesanan = new javax.swing.JButton();
        firstPesanan = new javax.swing.JButton();
        nextPesanan = new javax.swing.JButton();
        cariPesanan = new javax.swing.JButton();
        reloadtblPesanan = new javax.swing.JButton();
        jLabel127 = new javax.swing.JLabel();
        pegawaiPesanan = new javax.swing.JTextField();
        statusPembayaran = new javax.swing.JTextField();
        jLabel128 = new javax.swing.JLabel();
        totalHargaBarang = new javax.swing.JTextField();
        pnlPengiriman = new javax.swing.JPanel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jScroll4 = new javax.swing.JScrollPane();
        tblPengiriman = new javax.swing.JTable();
        idPengiriman = new javax.swing.JTextField();
        jalanPengiriman = new javax.swing.JTextField();
        kotaPengiriman = new javax.swing.JTextField();
        provPengiriman = new javax.swing.JTextField();
        ongkirPengiriman = new javax.swing.JTextField();
        statusPengiriman = new javax.swing.JComboBox<>();
        txtCariPengiriman = new javax.swing.JTextField();
        cancelPengiriman = new javax.swing.JButton();
        savePengiriman = new javax.swing.JButton();
        editPengiriman = new javax.swing.JButton();
        deletePengiriman = new javax.swing.JButton();
        newPengiriman = new javax.swing.JButton();
        lastPengiriman = new javax.swing.JButton();
        prevPengiriman = new javax.swing.JButton();
        firstPengiriman = new javax.swing.JButton();
        nextPengiriman = new javax.swing.JButton();
        cariPengiriman = new javax.swing.JButton();
        reloadtblPengiriman = new javax.swing.JButton();
        tanggalPengiriman = new javax.swing.JTextField();
        pnlKeranjang = new javax.swing.JPanel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jScroll5 = new javax.swing.JScrollPane();
        tblKeranjang = new javax.swing.JTable();
        idKeranjang = new javax.swing.JTextField();
        produkKeranjang = new javax.swing.JTextField();
        jumlahProduk = new javax.swing.JTextField();
        subTotal = new javax.swing.JTextField();
        txtCariKeranjang = new javax.swing.JTextField();
        cancelKeranjang = new javax.swing.JButton();
        saveKeranjang = new javax.swing.JButton();
        editKeranjang = new javax.swing.JButton();
        deleteKeranjang = new javax.swing.JButton();
        newKeranjang = new javax.swing.JButton();
        lastKeranjang = new javax.swing.JButton();
        prevKeranjang = new javax.swing.JButton();
        firstKeranjang = new javax.swing.JButton();
        nextKeranjang = new javax.swing.JButton();
        cariKeranjang = new javax.swing.JButton();
        reloadtblKeranjang = new javax.swing.JButton();
        pnlPromo = new javax.swing.JPanel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jScroll6 = new javax.swing.JScrollPane();
        tblPromo = new javax.swing.JTable();
        idPromo = new javax.swing.JTextField();
        tanggalAwal = new javax.swing.JTextField();
        tanggalBerakhir = new javax.swing.JTextField();
        txtCariPromo = new javax.swing.JTextField();
        cancelPromo = new javax.swing.JButton();
        savePromo = new javax.swing.JButton();
        editPromo = new javax.swing.JButton();
        deletePromo = new javax.swing.JButton();
        newPromo = new javax.swing.JButton();
        lastPromo = new javax.swing.JButton();
        prevPromo = new javax.swing.JButton();
        firstPromo = new javax.swing.JButton();
        nextPromo = new javax.swing.JButton();
        cariPromo = new javax.swing.JButton();
        reloadtblPromo = new javax.swing.JButton();
        potonganPromo = new javax.swing.JTextField();
        pnlOngkir = new javax.swing.JPanel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jScroll7 = new javax.swing.JScrollPane();
        tblOngkir = new javax.swing.JTable();
        idOngkir = new javax.swing.JTextField();
        tarifOngkir = new javax.swing.JTextField();
        txtCariOngkir = new javax.swing.JTextField();
        cancelOngkir = new javax.swing.JButton();
        saveOngkir = new javax.swing.JButton();
        editOngkir = new javax.swing.JButton();
        deleteOngkir = new javax.swing.JButton();
        newOngkir = new javax.swing.JButton();
        lastOngkir = new javax.swing.JButton();
        prevOngkir = new javax.swing.JButton();
        firstOngkir = new javax.swing.JButton();
        nextOngkir = new javax.swing.JButton();
        cariOngkir = new javax.swing.JButton();
        reloadtblOngkir = new javax.swing.JButton();
        provOngkir = new javax.swing.JTextField();
        pnlProduk = new javax.swing.JPanel();
        jLabel159 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        jScroll8 = new javax.swing.JScrollPane();
        tblProduk = new javax.swing.JTable();
        idProduk = new javax.swing.JTextField();
        hargaProduk = new javax.swing.JTextField();
        warnaProduk = new javax.swing.JTextField();
        txtCariProduk = new javax.swing.JTextField();
        cancelProduk = new javax.swing.JButton();
        saveProduk = new javax.swing.JButton();
        editProduk = new javax.swing.JButton();
        deleteProduk = new javax.swing.JButton();
        newProduk = new javax.swing.JButton();
        lastProduk = new javax.swing.JButton();
        prevProduk = new javax.swing.JButton();
        firstProduk = new javax.swing.JButton();
        nextProduk = new javax.swing.JButton();
        cariProduk = new javax.swing.JButton();
        reloadtblProduk = new javax.swing.JButton();
        namaProduk = new javax.swing.JTextField();
        kategoriProduk = new javax.swing.JComboBox<>();
        stokProduk = new javax.swing.JTextField();
        jLabel169 = new javax.swing.JLabel();
        terjualProduk = new javax.swing.JTextField();
        pnlMetode = new javax.swing.JPanel();
        jLabel166 = new javax.swing.JLabel();
        jLabel167 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        jScroll9 = new javax.swing.JScrollPane();
        tblMetode = new javax.swing.JTable();
        idMetode = new javax.swing.JTextField();
        kodePembayaran = new javax.swing.JTextField();
        txtCariMetode = new javax.swing.JTextField();
        cancelMetode = new javax.swing.JButton();
        saveMetode = new javax.swing.JButton();
        editMetode = new javax.swing.JButton();
        deleteMetode = new javax.swing.JButton();
        newMetode = new javax.swing.JButton();
        lastMetode = new javax.swing.JButton();
        prevMetode = new javax.swing.JButton();
        firstMetode = new javax.swing.JButton();
        nextMetode = new javax.swing.JButton();
        cariMetode = new javax.swing.JButton();
        reloadtblMetode = new javax.swing.JButton();
        namaMetode = new javax.swing.JTextField();
        pnlKepemilikan = new javax.swing.JPanel();
        jLabel170 = new javax.swing.JLabel();
        jLabel171 = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        jScroll10 = new javax.swing.JScrollPane();
        tblKepemilikan = new javax.swing.JTable();
        keranjangKepemilikan = new javax.swing.JTextField();
        txtCariKepemilikan = new javax.swing.JTextField();
        cancelKepemilikan = new javax.swing.JButton();
        saveKepemilikan = new javax.swing.JButton();
        editKepemilikan = new javax.swing.JButton();
        deleteKepemilikan = new javax.swing.JButton();
        newKepemilikan = new javax.swing.JButton();
        lastKepemilikan = new javax.swing.JButton();
        prevKepemilikan = new javax.swing.JButton();
        firstKepemilikan = new javax.swing.JButton();
        nextKepemilikan = new javax.swing.JButton();
        cariKepemilikan = new javax.swing.JButton();
        reloadtblKepemilikan = new javax.swing.JButton();
        pelangganKepemilikan = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sitePanel.setBackground(new java.awt.Color(8, 28, 21));
        sitePanel.setPreferredSize(new java.awt.Dimension(200, 600));

        btnPelanggan.setBackground(new java.awt.Color(45, 106, 79));
        btnPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPelangganMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPelangganMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPelangganMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPelangganMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPelangganMouseReleased(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PELANGGAN");

        javax.swing.GroupLayout btnPelangganLayout = new javax.swing.GroupLayout(btnPelanggan);
        btnPelanggan.setLayout(btnPelangganLayout);
        btnPelangganLayout.setHorizontalGroup(
            btnPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPelangganLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        btnPelangganLayout.setVerticalGroup(
            btnPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPelangganLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ADMIN");

        btnPegawai.setBackground(new java.awt.Color(45, 106, 79));
        btnPegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPegawaiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPegawaiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPegawaiMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPegawaiMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPegawaiMouseReleased(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tw Cen MT", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("PEGAWAI");

        javax.swing.GroupLayout btnPegawaiLayout = new javax.swing.GroupLayout(btnPegawai);
        btnPegawai.setLayout(btnPegawaiLayout);
        btnPegawaiLayout.setHorizontalGroup(
            btnPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPegawaiLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        btnPegawaiLayout.setVerticalGroup(
            btnPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPegawaiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnProduk.setBackground(new java.awt.Color(45, 106, 79));
        btnProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProdukMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProdukMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProdukMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnProdukMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnProdukMouseReleased(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tw Cen MT", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("PRODUK");

        javax.swing.GroupLayout btnProdukLayout = new javax.swing.GroupLayout(btnProduk);
        btnProduk.setLayout(btnProdukLayout);
        btnProdukLayout.setHorizontalGroup(
            btnProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnProdukLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        btnProdukLayout.setVerticalGroup(
            btnProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnProdukLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnPesanan.setBackground(new java.awt.Color(45, 106, 79));
        btnPesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPesananMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPesananMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPesananMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPesananMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPesananMouseReleased(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tw Cen MT", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("PESANAN");

        javax.swing.GroupLayout btnPesananLayout = new javax.swing.GroupLayout(btnPesanan);
        btnPesanan.setLayout(btnPesananLayout);
        btnPesananLayout.setHorizontalGroup(
            btnPesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPesananLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        btnPesananLayout.setVerticalGroup(
            btnPesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPesananLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnPengiriman.setBackground(new java.awt.Color(45, 106, 79));
        btnPengiriman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPengirimanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPengirimanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPengirimanMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPengirimanMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPengirimanMouseReleased(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tw Cen MT", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("PENGIRIMAN");

        javax.swing.GroupLayout btnPengirimanLayout = new javax.swing.GroupLayout(btnPengiriman);
        btnPengiriman.setLayout(btnPengirimanLayout);
        btnPengirimanLayout.setHorizontalGroup(
            btnPengirimanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPengirimanLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        btnPengirimanLayout.setVerticalGroup(
            btnPengirimanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPengirimanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnKeranjang.setBackground(new java.awt.Color(45, 106, 79));
        btnKeranjang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKeranjangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnKeranjangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnKeranjangMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnKeranjangMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnKeranjangMouseReleased(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tw Cen MT", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("KERANJANG");

        javax.swing.GroupLayout btnKeranjangLayout = new javax.swing.GroupLayout(btnKeranjang);
        btnKeranjang.setLayout(btnKeranjangLayout);
        btnKeranjangLayout.setHorizontalGroup(
            btnKeranjangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnKeranjangLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        btnKeranjangLayout.setVerticalGroup(
            btnKeranjangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnKeranjangLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnPromo.setBackground(new java.awt.Color(45, 106, 79));
        btnPromo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPromoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPromoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPromoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPromoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPromoMouseReleased(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Tw Cen MT", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("PROMO");

        javax.swing.GroupLayout btnPromoLayout = new javax.swing.GroupLayout(btnPromo);
        btnPromo.setLayout(btnPromoLayout);
        btnPromoLayout.setHorizontalGroup(
            btnPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPromoLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        btnPromoLayout.setVerticalGroup(
            btnPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPromoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnOngkir.setBackground(new java.awt.Color(45, 106, 79));
        btnOngkir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOngkirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnOngkirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOngkirMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnOngkirMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnOngkirMouseReleased(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Tw Cen MT", 1, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("ONGKIR");

        javax.swing.GroupLayout btnOngkirLayout = new javax.swing.GroupLayout(btnOngkir);
        btnOngkir.setLayout(btnOngkirLayout);
        btnOngkirLayout.setHorizontalGroup(
            btnOngkirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnOngkirLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        btnOngkirLayout.setVerticalGroup(
            btnOngkirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnOngkirLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnMetode.setBackground(new java.awt.Color(45, 106, 79));
        btnMetode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMetodeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMetodeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMetodeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMetodeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnMetodeMouseReleased(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("METODE PEMBAYARAN");

        javax.swing.GroupLayout btnMetodeLayout = new javax.swing.GroupLayout(btnMetode);
        btnMetode.setLayout(btnMetodeLayout);
        btnMetodeLayout.setHorizontalGroup(
            btnMetodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnMetodeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        btnMetodeLayout.setVerticalGroup(
            btnMetodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnMetodeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnLogout.setBackground(new java.awt.Color(149, 213, 178));
        btnLogout.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel3.setText("LOG OUT");

        javax.swing.GroupLayout btnLogoutLayout = new javax.swing.GroupLayout(btnLogout);
        btnLogout.setLayout(btnLogoutLayout);
        btnLogoutLayout.setHorizontalGroup(
            btnLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnLogoutLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        btnLogoutLayout.setVerticalGroup(
            btnLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnLogoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnKepemilikan.setBackground(new java.awt.Color(45, 106, 79));
        btnKepemilikan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKepemilikanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnKepemilikanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnKepemilikanMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnKepemilikanMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnKepemilikanMouseReleased(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("KEPEMILIKAN KERANJANG");

        javax.swing.GroupLayout btnKepemilikanLayout = new javax.swing.GroupLayout(btnKepemilikan);
        btnKepemilikan.setLayout(btnKepemilikanLayout);
        btnKepemilikanLayout.setHorizontalGroup(
            btnKepemilikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        btnKepemilikanLayout.setVerticalGroup(
            btnKepemilikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnKepemilikanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout sitePanelLayout = new javax.swing.GroupLayout(sitePanel);
        sitePanel.setLayout(sitePanelLayout);
        sitePanelLayout.setHorizontalGroup(
            sitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sitePanelLayout.createSequentialGroup()
                .addGroup(sitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sitePanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sitePanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sitePanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sitePanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sitePanelLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sitePanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sitePanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(sitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnKepemilikan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPromo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOngkir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMetode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sitePanelLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        sitePanelLayout.setVerticalGroup(
            sitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sitePanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnKepemilikan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(btnPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnOngkir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMetode, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        main.setBackground(new java.awt.Color(242, 204, 143));
        main.setPreferredSize(new java.awt.Dimension(700, 700));
        main.setLayout(new java.awt.CardLayout());

        masuk.setBackground(new java.awt.Color(255, 255, 255));
        masuk.setPreferredSize(new java.awt.Dimension(979, 700));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(88, 129, 87));
        jLabel4.setText("Selamat Datang di Halaman Admin");

        javax.swing.GroupLayout masukLayout = new javax.swing.GroupLayout(masuk);
        masuk.setLayout(masukLayout);
        masukLayout.setHorizontalGroup(
            masukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(masukLayout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(308, Short.MAX_VALUE))
        );
        masukLayout.setVerticalGroup(
            masukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(masukLayout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(410, Short.MAX_VALUE))
        );

        main.add(masuk, "card2");

        pnlPelanggan.setBackground(new java.awt.Color(255, 255, 255));
        pnlPelanggan.setPreferredSize(new java.awt.Dimension(979, 700));

        jLabel79.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(88, 129, 87));
        jLabel79.setText("DATA PELANGGAN");

        jLabel80.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel80.setText("ID");

        jLabel81.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel81.setText("Email");

        jLabel82.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel82.setText("Nama");

        jLabel83.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel83.setText("Jalan");

        jLabel84.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel84.setText("Kota");

        jLabel85.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel85.setText("Kata Sandi");

        jLabel86.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel86.setText("Provinsi");

        jLabel87.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel87.setText("Jenis Kelamin");

        jLabel88.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel88.setText("No Telepon");

        tblPelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Email", "Kata Sandi", "Nama", "Jalan", "Kota", "Provinsi", "No Telepon", "Jenis Kelamin"
            }
        ));
        tblPelanggan.setGridColor(new java.awt.Color(255, 255, 204));
        tblPelanggan.setSelectionBackground(new java.awt.Color(45, 106, 79));
        tblPelanggan.setShowGrid(false);
        tblPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPelangganMouseClicked(evt);
            }
        });
        jScroll.setViewportView(tblPelanggan);
        if (tblPelanggan.getColumnModel().getColumnCount() > 0) {
            tblPelanggan.getColumnModel().getColumn(3).setHeaderValue("Nama");
            tblPelanggan.getColumnModel().getColumn(4).setHeaderValue("Jalan");
            tblPelanggan.getColumnModel().getColumn(5).setHeaderValue("Kota");
            tblPelanggan.getColumnModel().getColumn(6).setHeaderValue("Provinsi");
            tblPelanggan.getColumnModel().getColumn(7).setHeaderValue("No Telepon");
            tblPelanggan.getColumnModel().getColumn(8).setHeaderValue("Jenis Kelamin");
        }

        idPelanggan.setEditable(false);

        kelaminPelanggan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-laki", "Perempuan" }));

        txtCariPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariPelangganActionPerformed(evt);
            }
        });

        cancelPelanggan.setBackground(new java.awt.Color(8, 28, 21));
        cancelPelanggan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelPelanggan.setForeground(new java.awt.Color(255, 255, 255));
        cancelPelanggan.setLabel("Cancel");
        cancelPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelPelangganActionPerformed(evt);
            }
        });

        savePelanggan.setBackground(new java.awt.Color(8, 28, 21));
        savePelanggan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        savePelanggan.setForeground(new java.awt.Color(255, 255, 255));
        savePelanggan.setText("Save");
        savePelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePelangganActionPerformed(evt);
            }
        });

        editPelanggan.setBackground(new java.awt.Color(8, 28, 21));
        editPelanggan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editPelanggan.setForeground(new java.awt.Color(255, 255, 255));
        editPelanggan.setText("Edit");
        editPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPelangganActionPerformed(evt);
            }
        });

        deletePelanggan.setBackground(new java.awt.Color(8, 28, 21));
        deletePelanggan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deletePelanggan.setForeground(new java.awt.Color(255, 255, 255));
        deletePelanggan.setText("Delete");
        deletePelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePelangganActionPerformed(evt);
            }
        });

        newPelanggan.setBackground(new java.awt.Color(8, 28, 21));
        newPelanggan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        newPelanggan.setForeground(new java.awt.Color(255, 255, 255));
        newPelanggan.setText("New");
        newPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPelangganActionPerformed(evt);
            }
        });

        lastPelanggan.setBackground(new java.awt.Color(8, 28, 21));
        lastPelanggan.setForeground(new java.awt.Color(255, 255, 255));
        lastPelanggan.setText(">>");
        lastPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastPelangganActionPerformed(evt);
            }
        });

        prevPelanggan.setBackground(new java.awt.Color(8, 28, 21));
        prevPelanggan.setForeground(new java.awt.Color(255, 255, 255));
        prevPelanggan.setText("<");
        prevPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevPelangganActionPerformed(evt);
            }
        });

        firstPelanggan.setBackground(new java.awt.Color(8, 28, 21));
        firstPelanggan.setForeground(new java.awt.Color(255, 255, 255));
        firstPelanggan.setText("<<");
        firstPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstPelangganActionPerformed(evt);
            }
        });

        nextPelanggan.setBackground(new java.awt.Color(8, 28, 21));
        nextPelanggan.setForeground(new java.awt.Color(255, 255, 255));
        nextPelanggan.setText(">");
        nextPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextPelangganActionPerformed(evt);
            }
        });

        cariPelanggan.setBackground(new java.awt.Color(8, 28, 21));
        cariPelanggan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cariPelanggan.setForeground(new java.awt.Color(255, 255, 255));
        cariPelanggan.setText("Cari");
        cariPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariPelangganActionPerformed(evt);
            }
        });

        reloadtblPelanggan.setBackground(new java.awt.Color(8, 28, 21));
        reloadtblPelanggan.setForeground(new java.awt.Color(255, 255, 255));
        reloadtblPelanggan.setText("↺");
        reloadtblPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadtblPelangganActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPelangganLayout = new javax.swing.GroupLayout(pnlPelanggan);
        pnlPelanggan.setLayout(pnlPelangganLayout);
        pnlPelangganLayout.setHorizontalGroup(
            pnlPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPelangganLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(pnlPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPelangganLayout.createSequentialGroup()
                        .addComponent(txtCariPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cariPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reloadtblPelanggan)))
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(pnlPelangganLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(pnlPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPelangganLayout.createSequentialGroup()
                        .addGroup(pnlPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPelangganLayout.createSequentialGroup()
                                .addComponent(firstPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prevPelanggan)
                                .addGap(3, 3, 3)
                                .addComponent(nextPelanggan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lastPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(newPelanggan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deletePelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(savePelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPelangganLayout.createSequentialGroup()
                                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(165, 165, 165)
                                .addComponent(emailPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlPelangganLayout.createSequentialGroup()
                        .addGroup(pnlPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel88)
                            .addComponent(jLabel87))
                        .addGap(138, 138, 138)
                        .addGroup(pnlPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idPelanggan)
                            .addComponent(sandiPelanggan)
                            .addComponent(namaPelanggan)
                            .addComponent(jalanPelanggan)
                            .addComponent(kotaPelanggan)
                            .addComponent(provPelanggan)
                            .addComponent(telpPelanggan)
                            .addComponent(kelaminPelanggan, 0, 323, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(pnlPelangganLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel79)
                .addGap(296, 296, 296))
        );
        pnlPelangganLayout.setVerticalGroup(
            pnlPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPelangganLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel79)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel80)
                    .addComponent(idPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel81)
                    .addComponent(emailPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel85)
                    .addComponent(sandiPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel82)
                    .addComponent(namaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel83)
                    .addComponent(jalanPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84)
                    .addComponent(kotaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel86)
                    .addComponent(provPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPelangganLayout.createSequentialGroup()
                        .addComponent(jLabel88)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel87))
                    .addGroup(pnlPelangganLayout.createSequentialGroup()
                        .addComponent(telpPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kelaminPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(pnlPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelPelanggan)
                    .addComponent(savePelanggan)
                    .addComponent(editPelanggan)
                    .addComponent(deletePelanggan)
                    .addComponent(newPelanggan)
                    .addComponent(lastPelanggan)
                    .addComponent(prevPelanggan)
                    .addComponent(firstPelanggan)
                    .addComponent(nextPelanggan))
                .addGap(18, 18, 18)
                .addGroup(pnlPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCariPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariPelanggan)
                    .addComponent(reloadtblPelanggan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        main.add(pnlPelanggan, "card2");

        pnlPegawai.setBackground(new java.awt.Color(255, 255, 255));
        pnlPegawai.setPreferredSize(new java.awt.Dimension(979, 700));

        jLabel89.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(88, 129, 87));
        jLabel89.setText("DATA PEGAWAI");

        jLabel90.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel90.setText("ID");

        jLabel91.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel91.setText("Email");

        jLabel92.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel92.setText("Nama");

        jLabel93.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel93.setText("Jalan");

        jLabel94.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel94.setText("Kota");

        jLabel95.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel95.setText("Kata Sandi");

        jLabel96.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel96.setText("Provinsi");

        jLabel97.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel97.setText("Jenis Kelamin");

        jLabel98.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel98.setText("No Telepon");

        tblPegawai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Email", "Kata Sandi", "Nama", "Jalan", "Kota", "Provinsi", "No Telepon", "Posisi", "Gaji", "Jenis Kelamin"
            }
        ));
        tblPegawai.setGridColor(new java.awt.Color(255, 255, 204));
        tblPegawai.setSelectionBackground(new java.awt.Color(45, 106, 79));
        tblPegawai.setShowGrid(false);
        tblPegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPegawaiMouseClicked(evt);
            }
        });
        jScroll1.setViewportView(tblPegawai);

        idPegawai.setEditable(false);

        kelaminPegawai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-laki", "Perempuan" }));
        kelaminPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelaminPegawaiActionPerformed(evt);
            }
        });

        txtCariPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariPegawaiActionPerformed(evt);
            }
        });

        cancelPegawai.setBackground(new java.awt.Color(8, 28, 21));
        cancelPegawai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelPegawai.setForeground(new java.awt.Color(255, 255, 255));
        cancelPegawai.setLabel("Cancel");
        cancelPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelPegawaiActionPerformed(evt);
            }
        });

        savePegawai.setBackground(new java.awt.Color(8, 28, 21));
        savePegawai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        savePegawai.setForeground(new java.awt.Color(255, 255, 255));
        savePegawai.setText("Save");
        savePegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePegawaiActionPerformed(evt);
            }
        });

        editPegawai.setBackground(new java.awt.Color(8, 28, 21));
        editPegawai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editPegawai.setForeground(new java.awt.Color(255, 255, 255));
        editPegawai.setText("Edit");
        editPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPegawaiActionPerformed(evt);
            }
        });

        deletePegawai.setBackground(new java.awt.Color(8, 28, 21));
        deletePegawai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deletePegawai.setForeground(new java.awt.Color(255, 255, 255));
        deletePegawai.setText("Delete");
        deletePegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePegawaiActionPerformed(evt);
            }
        });

        newPegawai.setBackground(new java.awt.Color(8, 28, 21));
        newPegawai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        newPegawai.setForeground(new java.awt.Color(255, 255, 255));
        newPegawai.setText("New");
        newPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPegawaiActionPerformed(evt);
            }
        });

        lastPegawai.setBackground(new java.awt.Color(8, 28, 21));
        lastPegawai.setForeground(new java.awt.Color(255, 255, 255));
        lastPegawai.setText(">>");
        lastPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastPegawaiActionPerformed(evt);
            }
        });

        prevPegawai.setBackground(new java.awt.Color(8, 28, 21));
        prevPegawai.setForeground(new java.awt.Color(255, 255, 255));
        prevPegawai.setText("<");
        prevPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevPegawaiActionPerformed(evt);
            }
        });

        firstPegawai.setBackground(new java.awt.Color(8, 28, 21));
        firstPegawai.setForeground(new java.awt.Color(255, 255, 255));
        firstPegawai.setText("<<");
        firstPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstPegawaiActionPerformed(evt);
            }
        });

        nextPegawai.setBackground(new java.awt.Color(8, 28, 21));
        nextPegawai.setForeground(new java.awt.Color(255, 255, 255));
        nextPegawai.setText(">");
        nextPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextPegawaiActionPerformed(evt);
            }
        });

        cariPegawai.setBackground(new java.awt.Color(8, 28, 21));
        cariPegawai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cariPegawai.setForeground(new java.awt.Color(255, 255, 255));
        cariPegawai.setText("Cari");
        cariPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariPegawaiActionPerformed(evt);
            }
        });

        reloadtblPegawai.setBackground(new java.awt.Color(8, 28, 21));
        reloadtblPegawai.setForeground(new java.awt.Color(255, 255, 255));
        reloadtblPegawai.setText("↺");
        reloadtblPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadtblPegawaiActionPerformed(evt);
            }
        });

        jLabel99.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel99.setText("Posisi");

        jLabel100.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel100.setText("Gaji");

        posisiPegawai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Courir", "Customer Service", "Digital Marketing Specialist", "E-commerce Manager", "Finance and Accounting", "Human Resources", "Inventory Manager", "IT Support Specialist", "Quality Assurance", "Sales Associate" }));

        javax.swing.GroupLayout pnlPegawaiLayout = new javax.swing.GroupLayout(pnlPegawai);
        pnlPegawai.setLayout(pnlPegawaiLayout);
        pnlPegawaiLayout.setHorizontalGroup(
            pnlPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPegawaiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel89)
                .addGap(296, 296, 296))
            .addGroup(pnlPegawaiLayout.createSequentialGroup()
                .addGroup(pnlPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPegawaiLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(pnlPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPegawaiLayout.createSequentialGroup()
                                .addComponent(firstPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prevPegawai)
                                .addGap(3, 3, 3)
                                .addComponent(nextPegawai)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lastPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(newPegawai)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deletePegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(savePegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPegawaiLayout.createSequentialGroup()
                                .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(165, 165, 165)
                                .addComponent(emailPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPegawaiLayout.createSequentialGroup()
                                .addGroup(pnlPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel98)
                                    .addComponent(jLabel97)
                                    .addComponent(jLabel100)
                                    .addComponent(jLabel99))
                                .addGap(138, 138, 138)
                                .addGroup(pnlPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(gajiPegawai)
                                        .addComponent(posisiPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(idPegawai, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                                        .addComponent(sandiPegawai)
                                        .addComponent(namaPegawai)
                                        .addComponent(jalanPegawai)
                                        .addComponent(kotaPegawai)
                                        .addComponent(provPegawai)
                                        .addComponent(telpPegawai, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(kelaminPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(pnlPegawaiLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(pnlPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPegawaiLayout.createSequentialGroup()
                                .addComponent(txtCariPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cariPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reloadtblPegawai))
                            .addComponent(jScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPegawaiLayout.setVerticalGroup(
            pnlPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPegawaiLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel89)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel90)
                    .addComponent(idPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel91)
                    .addComponent(emailPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel95)
                    .addComponent(sandiPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel92)
                    .addComponent(namaPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93)
                    .addComponent(jalanPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel94)
                    .addComponent(kotaPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel96)
                    .addComponent(provPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPegawaiLayout.createSequentialGroup()
                        .addComponent(jLabel98)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel97))
                    .addGroup(pnlPegawaiLayout.createSequentialGroup()
                        .addComponent(telpPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kelaminPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel99)
                    .addComponent(posisiPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPegawaiLayout.createSequentialGroup()
                        .addComponent(jLabel100)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelPegawai)
                            .addComponent(savePegawai)
                            .addComponent(editPegawai)
                            .addComponent(deletePegawai)
                            .addComponent(newPegawai)
                            .addComponent(lastPegawai)
                            .addComponent(prevPegawai)
                            .addComponent(firstPegawai)
                            .addComponent(nextPegawai)))
                    .addComponent(gajiPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCariPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariPegawai)
                    .addComponent(reloadtblPegawai))
                .addGap(12, 12, 12)
                .addComponent(jScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );

        main.add(pnlPegawai, "card2");

        pnlPesanan.setBackground(new java.awt.Color(255, 255, 255));
        pnlPesanan.setPreferredSize(new java.awt.Dimension(979, 700));

        jLabel109.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(88, 129, 87));
        jLabel109.setText("DATA PESANAN");

        jLabel110.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel110.setText("ID Pesanan");

        jLabel112.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel112.setText("Kode Promo");

        jLabel113.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel113.setText("ID Metode Pembayaran");

        jLabel114.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel114.setText("ID Pengiriman");

        jLabel115.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel115.setText("ID Keranjang");

        jLabel116.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel116.setText("Tanggal Pesanan");

        jLabel117.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel117.setText("ID Pegawai");

        jLabel118.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel118.setText("Total Harga");

        tblPesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Pesanan", "ID Keranjang", "Kode Promo", "ID Metode Pembayaran", "ID Pengiriman", "Tanggal Pesanan", "Total Harga Barang", "Total Harga", "ID Pegawai", "Status Pembayaran"
            }
        ));
        tblPesanan.setGridColor(new java.awt.Color(255, 255, 204));
        tblPesanan.setSelectionBackground(new java.awt.Color(45, 106, 79));
        tblPesanan.setShowGrid(false);
        tblPesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPesananMouseClicked(evt);
            }
        });
        jScroll3.setViewportView(tblPesanan);

        idPesanan.setEditable(false);

        txtCariPesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariPesananActionPerformed(evt);
            }
        });

        cancelPesanan.setBackground(new java.awt.Color(8, 28, 21));
        cancelPesanan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelPesanan.setForeground(new java.awt.Color(255, 255, 255));
        cancelPesanan.setLabel("Cancel");
        cancelPesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelPesananActionPerformed(evt);
            }
        });

        savePesanan.setBackground(new java.awt.Color(8, 28, 21));
        savePesanan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        savePesanan.setForeground(new java.awt.Color(255, 255, 255));
        savePesanan.setText("Save");
        savePesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePesananActionPerformed(evt);
            }
        });

        editPesanan.setBackground(new java.awt.Color(8, 28, 21));
        editPesanan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editPesanan.setForeground(new java.awt.Color(255, 255, 255));
        editPesanan.setText("Edit");
        editPesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPesananActionPerformed(evt);
            }
        });

        deletePesanan.setBackground(new java.awt.Color(8, 28, 21));
        deletePesanan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deletePesanan.setForeground(new java.awt.Color(255, 255, 255));
        deletePesanan.setText("Delete");
        deletePesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePesananActionPerformed(evt);
            }
        });

        newPesanan.setBackground(new java.awt.Color(8, 28, 21));
        newPesanan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        newPesanan.setForeground(new java.awt.Color(255, 255, 255));
        newPesanan.setText("New");
        newPesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPesananActionPerformed(evt);
            }
        });

        lastPesanan.setBackground(new java.awt.Color(8, 28, 21));
        lastPesanan.setForeground(new java.awt.Color(255, 255, 255));
        lastPesanan.setText(">>");
        lastPesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastPesananActionPerformed(evt);
            }
        });

        prevPesanan.setBackground(new java.awt.Color(8, 28, 21));
        prevPesanan.setForeground(new java.awt.Color(255, 255, 255));
        prevPesanan.setText("<");
        prevPesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevPesananActionPerformed(evt);
            }
        });

        firstPesanan.setBackground(new java.awt.Color(8, 28, 21));
        firstPesanan.setForeground(new java.awt.Color(255, 255, 255));
        firstPesanan.setText("<<");
        firstPesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstPesananActionPerformed(evt);
            }
        });

        nextPesanan.setBackground(new java.awt.Color(8, 28, 21));
        nextPesanan.setForeground(new java.awt.Color(255, 255, 255));
        nextPesanan.setText(">");
        nextPesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextPesananActionPerformed(evt);
            }
        });

        cariPesanan.setBackground(new java.awt.Color(8, 28, 21));
        cariPesanan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cariPesanan.setForeground(new java.awt.Color(255, 255, 255));
        cariPesanan.setText("Cari");
        cariPesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariPesananActionPerformed(evt);
            }
        });

        reloadtblPesanan.setBackground(new java.awt.Color(8, 28, 21));
        reloadtblPesanan.setForeground(new java.awt.Color(255, 255, 255));
        reloadtblPesanan.setText("↺");
        reloadtblPesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadtblPesananActionPerformed(evt);
            }
        });

        jLabel127.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel127.setText("Status Pembayaran");

        jLabel128.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel128.setText("Total Harga Barang");

        javax.swing.GroupLayout pnlPesananLayout = new javax.swing.GroupLayout(pnlPesanan);
        pnlPesanan.setLayout(pnlPesananLayout);
        pnlPesananLayout.setHorizontalGroup(
            pnlPesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPesananLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel109)
                .addGap(296, 296, 296))
            .addGroup(pnlPesananLayout.createSequentialGroup()
                .addGroup(pnlPesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPesananLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(pnlPesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScroll3, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlPesananLayout.createSequentialGroup()
                                .addComponent(txtCariPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cariPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reloadtblPesanan))))
                    .addGroup(pnlPesananLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(pnlPesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPesananLayout.createSequentialGroup()
                                .addComponent(firstPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prevPesanan)
                                .addGap(3, 3, 3)
                                .addComponent(nextPesanan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lastPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(newPesanan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deletePesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(savePesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPesananLayout.createSequentialGroup()
                                .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(idPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPesananLayout.createSequentialGroup()
                                .addGroup(pnlPesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlPesananLayout.createSequentialGroup()
                                        .addGroup(pnlPesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel115, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel113)
                                            .addComponent(jLabel114)
                                            .addGroup(pnlPesananLayout.createSequentialGroup()
                                                .addComponent(jLabel116, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(40, 40, 40)))
                                        .addGap(55, 55, 55))
                                    .addGroup(pnlPesananLayout.createSequentialGroup()
                                        .addComponent(jLabel112, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(138, 138, 138)))
                                .addGroup(pnlPesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(promoPesanan)
                                    .addComponent(metodePesanan)
                                    .addComponent(pengirimanPesanan)
                                    .addComponent(tanggalPesanan)
                                    .addComponent(keranjangPesanan, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)))
                            .addGroup(pnlPesananLayout.createSequentialGroup()
                                .addGroup(pnlPesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel118)
                                    .addComponent(jLabel117)
                                    .addComponent(jLabel128)
                                    .addComponent(jLabel127))
                                .addGap(90, 90, 90)
                                .addGroup(pnlPesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(totalHargaBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                                    .addComponent(totalHarga)
                                    .addComponent(pegawaiPesanan)
                                    .addComponent(statusPembayaran))))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        pnlPesananLayout.setVerticalGroup(
            pnlPesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPesananLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel109)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel110)
                    .addComponent(idPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel115)
                    .addComponent(keranjangPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel112)
                    .addComponent(promoPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel113)
                    .addComponent(metodePesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel114)
                    .addComponent(pengirimanPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel116)
                    .addComponent(tanggalPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel128)
                    .addComponent(totalHargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPesananLayout.createSequentialGroup()
                        .addComponent(jLabel118)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel117))
                    .addGroup(pnlPesananLayout.createSequentialGroup()
                        .addComponent(totalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pegawaiPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnlPesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPesananLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel127))
                    .addGroup(pnlPesananLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelPesanan)
                    .addComponent(savePesanan)
                    .addComponent(editPesanan)
                    .addComponent(deletePesanan)
                    .addComponent(newPesanan)
                    .addComponent(lastPesanan)
                    .addComponent(prevPesanan)
                    .addComponent(firstPesanan)
                    .addComponent(nextPesanan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCariPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariPesanan)
                    .addComponent(reloadtblPesanan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScroll3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        main.add(pnlPesanan, "card2");

        pnlPengiriman.setBackground(new java.awt.Color(255, 255, 255));
        pnlPengiriman.setPreferredSize(new java.awt.Dimension(979, 700));

        jLabel119.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(88, 129, 87));
        jLabel119.setText("DATA PENGIRIMAN");

        jLabel120.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel120.setText("ID");

        jLabel121.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel121.setText("Tanggal Pengiriman");

        jLabel122.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel122.setText("Kota Tujuan");

        jLabel123.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel123.setText("Provinsi Tujuan");

        jLabel124.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel124.setText("Status Pengiriman");

        jLabel125.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel125.setText("Jalan Tujuan");

        jLabel126.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel126.setText("ID Ongkir");

        tblPengiriman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tanggal Pengiriman", "Jalan Tujuan", "Kota Tujuan", "Provinsi Tujuan", "Status Pengiriman", "ID Ongkir"
            }
        ));
        tblPengiriman.setGridColor(new java.awt.Color(255, 255, 204));
        tblPengiriman.setSelectionBackground(new java.awt.Color(45, 106, 79));
        tblPengiriman.setShowGrid(false);
        tblPengiriman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPengirimanMouseClicked(evt);
            }
        });
        jScroll4.setViewportView(tblPengiriman);

        idPengiriman.setEditable(false);

        statusPengiriman.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dikirim", "Diterima", "Dibatalkan" }));

        txtCariPengiriman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariPengirimanActionPerformed(evt);
            }
        });

        cancelPengiriman.setBackground(new java.awt.Color(8, 28, 21));
        cancelPengiriman.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelPengiriman.setForeground(new java.awt.Color(255, 255, 255));
        cancelPengiriman.setLabel("Cancel");
        cancelPengiriman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelPengirimanActionPerformed(evt);
            }
        });

        savePengiriman.setBackground(new java.awt.Color(8, 28, 21));
        savePengiriman.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        savePengiriman.setForeground(new java.awt.Color(255, 255, 255));
        savePengiriman.setText("Save");
        savePengiriman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePengirimanActionPerformed(evt);
            }
        });

        editPengiriman.setBackground(new java.awt.Color(8, 28, 21));
        editPengiriman.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editPengiriman.setForeground(new java.awt.Color(255, 255, 255));
        editPengiriman.setText("Edit");
        editPengiriman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPengirimanActionPerformed(evt);
            }
        });

        deletePengiriman.setBackground(new java.awt.Color(8, 28, 21));
        deletePengiriman.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deletePengiriman.setForeground(new java.awt.Color(255, 255, 255));
        deletePengiriman.setText("Delete");
        deletePengiriman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePengirimanActionPerformed(evt);
            }
        });

        newPengiriman.setBackground(new java.awt.Color(8, 28, 21));
        newPengiriman.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        newPengiriman.setForeground(new java.awt.Color(255, 255, 255));
        newPengiriman.setText("New");
        newPengiriman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPengirimanActionPerformed(evt);
            }
        });

        lastPengiriman.setBackground(new java.awt.Color(8, 28, 21));
        lastPengiriman.setForeground(new java.awt.Color(255, 255, 255));
        lastPengiriman.setText(">>");
        lastPengiriman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastPengirimanActionPerformed(evt);
            }
        });

        prevPengiriman.setBackground(new java.awt.Color(8, 28, 21));
        prevPengiriman.setForeground(new java.awt.Color(255, 255, 255));
        prevPengiriman.setText("<");
        prevPengiriman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevPengirimanActionPerformed(evt);
            }
        });

        firstPengiriman.setBackground(new java.awt.Color(8, 28, 21));
        firstPengiriman.setForeground(new java.awt.Color(255, 255, 255));
        firstPengiriman.setText("<<");
        firstPengiriman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstPengirimanActionPerformed(evt);
            }
        });

        nextPengiriman.setBackground(new java.awt.Color(8, 28, 21));
        nextPengiriman.setForeground(new java.awt.Color(255, 255, 255));
        nextPengiriman.setText(">");
        nextPengiriman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextPengirimanActionPerformed(evt);
            }
        });

        cariPengiriman.setBackground(new java.awt.Color(8, 28, 21));
        cariPengiriman.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cariPengiriman.setForeground(new java.awt.Color(255, 255, 255));
        cariPengiriman.setText("Cari");
        cariPengiriman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariPengirimanActionPerformed(evt);
            }
        });

        reloadtblPengiriman.setBackground(new java.awt.Color(8, 28, 21));
        reloadtblPengiriman.setForeground(new java.awt.Color(255, 255, 255));
        reloadtblPengiriman.setText("↺");
        reloadtblPengiriman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadtblPengirimanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPengirimanLayout = new javax.swing.GroupLayout(pnlPengiriman);
        pnlPengiriman.setLayout(pnlPengirimanLayout);
        pnlPengirimanLayout.setHorizontalGroup(
            pnlPengirimanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPengirimanLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(pnlPengirimanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPengirimanLayout.createSequentialGroup()
                        .addGroup(pnlPengirimanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPengirimanLayout.createSequentialGroup()
                                .addComponent(firstPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prevPengiriman)
                                .addGap(3, 3, 3)
                                .addComponent(nextPengiriman)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lastPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(newPengiriman)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deletePengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(savePengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPengirimanLayout.createSequentialGroup()
                                .addComponent(jLabel121)
                                .addGap(83, 83, 83)
                                .addComponent(tanggalPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlPengirimanLayout.createSequentialGroup()
                        .addGroup(pnlPengirimanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel123, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlPengirimanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel122, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel125, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel124))
                        .addGap(99, 99, 99)
                        .addGroup(pnlPengirimanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idPengiriman)
                            .addComponent(jalanPengiriman)
                            .addComponent(kotaPengiriman)
                            .addComponent(provPengiriman)
                            .addComponent(ongkirPengiriman)
                            .addComponent(statusPengiriman, 0, 323, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPengirimanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel119)
                .addGap(296, 296, 296))
            .addGroup(pnlPengirimanLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(pnlPengirimanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScroll4, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPengirimanLayout.createSequentialGroup()
                        .addComponent(txtCariPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cariPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reloadtblPengiriman)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPengirimanLayout.setVerticalGroup(
            pnlPengirimanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPengirimanLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel119)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPengirimanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel120)
                    .addComponent(idPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPengirimanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel121)
                    .addComponent(tanggalPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPengirimanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel125)
                    .addComponent(jalanPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPengirimanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel122)
                    .addComponent(kotaPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPengirimanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel123)
                    .addComponent(provPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPengirimanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel124)
                    .addComponent(statusPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPengirimanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel126)
                    .addComponent(ongkirPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnlPengirimanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelPengiriman)
                    .addComponent(savePengiriman)
                    .addComponent(editPengiriman)
                    .addComponent(deletePengiriman)
                    .addComponent(newPengiriman)
                    .addComponent(lastPengiriman)
                    .addComponent(prevPengiriman)
                    .addComponent(firstPengiriman)
                    .addComponent(nextPengiriman))
                .addGap(27, 27, 27)
                .addGroup(pnlPengirimanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCariPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariPengiriman)
                    .addComponent(reloadtblPengiriman))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScroll4, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        main.add(pnlPengiriman, "card2");

        pnlKeranjang.setBackground(new java.awt.Color(255, 255, 255));
        pnlKeranjang.setPreferredSize(new java.awt.Dimension(979, 700));

        jLabel129.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(88, 129, 87));
        jLabel129.setText("DATA KERANJANG");

        jLabel130.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel130.setText("ID Keranjang");

        jLabel132.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel132.setText("Jumlah Produk");

        jLabel133.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel133.setText("Sub Total");

        jLabel135.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel135.setText("ID Produk");

        tblKeranjang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Keranjang", "ID Produk", "Jumlah Produk", "Sub Total"
            }
        ));
        tblKeranjang.setGridColor(new java.awt.Color(255, 255, 204));
        tblKeranjang.setSelectionBackground(new java.awt.Color(45, 106, 79));
        tblKeranjang.setShowGrid(false);
        tblKeranjang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKeranjangMouseClicked(evt);
            }
        });
        jScroll5.setViewportView(tblKeranjang);

        idKeranjang.setEditable(false);

        txtCariKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariKeranjangActionPerformed(evt);
            }
        });

        cancelKeranjang.setBackground(new java.awt.Color(8, 28, 21));
        cancelKeranjang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelKeranjang.setForeground(new java.awt.Color(255, 255, 255));
        cancelKeranjang.setLabel("Cancel");
        cancelKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelKeranjangActionPerformed(evt);
            }
        });

        saveKeranjang.setBackground(new java.awt.Color(8, 28, 21));
        saveKeranjang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        saveKeranjang.setForeground(new java.awt.Color(255, 255, 255));
        saveKeranjang.setText("Save");
        saveKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveKeranjangActionPerformed(evt);
            }
        });

        editKeranjang.setBackground(new java.awt.Color(8, 28, 21));
        editKeranjang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editKeranjang.setForeground(new java.awt.Color(255, 255, 255));
        editKeranjang.setText("Edit");
        editKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editKeranjangActionPerformed(evt);
            }
        });

        deleteKeranjang.setBackground(new java.awt.Color(8, 28, 21));
        deleteKeranjang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deleteKeranjang.setForeground(new java.awt.Color(255, 255, 255));
        deleteKeranjang.setText("Delete");
        deleteKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteKeranjangActionPerformed(evt);
            }
        });

        newKeranjang.setBackground(new java.awt.Color(8, 28, 21));
        newKeranjang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        newKeranjang.setForeground(new java.awt.Color(255, 255, 255));
        newKeranjang.setText("New");
        newKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newKeranjangActionPerformed(evt);
            }
        });

        lastKeranjang.setBackground(new java.awt.Color(8, 28, 21));
        lastKeranjang.setForeground(new java.awt.Color(255, 255, 255));
        lastKeranjang.setText(">>");
        lastKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastKeranjangActionPerformed(evt);
            }
        });

        prevKeranjang.setBackground(new java.awt.Color(8, 28, 21));
        prevKeranjang.setForeground(new java.awt.Color(255, 255, 255));
        prevKeranjang.setText("<");
        prevKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevKeranjangActionPerformed(evt);
            }
        });

        firstKeranjang.setBackground(new java.awt.Color(8, 28, 21));
        firstKeranjang.setForeground(new java.awt.Color(255, 255, 255));
        firstKeranjang.setText("<<");
        firstKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstKeranjangActionPerformed(evt);
            }
        });

        nextKeranjang.setBackground(new java.awt.Color(8, 28, 21));
        nextKeranjang.setForeground(new java.awt.Color(255, 255, 255));
        nextKeranjang.setText(">");
        nextKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextKeranjangActionPerformed(evt);
            }
        });

        cariKeranjang.setBackground(new java.awt.Color(8, 28, 21));
        cariKeranjang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cariKeranjang.setForeground(new java.awt.Color(255, 255, 255));
        cariKeranjang.setText("Cari");
        cariKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariKeranjangActionPerformed(evt);
            }
        });

        reloadtblKeranjang.setBackground(new java.awt.Color(8, 28, 21));
        reloadtblKeranjang.setForeground(new java.awt.Color(255, 255, 255));
        reloadtblKeranjang.setText("↺");
        reloadtblKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadtblKeranjangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlKeranjangLayout = new javax.swing.GroupLayout(pnlKeranjang);
        pnlKeranjang.setLayout(pnlKeranjangLayout);
        pnlKeranjangLayout.setHorizontalGroup(
            pnlKeranjangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKeranjangLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(pnlKeranjangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlKeranjangLayout.createSequentialGroup()
                        .addGroup(pnlKeranjangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel130)
                            .addComponent(jLabel132)
                            .addComponent(jLabel133))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                        .addGroup(pnlKeranjangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idKeranjang)
                            .addComponent(produkKeranjang)
                            .addComponent(jumlahProduk)
                            .addComponent(subTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(263, Short.MAX_VALUE))
                    .addGroup(pnlKeranjangLayout.createSequentialGroup()
                        .addComponent(firstKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prevKeranjang)
                        .addGap(3, 3, 3)
                        .addComponent(nextKeranjang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(newKeranjang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKeranjangLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel129)
                .addGap(296, 296, 296))
            .addGroup(pnlKeranjangLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(pnlKeranjangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScroll5, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlKeranjangLayout.createSequentialGroup()
                        .addComponent(txtCariKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cariKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reloadtblKeranjang)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        pnlKeranjangLayout.setVerticalGroup(
            pnlKeranjangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKeranjangLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel129)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlKeranjangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel130)
                    .addComponent(idKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlKeranjangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel135)
                    .addComponent(produkKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlKeranjangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel132)
                    .addComponent(jumlahProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlKeranjangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel133)
                    .addComponent(subTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(pnlKeranjangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelKeranjang)
                    .addComponent(saveKeranjang)
                    .addComponent(editKeranjang)
                    .addComponent(deleteKeranjang)
                    .addComponent(newKeranjang)
                    .addComponent(lastKeranjang)
                    .addComponent(prevKeranjang)
                    .addComponent(firstKeranjang)
                    .addComponent(nextKeranjang))
                .addGap(49, 49, 49)
                .addGroup(pnlKeranjangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCariKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariKeranjang)
                    .addComponent(reloadtblKeranjang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScroll5, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        main.add(pnlKeranjang, "card2");

        pnlPromo.setBackground(new java.awt.Color(255, 255, 255));
        pnlPromo.setPreferredSize(new java.awt.Dimension(979, 700));

        jLabel139.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        jLabel139.setForeground(new java.awt.Color(88, 129, 87));
        jLabel139.setText("DATA PROMO");

        jLabel140.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel140.setText("Kode Promo");

        jLabel141.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel141.setText("Jumlah Potongan");

        jLabel142.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel142.setText("Tanggal Berakhir");

        jLabel145.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel145.setText("Tanggal Awal");

        tblPromo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Promo", "Jumlah Potongan", "Tanggal Awal", "Tanggal Berakhir"
            }
        ));
        tblPromo.setGridColor(new java.awt.Color(255, 255, 204));
        tblPromo.setSelectionBackground(new java.awt.Color(45, 106, 79));
        tblPromo.setShowGrid(false);
        tblPromo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPromoMouseClicked(evt);
            }
        });
        jScroll6.setViewportView(tblPromo);

        idPromo.setEditable(false);

        tanggalAwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggalAwalActionPerformed(evt);
            }
        });

        txtCariPromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariPromoActionPerformed(evt);
            }
        });

        cancelPromo.setBackground(new java.awt.Color(8, 28, 21));
        cancelPromo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelPromo.setForeground(new java.awt.Color(255, 255, 255));
        cancelPromo.setLabel("Cancel");
        cancelPromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelPromoActionPerformed(evt);
            }
        });

        savePromo.setBackground(new java.awt.Color(8, 28, 21));
        savePromo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        savePromo.setForeground(new java.awt.Color(255, 255, 255));
        savePromo.setText("Save");
        savePromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePromoActionPerformed(evt);
            }
        });

        editPromo.setBackground(new java.awt.Color(8, 28, 21));
        editPromo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editPromo.setForeground(new java.awt.Color(255, 255, 255));
        editPromo.setText("Edit");
        editPromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPromoActionPerformed(evt);
            }
        });

        deletePromo.setBackground(new java.awt.Color(8, 28, 21));
        deletePromo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deletePromo.setForeground(new java.awt.Color(255, 255, 255));
        deletePromo.setText("Delete");
        deletePromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePromoActionPerformed(evt);
            }
        });

        newPromo.setBackground(new java.awt.Color(8, 28, 21));
        newPromo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        newPromo.setForeground(new java.awt.Color(255, 255, 255));
        newPromo.setText("New");
        newPromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPromoActionPerformed(evt);
            }
        });

        lastPromo.setBackground(new java.awt.Color(8, 28, 21));
        lastPromo.setForeground(new java.awt.Color(255, 255, 255));
        lastPromo.setText(">>");
        lastPromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastPromoActionPerformed(evt);
            }
        });

        prevPromo.setBackground(new java.awt.Color(8, 28, 21));
        prevPromo.setForeground(new java.awt.Color(255, 255, 255));
        prevPromo.setText("<");
        prevPromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevPromoActionPerformed(evt);
            }
        });

        firstPromo.setBackground(new java.awt.Color(8, 28, 21));
        firstPromo.setForeground(new java.awt.Color(255, 255, 255));
        firstPromo.setText("<<");
        firstPromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstPromoActionPerformed(evt);
            }
        });

        nextPromo.setBackground(new java.awt.Color(8, 28, 21));
        nextPromo.setForeground(new java.awt.Color(255, 255, 255));
        nextPromo.setText(">");
        nextPromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextPromoActionPerformed(evt);
            }
        });

        cariPromo.setBackground(new java.awt.Color(8, 28, 21));
        cariPromo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cariPromo.setForeground(new java.awt.Color(255, 255, 255));
        cariPromo.setText("Cari");
        cariPromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariPromoActionPerformed(evt);
            }
        });

        reloadtblPromo.setBackground(new java.awt.Color(8, 28, 21));
        reloadtblPromo.setForeground(new java.awt.Color(255, 255, 255));
        reloadtblPromo.setText("↺");
        reloadtblPromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadtblPromoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPromoLayout = new javax.swing.GroupLayout(pnlPromo);
        pnlPromo.setLayout(pnlPromoLayout);
        pnlPromoLayout.setHorizontalGroup(
            pnlPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPromoLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(pnlPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPromoLayout.createSequentialGroup()
                        .addGroup(pnlPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPromoLayout.createSequentialGroup()
                                .addComponent(firstPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prevPromo)
                                .addGap(3, 3, 3)
                                .addComponent(nextPromo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lastPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(newPromo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deletePromo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(savePromo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPromoLayout.createSequentialGroup()
                                .addComponent(jLabel141)
                                .addGap(106, 106, 106)
                                .addComponent(potonganPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlPromoLayout.createSequentialGroup()
                        .addGroup(pnlPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel140)
                            .addComponent(jLabel142)
                            .addComponent(jLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(110, 110, 110)
                        .addGroup(pnlPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idPromo, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                            .addComponent(tanggalAwal)
                            .addComponent(tanggalBerakhir))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPromoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel139)
                .addGap(296, 296, 296))
            .addGroup(pnlPromoLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(pnlPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScroll6, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPromoLayout.createSequentialGroup()
                        .addComponent(txtCariPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cariPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reloadtblPromo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPromoLayout.setVerticalGroup(
            pnlPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPromoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel139)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel140)
                    .addComponent(idPromo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel141)
                    .addComponent(potonganPromo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel145)
                    .addComponent(tanggalAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel142)
                    .addComponent(tanggalBerakhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(pnlPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelPromo)
                    .addComponent(savePromo)
                    .addComponent(editPromo)
                    .addComponent(deletePromo)
                    .addComponent(newPromo)
                    .addComponent(lastPromo)
                    .addComponent(prevPromo)
                    .addComponent(firstPromo)
                    .addComponent(nextPromo))
                .addGap(57, 57, 57)
                .addGroup(pnlPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCariPromo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariPromo)
                    .addComponent(reloadtblPromo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScroll6, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        main.add(pnlPromo, "card2");

        pnlOngkir.setBackground(new java.awt.Color(255, 255, 255));
        pnlOngkir.setPreferredSize(new java.awt.Dimension(979, 700));

        jLabel149.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        jLabel149.setForeground(new java.awt.Color(88, 129, 87));
        jLabel149.setText("DATA ONGKIR");

        jLabel150.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel150.setText("ID");

        jLabel151.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel151.setText("Provinsi");

        jLabel155.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel155.setText("Tarif");

        tblOngkir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Provinsi", "Ongkir"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOngkir.setGridColor(new java.awt.Color(255, 255, 204));
        tblOngkir.setSelectionBackground(new java.awt.Color(45, 106, 79));
        tblOngkir.setShowGrid(false);
        tblOngkir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOngkirMouseClicked(evt);
            }
        });
        jScroll7.setViewportView(tblOngkir);

        idOngkir.setEditable(false);

        txtCariOngkir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariOngkirActionPerformed(evt);
            }
        });

        cancelOngkir.setBackground(new java.awt.Color(8, 28, 21));
        cancelOngkir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelOngkir.setForeground(new java.awt.Color(255, 255, 255));
        cancelOngkir.setLabel("Cancel");
        cancelOngkir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelOngkirActionPerformed(evt);
            }
        });

        saveOngkir.setBackground(new java.awt.Color(8, 28, 21));
        saveOngkir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        saveOngkir.setForeground(new java.awt.Color(255, 255, 255));
        saveOngkir.setText("Save");
        saveOngkir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveOngkirActionPerformed(evt);
            }
        });

        editOngkir.setBackground(new java.awt.Color(8, 28, 21));
        editOngkir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editOngkir.setForeground(new java.awt.Color(255, 255, 255));
        editOngkir.setText("Edit");
        editOngkir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editOngkirActionPerformed(evt);
            }
        });

        deleteOngkir.setBackground(new java.awt.Color(8, 28, 21));
        deleteOngkir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deleteOngkir.setForeground(new java.awt.Color(255, 255, 255));
        deleteOngkir.setText("Delete");
        deleteOngkir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteOngkirActionPerformed(evt);
            }
        });

        newOngkir.setBackground(new java.awt.Color(8, 28, 21));
        newOngkir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        newOngkir.setForeground(new java.awt.Color(255, 255, 255));
        newOngkir.setText("New");
        newOngkir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOngkirActionPerformed(evt);
            }
        });

        lastOngkir.setBackground(new java.awt.Color(8, 28, 21));
        lastOngkir.setForeground(new java.awt.Color(255, 255, 255));
        lastOngkir.setText(">>");
        lastOngkir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastOngkirActionPerformed(evt);
            }
        });

        prevOngkir.setBackground(new java.awt.Color(8, 28, 21));
        prevOngkir.setForeground(new java.awt.Color(255, 255, 255));
        prevOngkir.setText("<");
        prevOngkir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevOngkirActionPerformed(evt);
            }
        });

        firstOngkir.setBackground(new java.awt.Color(8, 28, 21));
        firstOngkir.setForeground(new java.awt.Color(255, 255, 255));
        firstOngkir.setText("<<");
        firstOngkir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstOngkirActionPerformed(evt);
            }
        });

        nextOngkir.setBackground(new java.awt.Color(8, 28, 21));
        nextOngkir.setForeground(new java.awt.Color(255, 255, 255));
        nextOngkir.setText(">");
        nextOngkir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextOngkirActionPerformed(evt);
            }
        });

        cariOngkir.setBackground(new java.awt.Color(8, 28, 21));
        cariOngkir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cariOngkir.setForeground(new java.awt.Color(255, 255, 255));
        cariOngkir.setText("Cari");
        cariOngkir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariOngkirActionPerformed(evt);
            }
        });

        reloadtblOngkir.setBackground(new java.awt.Color(8, 28, 21));
        reloadtblOngkir.setForeground(new java.awt.Color(255, 255, 255));
        reloadtblOngkir.setText("↺");
        reloadtblOngkir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadtblOngkirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOngkirLayout = new javax.swing.GroupLayout(pnlOngkir);
        pnlOngkir.setLayout(pnlOngkirLayout);
        pnlOngkirLayout.setHorizontalGroup(
            pnlOngkirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOngkirLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(pnlOngkirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOngkirLayout.createSequentialGroup()
                        .addGroup(pnlOngkirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlOngkirLayout.createSequentialGroup()
                                .addComponent(firstOngkir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prevOngkir)
                                .addGap(3, 3, 3)
                                .addComponent(nextOngkir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lastOngkir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(newOngkir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editOngkir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteOngkir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(saveOngkir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelOngkir, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlOngkirLayout.createSequentialGroup()
                                .addComponent(jLabel151, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(165, 165, 165)
                                .addComponent(provOngkir, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlOngkirLayout.createSequentialGroup()
                        .addGroup(pnlOngkirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel150, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel155, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(147, 147, 147)
                        .addGroup(pnlOngkirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idOngkir, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                            .addComponent(tarifOngkir))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOngkirLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel149)
                .addGap(296, 296, 296))
            .addGroup(pnlOngkirLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(pnlOngkirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScroll7, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlOngkirLayout.createSequentialGroup()
                        .addComponent(txtCariOngkir, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cariOngkir, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reloadtblOngkir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlOngkirLayout.setVerticalGroup(
            pnlOngkirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOngkirLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel149)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlOngkirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel150)
                    .addComponent(idOngkir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlOngkirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel151)
                    .addComponent(provOngkir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlOngkirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel155)
                    .addComponent(tarifOngkir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(pnlOngkirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelOngkir)
                    .addComponent(saveOngkir)
                    .addComponent(editOngkir)
                    .addComponent(deleteOngkir)
                    .addComponent(newOngkir)
                    .addComponent(lastOngkir)
                    .addComponent(prevOngkir)
                    .addComponent(firstOngkir)
                    .addComponent(nextOngkir))
                .addGap(69, 69, 69)
                .addGroup(pnlOngkirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCariOngkir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariOngkir)
                    .addComponent(reloadtblOngkir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScroll7, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        main.add(pnlOngkir, "card2");

        pnlProduk.setBackground(new java.awt.Color(255, 255, 255));
        pnlProduk.setPreferredSize(new java.awt.Dimension(979, 700));

        jLabel159.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        jLabel159.setForeground(new java.awt.Color(88, 129, 87));
        jLabel159.setText("DATA PRODUK");

        jLabel160.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel160.setText("ID");

        jLabel161.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel161.setText("Nama");

        jLabel162.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel162.setText("Harga");

        jLabel163.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel163.setText("Stok");

        jLabel164.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel164.setText("Warna");

        jLabel165.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel165.setText("Kategori");

        tblProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "Kategori", "Harga", "Stok", "Warna", "Terjual"
            }
        ));
        tblProduk.setGridColor(new java.awt.Color(255, 255, 204));
        tblProduk.setSelectionBackground(new java.awt.Color(45, 106, 79));
        tblProduk.setShowGrid(false);
        tblProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdukMouseClicked(evt);
            }
        });
        jScroll8.setViewportView(tblProduk);

        idProduk.setEditable(false);

        txtCariProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariProdukActionPerformed(evt);
            }
        });

        cancelProduk.setBackground(new java.awt.Color(8, 28, 21));
        cancelProduk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelProduk.setForeground(new java.awt.Color(255, 255, 255));
        cancelProduk.setLabel("Cancel");
        cancelProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelProdukActionPerformed(evt);
            }
        });

        saveProduk.setBackground(new java.awt.Color(8, 28, 21));
        saveProduk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        saveProduk.setForeground(new java.awt.Color(255, 255, 255));
        saveProduk.setText("Save");
        saveProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveProdukActionPerformed(evt);
            }
        });

        editProduk.setBackground(new java.awt.Color(8, 28, 21));
        editProduk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editProduk.setForeground(new java.awt.Color(255, 255, 255));
        editProduk.setText("Edit");
        editProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProdukActionPerformed(evt);
            }
        });

        deleteProduk.setBackground(new java.awt.Color(8, 28, 21));
        deleteProduk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deleteProduk.setForeground(new java.awt.Color(255, 255, 255));
        deleteProduk.setText("Delete");
        deleteProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProdukActionPerformed(evt);
            }
        });

        newProduk.setBackground(new java.awt.Color(8, 28, 21));
        newProduk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        newProduk.setForeground(new java.awt.Color(255, 255, 255));
        newProduk.setText("New");
        newProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProdukActionPerformed(evt);
            }
        });

        lastProduk.setBackground(new java.awt.Color(8, 28, 21));
        lastProduk.setForeground(new java.awt.Color(255, 255, 255));
        lastProduk.setText(">>");
        lastProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastProdukActionPerformed(evt);
            }
        });

        prevProduk.setBackground(new java.awt.Color(8, 28, 21));
        prevProduk.setForeground(new java.awt.Color(255, 255, 255));
        prevProduk.setText("<");
        prevProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevProdukActionPerformed(evt);
            }
        });

        firstProduk.setBackground(new java.awt.Color(8, 28, 21));
        firstProduk.setForeground(new java.awt.Color(255, 255, 255));
        firstProduk.setText("<<");
        firstProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstProdukActionPerformed(evt);
            }
        });

        nextProduk.setBackground(new java.awt.Color(8, 28, 21));
        nextProduk.setForeground(new java.awt.Color(255, 255, 255));
        nextProduk.setText(">");
        nextProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextProdukActionPerformed(evt);
            }
        });

        cariProduk.setBackground(new java.awt.Color(8, 28, 21));
        cariProduk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cariProduk.setForeground(new java.awt.Color(255, 255, 255));
        cariProduk.setText("Cari");
        cariProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariProdukActionPerformed(evt);
            }
        });

        reloadtblProduk.setBackground(new java.awt.Color(8, 28, 21));
        reloadtblProduk.setForeground(new java.awt.Color(255, 255, 255));
        reloadtblProduk.setText("↺");
        reloadtblProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadtblProdukActionPerformed(evt);
            }
        });

        kategoriProduk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Smartphone", "Tablet", "Jam Tangan", "Laptop" }));

        stokProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stokProdukActionPerformed(evt);
            }
        });

        jLabel169.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel169.setText("Terjual");

        javax.swing.GroupLayout pnlProdukLayout = new javax.swing.GroupLayout(pnlProduk);
        pnlProduk.setLayout(pnlProdukLayout);
        pnlProdukLayout.setHorizontalGroup(
            pnlProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProdukLayout.createSequentialGroup()
                .addGroup(pnlProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProdukLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(pnlProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlProdukLayout.createSequentialGroup()
                                .addComponent(jLabel161, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(165, 165, 165)
                                .addComponent(namaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlProdukLayout.createSequentialGroup()
                                .addGroup(pnlProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel160, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel165, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel162, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel163, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel164, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel169, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(147, 147, 147)
                                .addGroup(pnlProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(idProduk, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                                    .addComponent(hargaProduk)
                                    .addComponent(warnaProduk)
                                    .addComponent(kategoriProduk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(stokProduk)
                                    .addComponent(terjualProduk)))
                            .addGroup(pnlProdukLayout.createSequentialGroup()
                                .addComponent(firstProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prevProduk)
                                .addGap(3, 3, 3)
                                .addComponent(nextProduk)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lastProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(newProduk)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(saveProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlProdukLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(pnlProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScroll8, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlProdukLayout.createSequentialGroup()
                                .addComponent(txtCariProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cariProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reloadtblProduk)))))
                .addContainerGap(120, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProdukLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel159)
                .addGap(351, 351, 351))
        );
        pnlProdukLayout.setVerticalGroup(
            pnlProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProdukLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel159)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel160)
                    .addComponent(idProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel161)
                    .addComponent(namaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel165)
                    .addComponent(kategoriProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel162)
                    .addComponent(hargaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel163)
                    .addComponent(stokProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel164)
                    .addComponent(warnaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel169)
                    .addComponent(terjualProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelProduk)
                    .addComponent(saveProduk)
                    .addComponent(editProduk)
                    .addComponent(deleteProduk)
                    .addComponent(newProduk)
                    .addComponent(lastProduk)
                    .addComponent(prevProduk)
                    .addComponent(firstProduk)
                    .addComponent(nextProduk))
                .addGap(25, 25, 25)
                .addGroup(pnlProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCariProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariProduk)
                    .addComponent(reloadtblProduk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScroll8, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        main.add(pnlProduk, "card2");

        pnlMetode.setBackground(new java.awt.Color(255, 255, 255));
        pnlMetode.setPreferredSize(new java.awt.Dimension(979, 700));

        jLabel166.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        jLabel166.setForeground(new java.awt.Color(88, 129, 87));
        jLabel166.setText("DATA METODE PEMBAYARAN");

        jLabel167.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel167.setText("ID");

        jLabel168.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel168.setText("Nama Bank");

        jLabel172.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel172.setText("Kode Pembayaran");

        tblMetode.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nama Bank", "Kode Pembayaran"
            }
        ));
        tblMetode.setGridColor(new java.awt.Color(255, 255, 204));
        tblMetode.setSelectionBackground(new java.awt.Color(45, 106, 79));
        tblMetode.setShowGrid(false);
        tblMetode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMetodeMouseClicked(evt);
            }
        });
        jScroll9.setViewportView(tblMetode);
        if (tblMetode.getColumnModel().getColumnCount() > 0) {
            tblMetode.getColumnModel().getColumn(2).setHeaderValue("Kode Pembayaran");
        }

        idMetode.setEditable(false);

        kodePembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodePembayaranActionPerformed(evt);
            }
        });

        txtCariMetode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariMetodeActionPerformed(evt);
            }
        });

        cancelMetode.setBackground(new java.awt.Color(8, 28, 21));
        cancelMetode.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelMetode.setForeground(new java.awt.Color(255, 255, 255));
        cancelMetode.setLabel("Cancel");
        cancelMetode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelMetodeActionPerformed(evt);
            }
        });

        saveMetode.setBackground(new java.awt.Color(8, 28, 21));
        saveMetode.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        saveMetode.setForeground(new java.awt.Color(255, 255, 255));
        saveMetode.setText("Save");
        saveMetode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMetodeActionPerformed(evt);
            }
        });

        editMetode.setBackground(new java.awt.Color(8, 28, 21));
        editMetode.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editMetode.setForeground(new java.awt.Color(255, 255, 255));
        editMetode.setText("Edit");
        editMetode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMetodeActionPerformed(evt);
            }
        });

        deleteMetode.setBackground(new java.awt.Color(8, 28, 21));
        deleteMetode.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deleteMetode.setForeground(new java.awt.Color(255, 255, 255));
        deleteMetode.setText("Delete");
        deleteMetode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMetodeActionPerformed(evt);
            }
        });

        newMetode.setBackground(new java.awt.Color(8, 28, 21));
        newMetode.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        newMetode.setForeground(new java.awt.Color(255, 255, 255));
        newMetode.setText("New");
        newMetode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMetodeActionPerformed(evt);
            }
        });

        lastMetode.setBackground(new java.awt.Color(8, 28, 21));
        lastMetode.setForeground(new java.awt.Color(255, 255, 255));
        lastMetode.setText(">>");
        lastMetode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastMetodeActionPerformed(evt);
            }
        });

        prevMetode.setBackground(new java.awt.Color(8, 28, 21));
        prevMetode.setForeground(new java.awt.Color(255, 255, 255));
        prevMetode.setText("<");
        prevMetode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevMetodeActionPerformed(evt);
            }
        });

        firstMetode.setBackground(new java.awt.Color(8, 28, 21));
        firstMetode.setForeground(new java.awt.Color(255, 255, 255));
        firstMetode.setText("<<");
        firstMetode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstMetodeActionPerformed(evt);
            }
        });

        nextMetode.setBackground(new java.awt.Color(8, 28, 21));
        nextMetode.setForeground(new java.awt.Color(255, 255, 255));
        nextMetode.setText(">");
        nextMetode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextMetodeActionPerformed(evt);
            }
        });

        cariMetode.setBackground(new java.awt.Color(8, 28, 21));
        cariMetode.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cariMetode.setForeground(new java.awt.Color(255, 255, 255));
        cariMetode.setText("Cari");
        cariMetode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariMetodeActionPerformed(evt);
            }
        });

        reloadtblMetode.setBackground(new java.awt.Color(8, 28, 21));
        reloadtblMetode.setForeground(new java.awt.Color(255, 255, 255));
        reloadtblMetode.setText("↺");
        reloadtblMetode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadtblMetodeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMetodeLayout = new javax.swing.GroupLayout(pnlMetode);
        pnlMetode.setLayout(pnlMetodeLayout);
        pnlMetodeLayout.setHorizontalGroup(
            pnlMetodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMetodeLayout.createSequentialGroup()
                .addGroup(pnlMetodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMetodeLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(pnlMetodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMetodeLayout.createSequentialGroup()
                                .addGroup(pnlMetodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel167, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel172))
                                .addGroup(pnlMetodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlMetodeLayout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addComponent(idMetode, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMetodeLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(kodePembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnlMetodeLayout.createSequentialGroup()
                                .addComponent(jLabel168, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(141, 141, 141)
                                .addComponent(namaMetode, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlMetodeLayout.createSequentialGroup()
                                .addComponent(firstMetode, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prevMetode)
                                .addGap(3, 3, 3)
                                .addComponent(nextMetode)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lastMetode, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(newMetode)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editMetode, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteMetode, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(saveMetode, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelMetode, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlMetodeLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(pnlMetodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScroll9, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlMetodeLayout.createSequentialGroup()
                                .addComponent(txtCariMetode, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cariMetode, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reloadtblMetode))))
                    .addGroup(pnlMetodeLayout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jLabel166)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMetodeLayout.setVerticalGroup(
            pnlMetodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMetodeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel166)
                .addGap(40, 40, 40)
                .addGroup(pnlMetodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel167)
                    .addComponent(idMetode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMetodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel168)
                    .addComponent(namaMetode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlMetodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMetodeLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(kodePembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMetodeLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel172)))
                .addGap(29, 29, 29)
                .addGroup(pnlMetodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelMetode)
                    .addComponent(saveMetode)
                    .addComponent(editMetode)
                    .addComponent(deleteMetode)
                    .addComponent(newMetode)
                    .addComponent(lastMetode)
                    .addComponent(prevMetode)
                    .addComponent(firstMetode)
                    .addComponent(nextMetode))
                .addGap(87, 87, 87)
                .addGroup(pnlMetodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCariMetode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariMetode)
                    .addComponent(reloadtblMetode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScroll9, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        main.add(pnlMetode, "card2");

        pnlKepemilikan.setBackground(new java.awt.Color(255, 255, 255));
        pnlKepemilikan.setPreferredSize(new java.awt.Dimension(979, 700));

        jLabel170.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        jLabel170.setForeground(new java.awt.Color(88, 129, 87));
        jLabel170.setText("DATA KEPEMILIKAN KERANJANG");

        jLabel171.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel171.setText("ID Keranjang");

        jLabel173.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel173.setText("ID Pelanggan");

        tblKepemilikan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Keranjang", "ID Pelanggan"
            }
        ));
        tblKepemilikan.setGridColor(new java.awt.Color(255, 255, 204));
        tblKepemilikan.setSelectionBackground(new java.awt.Color(45, 106, 79));
        tblKepemilikan.setShowGrid(false);
        tblKepemilikan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKepemilikanMouseClicked(evt);
            }
        });
        jScroll10.setViewportView(tblKepemilikan);

        keranjangKepemilikan.setEditable(false);

        txtCariKepemilikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariKepemilikanActionPerformed(evt);
            }
        });

        cancelKepemilikan.setBackground(new java.awt.Color(8, 28, 21));
        cancelKepemilikan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelKepemilikan.setForeground(new java.awt.Color(255, 255, 255));
        cancelKepemilikan.setLabel("Cancel");
        cancelKepemilikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelKepemilikanActionPerformed(evt);
            }
        });

        saveKepemilikan.setBackground(new java.awt.Color(8, 28, 21));
        saveKepemilikan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        saveKepemilikan.setForeground(new java.awt.Color(255, 255, 255));
        saveKepemilikan.setText("Save");
        saveKepemilikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveKepemilikanActionPerformed(evt);
            }
        });

        editKepemilikan.setBackground(new java.awt.Color(8, 28, 21));
        editKepemilikan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editKepemilikan.setForeground(new java.awt.Color(255, 255, 255));
        editKepemilikan.setText("Edit");
        editKepemilikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editKepemilikanActionPerformed(evt);
            }
        });

        deleteKepemilikan.setBackground(new java.awt.Color(8, 28, 21));
        deleteKepemilikan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deleteKepemilikan.setForeground(new java.awt.Color(255, 255, 255));
        deleteKepemilikan.setText("Delete");
        deleteKepemilikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteKepemilikanActionPerformed(evt);
            }
        });

        newKepemilikan.setBackground(new java.awt.Color(8, 28, 21));
        newKepemilikan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        newKepemilikan.setForeground(new java.awt.Color(255, 255, 255));
        newKepemilikan.setText("New");
        newKepemilikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newKepemilikanActionPerformed(evt);
            }
        });

        lastKepemilikan.setBackground(new java.awt.Color(8, 28, 21));
        lastKepemilikan.setForeground(new java.awt.Color(255, 255, 255));
        lastKepemilikan.setText(">>");
        lastKepemilikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastKepemilikanActionPerformed(evt);
            }
        });

        prevKepemilikan.setBackground(new java.awt.Color(8, 28, 21));
        prevKepemilikan.setForeground(new java.awt.Color(255, 255, 255));
        prevKepemilikan.setText("<");
        prevKepemilikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevKepemilikanActionPerformed(evt);
            }
        });

        firstKepemilikan.setBackground(new java.awt.Color(8, 28, 21));
        firstKepemilikan.setForeground(new java.awt.Color(255, 255, 255));
        firstKepemilikan.setText("<<");
        firstKepemilikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstKepemilikanActionPerformed(evt);
            }
        });

        nextKepemilikan.setBackground(new java.awt.Color(8, 28, 21));
        nextKepemilikan.setForeground(new java.awt.Color(255, 255, 255));
        nextKepemilikan.setText(">");
        nextKepemilikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextKepemilikanActionPerformed(evt);
            }
        });

        cariKepemilikan.setBackground(new java.awt.Color(8, 28, 21));
        cariKepemilikan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cariKepemilikan.setForeground(new java.awt.Color(255, 255, 255));
        cariKepemilikan.setText("Cari");
        cariKepemilikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariKepemilikanActionPerformed(evt);
            }
        });

        reloadtblKepemilikan.setBackground(new java.awt.Color(8, 28, 21));
        reloadtblKepemilikan.setForeground(new java.awt.Color(255, 255, 255));
        reloadtblKepemilikan.setText("↺");
        reloadtblKepemilikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadtblKepemilikanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlKepemilikanLayout = new javax.swing.GroupLayout(pnlKepemilikan);
        pnlKepemilikan.setLayout(pnlKepemilikanLayout);
        pnlKepemilikanLayout.setHorizontalGroup(
            pnlKepemilikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKepemilikanLayout.createSequentialGroup()
                .addGroup(pnlKepemilikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlKepemilikanLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(pnlKepemilikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlKepemilikanLayout.createSequentialGroup()
                                .addComponent(jLabel171, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(127, 127, 127)
                                .addComponent(keranjangKepemilikan, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlKepemilikanLayout.createSequentialGroup()
                                .addComponent(jLabel173, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)
                                .addComponent(pelangganKepemilikan, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlKepemilikanLayout.createSequentialGroup()
                                .addComponent(firstKepemilikan, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prevKepemilikan)
                                .addGap(3, 3, 3)
                                .addComponent(nextKepemilikan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lastKepemilikan, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(newKepemilikan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editKepemilikan, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteKepemilikan, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(saveKepemilikan, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelKepemilikan, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlKepemilikanLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(pnlKepemilikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScroll10, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlKepemilikanLayout.createSequentialGroup()
                                .addComponent(txtCariKepemilikan, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cariKepemilikan, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reloadtblKepemilikan))))
                    .addGroup(pnlKepemilikanLayout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jLabel170)))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        pnlKepemilikanLayout.setVerticalGroup(
            pnlKepemilikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKepemilikanLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel170)
                .addGap(40, 40, 40)
                .addGroup(pnlKepemilikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel171)
                    .addComponent(keranjangKepemilikan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlKepemilikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel173)
                    .addComponent(pelangganKepemilikan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(pnlKepemilikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelKepemilikan)
                    .addComponent(saveKepemilikan)
                    .addComponent(editKepemilikan)
                    .addComponent(deleteKepemilikan)
                    .addComponent(newKepemilikan)
                    .addComponent(lastKepemilikan)
                    .addComponent(prevKepemilikan)
                    .addComponent(firstKepemilikan)
                    .addComponent(nextKepemilikan))
                .addGap(87, 87, 87)
                .addGroup(pnlKepemilikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCariKepemilikan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariKepemilikan)
                    .addComponent(reloadtblKepemilikan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScroll10, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(163, Short.MAX_VALUE))
        );

        main.add(pnlKepemilikan, "card2");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(sitePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sitePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1240, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPelangganMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPelangganMouseEntered
        btnPelanggan.setBackground(new Color(82, 183, 136));
    }//GEN-LAST:event_btnPelangganMouseEntered

    private void btnPelangganMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPelangganMouseExited
        btnPelanggan.setBackground(new Color(45,106,79));
    }//GEN-LAST:event_btnPelangganMouseExited

    private void btnPelangganMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPelangganMousePressed
        btnPegawai.setBackground(new Color(45,106,79));
        btnPelanggan.setBackground(new Color(45,106,79));
        btnProduk.setBackground(new Color(45,106,79));
        btnPesanan.setBackground(new Color(45,106,79));
        btnPengiriman.setBackground(new Color(45,106,79));
        btnKeranjang.setBackground(new Color(45,106,79));
        btnPromo.setBackground(new Color(45,106,79));
        btnOngkir.setBackground(new Color(45,106,79));
        btnMetode.setBackground(new Color(45,106,79));
        btnKepemilikan.setBackground(new Color(45,106,79));
    }//GEN-LAST:event_btnPelangganMousePressed

    private void btnPelangganMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPelangganMouseReleased
        btnPelanggan.setBackground(new Color(82, 183, 136));
    }//GEN-LAST:event_btnPelangganMouseReleased

    private void btnPegawaiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPegawaiMouseEntered
        btnPegawai.setBackground(new Color(82, 183, 136));
    }//GEN-LAST:event_btnPegawaiMouseEntered

    private void btnPegawaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPegawaiMouseExited
        btnPegawai.setBackground(new Color(45,106,79));
    }//GEN-LAST:event_btnPegawaiMouseExited

    private void btnPegawaiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPegawaiMousePressed
        
        btnPegawai.setBackground(new Color(45,106,79));
        btnPelanggan.setBackground(new Color(45,106,79));
        btnProduk.setBackground(new Color(45,106,79));
        btnPesanan.setBackground(new Color(45,106,79));
        btnPengiriman.setBackground(new Color(45,106,79));
        btnKeranjang.setBackground(new Color(45,106,79));
        btnPromo.setBackground(new Color(45,106,79));
        btnOngkir.setBackground(new Color(45,106,79));
        btnMetode.setBackground(new Color(45,106,79));
        btnKepemilikan.setBackground(new Color(45,106,79));
    }//GEN-LAST:event_btnPegawaiMousePressed

    private void btnPegawaiMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPegawaiMouseReleased
        btnPegawai.setBackground(new Color(82, 183, 136));
    }//GEN-LAST:event_btnPegawaiMouseReleased

    private void btnProdukMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProdukMouseEntered
        btnProduk.setBackground(new Color(82, 183, 136));
    }//GEN-LAST:event_btnProdukMouseEntered

    private void btnProdukMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProdukMouseExited
        btnProduk.setBackground(new Color(45,106,79));
    }//GEN-LAST:event_btnProdukMouseExited

    private void btnProdukMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProdukMousePressed
        btnPegawai.setBackground(new Color(45,106,79));
        btnPelanggan.setBackground(new Color(45,106,79));
        btnProduk.setBackground(new Color(45,106,79));
        btnPesanan.setBackground(new Color(45,106,79));
        btnPengiriman.setBackground(new Color(45,106,79));
        btnKeranjang.setBackground(new Color(45,106,79));
        btnPromo.setBackground(new Color(45,106,79));
        btnOngkir.setBackground(new Color(45,106,79));
        btnMetode.setBackground(new Color(45,106,79));
        btnKepemilikan.setBackground(new Color(45,106,79));
    }//GEN-LAST:event_btnProdukMousePressed

    private void btnProdukMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProdukMouseReleased
        btnProduk.setBackground(new Color(82, 183, 136));
    }//GEN-LAST:event_btnProdukMouseReleased

    private void btnPesananMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesananMouseEntered
        btnPesanan.setBackground(new Color(82, 183, 136));
    }//GEN-LAST:event_btnPesananMouseEntered

    private void btnPesananMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesananMouseExited
        btnPesanan.setBackground(new Color(45,106,79));
    }//GEN-LAST:event_btnPesananMouseExited

    private void btnPesananMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesananMousePressed
        btnPegawai.setBackground(new Color(45,106,79));
        btnPelanggan.setBackground(new Color(45,106,79));
        btnProduk.setBackground(new Color(45,106,79));
        btnPesanan.setBackground(new Color(45,106,79));
        btnPengiriman.setBackground(new Color(45,106,79));
        btnKeranjang.setBackground(new Color(45,106,79));
        btnPromo.setBackground(new Color(45,106,79));
        btnOngkir.setBackground(new Color(45,106,79));
        btnMetode.setBackground(new Color(45,106,79));
        btnKepemilikan.setBackground(new Color(45,106,79));
    }//GEN-LAST:event_btnPesananMousePressed

    private void btnPesananMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesananMouseReleased
        btnPesanan.setBackground(new Color(82, 183, 136));
    }//GEN-LAST:event_btnPesananMouseReleased

    private void btnPengirimanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPengirimanMouseEntered
        btnPengiriman.setBackground(new Color(82, 183, 136));
    }//GEN-LAST:event_btnPengirimanMouseEntered

    private void btnPengirimanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPengirimanMouseExited
        btnPengiriman.setBackground(new Color(45,106,79));
    }//GEN-LAST:event_btnPengirimanMouseExited

    private void btnPengirimanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPengirimanMousePressed
        btnPegawai.setBackground(new Color(45,106,79));
        btnPelanggan.setBackground(new Color(45,106,79));
        btnProduk.setBackground(new Color(45,106,79));
        btnPesanan.setBackground(new Color(45,106,79));
        btnPengiriman.setBackground(new Color(45,106,79));
        btnKeranjang.setBackground(new Color(45,106,79));
        btnPromo.setBackground(new Color(45,106,79));
        btnOngkir.setBackground(new Color(45,106,79));
        btnMetode.setBackground(new Color(45,106,79));
        btnKepemilikan.setBackground(new Color(45,106,79));
    }//GEN-LAST:event_btnPengirimanMousePressed

    private void btnPengirimanMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPengirimanMouseReleased
        btnPengiriman.setBackground(new Color(82, 183, 136));
    }//GEN-LAST:event_btnPengirimanMouseReleased

    private void btnKeranjangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKeranjangMouseEntered
        btnKeranjang.setBackground(new Color(82, 183, 136));
    }//GEN-LAST:event_btnKeranjangMouseEntered

    private void btnKeranjangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKeranjangMouseExited
        btnKeranjang.setBackground(new Color(45,106,79));
    }//GEN-LAST:event_btnKeranjangMouseExited

    private void btnKeranjangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKeranjangMousePressed
        btnPegawai.setBackground(new Color(45,106,79));
        btnPelanggan.setBackground(new Color(45,106,79));
        btnProduk.setBackground(new Color(45,106,79));
        btnPesanan.setBackground(new Color(45,106,79));
        btnPengiriman.setBackground(new Color(45,106,79));
        btnKeranjang.setBackground(new Color(45,106,79));
        btnPromo.setBackground(new Color(45,106,79));
        btnOngkir.setBackground(new Color(45,106,79));
        btnMetode.setBackground(new Color(45,106,79));
        btnKepemilikan.setBackground(new Color(45,106,79));
    }//GEN-LAST:event_btnKeranjangMousePressed

    private void btnKeranjangMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKeranjangMouseReleased
        btnKeranjang.setBackground(new Color(82, 183, 136));
    }//GEN-LAST:event_btnKeranjangMouseReleased

    private void btnPromoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPromoMouseEntered
        btnPromo.setBackground(new Color(82, 183, 136));
    }//GEN-LAST:event_btnPromoMouseEntered

    private void btnPromoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPromoMouseExited
        btnPromo.setBackground(new Color(45,106,79));
    }//GEN-LAST:event_btnPromoMouseExited

    private void btnPromoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPromoMousePressed
        btnPegawai.setBackground(new Color(45,106,79));
        btnPelanggan.setBackground(new Color(45,106,79));
        btnProduk.setBackground(new Color(45,106,79));
        btnPesanan.setBackground(new Color(45,106,79));
        btnPengiriman.setBackground(new Color(45,106,79));
        btnKeranjang.setBackground(new Color(45,106,79));
        btnPromo.setBackground(new Color(45,106,79));
        btnOngkir.setBackground(new Color(45,106,79));
        btnMetode.setBackground(new Color(45,106,79));
        btnKepemilikan.setBackground(new Color(45,106,79));
    }//GEN-LAST:event_btnPromoMousePressed

    private void btnPromoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPromoMouseReleased
        btnPromo.setBackground(new Color(82, 183, 136));
    }//GEN-LAST:event_btnPromoMouseReleased

    private void btnOngkirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOngkirMouseEntered
        btnOngkir.setBackground(new Color(82, 183, 136));
    }//GEN-LAST:event_btnOngkirMouseEntered

    private void btnOngkirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOngkirMouseExited
        btnOngkir.setBackground(new Color(45,106,79));
    }//GEN-LAST:event_btnOngkirMouseExited

    private void btnOngkirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOngkirMousePressed
        btnPegawai.setBackground(new Color(45,106,79));
        btnPelanggan.setBackground(new Color(45,106,79));
        btnProduk.setBackground(new Color(45,106,79));
        btnPesanan.setBackground(new Color(45,106,79));
        btnPengiriman.setBackground(new Color(45,106,79));
        btnKeranjang.setBackground(new Color(45,106,79));
        btnPromo.setBackground(new Color(45,106,79));
        btnOngkir.setBackground(new Color(45,106,79));
        btnMetode.setBackground(new Color(45,106,79));
        btnKepemilikan.setBackground(new Color(45,106,79));
    }//GEN-LAST:event_btnOngkirMousePressed

    private void btnOngkirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOngkirMouseReleased
        btnOngkir.setBackground(new Color(82, 183, 136));
    }//GEN-LAST:event_btnOngkirMouseReleased

    private void btnMetodeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMetodeMouseEntered
        btnMetode.setBackground(new Color(82, 183, 136));
    }//GEN-LAST:event_btnMetodeMouseEntered

    private void btnMetodeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMetodeMouseExited
        btnMetode.setBackground(new Color(45,106,79));
    }//GEN-LAST:event_btnMetodeMouseExited

    private void btnMetodeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMetodeMousePressed
        btnPegawai.setBackground(new Color(45,106,79));
        btnPelanggan.setBackground(new Color(45,106,79));
        btnProduk.setBackground(new Color(45,106,79));
        btnPesanan.setBackground(new Color(45,106,79));
        btnPengiriman.setBackground(new Color(45,106,79));
        btnKeranjang.setBackground(new Color(45,106,79));
        btnPromo.setBackground(new Color(45,106,79));
        btnOngkir.setBackground(new Color(45,106,79));
        btnMetode.setBackground(new Color(45,106,79));
        btnKepemilikan.setBackground(new Color(45,106,79));
    }//GEN-LAST:event_btnMetodeMousePressed

    private void btnMetodeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMetodeMouseReleased
        btnMetode.setBackground(new Color(82, 183, 136));
    }//GEN-LAST:event_btnMetodeMouseReleased

    private void btnPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPelangganMouseClicked
        main.removeAll();
        main.repaint();
        main.revalidate();
        main.add(pnlPelanggan);
        main.repaint();
        main.revalidate();
        populateAllPelangganFields();
    }//GEN-LAST:event_btnPelangganMouseClicked

    private void btnPegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPegawaiMouseClicked
        main.removeAll();
        main.repaint();
        main.revalidate();
        main.add(pnlPegawai);
        main.repaint();
        main.revalidate();
        populateAllPegawaiFields();
    }//GEN-LAST:event_btnPegawaiMouseClicked

    private void newPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPelangganActionPerformed
        idPelanggan.setEditable(true);
        idPelanggan.setText("");
        emailPelanggan.setText("");
        sandiPelanggan.setText("");
        namaPelanggan.setText("");
        jalanPelanggan.setText("");
        kotaPelanggan.setText("");
        provPelanggan.setText("");
        telpPelanggan.setText("");
        kelaminPelanggan.setSelectedItem(0);
        idPelanggan.requestFocus();
    
    }//GEN-LAST:event_newPelangganActionPerformed

    private void deletePelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePelangganActionPerformed
        try{
            int answer = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete \"" + resultSet.getString("nama_pelanggan")+"\"?", "Delete confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            if (answer== JOptionPane.YES_OPTION){

                preparedStatement = connection.prepareStatement("DELETE from Pelanggan WHERE id_pelanggan=?");
                preparedStatement.setInt(1, resultSet.getInt("id_pelanggan"));
                int affectedRows = preparedStatement.executeUpdate();
                System.out.println(affectedRows + " " + "deleted row(s)");
                populateAllPelangganFields();
                //
            }

            else if (answer== JOptionPane.NO_OPTION){
                System.out.println("Cancel");}
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_deletePelangganActionPerformed

    private void editPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPelangganActionPerformed
        try{
            preparedStatement = connection.prepareStatement("update Pelanggan set email_pelanggan=?, kata_sandi=?, nama_pelanggan=?, jalan_pelanggan=?, kota_pelanggan=?, provinsi_pelanggan=?, no_telepon_pelanggan=?, jenis_kelamin_pelanggan=? where id_pelanggan=?");
            preparedStatement.setString(1, emailPelanggan.getText());
            preparedStatement.setString(2, sandiPelanggan.getText());
            preparedStatement.setString(3, namaPelanggan.getText());
            preparedStatement.setString(4, jalanPelanggan.getText());
            preparedStatement.setString(5, kotaPelanggan.getText());
            preparedStatement.setString(6, provPelanggan.getText());
            preparedStatement.setString(7, telpPelanggan.getText());
            preparedStatement.setString(8, (String)kelaminPelanggan.getSelectedItem());
            preparedStatement.setInt(9, Integer.parseInt(idPelanggan.getText()));
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows + " "+ "affected row(s)");
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
        }
        populateAllPelangganFields();
        
    }//GEN-LAST:event_editPelangganActionPerformed

    private void savePelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePelangganActionPerformed
        try{
            preparedStatement = connection.prepareStatement("insert into Pelanggan VALUES(?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, Integer.parseInt(idPelanggan.getText()));
            preparedStatement.setString(2, emailPelanggan.getText());
            preparedStatement.setString(3, sandiPelanggan.getText());
            preparedStatement.setString(4, namaPelanggan.getText());
            preparedStatement.setString(5, jalanPelanggan.getText());
            preparedStatement.setString(6, kotaPelanggan.getText());
            preparedStatement.setString(7, provPelanggan.getText());
            preparedStatement.setString(8, telpPelanggan.getText());
            preparedStatement.setString(9, (String)kelaminPelanggan.getSelectedItem());
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows + " "+ "affected row(s)");
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
        }
        populateAllPelangganFields();   
    }//GEN-LAST:event_savePelangganActionPerformed

    private void txtCariPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariPelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariPelangganActionPerformed

    private void prevPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevPelangganActionPerformed
        try{

            if(resultSet != null && !resultSet.isFirst()){
                resultSet.previous();
                idPelanggan.setText(resultSet.getString(1));
                emailPelanggan.setText(resultSet.getString(2));
                sandiPelanggan.setText(resultSet.getString(3));
                namaPelanggan.setText(resultSet.getString(4));
                jalanPelanggan.setText(resultSet.getString(5));
                kotaPelanggan.setText(resultSet.getString(6));
                provPelanggan.setText(resultSet.getString(7));
                telpPelanggan.setText(resultSet.getString(8));
                kelaminPelanggan.getModel().setSelectedItem(resultSet.getString(9));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_prevPelangganActionPerformed

    private void nextPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextPelangganActionPerformed
        try{

            if(resultSet != null && !resultSet.isLast()){
                resultSet.next();
                idPelanggan.setText(resultSet.getString(1));
                emailPelanggan.setText(resultSet.getString(2));
                sandiPelanggan.setText(resultSet.getString(3));
                namaPelanggan.setText(resultSet.getString(4));
                jalanPelanggan.setText(resultSet.getString(5));
                kotaPelanggan.setText(resultSet.getString(6));
                provPelanggan.setText(resultSet.getString(7));
                telpPelanggan.setText(resultSet.getString(8));
                kelaminPelanggan.getModel().setSelectedItem(resultSet.getString(9));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("hlo");
        }
    }//GEN-LAST:event_nextPelangganActionPerformed

    private void lastPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastPelangganActionPerformed
        try{
            resultSet=statement.executeQuery("select * from Pelanggan");

            resultSet.last();
            idPelanggan.setText(resultSet.getString(1));
            emailPelanggan.setText(resultSet.getString(2));
            sandiPelanggan.setText(resultSet.getString(3));
            namaPelanggan.setText(resultSet.getString(4));
            jalanPelanggan.setText(resultSet.getString(5));
            kotaPelanggan.setText(resultSet.getString(6));
            provPelanggan.setText(resultSet.getString(7));
            telpPelanggan.setText(resultSet.getString(8));
            kelaminPelanggan.setSelectedItem(resultSet.getString(9));

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lastPelangganActionPerformed

    private void firstPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstPelangganActionPerformed
        try{
            resultSet=statement.executeQuery("select * from Pelanggan");
            resultSet.first();
            idPelanggan.setText(resultSet.getString(1));
            emailPelanggan.setText(resultSet.getString(2));
            sandiPelanggan.setText(resultSet.getString(3));
            namaPelanggan.setText(resultSet.getString(4));
            jalanPelanggan.setText(resultSet.getString(5));
            kotaPelanggan.setText(resultSet.getString(6));
            provPelanggan.setText(resultSet.getString(7));
            telpPelanggan.setText(resultSet.getString(8));
            kelaminPelanggan.setSelectedItem(resultSet.getString(9));

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_firstPelangganActionPerformed

    private void tblPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPelangganMouseClicked
        int i = tblPelanggan.getSelectedRow();
            if (i == -1){
                return;
            }
            String id = (String) tblPelanggan.getValueAt(i, 0);
            idPelanggan.setText(id);
            String email = (String) tblPelanggan.getValueAt(i, 1);
            emailPelanggan.setText(email);
            String sandi = (String) tblPelanggan.getValueAt(i, 2);
            sandiPelanggan.setText(sandi);
            String nama = (String) tblPelanggan.getValueAt(i, 3);
            namaPelanggan.setText(nama);
            String jalan = (String) tblPelanggan.getValueAt(i, 4);
            jalanPelanggan.setText(jalan);
            String kota = (String) tblPelanggan.getValueAt(i, 5);
            kotaPelanggan.setText(kota);
            String prov = (String) tblPelanggan.getValueAt(i, 6);
            provPelanggan.setText(prov);
            String telp = (String) tblPelanggan.getValueAt(i, 7);
            telpPelanggan.setText(telp);
            String kelamin = (String) tblPelanggan.getValueAt(i, 8);
            kelaminPelanggan.setSelectedItem(kelamin);
         
    }//GEN-LAST:event_tblPelangganMouseClicked

    private void cancelPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelPelangganActionPerformed
        populateAllPelangganFields();
    }//GEN-LAST:event_cancelPelangganActionPerformed

    private void cariPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariPelangganActionPerformed
        DefaultTableModel ob=(DefaultTableModel) tblPelanggan.getModel();
        TableRowSorter<DefaultTableModel> obj=new TableRowSorter<>(ob);
        tblPelanggan.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txtCariPelanggan.getText()));
    }//GEN-LAST:event_cariPelangganActionPerformed

    private void reloadtblPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadtblPelangganActionPerformed
        txtCariPelanggan.setText("");
        tblPelanggan.setRowSorter(null);
    }//GEN-LAST:event_reloadtblPelangganActionPerformed

    private void tblPegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPegawaiMouseClicked
        int i = tblPegawai.getSelectedRow();
            if (i == -1){
                return;
            }
            String id = (String) tblPegawai.getValueAt(i, 0);
            idPegawai.setText(id);
            String email = (String) tblPegawai.getValueAt(i, 1);
            emailPegawai.setText(email);
            String sandi = (String) tblPegawai.getValueAt(i, 2);
            sandiPegawai.setText(sandi);
            String nama = (String) tblPegawai.getValueAt(i, 3);
            namaPegawai.setText(nama);
            String jalan = (String) tblPegawai.getValueAt(i, 4);
            jalanPegawai.setText(jalan);
            String kota = (String) tblPegawai.getValueAt(i, 5);
            kotaPegawai.setText(kota);
            String prov = (String) tblPegawai.getValueAt(i, 6);
            provPegawai.setText(prov);
            String telp = (String) tblPegawai.getValueAt(i, 7);
            telpPegawai.setText(telp);
            String posisi = (String) tblPegawai.getValueAt(i, 8);
            posisiPegawai.setSelectedItem(posisi);
            String gaji = (String) tblPegawai.getValueAt(i, 9);
            gajiPegawai.setText(gaji);
            String kelamin = (String) tblPegawai.getValueAt(i, 10);
            kelaminPegawai.setSelectedItem(kelamin);
    }//GEN-LAST:event_tblPegawaiMouseClicked

    private void txtCariPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariPegawaiActionPerformed
        
    }//GEN-LAST:event_txtCariPegawaiActionPerformed

    private void cancelPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelPegawaiActionPerformed
        populateAllPegawaiFields();
    }//GEN-LAST:event_cancelPegawaiActionPerformed

    private void savePegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePegawaiActionPerformed
        try{
            preparedStatement = connection.prepareStatement("insert into Pegawai VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, Integer.parseInt(idPegawai.getText()));
            preparedStatement.setString(2, emailPegawai.getText());
            preparedStatement.setString(3, sandiPegawai.getText());
            preparedStatement.setString(4, namaPegawai.getText());
            preparedStatement.setString(5, jalanPegawai.getText());
            preparedStatement.setString(6, kotaPegawai.getText());
            preparedStatement.setString(7, provPegawai.getText());
            preparedStatement.setString(8, telpPegawai.getText());
            preparedStatement.setString(9, gajiPegawai.getText());
            preparedStatement.setString(10, (String)posisiPegawai.getSelectedItem());
            preparedStatement.setString(11, (String)kelaminPegawai.getSelectedItem());
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows + " "+ "affected row(s)");
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
        }
        populateAllPegawaiFields();  
    }//GEN-LAST:event_savePegawaiActionPerformed

    private void editPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPegawaiActionPerformed
        try{
            preparedStatement = connection.prepareStatement("update Pegawai set email_pegawai=?, kata_sandi=?, nama_pegawai=?, jalan_pegawai=?, kota_pegawai=?, provinsi_pegawai=?, no_telepon_pegawai=?, gaji_pegawai=?, posisi_pegawai=?, jenis_kelamin_pegawai=? where id_pegawai=?");
            preparedStatement.setString(1, emailPegawai.getText());
            preparedStatement.setString(2, sandiPegawai.getText());
            preparedStatement.setString(3, namaPegawai.getText());
            preparedStatement.setString(4, jalanPegawai.getText());
            preparedStatement.setString(5, kotaPegawai.getText());
            preparedStatement.setString(6, provPegawai.getText());
            preparedStatement.setString(7, telpPegawai.getText());
            preparedStatement.setString(8, gajiPegawai.getText());
            preparedStatement.setString(9, (String)posisiPegawai.getSelectedItem());
            preparedStatement.setString(10, (String)kelaminPegawai.getSelectedItem());
            preparedStatement.setInt(11, Integer.parseInt(idPegawai.getText()));
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows + " "+ "affected row(s)");
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
        }
        populateAllPegawaiFields();
    }//GEN-LAST:event_editPegawaiActionPerformed

    private void deletePegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePegawaiActionPerformed
        try{
            int answer = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete \"" + resultSet.getString("nama_pegawai")+"\"?", "Delete confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            if (answer== JOptionPane.YES_OPTION){

                preparedStatement = connection.prepareStatement("DELETE from Pegawai WHERE id_pegawai=?");
                preparedStatement.setInt(1, resultSet.getInt("id_pegawai"));
                int affectedRows = preparedStatement.executeUpdate();
                System.out.println(affectedRows + " " + "deleted row(s)");
                populateAllPegawaiFields();
                //
            }

            else if (answer== JOptionPane.NO_OPTION){
                System.out.println("Cancel");}
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_deletePegawaiActionPerformed

    private void newPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPegawaiActionPerformed
        idPegawai.setEditable(true);
        idPegawai.setText("");
        emailPegawai.setText("");
        sandiPegawai.setText("");
        namaPegawai.setText("");
        jalanPegawai.setText("");
        kotaPegawai.setText("");
        provPegawai.setText("");
        telpPegawai.setText("");
        kelaminPegawai.setSelectedItem(0);
        posisiPegawai.setSelectedItem(0);
        gajiPegawai.setText("");
        idPegawai.requestFocus();
    }//GEN-LAST:event_newPegawaiActionPerformed

    private void lastPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastPegawaiActionPerformed
        try{
            resultSet=statement.executeQuery("select * from Pegawai");

            resultSet.last();
            idPegawai.setText(resultSet.getString(1));
            emailPegawai.setText(resultSet.getString(2));
            sandiPegawai.setText(resultSet.getString(3));
            namaPegawai.setText(resultSet.getString(4));
            jalanPegawai.setText(resultSet.getString(5));
            kotaPegawai.setText(resultSet.getString(6));
            provPegawai.setText(resultSet.getString(7));
            telpPegawai.setText(resultSet.getString(8));
            gajiPegawai.setText(resultSet.getString(9));
            posisiPegawai.getModel().setSelectedItem(resultSet.getString(10));
            kelaminPegawai.getModel().setSelectedItem(resultSet.getString(11));

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lastPegawaiActionPerformed

    private void prevPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevPegawaiActionPerformed
        try{

            if(resultSet != null && !resultSet.isFirst()){
            resultSet.previous();
            idPegawai.setText(resultSet.getString(1));
            emailPegawai.setText(resultSet.getString(2));
            sandiPegawai.setText(resultSet.getString(3));
            namaPegawai.setText(resultSet.getString(4));
            jalanPegawai.setText(resultSet.getString(5));
            kotaPegawai.setText(resultSet.getString(6));
            provPegawai.setText(resultSet.getString(7));
            telpPegawai.setText(resultSet.getString(8));
            gajiPegawai.setText(resultSet.getString(9));
            posisiPegawai.setSelectedItem(resultSet.getString(10));
            kelaminPegawai.setSelectedItem(resultSet.getString(11));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_prevPegawaiActionPerformed

    private void firstPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstPegawaiActionPerformed
        try{
            resultSet=statement.executeQuery("select * from Pegawai");
            resultSet.first();
            idPegawai.setText(resultSet.getString(1));
            emailPegawai.setText(resultSet.getString(2));
            sandiPegawai.setText(resultSet.getString(3));
            namaPegawai.setText(resultSet.getString(4));
            jalanPegawai.setText(resultSet.getString(5));
            kotaPegawai.setText(resultSet.getString(6));
            provPegawai.setText(resultSet.getString(7));
            telpPegawai.setText(resultSet.getString(8));
            gajiPegawai.setText(resultSet.getString(9));
            posisiPegawai.setSelectedItem(resultSet.getString(10));
            kelaminPegawai.setSelectedItem(resultSet.getString(11));

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_firstPegawaiActionPerformed

    private void nextPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextPegawaiActionPerformed
        try{

            if(resultSet != null && !resultSet.isLast()){
            resultSet.next();
            idPegawai.setText(resultSet.getString(1));
            emailPegawai.setText(resultSet.getString(2));
            sandiPegawai.setText(resultSet.getString(3));
            namaPegawai.setText(resultSet.getString(4));
            jalanPegawai.setText(resultSet.getString(5));
            kotaPegawai.setText(resultSet.getString(6));
            provPegawai.setText(resultSet.getString(7));
            telpPegawai.setText(resultSet.getString(8));
            gajiPegawai.setText(resultSet.getString(9));
            posisiPegawai.getModel().setSelectedItem(resultSet.getString(10));
            kelaminPegawai.getModel().setSelectedItem(resultSet.getString(11));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_nextPegawaiActionPerformed

    private void cariPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariPegawaiActionPerformed
        DefaultTableModel ob=(DefaultTableModel) tblPegawai.getModel();
        TableRowSorter<DefaultTableModel> obj=new TableRowSorter<>(ob);
        tblPegawai.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txtCariPegawai.getText()));
    }//GEN-LAST:event_cariPegawaiActionPerformed

    private void reloadtblPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadtblPegawaiActionPerformed
        txtCariPegawai.setText("");
        tblPegawai.setRowSorter(null);
    }//GEN-LAST:event_reloadtblPegawaiActionPerformed

    private void tblPesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPesananMouseClicked
        int i = tblPesanan.getSelectedRow();
            if (i == -1){
                return;
            }
            String id = (String) tblPesanan.getValueAt(i, 0);
            idPesanan.setText(id);
            String keranjang = (String) tblPesanan.getValueAt(i, 1);
            keranjangPesanan.setText(keranjang);
            String promo = (String) tblPesanan.getValueAt(i, 2);
            promoPesanan.setText(promo);
            String metode = (String) tblPesanan.getValueAt(i, 3);
            metodePesanan.setText(metode);
            String pengiriman = (String) tblPesanan.getValueAt(i, 4);
            pengirimanPesanan.setText(pengiriman);
            String tanggal = (String) tblPesanan.getValueAt(i, 5);
            tanggalPesanan.setText(tanggal);
            String barang = (String) tblPesanan.getValueAt(i, 6);
            totalHargaBarang.setText(barang);
            String harga = (String) tblPesanan.getValueAt(i, 7);
            totalHarga.setText(harga);
            String pegawai = (String) tblPegawai.getValueAt(i, 8);
            pegawaiPesanan.setText(pegawai);
            String status = (String) tblPegawai.getValueAt(i, 9);
            statusPembayaran.setText(status);
            
    }//GEN-LAST:event_tblPesananMouseClicked

    private void txtCariPesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariPesananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariPesananActionPerformed

    private void cancelPesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelPesananActionPerformed
        populateAllPesananFields(); 
    }//GEN-LAST:event_cancelPesananActionPerformed

    private void savePesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePesananActionPerformed
        try{
            preparedStatement = connection.prepareStatement("insert into Pesanan VALUES(?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, Integer.parseInt(idPesanan.getText()));
            preparedStatement.setInt(2, Integer.parseInt(keranjangPesanan.getText()));
            preparedStatement.setString(3, promoPesanan.getText());
            preparedStatement.setInt(4, Integer.parseInt(metodePesanan.getText()));
            preparedStatement.setInt(5, Integer.parseInt(pengirimanPesanan.getText()));
            preparedStatement.setString(6, tanggalPesanan.getText());
            preparedStatement.setInt(7, Integer.parseInt(totalHargaBarang.getText()));
            preparedStatement.setInt(8, Integer.parseInt(totalHarga.getText()));
            preparedStatement.setInt(9, Integer.parseInt(pegawaiPesanan.getText()));
            preparedStatement.setString(10, statusPembayaran.getText());
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows + " "+ "affected row(s)");
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
        }
        populateAllPesananFields();  
    }//GEN-LAST:event_savePesananActionPerformed

    private void editPesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPesananActionPerformed
        try{
            preparedStatement = connection.prepareStatement("update Pesanan set id_keranjang=?, kode_promo=?, id_metode_pembayaran=?, id_pengiriman=?, tanggal_pesanan=?, total_harga_barang=?, total_harga=?, id_pegawai=?, status_pembayaran=? where id_pesanan=?");
            preparedStatement.setInt(1, Integer.parseInt(keranjangPesanan.getText()));
            preparedStatement.setString(2, promoPesanan.getText());
            preparedStatement.setInt(3, Integer.parseInt(metodePesanan.getText()));
            preparedStatement.setInt(4, Integer.parseInt(pengirimanPesanan.getText()));
            preparedStatement.setString(5, tanggalPesanan.getText());
            preparedStatement.setInt(6, Integer.parseInt(totalHargaBarang.getText()));
            preparedStatement.setInt(7, Integer.parseInt(totalHarga.getText()));
            preparedStatement.setInt(8, Integer.parseInt(pegawaiPesanan.getText()));
            preparedStatement.setString(9, statusPembayaran.getText());
            preparedStatement.setInt(10, Integer.parseInt(idPesanan.getText()));
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows + " "+ "affected row(s)");
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
        }
        populateAllPesananFields();
    }//GEN-LAST:event_editPesananActionPerformed

    private void deletePesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePesananActionPerformed
        try{
            int answer = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete \"" + resultSet.getString("id_pesanan")+"\"?", "Delete confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            if (answer== JOptionPane.YES_OPTION){
                preparedStatement = connection.prepareStatement("DELETE from Pesanan WHERE id_pesanan=?");
                preparedStatement.setInt(1, resultSet.getInt("id_pesanan"));
                int affectedRows = preparedStatement.executeUpdate();
                System.out.println(affectedRows + " " + "deleted row(s)");
                populateAllPesananFields();
            }

            else if (answer== JOptionPane.NO_OPTION){
                System.out.println("Cancel");}
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_deletePesananActionPerformed

    private void newPesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPesananActionPerformed
        idPesanan.setEditable(true);
        idPesanan.setText("");
        keranjangPesanan.setText("");
        promoPesanan.setText("");
        metodePesanan.setText("");
        pengirimanPesanan.setText("");
        tanggalPesanan.setText("");
        totalHargaBarang.setText("");
        totalHarga.setText("");
        pegawaiPesanan.setText("");
        statusPembayaran.setText("");
        idPesanan.requestFocus();
    }//GEN-LAST:event_newPesananActionPerformed

    private void lastPesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastPesananActionPerformed
        try{

            resultSet=statement.executeQuery("select * from Pesanan");
                resultSet.last();
                idPesanan.setText(resultSet.getString(1));
                keranjangPesanan.setText(resultSet.getString(2));
                promoPesanan.setText(resultSet.getString(3));
                metodePesanan.setText(resultSet.getString(4));
                pengirimanPesanan.setText(resultSet.getString(5));
                tanggalPesanan.setText(resultSet.getString(6));
                totalHargaBarang.setText(resultSet.getString(7));
                totalHarga.setText(resultSet.getString(8));
                pegawaiPesanan.setText(resultSet.getString(9));
                statusPembayaran.setText(resultSet.getString(10));
            

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lastPesananActionPerformed

    private void prevPesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevPesananActionPerformed
        try{

            if(resultSet != null && !resultSet.isFirst()){
                resultSet.previous();
                idPesanan.setText(resultSet.getString(1));
                keranjangPesanan.setText(resultSet.getString(2));
                promoPesanan.setText(resultSet.getString(3));
                metodePesanan.setText(resultSet.getString(4));
                pengirimanPesanan.setText(resultSet.getString(5));
                tanggalPesanan.setText(resultSet.getString(6));
                totalHargaBarang.setText(resultSet.getString(7));
                totalHarga.setText(resultSet.getString(8));
                pegawaiPesanan.setText(resultSet.getString(9));
                statusPembayaran.setText(resultSet.getString(10));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_prevPesananActionPerformed

    private void firstPesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstPesananActionPerformed
        try{

            resultSet=statement.executeQuery("select * from Pesanan");
                resultSet.first();
                idPesanan.setText(resultSet.getString(1));
                keranjangPesanan.setText(resultSet.getString(2));
                promoPesanan.setText(resultSet.getString(3));
                metodePesanan.setText(resultSet.getString(4));
                pengirimanPesanan.setText(resultSet.getString(5));
                tanggalPesanan.setText(resultSet.getString(6));
                totalHargaBarang.setText(resultSet.getString(7));
                totalHarga.setText(resultSet.getString(8));
                pegawaiPesanan.setText(resultSet.getString(9));
                statusPembayaran.setText(resultSet.getString(10));
            

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_firstPesananActionPerformed

    private void nextPesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextPesananActionPerformed
        try{

            if(resultSet != null && !resultSet.isLast()){
                resultSet.next();
                idPesanan.setText(resultSet.getString(1));
                keranjangPesanan.setText(resultSet.getString(2));
                promoPesanan.setText(resultSet.getString(3));
                metodePesanan.setText(resultSet.getString(4));
                pengirimanPesanan.setText(resultSet.getString(5));
                tanggalPesanan.setText(resultSet.getString(6));
                totalHargaBarang.setText(resultSet.getString(7));
                totalHarga.setText(resultSet.getString(8));
                pegawaiPesanan.setText(resultSet.getString(9));
                statusPembayaran.setText(resultSet.getString(10));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_nextPesananActionPerformed

    private void cariPesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariPesananActionPerformed
        DefaultTableModel ob=(DefaultTableModel) tblPesanan.getModel();
        TableRowSorter<DefaultTableModel> obj=new TableRowSorter<>(ob);
        tblPesanan.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txtCariPesanan.getText()));
    }//GEN-LAST:event_cariPesananActionPerformed

    private void reloadtblPesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadtblPesananActionPerformed
        txtCariPesanan.setText("");
        tblPesanan.setRowSorter(null);
    }//GEN-LAST:event_reloadtblPesananActionPerformed

    private void tblPengirimanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPengirimanMouseClicked
        int i = tblPengiriman.getSelectedRow();
            if (i == -1){
                return;
            }
            String id = (String) tblPengiriman.getValueAt(i, 0);
            idPengiriman.setText(id);
            String tanggal = (String) tblPengiriman.getValueAt(i, 1);
            tanggalPengiriman.setText(tanggal);
            String jalan = (String) tblPengiriman.getValueAt(i, 2);
            jalanPengiriman.setText(jalan);
            String kota = (String) tblPengiriman.getValueAt(i, 3);
            kotaPengiriman.setText(kota);
            String prov = (String) tblPengiriman.getValueAt(i, 4);
            provPengiriman.setText(prov);
            String status = (String) tblPengiriman.getValueAt(i, 5);
            statusPengiriman.setSelectedItem(status);
            String ongkir = (String) tblPengiriman.getValueAt(i, 6);
            ongkirPengiriman.setText(ongkir);
    }//GEN-LAST:event_tblPengirimanMouseClicked

    private void txtCariPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariPengirimanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariPengirimanActionPerformed

    private void cancelPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelPengirimanActionPerformed
       populateAllPengirimanFields();
    }//GEN-LAST:event_cancelPengirimanActionPerformed

    private void savePengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePengirimanActionPerformed
        try{
            preparedStatement = connection.prepareStatement("insert into Pengiriman VALUES(?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, Integer.parseInt(idPengiriman.getText()));
            preparedStatement.setString(2, tanggalPengiriman.getText());
            preparedStatement.setString(3, jalanPengiriman.getText());
            preparedStatement.setString(4, kotaPengiriman.getText());
            preparedStatement.setString(5, provPengiriman.getText());
            preparedStatement.setString(6, (String)(statusPengiriman.getSelectedItem()));
            preparedStatement.setInt(7, Integer.parseInt(ongkirPengiriman.getText()));
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows + " "+ "affected row(s)");
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
        }
        populateAllPengirimanFields();  
    }//GEN-LAST:event_savePengirimanActionPerformed

    private void editPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPengirimanActionPerformed
        try{
            preparedStatement = connection.prepareStatement("update Pengiriman set tanggal_pengiriman=?, jalan_tujuan=?, kota_tujuan=?, provinsi_tujuan=?, status_pengiriman=?, id_ongkir=? where id_pengiriman=?");
            preparedStatement.setString(1, tanggalPengiriman.getText());
            preparedStatement.setString(2, jalanPengiriman.getText());
            preparedStatement.setString(3, kotaPengiriman.getText());
            preparedStatement.setString(4, provPengiriman.getText());
            preparedStatement.setString(5, (String)(statusPengiriman.getSelectedItem()));
            preparedStatement.setInt(6, Integer.parseInt(ongkirPengiriman.getText()));
            preparedStatement.setInt(7, Integer.parseInt(idPengiriman.getText()));
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows + " "+ "affected row(s)");
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
        }
        populateAllPengirimanFields();
    }//GEN-LAST:event_editPengirimanActionPerformed

    private void deletePengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePengirimanActionPerformed
        try{
            int answer = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete \"" + resultSet.getString("id_pengiriman")+"\"?", "Delete confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            if (answer== JOptionPane.YES_OPTION){
                preparedStatement = connection.prepareStatement("DELETE from Pengiriman WHERE id_pengiriman=?");
                preparedStatement.setInt(1, resultSet.getInt("id_pengiriman"));
                int affectedRows = preparedStatement.executeUpdate();
                System.out.println(affectedRows + " " + "deleted row(s)");
                populateAllPengirimanFields();
                //
            }

            else if (answer== JOptionPane.NO_OPTION){
                System.out.println("Cancel");}
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_deletePengirimanActionPerformed

    private void newPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPengirimanActionPerformed
        idPengiriman.setEditable(true);
        idPengiriman.setText("");
        tanggalPengiriman.setText("");
        jalanPengiriman.setText("");
        kotaPengiriman.setText("");
        provPengiriman.setText("");
        statusPengiriman.setSelectedItem(0);
        ongkirPengiriman.setText("");
        idPengiriman.requestFocus();
    }//GEN-LAST:event_newPengirimanActionPerformed

    private void lastPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastPengirimanActionPerformed
        try{
            resultSet=statement.executeQuery("select * from Pengiriman");
            resultSet.last();
            idPengiriman.setText(resultSet.getString(1));
            tanggalPengiriman.setText(resultSet.getString(2));
            jalanPengiriman.setText(resultSet.getString(3));
            kotaPengiriman.setText(resultSet.getString(4));
            provPengiriman.setText(resultSet.getString(5));
            statusPengiriman.setSelectedItem(resultSet.getString(6));
            ongkirPengiriman.setText(resultSet.getString(7));
            }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lastPengirimanActionPerformed

    private void prevPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevPengirimanActionPerformed
        try{
            if(resultSet != null && !resultSet.isFirst()){
                resultSet.previous();
                idPengiriman.setText(resultSet.getString(1));
                tanggalPengiriman.setText(resultSet.getString(2));
                jalanPengiriman.setText(resultSet.getString(3));
                kotaPengiriman.setText(resultSet.getString(4));
                provPengiriman.setText(resultSet.getString(5));
                statusPengiriman.setSelectedItem(resultSet.getString(6));
                ongkirPengiriman.setText(resultSet.getString(7));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_prevPengirimanActionPerformed

    private void firstPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstPengirimanActionPerformed
        try{
            resultSet=statement.executeQuery("select * from Pengiriman");
            resultSet.first();
            idPengiriman.setText(resultSet.getString(1));
            tanggalPengiriman.setText(resultSet.getString(2));
            jalanPengiriman.setText(resultSet.getString(3));
            kotaPengiriman.setText(resultSet.getString(4));
            provPengiriman.setText(resultSet.getString(5));
            statusPengiriman.setSelectedItem(resultSet.getString(6));
            ongkirPengiriman.setText(resultSet.getString(7));
            }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_firstPengirimanActionPerformed

    private void nextPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextPengirimanActionPerformed
        try{
            if(resultSet != null && !resultSet.isLast()){
                resultSet.next();
                idPengiriman.setText(resultSet.getString(1));
                tanggalPengiriman.setText(resultSet.getString(2));
                jalanPengiriman.setText(resultSet.getString(3));
                kotaPengiriman.setText(resultSet.getString(4));
                provPengiriman.setText(resultSet.getString(5));
                statusPengiriman.setSelectedItem(resultSet.getString(6));
                ongkirPengiriman.setText(resultSet.getString(7));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_nextPengirimanActionPerformed

    private void cariPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariPengirimanActionPerformed
        DefaultTableModel ob=(DefaultTableModel) tblPengiriman.getModel();
        TableRowSorter<DefaultTableModel> obj=new TableRowSorter<>(ob);
        tblPengiriman.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txtCariPengiriman.getText()));
    }//GEN-LAST:event_cariPengirimanActionPerformed

    private void reloadtblPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadtblPengirimanActionPerformed
        txtCariPengiriman.setText("");
        tblPengiriman.setRowSorter(null);
    }//GEN-LAST:event_reloadtblPengirimanActionPerformed

    private void tblKeranjangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKeranjangMouseClicked
       int i = tblKeranjang.getSelectedRow();
            if (i == -1){
                return;
            }
            String id = (String) tblKeranjang.getValueAt(i, 0);
            idKeranjang.setText(id);
            String produk = (String) tblKeranjang.getValueAt(i, 1);
            produkKeranjang.setText(produk);
            String jumlah = (String) tblKeranjang.getValueAt(i, 2);
            jumlahProduk.setText(jumlah);
            String subtotal = (String) tblKeranjang.getValueAt(i, 3);
            subTotal.setText(subtotal);
            
    }//GEN-LAST:event_tblKeranjangMouseClicked

    private void txtCariKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariKeranjangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariKeranjangActionPerformed

    private void cancelKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelKeranjangActionPerformed
        populateAllKeranjangFields();
    }//GEN-LAST:event_cancelKeranjangActionPerformed

    private void saveKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveKeranjangActionPerformed
        try{
            preparedStatement = connection.prepareStatement("insert into Keranjang VALUES(?,?,?,?)");
            preparedStatement.setInt(1, Integer.parseInt(idKeranjang.getText()));
            preparedStatement.setString(2, produkKeranjang.getText());
            preparedStatement.setInt(3, Integer.parseInt(jumlahProduk.getText()));
            preparedStatement.setInt(4, Integer.parseInt(subTotal.getText()));
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows + " "+ "affected row(s)");
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
        }
        populateAllKeranjangFields();  
    }//GEN-LAST:event_saveKeranjangActionPerformed

    private void editKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editKeranjangActionPerformed
        try{
            preparedStatement = connection.prepareStatement("update Keranjang set id_produk=?, jumlah_produk=?, sub_total=? where id_keranjang=?");
            preparedStatement.setString(1, produkKeranjang.getText());
            preparedStatement.setInt(2, Integer.parseInt(jumlahProduk.getText()));
            preparedStatement.setInt(3, Integer.parseInt(subTotal.getText()));
            preparedStatement.setInt(4, Integer.parseInt(idKeranjang.getText()));
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows + " "+ "affected row(s)");
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
        }
        populateAllKeranjangFields();
    }//GEN-LAST:event_editKeranjangActionPerformed

    private void deleteKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteKeranjangActionPerformed
        try{
            int answer = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete \"" + resultSet.getString("id_produk")+ " in " +resultSet.getString("id_keranjang")+"\"?", "Delete confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            if (answer== JOptionPane.YES_OPTION){
                preparedStatement = connection.prepareStatement("DELETE from Keranjang WHERE id_keranjang=? AND id_produk=?");
                preparedStatement.setInt(1, resultSet.getInt("id_keranjang"));
                preparedStatement.setInt(2, resultSet.getInt("id_produk"));
                int affectedRows = preparedStatement.executeUpdate();
                System.out.println(affectedRows + " " + "deleted row(s)");
                populateAllKeranjangFields();
            }

            else if (answer== JOptionPane.NO_OPTION){
                System.out.println("Cancel");}
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_deleteKeranjangActionPerformed

    private void newKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newKeranjangActionPerformed
        idKeranjang.setEditable(true);
        idKeranjang.setText("");
        produkKeranjang.setText("");
        jumlahProduk.setText("");
        subTotal.setText("");
        idKeranjang.requestFocus();
    }//GEN-LAST:event_newKeranjangActionPerformed

    private void lastKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastKeranjangActionPerformed
        try{
                resultSet=statement.executeQuery("select * from Keranjang");
                resultSet.last();
                idKeranjang.setText(resultSet.getString(1));
                produkKeranjang.setText(resultSet.getString(2));
                jumlahProduk.setText(resultSet.getString(3));
                subTotal.setText(resultSet.getString(4));
                }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lastKeranjangActionPerformed

    private void prevKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevKeranjangActionPerformed
        try{

            if(resultSet != null && !resultSet.isFirst()){
                resultSet.previous();
                idKeranjang.setText(resultSet.getString(1));
                produkKeranjang.setText(resultSet.getString(2));
                jumlahProduk.setText(resultSet.getString(3));
                subTotal.setText(resultSet.getString(4));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_prevKeranjangActionPerformed

    private void firstKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstKeranjangActionPerformed
        try{
                resultSet=statement.executeQuery("select * from Keranjang");
                resultSet.first();
                idKeranjang.setText(resultSet.getString(1));
                produkKeranjang.setText(resultSet.getString(2));
                jumlahProduk.setText(resultSet.getString(3));
                subTotal.setText(resultSet.getString(4));
                }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_firstKeranjangActionPerformed

    private void nextKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextKeranjangActionPerformed
        try{

            if(resultSet != null && !resultSet.isLast()){
                resultSet.next();
                idKeranjang.setText(resultSet.getString(1));
                produkKeranjang.setText(resultSet.getString(2));
                jumlahProduk.setText(resultSet.getString(3));
                subTotal.setText(resultSet.getString(4));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_nextKeranjangActionPerformed

    private void cariKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariKeranjangActionPerformed
        DefaultTableModel ob=(DefaultTableModel) tblKeranjang.getModel();
        TableRowSorter<DefaultTableModel> obj=new TableRowSorter<>(ob);
        tblKeranjang.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txtCariKeranjang.getText()));
    }//GEN-LAST:event_cariKeranjangActionPerformed

    private void reloadtblKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadtblKeranjangActionPerformed
        txtCariKeranjang.setText("");
        tblKeranjang.setRowSorter(null);
    }//GEN-LAST:event_reloadtblKeranjangActionPerformed

    private void tblPromoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPromoMouseClicked
        int i = tblPromo.getSelectedRow();
            if (i == -1){
                return;
            }
            String id = (String) tblPromo.getValueAt(i, 0);
            idPromo.setText(id);
            String potongan = (String) tblPromo.getValueAt(i, 1);
            potonganPromo.setText(potongan);
            String tanggalA = (String) tblPromo.getValueAt(i, 2);
            tanggalAwal.setText(tanggalA);
            String tanggalB = (String) tblPromo.getValueAt(i, 3);
            tanggalBerakhir.setText(tanggalB);
    }//GEN-LAST:event_tblPromoMouseClicked

    private void txtCariPromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariPromoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariPromoActionPerformed

    private void cancelPromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelPromoActionPerformed
        populateAllPromoFields();
    }//GEN-LAST:event_cancelPromoActionPerformed

    private void savePromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePromoActionPerformed
        try{
            preparedStatement = connection.prepareStatement("insert into Promo VALUES(?,?,?,?)");
            preparedStatement.setString(1, idPromo.getText());
            preparedStatement.setDouble(2, Double.parseDouble(potonganPromo.getText()));
            preparedStatement.setString(3, tanggalAwal.getText());
            preparedStatement.setString(4, tanggalBerakhir.getText());
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows + " "+ "affected row(s)");
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
        }
        populateAllPromoFields();  
    }//GEN-LAST:event_savePromoActionPerformed

    private void editPromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPromoActionPerformed
        try{
            preparedStatement = connection.prepareStatement("update Promo set persen_potongan=?, tanggal_awal=?, tanggal_berakhir=? where kode_promo=?");
            preparedStatement.setDouble(1, Double.parseDouble(potonganPromo.getText()));
            preparedStatement.setString(2, tanggalAwal.getText());
            preparedStatement.setString(3, tanggalBerakhir.getText());
            preparedStatement.setString(4, idPromo.getText());
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows + " "+ "affected row(s)");
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
        }
        populateAllPromoFields();
    }//GEN-LAST:event_editPromoActionPerformed

    private void deletePromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePromoActionPerformed
        try{
            int answer = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete \"" + resultSet.getString("kode_promo")+"\"?", "Delete confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            if (answer== JOptionPane.YES_OPTION){
                preparedStatement = connection.prepareStatement("DELETE from Promo WHERE kode_promo=?");
                preparedStatement.setString(1, resultSet.getString("kode_promo"));
                int affectedRows = preparedStatement.executeUpdate();
                System.out.println(affectedRows + " " + "deleted row(s)");
                populateAllPromoFields();
            }

            else if (answer== JOptionPane.NO_OPTION){
                System.out.println("Cancel");}
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_deletePromoActionPerformed

    private void newPromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPromoActionPerformed
        idPromo.setEditable(true);
        idPromo.setText("");
        potonganPromo.setText("");
        tanggalAwal.setText("");
        tanggalBerakhir.setText("");
        idPromo.requestFocus();
    }//GEN-LAST:event_newPromoActionPerformed

    private void lastPromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastPromoActionPerformed
        try{
            resultSet=statement.executeQuery("select * from Promo");
            resultSet.last();
            idPromo.setText(resultSet.getString(1));
            potonganPromo.setText(resultSet.getString(2));
            tanggalAwal.setText(resultSet.getString(3));
            tanggalBerakhir.setText(resultSet.getString(4));
            

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lastPromoActionPerformed

    private void prevPromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevPromoActionPerformed
        try{

            if(resultSet != null && !resultSet.isFirst()){
            resultSet.previous();
            idPromo.setText(resultSet.getString(1));
            potonganPromo.setText(resultSet.getString(2));
            tanggalAwal.setText(resultSet.getString(3));
            tanggalBerakhir.setText(resultSet.getString(4));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_prevPromoActionPerformed

    private void firstPromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstPromoActionPerformed
        try{
            resultSet=statement.executeQuery("select * from Promo");
            resultSet.first();
            idPromo.setText(resultSet.getString(1));
            potonganPromo.setText(resultSet.getString(2));
            tanggalAwal.setText(resultSet.getString(3));
            tanggalBerakhir.setText(resultSet.getString(4));
            

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_firstPromoActionPerformed

    private void nextPromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextPromoActionPerformed
        try{

            if(resultSet != null && !resultSet.isLast()){
            resultSet.next();
            idPromo.setText(resultSet.getString(1));
            potonganPromo.setText(resultSet.getString(2));
            tanggalAwal.setText(resultSet.getString(3));
            tanggalBerakhir.setText(resultSet.getString(4));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_nextPromoActionPerformed

    private void cariPromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariPromoActionPerformed
        DefaultTableModel ob=(DefaultTableModel) tblPromo.getModel();
        TableRowSorter<DefaultTableModel> obj=new TableRowSorter<>(ob);
        tblPromo.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txtCariPromo.getText()));
    }//GEN-LAST:event_cariPromoActionPerformed

    private void reloadtblPromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadtblPromoActionPerformed
        txtCariPromo.setText("");
        tblPromo.setRowSorter(null);
    }//GEN-LAST:event_reloadtblPromoActionPerformed

    private void tblOngkirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOngkirMouseClicked
        int i = tblOngkir.getSelectedRow();
            if (i == -1){
                return;
            }
            String id = (String) tblOngkir.getValueAt(i, 0);
            idOngkir.setText(id);
            String prov = (String) tblOngkir.getValueAt(i, 1);
            provOngkir.setText(prov);
            String tarif = (String) tblOngkir.getValueAt(i, 2);
            tarifOngkir.setText(tarif);
    }//GEN-LAST:event_tblOngkirMouseClicked

    private void txtCariOngkirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariOngkirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariOngkirActionPerformed

    private void cancelOngkirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelOngkirActionPerformed
        populateAllOngkirFields();
    }//GEN-LAST:event_cancelOngkirActionPerformed

    private void saveOngkirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveOngkirActionPerformed
        try{
            preparedStatement = connection.prepareStatement("insert into Ongkir VALUES(?,?,?)");
            preparedStatement.setInt(1, Integer.parseInt(idOngkir.getText()));
            preparedStatement.setString(2, provOngkir.getText());
            preparedStatement.setInt(3, Integer.parseInt(tarifOngkir.getText()));
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows + " "+ "affected row(s)");
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
        }
        populateAllOngkirFields();   
    }//GEN-LAST:event_saveOngkirActionPerformed

    private void editOngkirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editOngkirActionPerformed
        try{
            preparedStatement = connection.prepareStatement("update Ongkir set provinsi=?, tarif=? where id_ongkir=?");
            preparedStatement.setString(1, provOngkir.getText());
            preparedStatement.setInt(2, Integer.parseInt(tarifOngkir.getText()));
            preparedStatement.setInt(3, Integer.parseInt(idOngkir.getText()));
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows + " "+ "affected row(s)");
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
        }
        populateAllOngkirFields();
    }//GEN-LAST:event_editOngkirActionPerformed

    private void deleteOngkirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteOngkirActionPerformed
        try{
            int answer = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete \"" + resultSet.getString("id_ongkir")+"\"?", "Delete confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            if (answer== JOptionPane.YES_OPTION){
                preparedStatement = connection.prepareStatement("DELETE from Ongkir WHERE id_ongkir=?");
                preparedStatement.setInt(1, resultSet.getInt("id_ongkir"));
                int affectedRows = preparedStatement.executeUpdate();
                System.out.println(affectedRows + " " + "deleted row(s)");
                populateAllOngkirFields();
            }

            else if (answer== JOptionPane.NO_OPTION){
                System.out.println("Cancel");}
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_deleteOngkirActionPerformed

    private void newOngkirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newOngkirActionPerformed
       idOngkir.setEditable(true);
       idOngkir.setText("");
       provOngkir.setText("");
       tarifOngkir.setText("");
       idOngkir.requestFocus();
    }//GEN-LAST:event_newOngkirActionPerformed

    private void lastOngkirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastOngkirActionPerformed
        try{
            resultSet=statement.executeQuery("select * from Ongkir");
            resultSet.last();
            idOngkir.setText(resultSet.getString(1));
            provOngkir.setText(resultSet.getString(2));
            tarifOngkir.setText(resultSet.getString(3));
           
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lastOngkirActionPerformed

    private void prevOngkirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevOngkirActionPerformed
        try{
            if(resultSet != null && !resultSet.isFirst()){
            resultSet.previous();
            idOngkir.setText(resultSet.getString(1));
            provOngkir.setText(resultSet.getString(2));
            tarifOngkir.setText(resultSet.getString(3));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_prevOngkirActionPerformed

    private void firstOngkirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstOngkirActionPerformed
        try{
            resultSet=statement.executeQuery("select * from Ongkir");
            resultSet.first();
            idOngkir.setText(resultSet.getString(1));
            provOngkir.setText(resultSet.getString(2));
            tarifOngkir.setText(resultSet.getString(3));
           
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_firstOngkirActionPerformed

    private void nextOngkirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextOngkirActionPerformed
        try{

            if(resultSet != null && !resultSet.isLast()){
            resultSet.next();
            idOngkir.setText(resultSet.getString(1));
            provOngkir.setText(resultSet.getString(2));
            tarifOngkir.setText(resultSet.getString(3));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_nextOngkirActionPerformed

    private void cariOngkirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariOngkirActionPerformed
        DefaultTableModel ob=(DefaultTableModel) tblOngkir.getModel();
        TableRowSorter<DefaultTableModel> obj=new TableRowSorter<>(ob);
        tblOngkir.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txtCariOngkir.getText()));
    }//GEN-LAST:event_cariOngkirActionPerformed

    private void reloadtblOngkirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadtblOngkirActionPerformed
        txtCariOngkir.setText("");
        tblOngkir.setRowSorter(null);
    }//GEN-LAST:event_reloadtblOngkirActionPerformed

    private void tblProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdukMouseClicked
        int i = tblProduk.getSelectedRow();
            if (i == -1){
                return;
            }
            String id = (String) tblProduk.getValueAt(i, 0);
            idProduk.setText(id);
            String nama = (String) tblProduk.getValueAt(i, 1);
            namaProduk.setText(nama);
            String kategori = (String) tblProduk.getValueAt(i, 2);
            kategoriProduk.setSelectedItem(kategori);
            String harga = (String) tblProduk.getValueAt(i, 3);
            hargaProduk.setText(harga);
            String stok = (String) tblProduk.getValueAt(i, 4);
            stokProduk.setText(stok);
            String warna = (String) tblProduk.getValueAt(i, 5);
            warnaProduk.setText(warna);
            String terjual = (String) tblProduk.getValueAt(i, 6);
            terjualProduk.setText(terjual);
    }//GEN-LAST:event_tblProdukMouseClicked

    private void txtCariProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariProdukActionPerformed

    private void cancelProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelProdukActionPerformed
        populateAllProdukFields();
    }//GEN-LAST:event_cancelProdukActionPerformed

    private void saveProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveProdukActionPerformed
        try{
            preparedStatement = connection.prepareStatement("insert into Produk VALUES(?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, Integer.parseInt(idProduk.getText()));
            preparedStatement.setString(2, namaProduk.getText());
            preparedStatement.setString(3, (String)kategoriProduk.getSelectedItem());
            preparedStatement.setInt(4, Integer.parseInt(hargaProduk.getText()));
            preparedStatement.setInt(5, Integer.parseInt(stokProduk.getText()));
            preparedStatement.setString(6, warnaProduk.getText());
            preparedStatement.setInt(7, Integer.parseInt(terjualProduk.getText()));
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows + " "+ "affected row(s)");
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            
        }
        catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
        }
        populateAllProdukFields();  
    }//GEN-LAST:event_saveProdukActionPerformed

    private void editProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProdukActionPerformed
        try{
            preparedStatement = connection.prepareStatement("update Produk set nama_produk=?, kategori=?, harga=?, stok=?, warna=?, terjual=? where id_produk=?");
            preparedStatement.setString(1, namaProduk.getText());
            preparedStatement.setString(2, (String)kategoriProduk.getSelectedItem());
            preparedStatement.setInt(3, Integer.parseInt(hargaProduk.getText()));
            preparedStatement.setInt(4, Integer.parseInt(stokProduk.getText()));
            preparedStatement.setString(5, warnaProduk.getText());
            preparedStatement.setInt(6, Integer.parseInt(terjualProduk.getText()));
            preparedStatement.setInt(7, Integer.parseInt(idProduk.getText()));
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows + " "+ "affected row(s)");
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
        }
        populateAllProdukFields();
    }//GEN-LAST:event_editProdukActionPerformed

    private void deleteProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProdukActionPerformed
        try{
            int answer = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete \"" + resultSet.getString("nama_produk")+"\"?", "Delete confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            if (answer== JOptionPane.YES_OPTION){

                preparedStatement = connection.prepareStatement("DELETE from Produk WHERE id_produk=?");
                preparedStatement.setInt(1, resultSet.getInt("id_produk"));
                int affectedRows = preparedStatement.executeUpdate();
                System.out.println(affectedRows + " " + "deleted row(s)");
                populateAllProdukFields();
                //
            }

            else if (answer== JOptionPane.NO_OPTION){
                System.out.println("Cancel");}
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_deleteProdukActionPerformed

    private void newProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProdukActionPerformed
        idProduk.setEditable(true);
        idProduk.setText("");
        namaProduk.setText("");
        kategoriProduk.setSelectedItem(0);
        hargaProduk.setText("");
        stokProduk.setText("");
        warnaProduk.setText("");
        terjualProduk.setText("");
        idProduk.requestFocus();
    }//GEN-LAST:event_newProdukActionPerformed

    private void lastProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastProdukActionPerformed
        try{
            resultSet=statement.executeQuery("select * from Produk");
            resultSet.last();
            idProduk.setText(resultSet.getString(1));
            namaProduk.setText(resultSet.getString(2));
            kategoriProduk.setSelectedItem(resultSet.getString(3));
            hargaProduk.setText(resultSet.getString(4));
            stokProduk.setText(resultSet.getString(5));
            warnaProduk.setText(resultSet.getString(6));
            terjualProduk.setText(resultSet.getString(7));
           
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lastProdukActionPerformed

    private void prevProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevProdukActionPerformed
        try{

            if(resultSet != null && !resultSet.isFirst()){
            resultSet.previous();
            idProduk.setText(resultSet.getString(1));
            namaProduk.setText(resultSet.getString(2));
            kategoriProduk.setSelectedItem(resultSet.getString(3));
            hargaProduk.setText(resultSet.getString(4));
            stokProduk.setText(resultSet.getString(5));
            warnaProduk.setText(resultSet.getString(6));
            terjualProduk.setText(resultSet.getString(7));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_prevProdukActionPerformed

    private void firstProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstProdukActionPerformed
        try{
            resultSet=statement.executeQuery("select * from Produk");
            resultSet.first();
            idProduk.setText(resultSet.getString(1));
            namaProduk.setText(resultSet.getString(2));
            kategoriProduk.setSelectedItem(resultSet.getString(3));
            hargaProduk.setText(resultSet.getString(4));
            stokProduk.setText(resultSet.getString(5));
            warnaProduk.setText(resultSet.getString(6));
            terjualProduk.setText(resultSet.getString(7));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_firstProdukActionPerformed

    private void nextProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextProdukActionPerformed
        try{
            if(resultSet != null && !resultSet.isLast()){
            resultSet.next();
            idProduk.setText(resultSet.getString(1));
            namaProduk.setText(resultSet.getString(2));
            kategoriProduk.setSelectedItem(resultSet.getString(3));
            hargaProduk.setText(resultSet.getString(4));
            stokProduk.setText(resultSet.getString(5));
            warnaProduk.setText(resultSet.getString(6));
            terjualProduk.setText(resultSet.getString(7));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_nextProdukActionPerformed

    private void cariProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariProdukActionPerformed
        DefaultTableModel ob=(DefaultTableModel) tblProduk.getModel();
        TableRowSorter<DefaultTableModel> obj=new TableRowSorter<>(ob);
        tblProduk.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txtCariProduk.getText()));
    }//GEN-LAST:event_cariProdukActionPerformed

    private void reloadtblProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadtblProdukActionPerformed
        txtCariProduk.setText("");
        tblProduk.setRowSorter(null);
    }//GEN-LAST:event_reloadtblProdukActionPerformed

    private void btnProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProdukMouseClicked
        main.removeAll();
        main.repaint();
        main.revalidate();
        main.add(pnlProduk);
        main.repaint();
        main.revalidate();
        populateAllProdukFields();
    }//GEN-LAST:event_btnProdukMouseClicked

    private void kelaminPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelaminPegawaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kelaminPegawaiActionPerformed

    private void tblMetodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMetodeMouseClicked
        int i = tblMetode.getSelectedRow();
            if (i == -1){
                return;
            }
            String id = (String) tblMetode.getValueAt(i, 0);
            idMetode.setText(id);
            String nama = (String) tblMetode.getValueAt(i, 1);
            namaMetode.setText(nama);
            String kode = (String) tblMetode.getValueAt(i, 2);
            kodePembayaran.setText(kode);
            
    }//GEN-LAST:event_tblMetodeMouseClicked

    private void txtCariMetodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariMetodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariMetodeActionPerformed

    private void cancelMetodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelMetodeActionPerformed
        populateAllMetodeFields();
    }//GEN-LAST:event_cancelMetodeActionPerformed

    private void saveMetodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMetodeActionPerformed
        try{
            preparedStatement = connection.prepareStatement("insert into MetodePembayaran VALUES(?,?,?)");
            preparedStatement.setInt(1, Integer.parseInt(idMetode.getText()));
            preparedStatement.setString(2, namaMetode.getText());
            preparedStatement.setString(3, kodePembayaran.getText());
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows + " "+ "affected row(s)");
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
        }
        populateAllMetodeFields();  
    }//GEN-LAST:event_saveMetodeActionPerformed

    private void editMetodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMetodeActionPerformed
        try{
            
            preparedStatement = connection.prepareStatement("update MetodePembayaran set nama_bank=?, kode_pembayaran=? where id_metode_pembayaran=?");
            preparedStatement.setString(1, namaMetode.getText());
            preparedStatement.setString(2, kodePembayaran.getText());
            preparedStatement.setInt(3, Integer.parseInt(idMetode.getText()));
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows + " "+ "affected row(s)");
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
        }
        populateAllMetodeFields();
    }//GEN-LAST:event_editMetodeActionPerformed

    private void deleteMetodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMetodeActionPerformed
        try{
            int answer = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete \"" + resultSet.getString("id_metode_pembayaran")+"\"?", "Delete confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            if (answer== JOptionPane.YES_OPTION){

                preparedStatement = connection.prepareStatement("DELETE from MetodePembayaran WHERE id_metode_pembayaran=?");
                preparedStatement.setInt(1, resultSet.getInt("id_metode_pembayaran"));
                int affectedRows = preparedStatement.executeUpdate();
                System.out.println(affectedRows + " " + "deleted row(s)");
                populateAllMetodeFields();
                
            }

            else if (answer== JOptionPane.NO_OPTION){
                System.out.println("Cancel");}
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_deleteMetodeActionPerformed

    private void newMetodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMetodeActionPerformed
        idMetode.setEditable(true);
        idMetode.setText("");
        namaMetode.setText("");
        kodePembayaran.setText("");
        idMetode.requestFocus();
    }//GEN-LAST:event_newMetodeActionPerformed

    private void lastMetodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastMetodeActionPerformed
        try{
            resultSet=statement.executeQuery("select * from MetodePembayaran");
            resultSet.last();
            idMetode.setText(resultSet.getString(1));
            namaMetode.setText(resultSet.getString(2));
            kodePembayaran.setText(resultSet.getString(3));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lastMetodeActionPerformed

    private void prevMetodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevMetodeActionPerformed
       try{
            if(resultSet != null && !resultSet.isFirst()){
                resultSet.previous();
                idMetode.setText(resultSet.getString(1));
                namaMetode.setText(resultSet.getString(2));
                kodePembayaran.setText(resultSet.getString(3));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_prevMetodeActionPerformed

    private void firstMetodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstMetodeActionPerformed
        try{
            resultSet=statement.executeQuery("select * from MetodePembayaran");
            resultSet.first();
            idMetode.setText(resultSet.getString(1));
            namaMetode.setText(resultSet.getString(2));
            kodePembayaran.setText(resultSet.getString(3));
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_firstMetodeActionPerformed

    private void nextMetodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextMetodeActionPerformed
        try{

            if(resultSet != null && !resultSet.isLast()){
                resultSet.next();
                idMetode.setText(resultSet.getString(1));
                namaMetode.setText(resultSet.getString(2));
                kodePembayaran.setText(resultSet.getString(3));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_nextMetodeActionPerformed

    private void cariMetodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariMetodeActionPerformed
        DefaultTableModel ob=(DefaultTableModel) tblMetode.getModel();
        TableRowSorter<DefaultTableModel> obj=new TableRowSorter<>(ob);
        tblMetode.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txtCariMetode.getText()));
    }//GEN-LAST:event_cariMetodeActionPerformed

    private void reloadtblMetodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadtblMetodeActionPerformed
        txtCariMetode.setText("");
        tblMetode.setRowSorter(null);
    }//GEN-LAST:event_reloadtblMetodeActionPerformed

    private void kodePembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodePembayaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kodePembayaranActionPerformed

    private void btnPesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesananMouseClicked
        main.removeAll();
        main.repaint();
        main.revalidate();
        main.add(pnlPesanan);
        main.repaint();
        main.revalidate();
        populateAllPesananFields();
    }//GEN-LAST:event_btnPesananMouseClicked

    private void btnPengirimanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPengirimanMouseClicked
        main.removeAll();
        main.repaint();
        main.revalidate();
        main.add(pnlPengiriman);
        main.repaint();
        main.revalidate();
        populateAllPengirimanFields();
    }//GEN-LAST:event_btnPengirimanMouseClicked

    private void btnKeranjangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKeranjangMouseClicked
        main.removeAll();
        main.repaint();
        main.revalidate();
        main.add(pnlKeranjang);
        main.repaint();
        main.revalidate();
        populateAllKeranjangFields();
    }//GEN-LAST:event_btnKeranjangMouseClicked

    private void btnPromoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPromoMouseClicked
        main.removeAll();
        main.repaint();
        main.revalidate();
        main.add(pnlPromo);
        main.repaint();
        main.revalidate();
        populateAllPromoFields();
    }//GEN-LAST:event_btnPromoMouseClicked

    private void btnOngkirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOngkirMouseClicked
        main.removeAll();
        main.repaint();
        main.revalidate();
        main.add(pnlOngkir);
        main.repaint();
        main.revalidate();
        populateAllOngkirFields();
    }//GEN-LAST:event_btnOngkirMouseClicked

    private void btnMetodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMetodeMouseClicked
        main.removeAll();
        main.repaint();
        main.revalidate();
        main.add(pnlMetode);
        main.repaint();
        main.revalidate();
        populateAllMetodeFields();
    }//GEN-LAST:event_btnMetodeMouseClicked

    private void tanggalAwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggalAwalActionPerformed
        
    }//GEN-LAST:event_tanggalAwalActionPerformed

    private void stokProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stokProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stokProdukActionPerformed

    private void tblKepemilikanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKepemilikanMouseClicked
        int i = tblKepemilikan.getSelectedRow();
            if (i == -1){
                return;
            }
            String id = (String) tblKepemilikan.getValueAt(i, 0);
            keranjangKepemilikan.setText(id);
            String nama = (String) tblKepemilikan.getValueAt(i, 1);
            pelangganKepemilikan.setText(nama);
    }//GEN-LAST:event_tblKepemilikanMouseClicked

    private void txtCariKepemilikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariKepemilikanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariKepemilikanActionPerformed

    private void cancelKepemilikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelKepemilikanActionPerformed
        populateAllKepemilikanFields();
    }//GEN-LAST:event_cancelKepemilikanActionPerformed

    private void saveKepemilikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveKepemilikanActionPerformed
        try{
            preparedStatement = connection.prepareStatement("insert into KepemilikanKeranjang VALUES(?,?)");
            preparedStatement.setInt(1, Integer.parseInt(keranjangKepemilikan.getText()));
            preparedStatement.setInt(2, Integer.parseInt(pelangganKepemilikan.getText()));
            
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows + " "+ "affected row(s)");
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
        }
        populateAllKepemilikanFields();  
    }//GEN-LAST:event_saveKepemilikanActionPerformed

    private void editKepemilikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editKepemilikanActionPerformed
        try{
            preparedStatement = connection.prepareStatement("update KepemilikanKeranjang set id_pelanggan=? where id_keranjang=?");
            preparedStatement.setInt(1, Integer.parseInt(pelangganKepemilikan.getText()));
            preparedStatement.setInt(2, Integer.parseInt(keranjangKepemilikan.getText()));
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows + " "+ "affected row(s)");
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
        }
        populateAllKepemilikanFields();
    }//GEN-LAST:event_editKepemilikanActionPerformed

    private void deleteKepemilikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteKepemilikanActionPerformed
        try{
            int answer = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete \"" + resultSet.getString("id_keranjang")+"\"?", "Delete confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            if (answer== JOptionPane.YES_OPTION){

                preparedStatement = connection.prepareStatement("DELETE from KepemilikanKeranjang WHERE id_keranjang=?");
                preparedStatement.setInt(1, resultSet.getInt("id_keranjang"));
                int affectedRows = preparedStatement.executeUpdate();
                System.out.println(affectedRows + " " + "deleted row(s)");
                populateAllKeranjangFields();
                
            }

            else if (answer== JOptionPane.NO_OPTION){
                System.out.println("Cancel");}
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_deleteKepemilikanActionPerformed

    private void newKepemilikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newKepemilikanActionPerformed
        keranjangKepemilikan.setEditable(true);
        keranjangKepemilikan.setText("");
        pelangganKepemilikan.setText("");
        keranjangKepemilikan.requestFocus();
    }//GEN-LAST:event_newKepemilikanActionPerformed

    private void lastKepemilikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastKepemilikanActionPerformed
        try{
            resultSet=statement.executeQuery("select * from KepemilikanKeranjang");
            resultSet.last();
            keranjangKepemilikan.setText(resultSet.getString(1));
            pelangganKepemilikan.setText(resultSet.getString(2));
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lastKepemilikanActionPerformed

    private void prevKepemilikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevKepemilikanActionPerformed
        try{
            if(resultSet != null && !resultSet.isFirst()){
                resultSet.previous();
                keranjangKepemilikan.setText(resultSet.getString(1));
                pelangganKepemilikan.setText(resultSet.getString(2));
                
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_prevKepemilikanActionPerformed

    private void firstKepemilikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstKepemilikanActionPerformed
        try{
            resultSet=statement.executeQuery("select * from KepemilikanKeranjang");
            resultSet.first();
            keranjangKepemilikan.setText(resultSet.getString(1));
            pelangganKepemilikan.setText(resultSet.getString(2));
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_firstKepemilikanActionPerformed

    private void nextKepemilikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextKepemilikanActionPerformed
        try{
            if(resultSet != null && !resultSet.isLast()){
                resultSet.next();
                keranjangKepemilikan.setText(resultSet.getString(1));
                pelangganKepemilikan.setText(resultSet.getString(2));
                
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_nextKepemilikanActionPerformed

    private void cariKepemilikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariKepemilikanActionPerformed
        DefaultTableModel ob=(DefaultTableModel) tblKepemilikan.getModel();
        TableRowSorter<DefaultTableModel> obj=new TableRowSorter<>(ob);
        tblKepemilikan.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txtCariKepemilikan.getText()));
    }//GEN-LAST:event_cariKepemilikanActionPerformed

    private void reloadtblKepemilikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadtblKepemilikanActionPerformed
        txtCariKepemilikan.setText("");
        tblKepemilikan.setRowSorter(null);
    }//GEN-LAST:event_reloadtblKepemilikanActionPerformed

    private void btnKepemilikanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKepemilikanMouseClicked
        main.removeAll();
        main.repaint();
        main.revalidate();
        main.add(pnlKepemilikan);
        main.repaint();
        main.revalidate();
        populateAllKepemilikanFields();
    }//GEN-LAST:event_btnKepemilikanMouseClicked

    private void btnKepemilikanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKepemilikanMouseEntered
        btnKepemilikan.setBackground(new Color(82, 183, 136));
    }//GEN-LAST:event_btnKepemilikanMouseEntered

    private void btnKepemilikanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKepemilikanMouseExited
        btnKepemilikan.setBackground(new Color(45,106,79));
    }//GEN-LAST:event_btnKepemilikanMouseExited

    private void btnKepemilikanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKepemilikanMousePressed
        btnPegawai.setBackground(new Color(45,106,79));
        btnPelanggan.setBackground(new Color(45,106,79));
        btnProduk.setBackground(new Color(45,106,79));
        btnPesanan.setBackground(new Color(45,106,79));
        btnPengiriman.setBackground(new Color(45,106,79));
        btnKeranjang.setBackground(new Color(45,106,79));
        btnPromo.setBackground(new Color(45,106,79));
        btnOngkir.setBackground(new Color(45,106,79));
        btnMetode.setBackground(new Color(45,106,79));
        btnKepemilikan.setBackground(new Color(45,106,79));
    }//GEN-LAST:event_btnKepemilikanMousePressed

    private void btnKepemilikanMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKepemilikanMouseReleased
        btnKepemilikan.setBackground(new Color(82, 183, 136));
    }//GEN-LAST:event_btnKepemilikanMouseReleased

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        int option = JOptionPane.showConfirmDialog(this, "Yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
                    this.dispose(); 
                    new Login().setVisible(true); 
                }
            
    }//GEN-LAST:event_btnLogoutMouseClicked

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Admin().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnKepemilikan;
    private javax.swing.JPanel btnKeranjang;
    private javax.swing.JPanel btnLogout;
    private javax.swing.JPanel btnMetode;
    private javax.swing.JPanel btnOngkir;
    private javax.swing.JPanel btnPegawai;
    private javax.swing.JPanel btnPelanggan;
    private javax.swing.JPanel btnPengiriman;
    private javax.swing.JPanel btnPesanan;
    private javax.swing.JPanel btnProduk;
    private javax.swing.JPanel btnPromo;
    private javax.swing.JButton cancelKepemilikan;
    private javax.swing.JButton cancelKeranjang;
    private javax.swing.JButton cancelMetode;
    private javax.swing.JButton cancelOngkir;
    private javax.swing.JButton cancelPegawai;
    private javax.swing.JButton cancelPelanggan;
    private javax.swing.JButton cancelPengiriman;
    private javax.swing.JButton cancelPesanan;
    private javax.swing.JButton cancelProduk;
    private javax.swing.JButton cancelPromo;
    private javax.swing.JButton cariKepemilikan;
    private javax.swing.JButton cariKeranjang;
    private javax.swing.JButton cariMetode;
    private javax.swing.JButton cariOngkir;
    private javax.swing.JButton cariPegawai;
    private javax.swing.JButton cariPelanggan;
    private javax.swing.JButton cariPengiriman;
    private javax.swing.JButton cariPesanan;
    private javax.swing.JButton cariProduk;
    private javax.swing.JButton cariPromo;
    private javax.swing.JButton deleteKepemilikan;
    private javax.swing.JButton deleteKeranjang;
    private javax.swing.JButton deleteMetode;
    private javax.swing.JButton deleteOngkir;
    private javax.swing.JButton deletePegawai;
    private javax.swing.JButton deletePelanggan;
    private javax.swing.JButton deletePengiriman;
    private javax.swing.JButton deletePesanan;
    private javax.swing.JButton deleteProduk;
    private javax.swing.JButton deletePromo;
    private javax.swing.JButton editKepemilikan;
    private javax.swing.JButton editKeranjang;
    private javax.swing.JButton editMetode;
    private javax.swing.JButton editOngkir;
    private javax.swing.JButton editPegawai;
    private javax.swing.JButton editPelanggan;
    private javax.swing.JButton editPengiriman;
    private javax.swing.JButton editPesanan;
    private javax.swing.JButton editProduk;
    private javax.swing.JButton editPromo;
    private javax.swing.JTextField emailPegawai;
    private javax.swing.JTextField emailPelanggan;
    private javax.swing.JButton firstKepemilikan;
    private javax.swing.JButton firstKeranjang;
    private javax.swing.JButton firstMetode;
    private javax.swing.JButton firstOngkir;
    private javax.swing.JButton firstPegawai;
    private javax.swing.JButton firstPelanggan;
    private javax.swing.JButton firstPengiriman;
    private javax.swing.JButton firstPesanan;
    private javax.swing.JButton firstProduk;
    private javax.swing.JButton firstPromo;
    private javax.swing.JTextField gajiPegawai;
    private javax.swing.JTextField hargaProduk;
    private javax.swing.JTextField idKeranjang;
    private javax.swing.JTextField idMetode;
    private javax.swing.JTextField idOngkir;
    private javax.swing.JTextField idPegawai;
    private javax.swing.JTextField idPelanggan;
    private javax.swing.JTextField idPengiriman;
    private javax.swing.JTextField idPesanan;
    private javax.swing.JTextField idProduk;
    private javax.swing.JTextField idPromo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JScrollPane jScroll;
    private javax.swing.JScrollPane jScroll1;
    private javax.swing.JScrollPane jScroll10;
    private javax.swing.JScrollPane jScroll3;
    private javax.swing.JScrollPane jScroll4;
    private javax.swing.JScrollPane jScroll5;
    private javax.swing.JScrollPane jScroll6;
    private javax.swing.JScrollPane jScroll7;
    private javax.swing.JScrollPane jScroll8;
    private javax.swing.JScrollPane jScroll9;
    private javax.swing.JTextField jalanPegawai;
    private javax.swing.JTextField jalanPelanggan;
    private javax.swing.JTextField jalanPengiriman;
    private javax.swing.JTextField jumlahProduk;
    private javax.swing.JComboBox<String> kategoriProduk;
    private javax.swing.JComboBox<String> kelaminPegawai;
    private javax.swing.JComboBox<String> kelaminPelanggan;
    private javax.swing.JTextField keranjangKepemilikan;
    private javax.swing.JTextField keranjangPesanan;
    private javax.swing.JTextField kodePembayaran;
    private javax.swing.JTextField kotaPegawai;
    private javax.swing.JTextField kotaPelanggan;
    private javax.swing.JTextField kotaPengiriman;
    private javax.swing.JButton lastKepemilikan;
    private javax.swing.JButton lastKeranjang;
    private javax.swing.JButton lastMetode;
    private javax.swing.JButton lastOngkir;
    private javax.swing.JButton lastPegawai;
    private javax.swing.JButton lastPelanggan;
    private javax.swing.JButton lastPengiriman;
    private javax.swing.JButton lastPesanan;
    private javax.swing.JButton lastProduk;
    private javax.swing.JButton lastPromo;
    private javax.swing.JPanel main;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel masuk;
    private javax.swing.JTextField metodePesanan;
    private javax.swing.JTextField namaMetode;
    private javax.swing.JTextField namaPegawai;
    private javax.swing.JTextField namaPelanggan;
    private javax.swing.JTextField namaProduk;
    private javax.swing.JButton newKepemilikan;
    private javax.swing.JButton newKeranjang;
    private javax.swing.JButton newMetode;
    private javax.swing.JButton newOngkir;
    private javax.swing.JButton newPegawai;
    private javax.swing.JButton newPelanggan;
    private javax.swing.JButton newPengiriman;
    private javax.swing.JButton newPesanan;
    private javax.swing.JButton newProduk;
    private javax.swing.JButton newPromo;
    private javax.swing.JButton nextKepemilikan;
    private javax.swing.JButton nextKeranjang;
    private javax.swing.JButton nextMetode;
    private javax.swing.JButton nextOngkir;
    private javax.swing.JButton nextPegawai;
    private javax.swing.JButton nextPelanggan;
    private javax.swing.JButton nextPengiriman;
    private javax.swing.JButton nextPesanan;
    private javax.swing.JButton nextProduk;
    private javax.swing.JButton nextPromo;
    private javax.swing.JTextField ongkirPengiriman;
    private javax.swing.JTextField pegawaiPesanan;
    private javax.swing.JTextField pelangganKepemilikan;
    private javax.swing.JTextField pengirimanPesanan;
    private javax.swing.JPanel pnlKepemilikan;
    private javax.swing.JPanel pnlKeranjang;
    private javax.swing.JPanel pnlMetode;
    private javax.swing.JPanel pnlOngkir;
    private javax.swing.JPanel pnlPegawai;
    private javax.swing.JPanel pnlPelanggan;
    private javax.swing.JPanel pnlPengiriman;
    private javax.swing.JPanel pnlPesanan;
    private javax.swing.JPanel pnlProduk;
    private javax.swing.JPanel pnlPromo;
    private javax.swing.JComboBox<String> posisiPegawai;
    private javax.swing.JTextField potonganPromo;
    private javax.swing.JButton prevKepemilikan;
    private javax.swing.JButton prevKeranjang;
    private javax.swing.JButton prevMetode;
    private javax.swing.JButton prevOngkir;
    private javax.swing.JButton prevPegawai;
    private javax.swing.JButton prevPelanggan;
    private javax.swing.JButton prevPengiriman;
    private javax.swing.JButton prevPesanan;
    private javax.swing.JButton prevProduk;
    private javax.swing.JButton prevPromo;
    private javax.swing.JTextField produkKeranjang;
    private javax.swing.JTextField promoPesanan;
    private javax.swing.JTextField provOngkir;
    private javax.swing.JTextField provPegawai;
    private javax.swing.JTextField provPelanggan;
    private javax.swing.JTextField provPengiriman;
    private javax.swing.JButton reloadtblKepemilikan;
    private javax.swing.JButton reloadtblKeranjang;
    private javax.swing.JButton reloadtblMetode;
    private javax.swing.JButton reloadtblOngkir;
    private javax.swing.JButton reloadtblPegawai;
    private javax.swing.JButton reloadtblPelanggan;
    private javax.swing.JButton reloadtblPengiriman;
    private javax.swing.JButton reloadtblPesanan;
    private javax.swing.JButton reloadtblProduk;
    private javax.swing.JButton reloadtblPromo;
    private javax.swing.JTextField sandiPegawai;
    private javax.swing.JTextField sandiPelanggan;
    private javax.swing.JButton saveKepemilikan;
    private javax.swing.JButton saveKeranjang;
    private javax.swing.JButton saveMetode;
    private javax.swing.JButton saveOngkir;
    private javax.swing.JButton savePegawai;
    private javax.swing.JButton savePelanggan;
    private javax.swing.JButton savePengiriman;
    private javax.swing.JButton savePesanan;
    private javax.swing.JButton saveProduk;
    private javax.swing.JButton savePromo;
    private javax.swing.JPanel sitePanel;
    private javax.swing.JTextField statusPembayaran;
    private javax.swing.JComboBox<String> statusPengiriman;
    private javax.swing.JTextField stokProduk;
    private javax.swing.JTextField subTotal;
    private javax.swing.JTextField tanggalAwal;
    private javax.swing.JTextField tanggalBerakhir;
    private javax.swing.JTextField tanggalPengiriman;
    private javax.swing.JTextField tanggalPesanan;
    private javax.swing.JTextField tarifOngkir;
    private javax.swing.JTable tblKepemilikan;
    private javax.swing.JTable tblKeranjang;
    private javax.swing.JTable tblMetode;
    private javax.swing.JTable tblOngkir;
    private javax.swing.JTable tblPegawai;
    private javax.swing.JTable tblPelanggan;
    private javax.swing.JTable tblPengiriman;
    private javax.swing.JTable tblPesanan;
    private javax.swing.JTable tblProduk;
    private javax.swing.JTable tblPromo;
    private javax.swing.JTextField telpPegawai;
    private javax.swing.JTextField telpPelanggan;
    private javax.swing.JTextField terjualProduk;
    private javax.swing.JTextField totalHarga;
    private javax.swing.JTextField totalHargaBarang;
    private javax.swing.JTextField txtCariKepemilikan;
    private javax.swing.JTextField txtCariKeranjang;
    private javax.swing.JTextField txtCariMetode;
    private javax.swing.JTextField txtCariOngkir;
    private javax.swing.JTextField txtCariPegawai;
    private javax.swing.JTextField txtCariPelanggan;
    private javax.swing.JTextField txtCariPengiriman;
    private javax.swing.JTextField txtCariPesanan;
    private javax.swing.JTextField txtCariProduk;
    private javax.swing.JTextField txtCariPromo;
    private javax.swing.JTextField warnaProduk;
    // End of variables declaration//GEN-END:variables
}
