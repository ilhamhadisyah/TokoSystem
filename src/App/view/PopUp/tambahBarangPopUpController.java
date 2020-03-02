package App.view.PopUp;

import App.Model.itemObat;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class tambahBarangPopUpController implements Initializable {
    public TextField itemNameForm;
    public TextField noBatchForm;
    public TextField suplierForm;
    public DatePicker expDateForm;
    public DatePicker JatuhTempoForm;
    public Slider jumlahSlider;
    public TextField jumlahForm;
    public Button tambahDataBtn;
    public TextField hargaSatuan;
    public ComboBox jenisKesediaan;
    public TextField diskon;
    public DatePicker tanggalFaktur;
    public TextField noFaktur;
    public TextField kodeBarang;
    public Button backBtn;
    private Stage stage = null;
    private itemObat result = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        jenisKesediaan.getItems().addAll("1", "2");
        stage = new Stage();

    }

    public void jumlahDragAct(MouseEvent mouseEvent) {
    }



    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private void closeStage() {
        stage = (Stage) backBtn.getScene().getWindow();
        if(stage!=null) {
            stage.close();
        }
    }

    public itemObat getResult() {
        return result;
    }

    public void backBtnAction(ActionEvent actionEvent) {
        stage = (Stage) backBtn.getScene().getWindow();
        stage.close();
    }

    public void addBtnAction(ActionEvent actionEvent) {
        result = new itemObat();
        result.namaItem = itemNameForm.getText();
        result.noBatch = noBatchForm.getText();
        result.distributorAsal = suplierForm.getText();
        result.expDate = expDateForm.getValue();
        result.jatuhTempo = JatuhTempoForm.getValue();
        result.jumlahBarang = Integer.parseInt(jumlahForm.getText());
        result.hargaSatuan = Integer.parseInt(hargaSatuan.getText());
        result.diskon = Integer.parseInt(diskon.getText());
        result.tglFaktur = tanggalFaktur.getValue();
        result.totalHarga = Integer.parseInt(hargaSatuan.getText()) * Integer.parseInt(jumlahForm.getText());
        result.noFaktur = noFaktur.getText();
        result.kodeBarang = kodeBarang.getText();
        result.jenisSediaan = jenisKesediaan.getSelectionModel().getSelectedItem().toString();
        closeStage();

    }
}
