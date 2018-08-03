package controller.model;

public class Question {

	String question;
	String []Option;
	String answer;
	public Question()
	{
		
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption(int i) {
		return Option[i];
	}
	public void setOption(String[] option) {
		Option = option;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public Question(String question, String[] option, String answer) {
		super();
		this.question = question;
		Option = option;
		this.answer = answer;
	}
	
	
	
}
