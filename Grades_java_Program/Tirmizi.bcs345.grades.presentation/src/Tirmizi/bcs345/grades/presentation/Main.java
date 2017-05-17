/*********************************************************************
*Author:Atif Tirmizi
*File:Main.java
*Professor: Arthur Hoskey
*Date: 11/22/2015
*********************************************************************/
package Tirmizi.bcs345.grades.presentation;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/*
 * Main Class: Creates an instance of both classes of assignmentCollection and CourseMember.
 * It calls those methods depending on which class the user wants to use
 * Its also menu-driven
 */

public class Main {
	public static void main(String[] args) 
	{
		
		//main choice
		int mainChoice = 0;
		
		Scanner yourChoice = new Scanner(System.in);
		
		//Do while loop used to make sure the whole prgram runs, unless the user wishes to exit.
		do 
		{
			//WHen the user runs the program, this is the first choice that pops up
			System.out.println("Choose UI:");
			System.out.println("----------");
			System.out.println("1 – AssignmentCollectionConsoleUI");
	        System.out.println("2 – CourseMemberConsoleUI");
	        System.out.println("3 – CourseMemberSwingUI");
	        System.out.println("4 - Exit");//allows users to exit the whole program
			System.out.println("Enter Choice");
			mainChoice = yourChoice.nextInt();
			yourChoice.nextLine();
			
		if (mainChoice ==1)
		{
			//Choice if the user chooses AssignmentCollectionConsoleUI then create an instance 
			//of AssignmentCollectionConsoleUI and call the ShowUI method on it. 
			AssignmentCollectionConsoleUI A = new AssignmentCollectionConsoleUI();
			A.ShowUI();
		}
		
		//second choice:
		else if (mainChoice ==2)
		{
			//If the user chooses CourseMemberConsoleUI then create an 
			//instance of CourseMemberConsoleUI and call the ShowUI method on it.
			CourseMemberConsoleUI D = new CourseMemberConsoleUI();
			D.ShowUI();
		}
		
		//THIRD CHOICE:
		//Calls the GUI class and creates an instace of it. 
		//This option gets called from the main menu
		else if (mainChoice ==3)
		{
			CourseMemberSwingUI c = new CourseMemberSwingUI();
			c.ShowUI();
		}
		
		//END OF DO WHILE LOOP TO QUIT THE PROGRAM
		} 
		while (mainChoice !=4);//while statement allows user to exit the program

	}
}
