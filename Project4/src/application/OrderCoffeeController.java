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
/**
 * Controller used to handle the Coffee GUI
 * 
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 *
 */
public class OrderCoffeeController{
    @FXML
    private ComboBox<String> coffeSizes;//coffee sizes available

    @FXML
    private CheckBox creamAddon;//cream addon in the coffee gui
    @FXML
    private CheckBox creamAddon2;//Whipped cream addon in the coffee gui
    @FXML
    private CheckBox syrupAddon;//Syrup addon in the coffee gui
    @FXML
    private CheckBox milkAddon;//milk addon in the coffee gui
    @FXML
    private CheckBox caramelAddon;//caramel addon in the coffee gui
    @FXML
    private TextArea subTotalPrice;//subtotal output box
    @FXML
    private TextArea orderInfo;//list of items ordered while the gui is opened
    
    
	ObservableList<String> coffeeSizesList = FXCollections.observableArrayList("Short", "Tall", "Grande","Venti");
	
	Coffee coffee;//coffee object used to represent each coffer order
	Order order;//order object that represents the current order
	/**
	 * method that gets called after constructor of the class. It is used to initialize items in the class
	 */
    @FXML 
    void initialize() {
    	coffeSizes.setItems(coffeeSizesList);
    	creamAddon.selectedProperty().addListener(addonChangeListenter);
    	creamAddon2.selectedProperty().addListener(addonChangeListenter);
    	syrupAddon.selectedProperty().addListener(addonChangeListenter);
    	milkAddon.selectedProperty().addListener(addonChangeListenter);
    	caramelAddon.selectedProperty().addListener(addonChangeListenter);
    	
    	coffee = new Coffee();
    	
    }
    /**
     * Listener used to check if a CheckBox event has occured
     */
    ChangeListener<Boolean> addonChangeListenter = new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> ov,
            Boolean old_val, Boolean new_val) {
            if (new_val || old_val) {
            	addAddon();
            }
        }};
        
    /*
     * Event handler used to check if a coffee size change has occurred
     */
    @FXML
    void coffeSizeEvent(ActionEvent event) {
        coffee.setCoffeeSize(coffeSizes.getSelectionModel().getSelectedIndex());
        addAddon();
        }
    /*
     * Used by the Main controller to get a reference of the data in the main controller in child stages
     */
    public void setMainController(MainMenuController controller) {
    	this.order = controller.getOrderReference();
    }
    /*
     * Event handler used to check if the add coffee to order button has been clicked.
     */
	@FXML
	void addCoffeeToOrder(ActionEvent event) {
		if(coffeSizes.getSelectionModel().getSelectedIndex() > -1) {
			if(order.add(coffee) ) {
				orderInfo.appendText(coffee+" " +"\n");
				coffee = new Coffee();
			    creamAddon.setSelected(false);
			    creamAddon2.setSelected(false);
			    syrupAddon.setSelected(false);
			    milkAddon.setSelected(false);
			    caramelAddon.setSelected(false);
			    coffeSizes.getSelectionModel().clearSelection();
			    subTotalPrice.clear();
			}
		}else
			orderInfo.appendText("Please select a coffee size\n");
	}
	/*
	 * changes the addons in the coffee every time the listener is triggered
	 */
	void addAddon() {
		if(coffeSizes.getSelectionModel().getSelectedIndex() > -1) {
		
			if(creamAddon.isSelected())
				coffee.add("Whipped Cream");
			else
				coffee.remove("Whipped Cream");
			
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
			if(creamAddon2.isSelected())
				coffee.add("Cream");
			else
				coffee.remove("Cream");
			
			subTotalPrice.clear();
			coffee.calculateSubTotal();
			subTotalPrice.appendText(String.format("%.2f",coffee.getSubTotal())+"\n");
		}
	}
	
    
}
