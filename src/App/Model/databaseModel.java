package App.Model;

import App.view.katalog.*;
import App.view.barangMasuk.*;
import App.view.kasir.*;
import App.view.laporanPenjualan.*;
import javafx.scene.control.Alert;

import javax.swing.*;
import java.sql.*;

public class databaseModel {
    String url = "jdbc:mysql://localhost:3306/apotik_farmarida?useTimezone=true&serverTimezone=UTC";
    String username = "root";
    String password = "";
    Connection con;
    Statement stmt;
    ResultSet rs;

    public void getConnection() {
        try {
            //Class.forName("com.mysql.jdbc.Driver"); jdbc:mysql://localhost:3306/jwdb?useTimezone=true&serverTimezone=UTC", "root", "admin")
            con = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Database Error", "Error", 00);
        } finally {
            if (con != null) {
                System.out.println("connected");
            }
        }
    }

    public void addKatalogData() throws SQLException {
        getConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT * FROM katalog");
        while (rs.next()) {
            //data.add();
            katalogController.data.add(new katalogModel(
                    rs.getString("id_barang"),
                    rs.getString("nama_barang"),
                    rs.getString("no_faktur"),
                    rs.getInt("harga_satuan"),
                    rs.getString("jenis_sediaan"),
                    rs.getString("no_batch"),
                    rs.getString("distributor"),
                    rs.getString("exp_date")));

        }
        //return data;
        stmt.close();
        con.close();
    }

    public void addBarangMasukData() throws SQLException {
        getConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT * FROM barang_masuk");
        while (rs.next()) {
            barangMasukController.data.add(new barangMasukModel(
                    rs.getString("id_barang"),
                    rs.getString("nama_barang"),
                    rs.getString("no_faktur"),
                    rs.getInt("harga_barang"),
                    rs.getInt("jumlah_barang"),
                    rs.getString("jenis_sediaan"),
                    rs.getString("no_batch"),
                    rs.getString("distributor"),
                    rs.getInt("diskon"),
                    rs.getString("exp_date"),
                    rs.getString("tanggal_faktur"),
                    rs.getString("jatuh_tempo"),
                    rs.getInt("total_harga")
            ));
        }
        stmt.close();
        con.close();
    }

    public void addStokData() throws SQLException {
        getConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT * FROM stok");
        while (rs.next()) {
            penjualanController.data.add(new penjualanModel(
                    rs.getString("id_barang"),
                    rs.getString("nama_barang"),
                    rs.getInt("harga_satuan"),
                    rs.getInt("stok")
            ));
        }
        stmt.close();
        con.close();
    }

    public void addHistoryData() throws SQLException {
        getConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT * FROM riwayat_penjualan");
        while (rs.next()) {
            laporanPenjualanController.data.add(new laporanModel(
                    rs.getInt("id_pelanggan"),
                    rs.getString("tanggal_pembelian"),
                    rs.getInt("total_harga"),
                    rs.getString("barang_dibeli")
            ));
        }
        stmt.close();
        con.close();
    }


    public static void main(String[] args) throws SQLException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        databaseModel databaseModel = new databaseModel();
        //databaseModel.getConnection();
        //databaseModel.addStokData();
        //alert.showAndWait();


    }
}
