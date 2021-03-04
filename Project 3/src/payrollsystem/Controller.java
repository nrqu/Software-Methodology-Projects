package payrollsystem;

import java.io.File;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class Controller {
	Company company = new Company();//Creates a new company instance to store employees
	Fulltime fulltime; // instance used to store full time employees
	Parttime parttime;// instance used to store part time employees
	Management management;// instance used to store management employees

	@FXML
	private DatePicker date;
	
	@FXML
	private TextField name, AnnualSalary, HoursWorked, Rate;

	@FXML
	private ToggleGroup dept, empType, role;

	@FXML
	// RadioButto objects for dept ToggleGroup
	private RadioButton IT, ECE, CS;

	@FXML
	//RadioButto objects for empType ToggleGroup
	private RadioButton FT, PT, Management;

	@FXML
	//RadioButto objects for FTtype ToggleGroup
	private RadioButton manager, headDpt, director;

	@FXML
	private Button addButton, removeButton, setHoursButton, clearButton;

	@FXML
	private MenuItem importFile, exportFile, printAll, printDept, printHired, calculatePayment;

	@FXML
	private TextArea messageArea;


    @FXML
    void add(ActionEvent event) {
    	String tmpDate = date.getValue().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    	RadioButton tmpDept = (RadioButton) dept.getSelectedToggle();
    	String department = tmpDept.getText();
    
    	if(PT.isSelected()) {
    		parttime = new Parttime(new Profile(name.getText(), department, tmpDate), Float.parseFloat(Rate.getText()));
    	}
    	// JUST FOR DEBUG
    	messageArea.setText(parttime.toString());
    	

    }
    
    @FXML
    void enableEmpTypeOptions(ActionEvent event) {
    	if(FT.isSelected()) {
    		HoursWorked.setDisable(true);
    		Rate.setDisable(true);
    		setHoursButton.setDisable(true);
    		AnnualSalary.setDisable(false);

    	} 


    	if(PT.isSelected()) {
    		AnnualSalary.setDisable(true);
    		HoursWorked.setDisable(false);
    		Rate.setDisable(false);
    		setHoursButton.setDisable(false);
    	}
    	
    	if(Management.isSelected()) {
    		manager.setDisable(false);
    		headDpt.setDisable(false);
    		director.setDisable(false);
    		AnnualSalary.setDisable(false);
    		setHoursButton.setDisable(true);
    		Rate.setDisable(true);
    		HoursWorked.setDisable(true);

    	}
    }
}