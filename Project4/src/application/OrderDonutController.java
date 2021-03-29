package application;

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
import javafx.scene.input.MouseEvent;

public class OrderDonutController extends MainMenuController{

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
    
    @FXML
    void addDonutButton(ActionEvent event) {
    	donutOrderListView.getItems().add(donutFlavorDropDown.getValue());
    }

    


}
