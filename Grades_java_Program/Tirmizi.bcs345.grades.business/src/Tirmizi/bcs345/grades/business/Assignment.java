//*********************************************************************
//Author:Atif Tirmizi
//File:Assingment.java
//Professor: Arthur Hoskey
////file from the previous assignments
//*********************************************************************
package Tirmizi.bcs345.grades.business;

import java.io.PrintStream;
import java.util.Scanner;
/**
* 
* @author Atif Tirmizi
* @version 1.0
* @since 12/1/2015
*
*/
public class Assignment {
	/*
	 * Assignment Class
	 */
			//Attributes:
			//PRIVATE MEMBER VARIABLES
			private String Name;
			private double Grade;
			
			private String Category;
			
			
			public Assignment() //default constructor
			{
				Name = "";
				Grade = 0;
				Category = "";	
			}
			
			//GET AND SET METHODS FOR ALL MEMBER VARIABLES
			public String getName() //GET METHOD
			{
				return Name;
			}
			
			public void setName(String fullName)
			{
				Name = fullName;
			}
			//////////////////////////////////
			public double getGrade() //GET METHOD
			{
				return Grade;
			}
			
			public void setGrade(double finalGrade)
			{
				Grade = finalGrade;
			}
			
			////////////////////////////////
			public String getCategory()//GET METHOD
			{
				return Category;
			}
			
			
			public void setCategory(String fullCategory)
			{
				Category = fullCategory;
				
			}
			
			///////////////////////////////////
			//WRITE METHODS:
			public void Write(PrintStream ps)
			{
				  ps.println(Name);
				  ps.println(Grade);
				  ps.println(Category);
				
			}
			
			//READ THE CONTENTS OF ALL MEMBER VARIABLES
			
				public void Read(Scanner s)
				{
		          	//ALLOWS DATA TO BE SAVED UNDER THE VARIABLE NAME
					Name = s.nextLine();
					Grade = s.nextInt();
					
					s.nextLine();
					Category = s.nextLine();
				}
				
				//*****************************************************
				//Method that returns a string using JSON formatting(Assignment Class):
				@Override
				public String toString()
				{
					String sGrade = Double.toString(Grade);
					String x = "{\"Name\": \"" + Name
								+ "\", \"Grade\": " + sGrade
								+ ", \"Category\": \"" + Category + "\"}";
					return x;
				}
				
				
}
