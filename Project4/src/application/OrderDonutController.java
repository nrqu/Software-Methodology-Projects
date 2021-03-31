package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;

public class OrderDonutController extends MainMenuController{
	
	ArrayList listOfYeastDonuts = new ArrayList();
	YeastDonut yeastDonut;
	double newSubTotal = 0.0;

    @FXML
    private ComboBox<String> donutTypeDropDown;

    @FXML
    private ComboBox<String> donutFlavorDropDown;

    @FXML
    private TextArea donutSubtotal;

    @FXML
    private Button addDonut;

    @FXML
    private Button removeDonut;

    @FXML
    private Spinner<Integer> donutAmountSpinner;
    
    @FXML
    private ListView<String> donutOrderListView;
    
	ObservableList<String> donutTypes = FXCollections.observableArrayList("yeast donut", "cake donut", "donut holes");
    ObservableList<String> yeastDonutFlavors = FXCollections.observableArrayList("Chocolate-Glazed", "Black and White", "Meyer Lemon");
	ObservableList<String> cakeDonutFlavors = FXCollections.observableArrayList("Plain", "Vainalle-Glazed", "Baked Blueberry");
	ObservableList<String> donutHolestFlavors = FXCollections.observableArrayList("Chocolate Frosted", "Powdered", "Cinammon");
	
    @FXML
    void initialize() {
//    	donutTypeDropDown.setValue("yeast donut");	
    	donutTypeDropDown.setItems(donutTypes);
    	
    	
//    	donutFlavorDropDown.setValue("Chocolate-Glazed");
//    	donutFlavorDropDown.setItems(yeastDonutFlavors);
    	
    	SpinnerValueFactory<Integer> donutQuantity = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 5);
    	donutAmountSpinner.setValueFactory(donutQuantity);
    }
    
    @FXML
    void donutFlavorChangeOptions(ActionEvent event)
    {
		if (donutTypeDropDown.getValue().equals("cake donut")) {
			donutFlavorDropDown.setValue("Plain");
			donutFlavorDropDown.setItems(cakeDonutFlavors);

		} else if (donutTypeDropDown.getValue().equals("donut holes")) {
			donutFlavorDropDown.setValue("Chocolate Frosted");
			donutFlavorDropDown.setItems(donutHolestFlavors);
		} else {
			donutFlavorDropDown.setValue("Chocolate-Glazed");
			donutFlavorDropDown.setItems(yeastDonutFlavors);
		}
    	
    }
    
    void updateAddSubTotal() {
    	yeastDonut = new YeastDonut(donutAmountSpinner.getValue());
    	yeastDonut.calculateSubTotal();
    	double subTotal = yeastDonut.getSubTotal();
    	
    	newSubTotal += subTotal;
    	
    	System.out.println(newSubTotal);
    	
    	donutSubtotal.setText(String.valueOf(newSubTotal));
    }
    
    
    @FXML
    void addDonutButton(ActionEvent event) {
    	
		if (donutTypeDropDown.getValue() == null || donutFlavorDropDown.getValue() == null) {
			return;
		} else {
			donutOrderListView.getItems()
					.add(donutFlavorDropDown.getValue() + " (" + donutAmountSpinner.getValue() + ")");
			
			updateAddSubTotal();
		}
		
    }
    
    void updateRemoveSubTotal() {
    	
    }
    
    @FXML
    void removeDonutButton(ActionEvent event) {
    	
    	int selectedDonutOrder = donutOrderListView.getSelectionModel().getSelectedIndex();
    	
    	if (selectedDonutOrder != -1) {
    		donutOrderListView.getItems().remove(selectedDonutOrder);
    	}
    	
    }


 
    
    

    


}
