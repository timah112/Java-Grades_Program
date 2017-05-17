/**
*******************************************************************
*Author:Atif Tirmizi
*File: CourseMemberConsoleUI.java
*Professor: Arthur Hoskey
********************************************************************
**/

package Tirmizi.bcs345.grades.presentation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import Tirmizi.bcs345.grades.business.Assignment;
import Tirmizi.bcs345.grades.business.AssignmentCollection;
import Tirmizi.bcs345.grades.business.CourseMember;
import Tirmizi.bcs345.grades.business.Student;
/*
 * This class creates a menu for the using using the functions, methods, and variables from the 
 * CourseMember class.
 * It will be later called in main method.
 *  
 * 
 * 
 * @author Atif Tirmizi
 * @version 1.0
 * @since 11/1/2015
 */

public class CourseMemberConsoleUI 
{
	
	//Creating an instance of CourseMember
	CourseMember c = new CourseMember();
	
	//Shows the user interface. When this method is called it 
	//should display the menu to the user. See the Menu 
	//Description section below for details.
	public void ShowUI()
	{
		//Menu for the user who runs this
		System.out.println("Assignment Collection UI");
		System.out.println("-------------------------");
		
		System.out.println("1 – Read course member from file");
		System.out.println("2 – Write course member to file");
		System.out.println("3 – Show course member report on screen");
		System.out.println("4 – Show course member JSON on screen");
		System.out.println("5 – Show AssignmentCollection using for-each");
		System.out.println("6 - Exit");
	
		//ENTER A CHOICE FOR THE USER MENU
		int pickChoice;
		
		Scanner choice = new Scanner(System.in);
		
		
		
		do {
			System.out.println("Enter Choice");
			pickChoice = choice.nextInt();
			choice.nextLine();
		
		/************************************************************
		*Beginning of if else statements so the program can recognize a specific option
		*from the user
		*/
		//FIRST CHOICE
		if (pickChoice ==1)
		{//method for the first choice: 
			
			String newFileName;
			System.out.println("Please enter the name of the file to read from");
			newFileName = choice.nextLine();
			
			Scanner inputScanner = null;
			//try and catch used to catch any mistakes the compiler reads
			try 
			{	//allocating new memory for an input scanner
				inputScanner = new Scanner(new FileReader(newFileName));
			} 
			catch (FileNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			try 
			{
				c.Read(inputScanner);
				
			}
			catch (IOException e) 
			{
				//TODO Auto-generated catch block
				  e.printStackTrace();
			}
			
		}
	
		//If the user enters CHOICE 2:
		//THIS WORKS
		else if (pickChoice ==2)
		{
			System.out.println("Enter a filename to write the data to:");
			PrintStream outf = null;
			
			try 
			{
				outf = new PrintStream(choice.nextLine()); //output the FILE
			} 
			catch (Exception e) 
			{
				System.out.println("ERROR. Could not open file!");
			}
			
			c.Write(outf);//writing to the actual file	
		}
		//calling the method to print out the report for CourseMember Class
		else if (pickChoice ==3)
		{
			
			c.Report(System.out);	
		}
		//
		else if (pickChoice ==4)
		{
			AssignmentCollection z = c.getAssignments();
			
			System.out.println(z);
		}
		
		/*Shows all assignments in the AssignmentCollection member of CourseMember. 
		 * This assignment data should be shown on the screen using a for-each. 
		 * USING THE FOR-EACH STYLE DESCRIBED IN THE CHAPTER 3 SLIDES 
		 * AS PART OF YOUR SOLUTION.
		 */
		else if (pickChoice ==5)
		{
			AssignmentCollection Assignment = c.getAssignments();

			{
			
				for (Assignment item : Assignment) 
				{ 
					System.out.println("Item is: " + item); 
				} 
			}
		}
		
		 //Last choice
		 /*
		  * This allows the user to exit from the loop
		  */
		else if (pickChoice ==6)
		{
			//EXIT THE LOOP
		}
		
		//else statement to complete the if else statements
		else 
		{
			System.out.println("You have entered an invalid choice, please try again.");
		}
		
		}while (pickChoice !=6); //if the user enters 6, the program closes
	}
			
			
}
