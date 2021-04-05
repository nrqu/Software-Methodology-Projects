package application;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
/**
 * This class is used as the donut GUI controller for the stage created by the the MainMenuController class.
 * 
 * 
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 *
 */
public class OrderDonutController {

	YeastDonut yeastDonut;
	CakeDonut cakeDonut;
	DonutHoles donutHoles;
	Donut donuts;
	Order order;

	double subTotal = 0.0;
	int count = 0;

	protected MainMenuController mainController;

	@FXML
	private ComboBox<String> donutTypeDropDown;

	@FXML
	private ComboBox<String> donutFlavorDropDown;

	@FXML
	private TextArea donutSubtotal;

	@FXML
	private Spinner<Integer> donutAmountSpinner;

	@FXML
	private ListView<Donut> donutOrderListView;

	ObservableList<String> donutTypes = FXCollections.observableArrayList("yeast donut", "cake donut", "donut holes");
	ObservableList<String> yeastDonutFlavors;
	ObservableList<String> cakeDonutFlavors;
	ObservableList<String> donutHolestFlavors;

	/**
	 * It initializes corresponding variables.
	 */

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

	/**
	 * Gets the an order reference from the main controller.
	 */

	public void setMainController(MainMenuController controller) {
		this.mainController = controller;
		this.order = controller.getOrderReference();
	}

	/**
	 * It changes the donut flavors corresponding to each donut type.
	 */

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

	/**
	 * It updates the subtotal when any type of donut is added to the order list.
	 */

	void updateAddSubTotal() {
		if (donutTypeDropDown.getValue().equals("yeast donut")) {
			yeastDonut = new YeastDonut(donutAmountSpinner.getValue());
			yeastDonut.calculateSubTotal();
			subTotal += yeastDonut.getSubTotal();
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

	/**
	 * It adds a Donut object to the listView, updates the count variable when a
	 * Donut object, and calls the updateAddSubTotal method.
	 */

	@FXML
	void addDonutButton(ActionEvent event) {

		if (donutTypeDropDown.getValue() == null || donutFlavorDropDown.getValue() == null) {
			return;
		} else {
			double donutBasePrice = 0.0;
			if (donutTypeDropDown.getValue().equals("yeast donut")) {
				donutBasePrice = yeastDonut.getBasePrice();
			} else if (donutTypeDropDown.getValue().equals("cake donut")) {
				donutBasePrice = cakeDonut.getBasePrice();
			} else if (donutTypeDropDown.getValue().equals("donut holes")) {
				donutBasePrice = donutHoles.getBasePrice();
			}
			donuts = new Donut(donutTypeDropDown.getValue(), donutFlavorDropDown.getValue(),
					donutAmountSpinner.getValue(), donutBasePrice);
			donuts.calculateSubTotal();
			donutOrderListView.getItems().add(donuts);
			count++;

			updateAddSubTotal();
		}

	}

	/**
	 * It removes a Donut object from the listView, updates the count and subtotal
	 * variable depending on the Donut object removed.
	 */

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
			count--;
		}
	}

	/**
	 * It adds any Donut object on the listView to the Order Object.
	 */

	@FXML
	void addToOrder(ActionEvent event) {
		Alert alert;

		if (donutOrderListView.getItems().isEmpty() != true) {
			alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation");
			alert.setHeaderText("Donuts Added to Your Order!");
			alert.setContentText("Enjoy!");
			alert.showAndWait();

			for (int i = 0; i < count; i++) {
				Donut d = donutOrderListView.getItems().get(i);
				order.add(d);
			}

			// Reset global variables, listView, and subTotal text area.
			donutOrderListView.getItems().clear();
			donutSubtotal.clear();
			count = 0;
			subTotal = 0.0;
		} else {
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning!");
			alert.setHeaderText("Order List Empty!");
			alert.setContentText("Try adding some donuts to your order!");
			alert.showAndWait();
		}
	}

}
