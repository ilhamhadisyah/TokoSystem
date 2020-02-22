package App.view.barangMasuk;

import App.Model.abstractController;
import App.Model.itemObat;
import App.view.PopUp.tambahBarangPopUpController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class barangMasukController extends abstractController implements Initializable {
    public JFXButton tambahBarang;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    private itemObat showPopupWindow() {
        itemObat itemObat = new itemObat();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("App/view/PopUp/tambahBarangPopUp.fxml"));
        // initializing the controller
        tambahBarangPopUpController popupController = new tambahBarangPopUpController();
        //loader.setController(popupController);
        Parent layout;
        try {
            layout = loader.load();
            Scene scene = new Scene(layout);
            // this is the popup stage
            Stage popupStage = new Stage();
            // Giving the popup controller access to the popup stage (to allow the controller to close the stage)
            popupController.setStage(popupStage);
            if(this.main!=null) {
                popupStage.initOwner(main.getPrimaryStage());
            }
            popupStage.initModality(Modality.WINDOW_MODAL);
            popupStage.setScene(scene);
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

}
