package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainMenuController {
    @FXML
    private ImageView orderDonuts;

    @FXML
    private void openCoffeeOrderMenu(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OrderCoffeeView.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(root1));  
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void openDonutOrderMenu(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OrderDonutView.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(root1));  
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
}
