package App.view.mainPage;

import com.jfoenix.controls.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;

public class mainPageController implements Initializable {

    public JFXButton exit;
    public JFXButton minimize;
    public Label clock;
    public JFXTextField tanggalSekarang;
    public AnchorPane leftPane;
    public JFXButton katalogTab;
    public JFXButton barangMasukTab;
    public JFXButton penjualanTab;
    public StackPane padPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

       Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, event -> {
           LocalTime curent = LocalTime.now(); 
           LocalDate curentDate = LocalDate.now();
           Date date = new Date();

           //tanggalSekarang.setText(curentDate.getDayOfMonth()+"/"+curentDate.getMonthValue()+"/"+curentDate.getYear());
           clock.setText(curent.getHour()+":"+curent.getMinute()+":"+curent.getSecond());
       }),
               new KeyFrame(Duration.seconds(1))
       );
       timeline.setCycleCount(Animation.INDEFINITE);
       timeline.play();
    }

    public void getKatalog() {
        padPane.getChildren().clear();
        AnchorPane katalog = null;
        try {
            katalog = FXMLLoader.load(getClass().getClassLoader().getResource("App/view/katalog/katalog.fxml"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        padPane.getChildren().add(katalog);
    }

    public void getBarangMasuk() {
        padPane.getChildren().clear();
        AnchorPane brgMasuk = null;
        try {
            brgMasuk = FXMLLoader.load(getClass().getClassLoader().getResource("App/view/barangMasuk/barangMasuk.fxml"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        padPane.getChildren().add(brgMasuk);
    }

    public void getPenjualan() {
        padPane.getChildren().clear();
        AnchorPane katalog = null;
        try {
            katalog = FXMLLoader.load(getClass().getClassLoader().getResource("App/view/penjualan/penjualan.fxml"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        padPane.getChildren().add(katalog);
    }

    public void exitPress(ActionEvent actionEvent) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }
    public void minizePress(ActionEvent actionEvent) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.setIconified(true);
    }


    public void katalogClicked(ActionEvent actionEvent) {
       getKatalog();
    }

    public void barangMasukClicked(ActionEvent actionEvent) {
        getBarangMasuk();
    }

    public void penjualanClicked(ActionEvent actionEvent) {
        getPenjualan();
    }
}