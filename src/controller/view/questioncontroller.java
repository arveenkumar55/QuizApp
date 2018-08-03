package controller.view;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import controller.model.Question;
import controller.model.Quiz;
import controller.Userlogin;
import controller.model.Filehandling;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class questioncontroller {
	Quiz quiz;
	String SelectedValue;
	int count=0;
	int score=0;
	static int Quizcounter=0;
	static int initialValue=0;
	static int finalValue=4;
	boolean cheat=false;
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    
    @FXML
    private Label Answermsgl;

    @FXML
    private Label Question;

    @FXML
    private RadioButton OptionA;

    @FXML
    private RadioButton OptionB;

    @FXML
    private RadioButton OptionC;

    @FXML
    private RadioButton OptionD;
    @FXML
    private Button nextButton;
    
    @FXML
	public void initialize()
	{
		
    	Quizcounter=Quizcounter+1;
    	
    	System.out.println("Quiz counter is "+ Quizcounter);
    	
    	
    	
		for(int i = 0; i < 20; i++)
	     {
	       numbers.add(i+1);
	     }
	 
	     Collections.shuffle(numbers);
		
	     
		quiz=new Quiz();
		 Filehandling.getQuiz(numbers,initialValue,finalValue,quiz);
		    
		 
		    
		    Question.setText(Integer.toString(count+1)+". "+quiz.getQuestion(count).getQuestion());
	    	OptionA.setText(quiz.getQuestion(count).getOption(0));
	    	OptionB.setText(quiz.getQuestion(count).getOption(1));
	    	OptionC.setText(quiz.getQuestion(count).getOption(2));
	    	OptionD.setText(quiz.getQuestion(count).getOption(3));
			
			initialValue=finalValue+1;
			finalValue=finalValue+4; 
		       
    	}
	

    public static int  getQuizCounter()
    {
    	return Quizcounter;
    }
   


	@FXML
    void handleOptionA(ActionEvent event) {
    	
    	SelectedValue=quiz.getQuestion(count).getOption(0);
    	OptionB.setSelected(false);
     	OptionC.setSelected(false);
     	OptionD.setSelected(false);

    }

    @FXML
    void handleOptionB(ActionEvent event) {

    	SelectedValue=quiz.getQuestion(count).getOption(1);
    	OptionA.setSelected(false);
     	OptionC.setSelected(false);
     	OptionD.setSelected(false);

    }

    @FXML
    void handleOptionC(ActionEvent event) {

    	SelectedValue=quiz.getQuestion(count).getOption(2);
    	OptionA.setSelected(false);
     	OptionB.setSelected(false);
     	OptionD.setSelected(false);

    }

    @FXML
    void handleOptionD(ActionEvent event) {

    	SelectedValue=quiz.getQuestion(count).getOption(3);
    	OptionA.setSelected(false);
     	OptionB.setSelected(false);
     	OptionC.setSelected(false);

    }

    @FXML
    void handlecheat(ActionEvent event) {

    	cheat=true;
    	Answermsgl.setText("Answer is :"+quiz.getQuestion(count).getAnswer());
    	
    }

    @FXML
    void handlenext(ActionEvent event) {
         
    	System.out.println(SelectedValue);
    	
    	if(!cheat)
    	{
    	if(SelectedValue.equals(quiz.getQuestion(count).getAnswer()))
    	{
    		score=score+1;
    	}
    	}
    	cheat=false;
    	count=count+1;
    	if(count==5)
    	{
    		ScoreCardController.SetScore(String.valueOf(score));
    	      loadFXML();	
    	}
    	else
    	{
    	OptionA.setSelected(false);
     	OptionB.setSelected(false);
     	OptionC.setSelected(false);
     	OptionD.setSelected(false);
    	Question.setText(Integer.toString(count+1)+". "+quiz.getQuestion(count).getQuestion());
    	OptionA.setText(quiz.getQuestion(count).getOption(0));
    	OptionB.setText(quiz.getQuestion(count).getOption(1));
    	OptionC.setText(quiz.getQuestion(count).getOption(2));
    	OptionD.setText(quiz.getQuestion(count).getOption(3));
		//count=count+1;
		System.out.println(String.valueOf(score));
		Answermsgl.setText(" ");
    	}
    }

    private void loadFXML() {
		// TODO Auto-generated method stub
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("ScoreCard.fxml"));
		AnchorPane login = null;
		try {
			login = (AnchorPane) loader.load();
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(login);
		Stage stg = Userlogin.getStage();
		if( stg != null){
			stg.setScene(scene);
			stg.show();
		}

		
	}


	@FXML
    void handleskip(ActionEvent event)
    {
    	count=count+1;
    	if(count==5)
    	{
    		ScoreCardController.SetScore(String.valueOf(score));
    	      loadFXML();	
    	}
    	else
    	{
    	OptionA.setSelected(false);
     	OptionB.setSelected(false);
     	OptionC.setSelected(false);
     	OptionD.setSelected(false);
    	Question.setText(Integer.toString(count+1)+". "+quiz.getQuestion(count).getQuestion());
    	OptionA.setText(quiz.getQuestion(count).getOption(0));
    	OptionB.setText(quiz.getQuestion(count).getOption(1));
    	OptionC.setText(quiz.getQuestion(count).getOption(2));
    	OptionD.setText(quiz.getQuestion(count).getOption(3));
		//count=count+1;
		System.out.println(String.valueOf(score));
		Answermsgl.setText(" ");

    	}
    }


}
