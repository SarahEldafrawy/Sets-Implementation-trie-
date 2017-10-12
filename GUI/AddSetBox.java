
package Assignment1.GUI;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AddSetBox extends GUI {
	
	private TextField inputsForSet;
	private Button closeButton;
	private Stage window;
	
    public AddSetBox() {
    	
        this.window = new Stage();

        window.setTitle("Creating new Set");
        window.setMaxWidth(750);
        window.setMaxHeight(650);

        Label label = new Label();
        label.setText("Add between each String a space ( )");
        label.setWrapText(true);
        GridPane.setConstraints(label, 0, 2);
        
        this.inputsForSet = new TextField();
        GridPane.setConstraints(this.inputsForSet, 0, 3);
        
        this.closeButton = new Button("Okay!");
        GridPane.setConstraints(this.closeButton, 0, 5);
        closeButton.setOnAction(e -> {
        	addSet(inputsForSet.getText());
    		window.close();
        });
        
        VBox layout = new VBox(5);
        layout.getChildren().addAll(label,this.inputsForSet, this.closeButton);
        layout.setPadding(new Insets(30, 30, 30, 30));
        layout.setSpacing(40);
        layout.setAlignment(Pos.CENTER);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        scene.getStylesheets().add(GUI.class.getResource("text.css").toExternalForm()); 

        window.setScene(scene);
        window.showAndWait();
    }  

}