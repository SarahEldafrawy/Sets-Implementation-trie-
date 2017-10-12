package Assignment1.GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class AddSetsScene {

	private GridPane outputGrid;
	private HBox outputHBox;
	private Scene addSetsScene;
	private Label universeOutputLabel;
	private Button returnButton;
	private Button doneButton;
	private Button addSetButton;

	
	public AddSetsScene(String universeLabel)
	{
		this.returnButton = new Button("Return");
		this.doneButton = new Button("Done");
		this.doneButton.setDisable(true);
		this.addSetButton = new Button("Add new Set");
		this.universeOutputLabel = new Label(universeLabel);
		this.outputGrid = new GridPane();
		this.outputHBox = new HBox(30);
		setGrid();
		setCss();
		setLabelsOnGrid();
		addElements();
	}

	private void setGrid()
	{
		 this.outputGrid.setPadding(new Insets(20, 20, 20, 20));
		 this.outputGrid.setAlignment(Pos.BASELINE_CENTER);
		 this.outputGrid.setVgap(20);
		 this.outputGrid.setHgap(10);
		 this.outputHBox.setAlignment(Pos.BASELINE_CENTER);
		 this.addSetsScene = new Scene(this.outputGrid, 650, 550);
	}
	
	private void setLabelsOnGrid()
	{
		GridPane.setConstraints(this.universeOutputLabel, 1, 1);
	}
	
	private void addElements()
	{
		GridPane.setConstraints(this.outputHBox,1,8);
		this.outputHBox.getChildren().addAll(this.addSetButton,this.doneButton, this.returnButton);
		this.outputGrid.getChildren().addAll(this.outputHBox, this.universeOutputLabel);
	}
	
	public Scene getAddSetsScene()
	{
		return this.addSetsScene;
	}
	public void setLabel (String str) {
		this.universeOutputLabel.setText(str);
	}
	public Button getaddSetButton() {
		return addSetButton;
	}
	public Button getDoneButton()
	{
		return this.doneButton;
	}
	public Button getReturnButton()
	{
		return this.returnButton;
	}
	
	private void setCss()
	{
		this.outputGrid.getStylesheets().add(GUI.class.getResource("text.css").toExternalForm());
	}
}