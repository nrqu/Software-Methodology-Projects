package application;

import java.io.File;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

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
    
	/**
	 * Exports a file into a text file
	 */
	@FXML
	void exportFile(ActionEvent event) {
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Open Target File for the Export");
		chooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"),
				new ExtensionFilter("All Files", "*.*"));
		Stage stage = new Stage();
		File targetFile = chooser.showSaveDialog(stage); // get the reference of the target file
		
		
		Alert a = new Alert(AlertType.CONFIRMATION);
		a.setTitle("CONFIRMATION");
		a.setHeaderText(storeOrders.exportDataBase(targetFile));
		a.showAndWait();
	}
    
 

    
}
