package controller.model;

public class Quiz {

	Question[]question;

	public Question getQuestion(int i) {
		return question[i];
	}

	public void setQuestion(Question Question, int index) {
      question[index] = Question;
	}

	public Quiz(Question[] question) {
		super();
		this.question = question;
	}

	public Quiz() {
		super();
		
		question=new Question[5];	
		// TODO Auto-generated constructor stub
	} 
}
