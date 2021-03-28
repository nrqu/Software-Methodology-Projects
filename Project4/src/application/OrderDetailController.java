package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class OrderDetailController extends MainMenuController{

    @FXML
    private ListView<String> orderSummaryList;

    @FXML
    private TextField orderSubTotal;

    @FXML
    private TextField orderSaleTax;

    @FXML
    private TextField orderTotal;

    @FXML
    private Button orderRemoveItem;

    @FXML
    private Button orderPlaceOrder;
}
