package application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;

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

}
