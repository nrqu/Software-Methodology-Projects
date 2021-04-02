package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SpinnerValueFactory;

public class OrderPageController{
	protected MainMenuController mainController;

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
    
    @FXML
    void cancelOrder(ActionEvent event) {
    	int selectedOrder = orderHistory.getSelectionModel().getSelectedIndex();
    	
    	if(selectedOrder != -1) {
    		storeOrders.remove(orderHistory.getItems().get(selectedOrder));
    		orderHistory.getItems().remove(selectedOrder);
    	}
    }
    
 

    
}
