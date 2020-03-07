package App.view.barangMasuk;

import App.Model.abstractController;
import App.Model.databaseModel;
import App.Model.itemObat;
import App.view.PopUp.tambahBarangPopUpController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.text.TabableView;
import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

public class barangMasukController extends abstractController implements Initializable {
    public Button tambahBarang;
    public TextField inFilter;
    public Button coba;
    public TableView barangMasukTable;
    public TableColumn idItem;
    public TableColumn namaItem;
    itemObat itemObat = new itemObat();
    public TableCell nama;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        barangMasukTable = new TableView();


    }

    private itemObat showPopupWindow() {

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
            if(this.main!=null) {
                popupStage.initOwner(main.getPrimaryStage());
            }
            popupStage.initModality(Modality.WINDOW_MODAL);
            popupStage.setScene(scene);
            popupStage.initStyle(StageStyle.UNDECORATED);
            popupStage.showAndWait();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return popupController.getResult();
    }

    public void jumlahDragAct(MouseEvent mouseEvent) {
    }

    public void tambahBarangClicked(ActionEvent actionEvent) {
        showPopupWindow();

    }

    public void cobaClick(ActionEvent actionEvent) {
        System.out.println(itemObat.namaItem);
        System.out.println(itemObat.getNoBatch());
        System.out.println(itemObat.getDiskon());
        System.out.println(itemObat.expDate);

    }
}
