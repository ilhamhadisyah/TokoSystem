package sample;

import com.jfoenix.controls.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;

public class mainPageController implements Initializable {
    public Tab katalogTab;
    public JFXTreeTableView tableViewKatalog;
    public AnchorPane detailPadPane;
    public Tab barangMasukTab;
    public Tab penjualanTab;
    public JFXButton exit;
    public JFXButton minimize;
    public JFXTextField itemNameForm;
    public JFXTextField noBatchForm;
    public JFXTextField suplierForm;
    public JFXDatePicker expDateForm;
    public JFXDatePicker JatuhTempoForm;
    public JFXSlider jumlahSlider;
    public JFXTextField jumlahForm;
    public Label clock;
    public JFXTextField inFilter;
    public JFXTextField katalogFilter;
    public JFXTextField tanggalSekarang;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AnchorPane detail = null;
        try {
            detail = FXMLLoader.load(getClass().getResource("detailObat.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        detailPadPane.getChildren().add(detail);

        TreeTableColumn IdCol = new TreeTableColumn("ID Item");
        TreeTableColumn namItemCol = new TreeTableColumn("Nama Item");
        TreeTableColumn expDateCol = new TreeTableColumn("Exp Date");
        tableViewKatalog.getColumns().addAll(IdCol,namItemCol,expDateCol);

        jumlahSlider.setMax(25);

       Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, event -> {
           LocalTime curent = LocalTime.now(); 
           LocalDate curentDate = LocalDate.now();
           Date date = new Date();

           tanggalSekarang.setText(curentDate.getDayOfMonth()+"/"+curentDate.getMonthValue()+"/"+curentDate.getYear());
           clock.setText(curent.getHour()+":"+curent.getMinute()+":"+curent.getSecond());
       }),
               new KeyFrame(Duration.seconds(1))
       );
       timeline.setCycleCount(Animation.INDEFINITE);
       timeline.play();


    }

    public void exitPress(ActionEvent actionEvent) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    public void minizePress(ActionEvent actionEvent) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.setIconified(true);
    }


    public void jumlahDragAct(MouseEvent mouseEvent) {
        int jumlah = (int)jumlahSlider.getValue();
        jumlahForm.setText(jumlah+"");
    }
}