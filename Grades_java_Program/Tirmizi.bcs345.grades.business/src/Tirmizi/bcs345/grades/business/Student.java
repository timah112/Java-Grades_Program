//*********************************************************************
//Author:Atif Tirmizi
//File: Student.java
//Professor: Arthur Hoskey
//*********************************************************************
package Tirmizi.bcs345.grades.business;

import java.io.PrintStream;
import java.util.Scanner;

/** 
* @author Atif Tirmizi
* @version 1.0
* @since 12/1/2015
*Student class that defines student methods and member variables within it.
*/
public class Student {
	//ALL PRIVATE MEMBER VARIABLES:
	//Attributes:
	private String First; 
	private String Last;
	private int ID;
	private String Major;
	
	//STUDENT DEFAULT CONSTRUCTOR: WHICH HAS NO PARAMETERS
	public Student()
	{
		First = "";
		Last = "";
		ID = 0;
		Major = "";
		
	}
	
	public String getFirst()  //GET METHODS
	{
		 return First;
	}
	
	public void setFirst(String FirstName) //SET METHODS
	{
		First = FirstName;
	}
	///////////////////////////////
	public String getLast()//GET METHODS
	{
		return Last;
	}
	
	public void setLast(String LastName) //SET METHODS
	{
		Last = LastName;
		
	}
	////////////////////////////////
	public int getID()//GET METHODS
	{
		return ID;
		
	}
	
	public void setID(int id) //SET METHODS
	{
		ID = id;
		
	}
	///////////////////////////////
	public String getMajor()//GET METHODS
	{
		return Major;
	}
	
	public void setMajor(String fullMajor) //SET METHODS
	{
		Major = fullMajor;
	}
	//*****************************************
	//Print methods (write):
	public void Write(PrintStream ps)
	{
		  ps.println(First);
		  ps.println(Last);
		  ps.println(ID);
		  ps.println(Major);
		
	}
	
	//*****************************************
	//READ THE CONTENTS OF ALL MEMBER VARIABLES
	public void Read(Scanner s)
	{
		//Scanner First = new Scanner(System.in);
		//System.out.Printf(First.nextInt)
		First = s.nextLine();
		Last = s.nextLine();
		ID = s.nextInt();
		s.nextLine();
		Major=s.nextLine();
		
	}
	//**********************************************
	//Method that returns a string using JSON formatting: 
	@Override
	public String toString()
	{
		/*

		return "Student {First=" + First + ", Last=" + Last
                + ", ID=" + ID + ", Major="
                + Major+ "}";
		*/
		
		String sID = Double.toString(ID);
		String x = "\"First\": \"" + First
					+ "\", \"Last\": " + Last
					+ "\", \"ID\": " + ID
					+ ", \"Major\": \"" + Major + "\" ";
		return x;
	}
	
}
