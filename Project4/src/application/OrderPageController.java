package application;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SpinnerValueFactory;

public class OrderPageController{

    @FXML
    private ListView<String> orderHistory;

    @FXML
    private Button orderCancel;

    @FXML
    private MenuItem orderExport;
    

}
