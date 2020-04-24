package App;
import App.view.PopUp.tambahBarangPopUpController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("view/mainPage/mainPage.fxml"));
        primaryStage.setTitle("TokoSystem");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.setMaximized(true);
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
        //loadDriver loadDriver= new loadDriver();
        //loadDriver.connect();
        //loadDriver.addItem();
        //loadDriver.retrieveData();

    }
}
