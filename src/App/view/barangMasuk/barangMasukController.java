package App.view.barangMasuk;
import App.Model.databaseModel;
import App.Model.abstractController;
import App.Model.barangMasukModel;
import App.view.PopUp.tambahBarangPopUpController;
import App.view.Toast;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

import java.sql.SQLException;
import java.util.ResourceBundle;

public class barangMasukController extends abstractController implements Initializable {
    public Button tambahBarang;
    public TextField inFilter;
    public Button coba;
    public TableView<barangMasukModel> barangMasukTable;

    private TableColumn IDCol = new TableColumn("ID Item");
    private TableColumn namaCol = new TableColumn("Nama Item");
    private TableColumn noFakturCol = new TableColumn("No Faktur");
    private TableColumn hargaSatuanCol = new TableColumn("Harga Satuan");
    private TableColumn diskonCol = new TableColumn("Diskon");
    private TableColumn totalHargaCol = new TableColumn("Total Harga");
    private TableColumn jumlahBarangCol = new TableColumn("Stok");
    private TableColumn jenisSediaanCol = new TableColumn("Jenis Sediaan");
    private TableColumn noBatchCol = new TableColumn("No Batch");
    private TableColumn suplierCol = new TableColumn("Suplier");
    private TableColumn expDateCol = new TableColumn("Exp Date");
    private TableColumn tglFakturCol = new TableColumn("Tanggal Faktur");
    private TableColumn jatuhTempoCol = new TableColumn("Jatuh Tempo");

    public static ObservableList<barangMasukModel> data = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadData();
        } catch (SQLException e) {
            Toast.show("Database Error !", null);
        }

        IDCol.setCellValueFactory(new PropertyValueFactory<barangMasukModel, String>("IDItem"));
        namaCol.setCellValueFactory(new PropertyValueFactory<barangMasukModel, String>("namaItem"));
        noFakturCol.setCellValueFactory(new PropertyValueFactory<barangMasukModel, String>("noFaktur"));
        hargaSatuanCol.setCellValueFactory(new PropertyValueFactory<barangMasukModel, Integer>("hargaSatuan"));
        diskonCol.setCellValueFactory(new PropertyValueFactory<barangMasukModel, Integer>("diskon"));
        jumlahBarangCol.setCellValueFactory(new PropertyValueFactory<barangMasukModel, Integer>("jumlahBarang"));
        jenisSediaanCol.setCellValueFactory(new PropertyValueFactory<barangMasukModel, String>("jenisSediaan"));
        noBatchCol.setCellValueFactory(new PropertyValueFactory<barangMasukModel, String>("noBatch"));
        suplierCol.setCellValueFactory(new PropertyValueFactory<barangMasukModel, String>("asalDistributor"));
        expDateCol.setCellValueFactory(new PropertyValueFactory<barangMasukModel, String>("expDate"));
        tglFakturCol.setCellValueFactory(new PropertyValueFactory<barangMasukModel, String>("tglFaktur"));
        jatuhTempoCol.setCellValueFactory(new PropertyValueFactory<barangMasukModel, String>("jatuhTempo"));
        totalHargaCol.setCellValueFactory(new PropertyValueFactory<barangMasukModel, String>("totalHarga"));
        barangMasukTable.getColumns().addAll(IDCol, namaCol, hargaSatuanCol,
                diskonCol, totalHargaCol, jumlahBarangCol, jenisSediaanCol, expDateCol, noFakturCol, noBatchCol,
                suplierCol, tglFakturCol, jatuhTempoCol);

        FilteredList<barangMasukModel> filteredData = new FilteredList<>(data, p -> true);
        inFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (person.getIDItem().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (person.getNamaItem().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (person.getAsalDistributor().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        SortedList<barangMasukModel> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(barangMasukTable.comparatorProperty());
        barangMasukTable.setItems(sortedData);


    }

    databaseModel databaseModel = new databaseModel();

    public void loadData() throws SQLException {
        data.clear();
        barangMasukTable.setItems(data);
        databaseModel.addBarangMasukData();
        barangMasukTable.setItems(data);


    }

    private void showPopupWindow() {//gunakan itemObat di tipenya
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("App/view/PopUp/tambahBarangPopUp.fxml"));
        // initializing the controller
        tambahBarangPopUpController popupController = new tambahBarangPopUpController();
        //loader.setController(popupController);
        Parent layout;
        try {
            layout = loader.load();
            Scene scene = new Scene(layout);
            Stage popupStage = new Stage();
            popupController.setStage(popupStage);
            if (this.main != null) {
                popupStage.initOwner(main.getPrimaryStage());
            }
            popupStage.initModality(Modality.WINDOW_MODAL);
            popupStage.setScene(scene);
            popupStage.initStyle(StageStyle.UNDECORATED);
            popupStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //return popupController.getResult();
    }

    public void jumlahDragAct(MouseEvent mouseEvent) {
    }

    public void tambahBarangClicked(ActionEvent actionEvent) {
        showPopupWindow();

    }


    public void cobaClick(ActionEvent actionEvent) {
        data.clear();
        barangMasukTable.setItems(data);
    }
}
