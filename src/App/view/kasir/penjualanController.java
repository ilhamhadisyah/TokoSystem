package App.view.kasir;

import App.Model.databaseModel;
import App.Model.penjualanModel;
import App.view.Toast;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class penjualanController extends databaseModel implements Initializable {
    public TableView<penjualanModel> miniTable = new TableView<penjualanModel>();
    public TextField filterField;
    public TableView ringkasanItemTable;
    public TextField paymentField;
    public Label billLabel;
    public Label paymentLabel;
    public Label cashbackLabel;
    public Button deleteSelectedItem;
    public Label errorMessage;
    TableColumn id_barang = new TableColumn("ID Barang");
    TableColumn nama_barang = new TableColumn("Nama Barang");
    TableColumn harga_barang = new TableColumn("Harga Satuan");
    TableColumn stok = new TableColumn("Stok");

    TableColumn id_barang1 = new TableColumn("ID Barang");
    TableColumn nama_barang1 = new TableColumn("Nama Barang");
    TableColumn harga_barang1 = new TableColumn("Harga Satuan");
    TableColumn stok1 = new TableColumn("Jumlah Beli");

    AtomicInteger totalHarga = new AtomicInteger();
    int kembalian = 0;
    int pembayaran = 0;
    NumberFormat numberFormat = NumberFormat.getInstance();

    public static ObservableList<penjualanModel> data = FXCollections.observableArrayList();
    ObservableList<penjualanModel> ringkasanData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadData();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        numberFormat.setMinimumIntegerDigits(0);
        numberFormat.setGroupingUsed(true);

        /*
        Set column in left & right table
         */
        id_barang.setCellValueFactory(new PropertyValueFactory<penjualanModel, String>("idBarang"));
        nama_barang.setCellValueFactory(new PropertyValueFactory<penjualanModel, String>("namaBarang"));
        harga_barang.setCellValueFactory(new PropertyValueFactory<penjualanModel, String>("hargabarang"));
        stok.setCellValueFactory(new PropertyValueFactory<penjualanModel, String>("stok"));

        id_barang1.setCellValueFactory(new PropertyValueFactory<penjualanModel, String>("idBarang"));
        nama_barang1.setCellValueFactory(new PropertyValueFactory<penjualanModel, String>("namaBarang"));
        harga_barang1.setCellValueFactory(new PropertyValueFactory<penjualanModel, String>("hargabarang"));
        stok1.setCellValueFactory(new PropertyValueFactory<penjualanModel, String>("stok"));

        ringkasanItemTable.getColumns().addAll(id_barang1, nama_barang1, stok1, harga_barang1);

        miniTable.getColumns().addAll(id_barang, nama_barang, harga_barang, stok);

         /*
            add selected item in left table to right table
         */
        miniTable.setRowFactory(tv -> {

            TableRow<penjualanModel> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!row.isEmpty())) {
                    penjualanModel rowdata = row.getItem();
                    ringkasanData.add(new penjualanModel(rowdata.getIdBarang(), rowdata.getNamaBarang(), rowdata.getHargabarang(), 1));
                    ringkasanItemTable.setItems(ringkasanData);


                    totalHarga.addAndGet(rowdata.getHargabarang());
                    billLabel.setText(numberFormat.format(totalHarga));

                    kembalian = pembayaran - totalHarga.get();
                    cashbackLabel.setText(numberFormat.format(kembalian));
                }
            });
            return row;
        });

        // 1. Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<penjualanModel> filteredData = new FilteredList<>(data, p -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getIdBarang().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (person.getNamaBarang().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }
                return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<penjualanModel> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(miniTable.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        miniTable.setItems(sortedData);
    }

    public void loadData() throws SQLException {
        data.clear();
        miniTable.setItems(data);
        super.addStokData();
        miniTable.setItems(data);

    }

    public void showPayment(KeyEvent keyEvent) {
        pembayaran = Integer.parseInt(paymentField.getText());
        kembalian = pembayaran - totalHarga.get();

        paymentLabel.setText(numberFormat.format(pembayaran));
        cashbackLabel.setText(numberFormat.format(kembalian));
    }

    public void saveTransactionRecord(ActionEvent actionEvent) {
    }


    public void deleteSelectedItem(ActionEvent actionEvent) {
        try {
            penjualanModel pen = (App.Model.penjualanModel) ringkasanItemTable.getSelectionModel().getSelectedItem();
            int harga = pen.getHargabarang();
            totalHarga.addAndGet(-harga);
            kembalian = kembalian + harga;
            cashbackLabel.setText(numberFormat.format(kembalian));
            ringkasanItemTable.getItems().remove(pen);
            billLabel.setText(numberFormat.format(totalHarga));
        } catch (Exception e) {
            Toast.show("Pilih item yang akan dihapus !", deleteSelectedItem);
        }


    }
}
