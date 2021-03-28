package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;

public class OrderPageController extends MainMenuController{

    @FXML
    private ListView<String> orderHistory;

    @FXML
    private Button orderCancel;

    @FXML
    private MenuItem orderExport;
}
