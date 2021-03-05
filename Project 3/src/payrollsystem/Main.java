package payrollsystem;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
    	BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("View.fxml"));
        primaryStage.getIcons().add(new Image("https://i.ibb.co/DGTHRP1/cat.png"));
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}