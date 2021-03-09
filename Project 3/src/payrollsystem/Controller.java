package payrollsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class Controller {
	Company company = new Company();// Creates a new company instance to store employees
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
	// RadioButto objects for empType ToggleGroup
	private RadioButton FT, PT, Management;

	@FXML
	// RadioButto objects for FTtype ToggleGroup
	private RadioButton manager, headDpt, director;

	@FXML
	private Button addButton, removeButton, setHoursButton, clearButton;

	@FXML
	private MenuItem importFile, exportFile, printAll, printDept, printHired, calculatePayment;

	@FXML
	private TextArea messageArea;

	@FXML
	void disableFutureDates(MouseEvent event) {
		date.setDayCellFactory(param -> new DateCell() {
			@Override
			public void updateItem(LocalDate date, boolean empty) {
				super.updateItem(date, empty);
				setDisable(empty || date.compareTo(LocalDate.now()) > 0);
			}
		});

		date.setEditable(false);
	}

	@FXML
	void add(ActionEvent event) {
		try {
			String tmpDate = date.getValue().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
			RadioButton tmpDept = (RadioButton) dept.getSelectedToggle();
			String department = tmpDept.getText();

			if (PT.isSelected()) {
				if(checkNegativeValue(Float.parseFloat(Rate.getText())) != true)
				{
					Rate.clear();
					return;
				}
				
				parttime = new Parttime(new Profile(name.getText(), department, tmpDate),
						Float.parseFloat(Rate.getText()));

				if (company.add(parttime))
					messageArea.appendText("Employee added.\n");
				else
					messageArea.appendText("Employee is already in the list.\n");
			}

			if (FT.isSelected()) {
				if(checkNegativeValue(Float.parseFloat(AnnualSalary.getText())) != true)
				{
					AnnualSalary.clear();
					return;
				}
				
				fulltime = new Fulltime(new Profile(name.getText(), department, tmpDate),
						Float.parseFloat(AnnualSalary.getText()));

				if (company.add(fulltime))
					messageArea.appendText("Employee added.\n");
				else
					messageArea.appendText("Employee is already in the list.\n");
			}

			if (Management.isSelected()) {

				RadioButton tmpRole = (RadioButton) role.getSelectedToggle();
				String strRole = tmpRole.getText();
				int intRole = 0;

				if (strRole.compareTo("manager") == 0)
					intRole = 1;
				else if (strRole.compareTo("headDpt") == 0)
					intRole = 2;
				else if (strRole.compareTo("director") == 0)
					intRole = 3;
				
				if(checkNegativeValue(Integer.parseInt(AnnualSalary.getText())) != true) {
					AnnualSalary.clear();
					return;
				}

				management = new Management(new Profile(name.getText(), department, tmpDate),
						Integer.parseInt(AnnualSalary.getText()), intRole);

				if (company.add(management))
					messageArea.appendText("Employee added.\n");
				else
					messageArea.appendText("Employee is already in the list.\n");
			}
		} catch (Exception e) {
			messageArea.appendText("Invalid input!\n");
		}
	}

	@FXML
	void remove(ActionEvent event) {
		try {
			String tmpDate = date.getValue().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
			RadioButton tmpDept = (RadioButton) dept.getSelectedToggle();
			String department = tmpDept.getText();

			if (company.getNumEmployee() > 0) {
				if (company.remove(new Employee(new Profile(name.getText(), department, tmpDate)))) {
					messageArea.appendText("Employee removed.\n");
				} else {
					messageArea.appendText("Employee does not exist.\n");
				}
			} else {
				messageArea.appendText("Employee database is empty.\n");
			}
		} catch (Exception e) {
			messageArea.appendText("Invalid input!\n");
		}
	}

	@FXML
	void printAll(ActionEvent event) {
		if (company.getNumEmployee() > 0) {
			messageArea.appendText("--Printing earning statements for all employees--\n");
			for (int i = 0; i < company.getNumEmployee(); ++i) {
				messageArea.appendText(company.print(i) + "\n");
			}
		} else {
			messageArea.appendText("Employee database is empty.\n");
		}
	}

	@FXML
	void printDept(ActionEvent event) {
		if (company.getNumEmployee() > 0) {
			messageArea.appendText("--Print earning statements for all employees by department--\n");
			company.printByDepartment();
			for (int i = 0; i < company.getNumEmployee(); ++i) {
				messageArea.appendText(company.print(i) + "\n");
			}
		} else {
			messageArea.appendText("Employee database is empty.\n");
		}
	}

	@FXML
	void printHired(ActionEvent event) {
		if (company.getNumEmployee() > 0) {
			messageArea.appendText("--Print earning statements for all employees by date hired--\n");
			company.printByDate();
			for (int i = 0; i < company.getNumEmployee(); ++i) {
				messageArea.appendText(company.print(i) + "\n");
			}
		} else {
			messageArea.appendText("Employee database is empty.\n");
		}
	}

	@FXML
	void setHours(ActionEvent event) {
		try {
			if (checkHoursWorked(Integer.parseInt(HoursWorked.getText())) != true) {
				HoursWorked.clear();
			} else {
				String tmpDate = date.getValue().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
				RadioButton tmpDept = (RadioButton) dept.getSelectedToggle();
				String department = tmpDept.getText();
				parttime = new Parttime(new Profile(name.getText(), department, tmpDate),
						Integer.parseInt(HoursWorked.getText()));
				if (company.setHours(parttime))
					messageArea.appendText("Working hours set\n");
				else
					messageArea.appendText("Employee does not exist.\n");
			}
		} catch (NumberFormatException e) {
			if (company.getNumEmployee() == 0) {
				messageArea.appendText("Employee database empty.\n");
			}
		}
	}

	@FXML
	void calculatePayment(ActionEvent event) {
		if (company.getNumEmployee() > 0) {
			company.processPayments();
			messageArea.appendText("Calculation of employee payments is done.\n");
		} else {
			messageArea.appendText("Employee database is empty.\n");
		}
	}

	@FXML
	void clearTextFields(MouseEvent event) {
		name.clear();
		AnnualSalary.clear();
		HoursWorked.clear();
		Rate.clear();
		date.setValue(null);

	}

	@FXML
	void importFile(ActionEvent event) {
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Open Source File for the Import");
		chooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"),
				new ExtensionFilter("Text Files", "*.*"));
		Stage stage = new Stage();
		File sourceFile = chooser.showOpenDialog(stage); // get the reference of the source file
		try {

			Scanner scan = new Scanner(sourceFile);
			while (scan.hasNextLine()) {
				handleCommand(scan.nextLine());
				;
			}
			scan.close();

		} catch (FileNotFoundException e) {
			messageArea.appendText(e.toString());
		}
	}

	@FXML
	void exportFile(ActionEvent event) {
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Open Target File for the Export");
		chooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"),
				new ExtensionFilter("All Files", "*.*"));
		Stage stage = new Stage();
		File targetFile = chooser.showSaveDialog(stage); // get the reference of the target file

		messageArea.appendText(company.exportDataBase(targetFile));

	}

	void handleCommand(String command) {
		String[] tokens = command.split(",");
		switch (tokens[0]) {
		case "P":
			if (checkDepartment(tokens[2]) != true || checkNegativeValue(Float.parseFloat(tokens[4])) != true
					|| checkDate(tokens[3]) != true)
				break;

			parttime = new Parttime(new Profile(tokens[1], tokens[2], tokens[3]), Float.parseFloat(tokens[4]));

			if (company.add(parttime))
				messageArea.appendText("Employee added.\n");
			else
				messageArea.appendText("Employee is already in the list.\n");

			break;
		case "F":
			if (checkDepartment(tokens[2]) != true || checkNegativeValue(Float.parseFloat(tokens[4])) != true
					|| checkDate(tokens[3]) != true)
				break;

			fulltime = new Fulltime(new Profile(tokens[1], tokens[2], tokens[3]), Float.parseFloat(tokens[4]));
			if (company.add(fulltime))
				messageArea.appendText("Employee added.\n");
			else
				messageArea.appendText("Employee is already in the list.\n");

			break;

		case "M":
			if (checkDepartment(tokens[2]) != true || checkDate(tokens[3]) != true
					|| checkNegativeValue(Integer.parseInt(tokens[4])) != true
					|| checkRole(Integer.parseInt(tokens[5])) != true)
				break;

			management = new Management(new Profile(tokens[1], tokens[2], tokens[3]), Integer.parseInt(tokens[4]),
					Integer.parseInt(tokens[5]));

			if (company.add(management))
				messageArea.appendText("Employee added.\n");
			else
				messageArea.appendText("Employee is already in the list.\n");
			break;
		default:
			messageArea.appendText("Invalid Command!\n");

		}

	}

	@FXML
	void enableEmpTypeOptions(ActionEvent event) {
		if (FT.isSelected()) {
			HoursWorked.setDisable(true);
			Rate.setDisable(true);
			setHoursButton.setDisable(true);
			AnnualSalary.setDisable(false);
			manager.setDisable(true);
			headDpt.setDisable(true);
			director.setDisable(true);

		}

		if (PT.isSelected()) {
			AnnualSalary.setDisable(true);
			HoursWorked.setDisable(false);
			Rate.setDisable(false);
			setHoursButton.setDisable(false);
			manager.setDisable(true);
			headDpt.setDisable(true);
			director.setDisable(true);
		}

		if (Management.isSelected()) {
			manager.setDisable(false);
			headDpt.setDisable(false);
			director.setDisable(false);
			AnnualSalary.setDisable(false);
			setHoursButton.setDisable(true);
			Rate.setDisable(true);
			HoursWorked.setDisable(true);

		}
	}
	
	private boolean checkHoursWorked(int hoursWorked) {
		if (hoursWorked > 100) {
			messageArea.appendText("Invalid hours: over 100.\n");
			return false;
		} else if (hoursWorked < 0) {
			messageArea.appendText("Working hours cannot be negative.\n");
			return false;
		}
		return true;
	}

	/**
	 * The checkNegativeValue method receives a float value and checks if it is less
	 * than zero.
	 *
	 * @param value The value to be compared.
	 * @return true if the value is greater than zero. Otherwise, it returns false
	 *         and prints an error message.
	 */
	private boolean checkNegativeValue(float value) {
		if (value < 0) {
			messageArea.appendText("Pay rate cannot be negative.\n");
			return false;
		}
		return true;
	}

	/**
	 * The checkRole method receives an integer value and checks if it is a valid
	 * role.
	 *
	 * @param role The role of a full time employee.
	 * @return true if the value is in valid range. Otherwise, it returns false and
	 *         prints and error message.
	 */
	private boolean checkRole(int role) {
		if (role <= 0 || role > 3) {
			messageArea.appendText("Invalid management code.\n");
			return false;
		}
		return true;
	}

	/**
	 * The checkDate method receives a String object containing a date number.
	 *
	 * @param date The string date to be compared.
	 * @return true if the string contains a valid date. Otherwise, it returns false
	 *         and prints an error message.
	 */
	private boolean checkDate(String date) {
		Date dateObj = new Date(date);

		if (!(dateObj.isValid())) {
			messageArea.appendText(date + " is not a valid date.\n");
			return false;
		}
		return true;
	}

	/**
	 * The checkDeparment method receives a String object and checks whether or not
	 * it matches one of the valid department codes ("CS", "IT", "ECE).
	 *
	 * @param departmentCode String object holding a department code.
	 * @return true if the String passed matches to one of the department codes.
	 *         Otherwise, it returns false and prints an error message to the
	 *         console.
	 */
	private boolean checkDepartment(String departmentCode) {

		if (departmentCode.compareTo("CS") != 0 && departmentCode.compareTo("IT") != 0
				&& departmentCode.compareTo("ECE") != 0) {
			messageArea.appendText(departmentCode + " is not a valid department code.\n");
			return false;
		}

		return true;
	}
}