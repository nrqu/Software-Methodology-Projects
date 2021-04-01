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

public class OrderDonutController extends MainMenuController {

	YeastDonut yeastDonut;
	CakeDonut cakeDonut;
	DonutHoles donutHoles;
	Donut donuts;

	double subTotal = 0.0;

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
	private ListView<Donut> donutOrderListView;

	ObservableList<String> donutTypes = FXCollections.observableArrayList("yeast donut", "cake donut", "donut holes");
	ObservableList<String> yeastDonutFlavors;
	ObservableList<String> cakeDonutFlavors;
	ObservableList<String> donutHolestFlavors;

	@FXML
	void initialize() {

		yeastDonut = new YeastDonut();
		cakeDonut = new CakeDonut();
		donutHoles = new DonutHoles();

		yeastDonutFlavors = FXCollections.observableArrayList(yeastDonut.getList());
		cakeDonutFlavors = FXCollections.observableArrayList(cakeDonut.getList());
		donutHolestFlavors = FXCollections.observableArrayList(donutHoles.getList());
		donutTypeDropDown.setItems(donutTypes);

		SpinnerValueFactory<Integer> donutQuantity = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
		donutAmountSpinner.setValueFactory(donutQuantity);
	}

	@FXML
	void donutFlavorChangeOptions(ActionEvent event) {
		if (donutTypeDropDown.getValue().equals("yeast donut")) {
			donutFlavorDropDown.setValue(yeastDonutFlavors.get(0));
			donutFlavorDropDown.setItems(yeastDonutFlavors);
		} else if (donutTypeDropDown.getValue().equals("cake donut")) {
			donutFlavorDropDown.setValue(cakeDonutFlavors.get(0));
			donutFlavorDropDown.setItems(cakeDonutFlavors);
		} else if (donutTypeDropDown.getValue().equals("donut holes")) {
			donutFlavorDropDown.setValue(donutHolestFlavors.get(0));
			donutFlavorDropDown.setItems(donutHolestFlavors);
		}
	}

	void updateAddSubTotal() {
		if (donutTypeDropDown.getValue().equals("yeast donut")) {
			yeastDonut = new YeastDonut(donutAmountSpinner.getValue());
			yeastDonut.calculateSubTotal();
			subTotal += yeastDonut.getSubTotal();;
			
		} else if (donutTypeDropDown.getValue().equals("cake donut")) {
			cakeDonut = new CakeDonut(donutAmountSpinner.getValue());
			cakeDonut.calculateSubTotal();
			subTotal += cakeDonut.getSubTotal();
		} else if (donutTypeDropDown.getValue().equals("donut holes")) {
			donutHoles = new DonutHoles(donutAmountSpinner.getValue());
			donutHoles.calculateSubTotal();
			subTotal += donutHoles.getSubTotal();
		}
		donutSubtotal.setText(String.format("%,.2f", subTotal));
	}

	@FXML
	void addDonutButton(ActionEvent event) {

		if (donutTypeDropDown.getValue() == null || donutFlavorDropDown.getValue() == null) {
			return;
		} else {
			donuts = new Donut(donutTypeDropDown.getValue(), donutFlavorDropDown.getValue(),
					donutAmountSpinner.getValue());
			donutOrderListView.getItems().add(donuts);

			updateAddSubTotal();
		}

	}

	@FXML
	void removeDonutButton(ActionEvent event) {

		int selectedDonutOrder = donutOrderListView.getSelectionModel().getSelectedIndex();

		if (selectedDonutOrder != -1) {
			Donut donut = donutOrderListView.getItems().get(selectedDonutOrder);
			if (donut.getDonutType().equals("yeast donut")) {
				subTotal -= yeastDonut.getSubTotal();
			} else if (donut.getDonutType().equals("cake donut")) {
				subTotal -= cakeDonut.getSubTotal();
			} else if (donut.getDonutType().equals("donut holes")) {
				subTotal -= donutHoles.getSubTotal();
			}
			
			donutSubtotal.setText(String.format("%,.2f", subTotal));
			donutOrderListView.getItems().remove(selectedDonutOrder);
		}
	}
}
