package Assignment1.GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;

public class AddUniverseScene {
	
	private GridPane manualGrid;
	private Scene manualScene;
	private Button submitButton;
	private Button returnButton;
	private Label mintermLabel;
	private Label numberOfBitslabel;
	private TextField mintermInput;
	private ComboBox<Integer> numberOfBitsInput;
	
	public AddUniverseScene(String Universe, String numberOfBitsLabel)
	{
		this.mintermLabel = new Label(Universe);
		this.numberOfBitslabel = new Label(numberOfBitsLabel);
		this.mintermInput = new TextField();
		this.numberOfBitsInput = new ComboBox<>();
		this.submitButton = new Button("Submit");
		this.returnButton = new Button("Return");
		this.manualGrid = new GridPane();
        setGrid();
        setButtonsOnGrid();
        setLabelsOnGrid();
        setTextFieldsOnGrid();
        setComboBoxOnGrid();
        setCss();
        addElements();
	}
	
	private void setGrid()
	{
		this.manualGrid.setPadding(new Insets(10, 10, 10, 10));
		this.manualGrid.setAlignment(Pos.BASELINE_CENTER);
		this.manualGrid.setVgap(20);
		this.manualGrid.setHgap(20);
		this.manualScene = new Scene(this.manualGrid, 650, 450);
	}
	
	private void setButtonsOnGrid()
	{
		GridPane.setConstraints(this.submitButton, 3, 7);
		GridPane.setConstraints(this.returnButton, 5, 7);
	}
	
	private void setLabelsOnGrid()
	{
		GridPane.setConstraints(this.mintermLabel, 3, 1);
		this.mintermLabel.setTextAlignment(TextAlignment.JUSTIFY);
		GridPane.setConstraints(this.numberOfBitslabel,3,5);
	}
	
	private void setTextFieldsOnGrid()
	{
		GridPane.setConstraints(this.mintermInput, 3, 2);
	}
	
	private void setComboBoxOnGrid()
	{
		 this.numberOfBitsInput.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
		 this.numberOfBitsInput.setValue(2);
		 GridPane.setConstraints(this.numberOfBitsInput, 4, 5);
	}

	private void addElements()
	{
		 this.manualGrid.getChildren().addAll(this.mintermLabel, this.numberOfBitslabel, this.mintermInput, this.numberOfBitsInput, this.submitButton, this.returnButton);        
	}
	
	public Scene getManualScene() {
		return this.manualScene;
	}

	public Button getSubmitButton() {
		return this.submitButton;
	}
	
	public Button getReturnButton() {
		return this.returnButton;
	}
	
	public GridPane getManualGrid() {
		return manualGrid;
	}

	public TextField getMintermInput() {
		return mintermInput;
	}

	public ComboBox<Integer> getNumberOfBitsInput() {
		return numberOfBitsInput;
	}
	
	private void setCss()
	{
		this.manualGrid.getStylesheets().add(GUI.class.getResource("text.css").toExternalForm());
	}
}