package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class OrderDetailController {
	private  MainMenuController mainController;

    @FXML
    private ListView<String> orderSummaryList;

    @FXML
    private TextField orderSubTotal;

    @FXML
    private TextField orderSaleTax;

    @FXML
    private TextField orderTotal;
	@FXML
	
	Order order;
	ArrayList<MenuItem> arr;

	
	
	
    public void setMainController(MainMenuController controller) {
    	this.mainController = controller;
    	this.order = controller.getOrderReference();
    	arr = order.getArr();
    	if(!arr.isEmpty()) {
	    	for(var a: arr) {
	    		orderSummaryList.getItems().add(a.toString());
	    	}
	    	setPrice();
    	}

    }
    @FXML
    void orderPlaceOrder(ActionEvent event) {
   
    }

    @FXML
    void orderRemoveItem(ActionEvent event) {
    	int selectedIndex = orderSummaryList.getSelectionModel().getSelectedIndex();
    	if(selectedIndex > -1 && !arr.isEmpty()) {
    		arr.remove(selectedIndex);
    		orderSummaryList.getItems().remove(selectedIndex);
    		setPrice();
    	}
    }
    void setPrice() {
    	double subtotal = 0;
    	double  taxes = 0;
    	double total=0;
    	for(var a : arr) {
    		subtotal+=a.getSubTotal();
    	}
    	if(subtotal > 0) {
    		taxes = subtotal * 0.06625;
    	}
    	total = subtotal + taxes;
    	
    	orderSubTotal.setText(subtotal+"");
    	orderSaleTax.setText(taxes+"");
    	orderTotal.setText(total+"");
    }
}
