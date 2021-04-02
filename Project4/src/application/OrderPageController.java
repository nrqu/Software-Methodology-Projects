package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SpinnerValueFactory;

public class OrderPageController{
	private  MainMenuController mainController;

    @FXML
    private ListView<Order> orderHistory;

    @FXML
    private Button orderCancel;

    @FXML
    private MenuItem orderExport;
    
	StoreOrders storeOrders;

    
    public void setMainController(MainMenuController controller) {
    	this.mainController = controller;
    	this.storeOrders = controller.getStoreOrderReference();
    	ArrayList<Order> arr = storeOrders.getArr();
    	
    	if(!arr.isEmpty()) {
	    	for(var a: arr) {
	    		orderHistory.getItems().add(a);
	    	}
    	}
    }
}
