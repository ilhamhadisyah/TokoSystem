package App.view.laporanPenjualan;

import App.Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class laporanPenjualanController extends databaseModel implements Initializable {
    public TableView tableRingkasan;
    public TextField katalogFilter;

    private TableColumn idPelanggan = new TableColumn("ID Pelanggan");
    private TableColumn tanggalBeli = new TableColumn("Tanggal Transaksi");
    private TableColumn totalharga = new TableColumn("Total Harga");
    private TableColumn barangYangDibeli = new TableColumn("Barang yang Dibeli");

    public static ObservableList<laporanModel> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            addDataToTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        idPelanggan.setCellValueFactory(new PropertyValueFactory<laporanModel, Integer>("idPelanggan"));
        tanggalBeli.setCellValueFactory(new PropertyValueFactory<laporanModel, String>("tanggalPembelian"));
        totalharga.setCellValueFactory(new PropertyValueFactory<laporanModel, Integer>("totalHargaBeli"));
        barangYangDibeli.setCellValueFactory(new PropertyValueFactory<laporanModel, String>("barangDibeli"));

        tableRingkasan.getColumns().addAll(idPelanggan, tanggalBeli, totalharga, barangYangDibeli);

    }

    databaseModel databaseModel = new databaseModel();

    public void addDataToTable() throws SQLException {
        data.clear();
        tableRingkasan.setItems(data);
        databaseModel.addHistoryData();
        tableRingkasan.setItems(data);
    }

}
