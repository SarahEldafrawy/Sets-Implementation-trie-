package Assignment1.GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class GUI extends Application implements EventHandler<ActionEvent> {
	
    WelcomeScene welcome;
    AddUniverseScene universeInput;
    AddSetsScene addSets;
    AddSetBox addBox;
    OperationsOnSetsScene operationsOnSets;
    
    private int numberOfSets;
    private int numberOfClicks;
    
    public static void main(String[] args) {
        launch(args);
    }
   
    @Override
    public void start(Stage window) {
    	
        window.setTitle("Sets Operations");        
        welcome = new WelcomeScene("Welcome !!\n\n"+" Let's start...\n\n");  
        universeInput = new AddUniverseScene("Insert Universe Elements:\n"+"*Add between each String a space ( )","Insert Number of Sets:");
        addSets = new AddSetsScene("blah");
        operationsOnSets = new OperationsOnSetsScene(null); // must be modified
        
        welcome.getManualButton().setOnAction(e -> window.setScene(universeInput.getManualScene()));
        welcome.getHelpButton().setOnAction(e -> 
        	HelpBox.display("Help Menu","Add text here")
        		);
        addSets.getaddSetButton().setOnAction(e -> {
        	numberOfClicks++;
        	if (numberOfClicks == numberOfSets) {
        		addSets.getaddSetButton().setDisable(true);
        		addSets.getDoneButton().setDisable(false);
        	}
        	addBox = new AddSetBox();
        });
        
       welcome.getExitButton().setOnAction(e -> {
    		   window.close();
       });
       universeInput.getSubmitButton().setOnAction(e-> {
    	   submit(universeInput.getMintermInput().getText(), universeInput.getNumberOfBitsInput().getValue());
    	   window.setScene(addSets.getAddSetsScene());
    	  
    	});
       universeInput.getReturnButton().setOnAction(e -> window.setScene(welcome.getScene()));
       addSets.getReturnButton().setOnAction(e->window.setScene(welcome.getScene()));
       operationsOnSets.getReturnButton().setOnAction(e->window.setScene(welcome.getScene()));

       addSets.getDoneButton().setOnAction(e->window.setScene(operationsOnSets.getScene()));
       operationsOnSets.getDoneButton().setOnAction(e-> AnsBox.display("Ans")); // parameter string with answer

       window.setScene(welcome.getScene());
       window.show();
    	
    }
    //public variable contains number of sets
	//loop to make the list for comboBox
    //REAL FUNCTION
    public void submit (String universe, Integer numOfSets) {
    	this.numberOfSets = numOfSets;
    	this.numberOfClicks = 0;
    	
    	addSets.setLabel(universe);
    }
    
    public void addSet (String str) {
    	
    	System.out.println(str);
    }

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
}
