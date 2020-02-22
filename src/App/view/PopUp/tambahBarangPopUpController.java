package App.view.PopUp;

import App.Model.itemObat;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class tambahBarangPopUpController implements Initializable {
    public JFXTextField itemNameForm;
    public JFXTextField noBatchForm;
    public JFXTextField suplierForm;
    public JFXDatePicker expDateForm;
    public JFXDatePicker JatuhTempoForm;
    public JFXSlider jumlahSlider;
    public JFXTextField jumlahForm;
    public JFXButton tambahDataBtn;
    public JFXTextField hargaSatuan;
    public JFXComboBox jenisKesediaan;
    public JFXTextField diskon;
    public JFXDatePicker tanggalFaktur;
    public JFXTextField noFaktur;
    public JFXTextField kodeBarang;
    private Stage stage=null;
    private itemObat result=null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        jenisKesediaan.getItems().addAll("1","2");


    }

    public void jumlahDragAct(MouseEvent mouseEvent) {
    }



    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private void closeStage() {
        if(stage!=null) {
            stage.close();
        }
    }

    public itemObat getResult() {
        return result;
    }

    public void backBtnAction(ActionEvent actionEvent) {
        this.stage.close();
    }

    public void addBtnAction(ActionEvent actionEvent) {

            result.clear();
            result.setNamaItem(itemNameForm.getText());
            result.setNoBatch(noBatchForm.getText());
            result.setDistributorAsal(suplierForm.getText());
            result.setExpDate(expDateForm.getValue());
            result.setJatuhTempo(JatuhTempoForm.getValue());
            result.setJumlahBarang(Integer.parseInt(jumlahForm.getText()));
            result.setHargaSatuan(Integer.parseInt(hargaSatuan.getText()));
            result.setDiskon(Integer.parseInt(diskon.getText()));
            result.setTglFaktur(tanggalFaktur.getValue());
            result.setTotalHarga(Integer.parseInt(hargaSatuan.getText())*Integer.parseInt(jumlahForm.getText()));
            result.setNoFaktur(noFaktur.getText());
            result.setKodeBarang(kodeBarang.getText());
            result.setJenisKesediaan(jenisKesediaan.getSelectionModel().getSelectedItem().toString());
            closeStage();

    }
}
