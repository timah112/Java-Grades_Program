/*********************************************************************
*Author:Atif Tirmizi
*File: CourseMember.java
*Professor: Arthur Hoskey
*********************************************************************/
package Tirmizi.bcs345.grades.business;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**Class: CourseMember
 * This class creates a new default constructor 
 * It uses get/set methods and implements like those from the AssignmentCollection
 *
 * *
 * @author Atif Tirmizi
 * @version 1.0
 * @since 12/1/2015
 *
*/
public class CourseMember {
	
	//MEMBER VARIABLES
	private Student Student; //holds student name and major
	private AssignmentCollection Assignments; //holds data about assignments
	
	//DEFAULT CONSTRUCTOR
	//creates instances of each member variable
	public CourseMember()
	{
		Student = new Student();
		Assignments = new AssignmentCollection();
	}
	
	//GET/SET METHODS
	//write get/set methods for all member variables(student, and AssignmentCollection)
	public Student getStudent()
	{
		return Student;
	}
	
	public void setStudent(Student everyStudent)
	{
		Student = everyStudent;
	}
	
	//get method for assignments variable
	public AssignmentCollection getAssignments()
	{
		return Assignments;
	}
	
	//set method for Assignments member variable
	public void setAssignments(AssignmentCollection allAssignments) 
	{
		Assignments = allAssignments;
		
	}
	
	/*Methodvoid Write(PrintStream ps)
	*Writing the contents of all member variables to the given 
	*instance of PrintStream. Assume the PrintStream is already 
	*open and ready to use. NOT ALLOWED TO ADD ANY DESCRIPTIVE TEXT IN 
	*THE OUTPUT. JUST PRINT THE VALUES. 
	*/
	 public void Write(PrintStream ps)
	 {		
		 Student.Write(ps);
		 Assignments.Write(ps);
		 
	 }
	
	//void Read Method(Scanner s)
	 public void Read(Scanner s) throws IOException
		{
			Student.Read(s);
			Assignments.Read(s);
			
		}
	
	
	//void Report(PrintStream ps)
	 public void Report(PrintStream ps)
	 {
		 //This method creates a written report that calculates the average of all
		 //data, and outputs it in an organized manner
		 String first = "First";
		 String last = "Last";
		 String id = "ID";
		 String major = "Major";
		 
		 System.out.println("Course Member Report");
		 System.out.println("---------------------");
		                    
		 //%'s specify the distance between the elements
		 System.out.printf("%10s,%10s,%10s", first, last, id, major);
		 
		 //calling the method from Assignments
		 Assignments.Report(ps);
	 }
	
	//Method to display the data in a JSON String specific format
	 @Override
	 public String toString()
	{
		//This is the toString method call for Student class
		 String y = "";
		 y+=Student.toString();
		 
		 //This is the toString method call for Assignment class
		 String z = "";
		 z+= Assignments.toString();
		 return z; //return statement
	}
	

}
