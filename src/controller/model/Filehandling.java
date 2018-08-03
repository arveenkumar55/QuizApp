package controller.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Filehandling {

	 public static void file_write(Account account) 
	    {
		 
	      String Data=null;
	      
	       Data=account.getName();
	       Data=Data+","+account.getPassword();
	       Data=Data+","+account.getAddress();
	       Data=Data+","+account.getGender();

	      
	        BufferedWriter writer = null;
	    try {

	        writer = new BufferedWriter(new FileWriter("AccountInformation.txt",true));
	        
	          writer.write(Data);
	          writer.newLine();
	          writer.flush();
	        }      
	    
	      catch(IOException ex) {
	        ex.printStackTrace();
	    } 
	    finally{
	        if(writer!=null){
	            try {
	                writer.close();
	            } catch (IOException ex) {
	                System.out.println("input output error occur");
	            }
	        }  
	        
	    }

}
	public static String file_read(String name,String password)
	{
		String data=null;
		 String information=null;
			// TODO Auto-generated method stub
		        try {
		        
		        FileReader in;
		        in = new FileReader("AccountInformation.txt");
		        BufferedReader br = new BufferedReader(in);
		        String aLine =null; 
		        information="Invalid User ID or password";
		            while ((aLine = br.readLine()) != null) {
		                data=aLine;
		                String[]var=data.split(",");
		   			     

		                if(name.equals(var[0]))
		                {
		                	//data=" you have entered wrong password";
		                	if(password.equals(var[1]))
		                	{
		                		information="Successfully Login";
		                	}
		                }
		                
		            }
		             in.close();
		        }
		        catch (IOException ex) 
		        {
		            System.out.println("input output error occured");
		        }
				return information;

		}
	public static  void getQuiz(ArrayList<Integer> numbers, int initialValue, int finalValue, Quiz quiz) {
		{	// TODO Auto-generated method stub
			
		//System.out.print("come in function");
		//for(int i=0;i<numbers.size();i++)
		//{
			//System.out.print("number is "+numbers.get(i));
		//}
		
		

		String data=null;
		int count=0;
		int LineNo=0;
		// TODO Auto-generated method stub
	        try {
	        
	        FileReader in;
	        in = new FileReader("question.txt");
	        BufferedReader br = new BufferedReader(in);
	        String aLine =null; 
	        System.out.println("The intial value is "+initialValue);
	        System.out.println("The Final value is "+finalValue);
	      /*  for(int i=0;i<numbers.size();i++)
	        {
	        	System.out.println("The Number value is "+numbers.get(i));
	        }
	        */    while ((aLine = br.readLine()) != null) {
	            	
	            	LineNo=LineNo+1;
	           	
	            	
	               if(LineNo==numbers.get(initialValue) || LineNo==numbers.get(initialValue+1)|| LineNo==numbers.get(initialValue+2) || LineNo==numbers.get(initialValue+3) || LineNo==numbers.get(initialValue+4))
	               {  data=aLine;
	               
	               //System.out.println("The value is "+count);
	             //  System.out.println("The Line Value is "+ LineNo);

	               //System.out.println("The value is "+count); 
	                String question=null;
	        		String answer=null;
	        		String [] option=new String[4];
	        		Question  Question=new Question();
	                String[]var=data.split(",");
	   			     question=var[0];
	   			     option[0]=var[1];
	   			     option[1]=var[2];
	   			     option[2]=var[3];
	   			     option[3]=var[4];

	                  answer=var[5];
	                   Question.setQuestion(question);
	                   Question.setOption(option);
	                  Question.setAnswer(answer);
	                 quiz.setQuestion(Question, count);
	                 count=count+1;
	            }
	            }
	             in.close();
	        }
	        catch (IOException ex) 
	        {
	            System.out.println("input output error occured");
	        }
	        
		//quiz.setQuestion(Question);
	     //System.out.println(quiz.getQuestion(0).getQuestion());    
		 
	}

	}
}
	 

	 