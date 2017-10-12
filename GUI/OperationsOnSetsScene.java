package Assignment1.GUI;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class OperationsOnSetsScene {
	
	private Scene operationsScene; 
	private GridPane operationsGrid; 
	private VBox operationsVBox;
	private HBox operationsHBox;
	private ComboBox<Character> numberOfSetsFirst;
	private ComboBox<Character> numberOfSetsSecond;
	private ComboBox<String> operations;
	private Button doneButton;
	private Button returnButton;

	
	public OperationsOnSetsScene(ObservableList<Character> list) {
		
		this.numberOfSetsFirst = new ComboBox<Character>();
		this.numberOfSetsFirst.setItems(list);
	    this.numberOfSetsFirst.setValue('A');
		this.numberOfSetsSecond = new ComboBox<Character>();
	    this.numberOfSetsSecond.setItems(list);
		this.operations = new ComboBox<String>();
		this.operations.getItems().addAll("Intersection", "Union", "Complement");
		this.operations.setValue("Intersection");
		
		this.operationsVBox = new VBox(15);
		this.operationsHBox = new HBox(30);
		this.operationsGrid = new GridPane();
		this.doneButton = new Button("Done");
		this.returnButton = new Button("Return");
		setGrid();
		addElements();
	}

	private void setGrid() {
		this.operationsGrid.setPadding(new Insets(10, 10, 10, 10));
		this.operationsGrid.setAlignment(Pos.CENTER);
		this.operationsVBox.setPadding(new Insets(10, 10, 10, 10));
		this.operationsVBox.setAlignment(Pos.CENTER);	
		this.operationsScene = new Scene(this.operationsGrid, 650, 450);
		this.operationsHBox.setAlignment(Pos.BASELINE_CENTER);

	}
	
	private void addElements() {
		this.operationsGrid.getChildren().add(this.operationsVBox);
		this.operationsVBox.getChildren().addAll(this.numberOfSetsFirst, this.numberOfSetsSecond, this.operations, this.operationsHBox);
		this.operationsHBox.getChildren().addAll(this.doneButton, this.returnButton);

	}

	public Scene getScene() {
		return this.operationsScene;
		
	}
	
	public Button getDoneButton()
	{
		return this.doneButton;
	}
	public Button getReturnButton()
	{
		return this.returnButton;
	}
	
}
