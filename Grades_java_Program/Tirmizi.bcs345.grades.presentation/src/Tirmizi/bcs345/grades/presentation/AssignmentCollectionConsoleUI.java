//*********************************************************************
//Author:Atif Tirmizi
//File:
//Professor: Arthur Hoskey
//*********************************************************************
package Tirmizi.bcs345.grades.presentation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;


import Tirmizi.bcs345.grades.business.Assignment;
import Tirmizi.bcs345.grades.business.AssignmentCollection;

/**This class is the console class for assignmentCollection
 * It calls the methods from that class, and prints them
 * It has a menu for a user to choose from
 * 
 * 
 * 
 * @author Atif Tirmizi
 * @version 1.0
 * @since 12/1/2015
 *
*/
public class AssignmentCollectionConsoleUI {

	AssignmentCollection s = new AssignmentCollection();
	
		//shows the user interface. WHen this method is called it should 
		//display the menu to the user. 
		
		void ShowUI() 
		{   //Menu for the user who runs this
			System.out.println("Assignment Collection UI");
			System.out.println("-------------------------");
			
			System.out.println("1-Read assignment collection from file");
			System.out.println("2-Write assignment collection to file");
			System.out.println("3-Show assignment by index");
			System.out.println("4-Show assignment by name");
			System.out.println("5-Show assignment collection as JSON string");
			System.out.println("6-Show assignment collection report on screen");
			System.out.println("7- Exit");
					
			//ENTER A CHOICE FOR THE USER MENU
			int pickChoice;
			
			Scanner choice = new Scanner(System.in);
			
			
		
			//Do while loop
			//A type of loop where everything after 'do' must run and when the user enters a choice
			//that is not supported by the while statement, the program executes.
			do {
				System.out.println("Enter Choice");
				pickChoice = choice.nextInt();
				choice.nextLine();
			//************************************************************
			//Beginning of if else statements so the program can recognize a specific option
			//from the user
			//************************************************************
			
			//FIRST CHOICE:
			//User enters the name of a specific file he/she wants to read all the data from.
			//It call the Scanner method from AssignmentCollection class and uses it to read all
			//the data from the file
			if (pickChoice ==1)
			{
				//method for the first choice: 
				String fileName;
				System.out.println("Please enter the name of the file to read from");
				fileName = choice.nextLine();
				
				//try and catch methods used to catch any mistakes the compiler throws
				Scanner inputScanner = null;
				try 
				{
					inputScanner = new Scanner(new FileReader(fileName));
				} 
				catch (FileNotFoundException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
				try 
				{
					s.Read(inputScanner);
					
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			
			//If the user enters CHOICE 2:
			//THIS WORKS
			//Calls the write method. Write all the data from the main file, to
			//another file that the user names!
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
				s.Write(outf);
				
			}
			
			//THIRD CHOICE FOR USER:
			/*
			 * This is calling the getByIndex method, 
			 * It asks the user to enter an index and then have it displayed on screen
			 */
			else if (pickChoice ==3)
			{
				int aIndex;
				//scanner method used to get the choice from the user
				System.out.println("Please enter the index. ");
				Scanner anotherChoice = new Scanner(System.in);
				aIndex = anotherChoice.nextInt();
				
				//if else statement used so the program is sure that the user enters an index below 12
				if (anotherChoice.nextInt() <= 12)
				{
					s.GetByIndex(aIndex);
					System.out.println(anotherChoice.nextInt());
					System.out.println("the index you chose is: " + aIndex);
				}
				else
					System.out.println("The index is wrong");
			}
			
			//FOURTH CHOICE FOR THE USER
			 /*
			  * This choice basically asks the user to enter the name of the assignment
			  * and then prints it. 
			  */
			else if (pickChoice ==4)
			{
				AssignmentCollection name = new AssignmentCollection();
				AssignmentCollection.GetByName();
				String aName;
				Scanner someOtherChoice = new Scanner(System.in);
				System.out.println("Please enter the name. ");
				aName = someOtherChoice.nextLine();
				
				
				System.out.println("the name you chose is: " + someOtherChoice.nextLine());
			}
			
			//FIFTH CHOICE FOR THE USER
			/*
			 * If the user enters this choice, the program will show all the data as a string
			 */
			else if (pickChoice ==5)
			{
				AssignmentCollection x = new AssignmentCollection();
				
				System.out.println(x);
			}
			
			//SIXT CHOICE FOR THE USER
			//Shows the assignment report on the screen
			else if (pickChoice ==6)
			{
				s.Report(System.out);
				
			}
			 //Last choice
			 /*
			  * This allows the user to exit from the loop
			  */
			else if (pickChoice ==7)//if the user enters 7, the program will close.
			{
				//EXIT 
			}
			
			
			else //
			{
				System.out.println("You have entered an invalid choice, please try again.");
			
			}
			}while (pickChoice !=7); 
		}
			
		private static void getByName(Object name) {
			// TODO Auto-generated method stub
			
		}
		
	}
//END
