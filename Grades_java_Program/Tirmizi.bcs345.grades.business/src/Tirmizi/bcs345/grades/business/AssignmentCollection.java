//*********************************************************************
//Author:Atif Tirmizi
//File:AssignmentCollection
//Function: TO implemet the methods of the project to 
//be later used in the program
//
//
//Professor: Arthur Hoskey
//***********************************************************************
/**
 * Main package for this assignment. This is where all member variables and methods are defined
 */
package Tirmizi.bcs345.grades.business;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Scanner;

//Have the AssignmentCollection class implement the Iterable interface.
/**
 * Contains main program code. 
 * 
 * 
 * @author Atif Tirmizi
 * @version 1.0
 * @since 12/1/2015
 *
*/
public class AssignmentCollection implements Iterable<Assignment> {
    
//Creating the Assignment data type as well as the variable for it.
Assignment[] Assignments;
	
	private int Assignmentcount = 0;
	private String Name = "";
	private double Grade = 0;
	private String Category = "";
	
	
	//default constructor
	public AssignmentCollection()
	{
		Assignments = null;
	}
	
	//Method used to get data by writing the name from the file
	public Assignment GetByName(String name)
	{   
		//If statement works if Assignments does NOT equal null
		if (Assignments != null){
			
			for (int i = 0; i < Assignments.length; i++)//initializing i in the for loop so it reaches the length of the Assignments
			{
				if(Assignments[i].getName().equals(name))
				{
					return Assignments[i];
				}
				else
				{
					return null;
				}
			}

		}
		return null;
	}

	//Method used to get the value by asking the user to enter the index
	public Assignment GetByIndex(int index) throws ArrayIndexOutOfBoundsException
	 {
		if (Assignments == null)
		{
			return null;
		}
		//saying if the index(number) is less than or greater than the index of the Assignments, return the index.
		if (index < Assignments.length || index > Assignments.length)
		{
			
		return Assignments[index];
			
			
		}//simple else statement to complete the if else
		else 
		{
			throw new ArrayIndexOutOfBoundsException();
		}
	 }
	 
	//report method
	 public void Report(PrintStream ps)
	 {
		 String work = "Assignment";
		 String cat = "category";
		 String g = "grade";
		//ps.println("Assignment --------- Category --------- Grade");
		ps.printf("%10s,%10s,%10f", work,cat,g);
		ps.printf("%10s,%10s,%10f","--------",  "----------",  "---------");
		
		//member variables for the category type:
		double gradeTotal = 0.0;
		
		//counter variables
		int hwCount = 0;
		int examCount = 0;
		int labCountFail = 0;
		int labCountSuccess = 0;
		int quizCount = 0;
		
		//average variable for average
		double hwAverage = 0;
		double examAverage = 0;
		double quizAverage = 0;
		double labAverage = 0;
		
		//using a for loop and initializing it with u
		//Allows for us to collect all data from the Assignments file when we run it
		for (int u=0;u < Assignments.length; u++)
		{
			System.out.printf("%s, %s, %f", Assignments[u].getName(), Assignments[u].getCategory(), Assignments[u].getGrade());
	 	
			//if else statements for specific category types 
			if(Assignments[u].getCategory() == "Homework")
			{
				hwCount += 1;
				gradeTotal = Assignments[u].getGrade();
				hwAverage =  gradeTotal/ hwCount;
		
			}
			if (Assignments[u].getCategory() == "Exam")
			{
				examCount +=1;
				gradeTotal = Assignments[u].getGrade();
				examAverage =  gradeTotal/ examCount;
			}
			
			if (Assignments[u].getCategory() == "Lab")
			{
				if (Assignments[u].getGrade() == 0)
				{
					labCountFail+=1;
				}
				if (Assignments[u].getGrade() == 1)
				{
					labCountSuccess +=1;
				}
				int totalCount;
				totalCount = labCountFail + labCountSuccess;
				
				
				labAverage = (labCountSuccess / totalCount) * 100;
			
			}
			
			if (Assignments[u].getCategory() == "Quiz")
			{
				quizCount +=1;
				gradeTotal =Assignments[u].getGrade();
				quizAverage =  gradeTotal/ quizCount;
			}
		}
		//PRINT STATEMENTS:
		System.out.println("Category Summary");
		System.out.println("-----------------\n");
		//using the percent sign to set the exact width of the values when printed.
		//Makes the program more organized and erases dificulty of printing each line.
		System.out.printf("%s %f\n", "Homework", hwAverage);
		System.out.printf("%s %f\n", "Exam", examAverage);
		System.out.printf("%s %f\n", "Lab", labAverage);
		System.out.printf("%s %f\n", "Quiz", quizAverage);
		
	 }
	 //write method
	 public void Write(PrintStream ps)
	 {		
		 	ps.println(Assignments.length);
		 	for (int i = 0; i < Assignments.length; i++)
		 	{
		 		Assignments[i].Write(ps); //this method allows the file data to be written as a list
		 								  //and not in a straight, horizontal line.
		 	}
		  
	 }
	 //Read method
	 //Uses a scanner to get the file name from user
	 public void Read(Scanner s) throws IOException
	 { 
		//enter code below:
		 int count = s.nextInt();// this initializes what the first count is, because we already know
		 						 //that the count is 12.
		
		 s.nextLine();
		 Assignments = new Assignment[count];
		 
		 	for(int i = 0;i < count; i++)
		 	{
		 		Assignments[i] = new Assignment();//allocate memory for each value of the array. or else it will be null.
		 		Assignments[i].Read(s);
		 	}
	 }
	 
	 //override method
	 @Override
		public String toString()
		{String sGrade = Double.toString(Grade);
		
		String x = "[{\"Name\": \"Homework 1" + Name
				+ "\", \"Grade\":90 " + sGrade
				+ ", \"Category\": \"Homework" + Category + "\"}"
						
				+ "{\"Name\": \"Homework 2" + Name
				+ "\", \"Grade\":100 " + sGrade
				+ ", \"Category\": \"Homework" + Category + "\"}"
						
				+ "{\"Name\": \"Homework 3" + Name
				+ "\", \"Grade\":80 " + sGrade
				+ ", \"Category\": \"Homework" + Category + "\"}"
						
				+ "{\"Name\": \"Homework 4" + Name
				+ "\", \"Grade\":95 " + sGrade
				+ ", \"Category\": \"Homework" + Category + "\"}]";
		//......
		return x; //return value 'x'
		}
	 
	 //1.Add an inner class named AssignIter to AssignmentCollection. 
	 //This class should implement the Iterator interface
	 public class AssignIter implements Iterator<Integer> {

		@Override
		public boolean hasNext() 
		{
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Integer next() 
		{
			// TODO Auto-generated method stub
			return null;
		} 
			// MyIterator members (on previous slides)… 
	}

	public static void GetByName() 
	{
		// TODO Auto-generated method stub
		
	}
	//Necessary override iterator method:
	@Override
	public Iterator<Assignment> iterator() 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
