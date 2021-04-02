package application;

import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;

public class OrderCoffeeController{
	private  MainMenuController mainController;
    @FXML
    private ComboBox<String> coffeSizes;

    @FXML
    private CheckBox creamAddon;

    @FXML
    private CheckBox syrupAddon;

    @FXML
    private CheckBox milkAddon;

    @FXML
    private CheckBox caramelAddon;


    @FXML
    private TextArea subTotalPrice;

    @FXML
    private TextArea orderInfo;
    
    
	ObservableList<String> coffeeSizesList = FXCollections.observableArrayList("Short", "Tall", "Grande","Venti");
	
	Coffee coffee;
	Order order;
    @FXML 
    void initialize() {
    	coffeSizes.setItems(coffeeSizesList);
    	creamAddon.selectedProperty().addListener(addonChangeListenter);
    	syrupAddon.selectedProperty().addListener(addonChangeListenter);
    	milkAddon.selectedProperty().addListener(addonChangeListenter);
    	caramelAddon.selectedProperty().addListener(addonChangeListenter);
    	
    	coffee = new Coffee();
    	
    }
    ChangeListener<Boolean> addonChangeListenter = new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> ov,
            Boolean old_val, Boolean new_val) {
            if (new_val || old_val)
            	addAddon();
        }};
        
    
        @FXML
        void coffeSizeEvent(ActionEvent event) {
        	coffee.setCoffeeSize(0);
        	coffee.setCoffeeSize(coffeSizes.getSelectionModel().getSelectedIndex());
        	addAddon();

        }
    public void setMainController(MainMenuController controller) {
    	this.mainController = controller;
    	this.order = controller.getOrderReference();
    }

	@FXML
	void addCoffeeToOrder(ActionEvent event) {
		if(coffeSizes.getSelectionModel().getSelectedIndex() > -1) {
			if(order.add(coffee) )
				orderInfo.appendText(coffee+" " +"\n");
		}else
			orderInfo.appendText("Please select a coffee size\n");
	}
	
	void addAddon() {
		subTotalPrice.clear();
		if(creamAddon.isSelected())
			coffee.add("Cream");
		else
			coffee.remove("Cream");
		if(syrupAddon.isSelected())
			coffee.add("Syrup");
		else
			coffee.remove("Syrup");
		if(milkAddon.isSelected())
			coffee.add("Milk");
		else 
			coffee.remove("Milk");
		if(caramelAddon.isSelected())
			coffee.add("Caramel");
		else 
			coffee.remove("Caramel");

			
		subTotalPrice.appendText(String.format("%,.2f",coffee.getPrice())+"\n");
	}
	
    
}
