package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Class used as a controller for the main state in the GUI
 * 
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 *
 */
public class MainMenuController {
	
	StoreOrders storeOrders;
	Order order;
	/**
	 * method called after the constructor of the class used to initialize data
	 */
    @FXML 
    void initialize() {
    	storeOrders = new StoreOrders();
    	order = new Order();
    }
    /**
     * Creates a new stage representing the coffee GUI making the main stage its parent
     * @param ActionEvent
     */
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
    /**
     * Creates a new stage representing the donut GUI making the main stage its parent
     * @param ActionEvent
     */
    @FXML
    void openDonutOrderMenu(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OrderDonutView.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(root1));
			OrderDonutController donutController = fxmlLoader.getController();
			donutController.setMainController(this);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    /**
     * Creates a new stage representing the Order GUI making the main stage its parent
     * @param ActionEvent
     */
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
    /**
     * Creates a new stage representing the OrderStore GUI making the main stage its parent
     * @param ActionEvent
     */
    @FXML
    void openOrderPageMenu(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OrderPageView.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(root1));
			OrderPageController orderController = fxmlLoader.getController();
			orderController.setMainController(this);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    /**
     * returns a reference of the order object used to represent an order
     * @return Order Object
     */
    public Order getOrderReference() {
    	return order;
    }
    /**
     * returns a reference of the StoreObject object used to represent all the orders in the system
     * @return Order Object
     */
    public StoreOrders getStoreOrderReference() {
    	return storeOrders;
    }
    /**
     * Setter method used to change the Order object
     * @param New Order object
     */
    public void setOrderReference(Order order) {
    	this.order = order;
    }
}
