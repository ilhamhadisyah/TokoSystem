package App.view.katalog;

import App.Model.databaseModel;
import App.Model.katalogModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class katalogController extends databaseModel implements Initializable {
    public TableView<katalogModel> tableViewKatalog;
    public TextField katalogFilter;

    private TableColumn IDCol = new TableColumn("ID Item");
    private TableColumn namaCol = new TableColumn("Nama Item");
    private TableColumn noFakturCol = new TableColumn("No Faktur");
    private TableColumn hargaSatuanCol = new TableColumn("Harga Satuan");
    private TableColumn jenisSediaanCol = new TableColumn("Jenis Sediaan");
    private TableColumn noBatchCol = new TableColumn("No Batch");
    private TableColumn suplierCol = new TableColumn("Suplier");
    private TableColumn expDateCol = new TableColumn("Exp Date");

    public static ObservableList<katalogModel> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        IDCol.setCellValueFactory(new PropertyValueFactory<katalogModel, String>("IDItem"));
        namaCol.setCellValueFactory(new PropertyValueFactory<katalogModel, String>("namaItem"));
        noFakturCol.setCellValueFactory(new PropertyValueFactory<katalogModel, String>("noFaktur"));
        hargaSatuanCol.setCellValueFactory(new PropertyValueFactory<katalogModel, Integer>("hargaSatuan"));
        jenisSediaanCol.setCellValueFactory(new PropertyValueFactory<katalogModel, String>("jenisSediaan"));
        noBatchCol.setCellValueFactory(new PropertyValueFactory<katalogModel, String>("noBatch"));
        suplierCol.setCellValueFactory(new PropertyValueFactory<katalogModel, String>("asalDistributor"));
        expDateCol.setCellValueFactory(new PropertyValueFactory<katalogModel, String>("expDate"));

        tableViewKatalog.getColumns().addAll(IDCol, namaCol, hargaSatuanCol,
                jenisSediaanCol, noFakturCol, noBatchCol, suplierCol, expDateCol);


        try {
            loadData();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        // 1. Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<katalogModel> filteredData = new FilteredList<>(data, p -> true);
        katalogFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getIDItem().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (person.getNamaItem().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (person.getAsalDistributor().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<katalogModel> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(tableViewKatalog.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tableViewKatalog.setItems(sortedData);
    }

    public void loadData() throws SQLException {
        //tableViewKatalog.getItems().clear();
        data.clear();
        tableViewKatalog.setItems(data);
        super.addKatalogData();
        tableViewKatalog.setItems(data);


    }
}
