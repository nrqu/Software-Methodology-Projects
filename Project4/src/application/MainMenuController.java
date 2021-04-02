package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuController {
	
	StoreOrders storeOrders;
	Order order;
	
    @FXML 
    void initialize() {
    	storeOrders = new StoreOrders();
    	order = new Order();
    }
    
    @FXML
    private void openCoffeeOrderMenu(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OrderCoffeeView.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(root1)); 
			OrderCoffeeController coffeeController = fxmlLoader.getController();
			coffeeController.setMainController(this);
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
    @FXML
    void openOrderDetailMenu(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OrderDetailView.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(root1));  
			OrderDetailController orderController = fxmlLoader.getController();
			orderController.setMainController(this);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    @FXML
    void openOrderPageMenu(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OrderPageView.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(root1));
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    public Order getOrderReference() {
    	return order;
    }
    public StoreOrders getStoreOrderReference() {
    	return storeOrders;
    }
}
