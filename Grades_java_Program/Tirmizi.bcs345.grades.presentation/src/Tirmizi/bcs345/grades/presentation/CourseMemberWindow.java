/*********************************************************************
*Author:Atif Tirmizi
*File:CourseMemberWindow.java
*Professor: Arthur Hoskey
*Date: 12/7/2015
*********************************************************************/
package Tirmizi.bcs345.grades.presentation;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import Tirmizi.bcs345.grades.business.CourseMember;
import Tirmizi.bcs345.grades.business.Student;

/**
*CourseMemberWindow file: creates and defines member variables and methods for all
*the GUI functions for the program. 
*
* @author Atif Tirmizi
* @version 1.0
* @since 12/1/2015
*/
public class CourseMemberWindow extends JFrame implements ActionListener {
	
	//protected member variables: 
	protected  CourseMember CourseMember;
	
	//other protected member variables:
	protected JTabbedPane tabPane;
	
	//vars for JTextArea
	protected JTextArea messageTextArea;
	protected JTextArea firstNameTextArea;
	protected JTextArea IDTextArea;
	protected JTextArea lastNameTextArea;
	protected JTextArea majorTextArea;
	protected JTextArea examTextArea;
	protected JTextArea homeWorkTextArea;
	protected JTextArea quizTextArea;
	protected JTextArea labTextArea;
	protected JTextArea overallTextArea;
	
	//vars for JButton
	protected JButton inputButton;
	protected JButton clearButton;
	protected JButton m_openButton;
	protected JButton m_saveButton;
	protected JButton m_exitButton;
	
	//vars for JLabel
	protected JLabel lastNameLabel;
	protected JLabel messageLabel;
	protected JLabel firstNameLabel;
	protected JLabel IDLabel;
	protected JLabel majorLabel;
	protected JLabel examLabel;
	protected JLabel homeWorkLabel;
	protected JLabel quizLabel;
	protected JLabel labLabel;
	protected JLabel overallLabel;
	
	//vars for JMenuBar
	protected JMenuBar menuBar;
	
	

	//DEFAULT CONSTRUCTOR:
	//1.	Calls new for CourseMember member variable.
	//2.	Set the window size and title. 
	//3.	Set the default close operation. Use DISPOSE_ON_CLOSE.
	//4.	Create the GUI controls and display them in the window.
	//5.	Any other code needed to initialize the window or member variables.
	//6.	Add event handling code for menu items.
	public CourseMemberWindow()
	{
		//code:
		CourseMember = new CourseMember(); //calling new for the member variable
		
		setSize(700, 800); //Sets Window Size + Title
		setTitle("BCS 345 - CourseMemberWIndow"); //Sets title on Window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //JAVA BUILT-IN METHOD FOR EXITING
		
		//panel for student;
		tabPane = new JTabbedPane();
		JPanel studentPanel;
		studentPanel = new JPanel();
		
		tabPane.addTab("Student", studentPanel);
		
		GridLayout g2 = new GridLayout(5, 0); //giving the grid set widths and columns
		studentPanel.setLayout(g2);
		//******************************************************
		//Setup for Message Label text
		//******************************************************
		
		messageLabel = new JLabel();
		//******************************************************
		//Setup for  MessageTextArea
		//******************************************************
		
		//creating the label for the FIRST NAME:
		firstNameLabel = new JLabel("First");
		firstNameTextArea = new JTextArea(1, 15);
		
		//creating the actual label and text area for firstName
		studentPanel.add(firstNameLabel);
		studentPanel.add(firstNameTextArea);
		
		//label and text area for the LAST NAME:
		lastNameLabel = new JLabel("Last");
		lastNameTextArea = new JTextArea(1, 20);
		
		studentPanel.add(lastNameLabel);
		studentPanel.add(lastNameTextArea);
		
		
		//label and text area for the ID:
		IDLabel = new JLabel("ID");
		IDTextArea = new JTextArea(1, 20);
		
		studentPanel.add(IDLabel);
		studentPanel.add(IDTextArea);
		
		//label and text area for the ID:
		majorLabel = new JLabel("Major");
		majorTextArea = new JTextArea(1, 20);
		
		studentPanel.add(majorLabel);
		studentPanel.add(majorTextArea);


		//******************************************************
		//Setup FOR GRADES PANEL:
		//******************************************************
		
		JPanel GradesPanel; //creates new Instance for Grades
		GradesPanel = new JPanel(); //calls new for dataPanel
		
		GridLayout gl = new GridLayout(6, 0);
		GradesPanel.setLayout(gl);
		
		//creating the label for the FIRST NAME:
		examLabel = new JLabel("Exam Avg");
		examTextArea = new JTextArea(1, 20);
		
		//creating the actual label and text area for firstName
		GradesPanel.add(examLabel);
		GradesPanel.add(examTextArea);
		
		//label and text area for the LAST NAME:
		homeWorkLabel = new JLabel("Homework Avg");
		homeWorkTextArea = new JTextArea(1, 20);
		
		GradesPanel.add(homeWorkLabel);
		GradesPanel.add(homeWorkTextArea);
		
		
		//label and text area for the ID:
		quizLabel = new JLabel("Quiz Avg");
		quizTextArea = new JTextArea(1, 20);
		
		GradesPanel.add(quizLabel);
		GradesPanel.add(quizTextArea);
		
		//label and text area for the ID:
		labLabel = new JLabel("Lab Avg");
		labTextArea = new JTextArea(1, 20);
		
		GradesPanel.add(labLabel);
		GradesPanel.add(labTextArea);
		
		//label and text area for the ID:
		overallLabel = new JLabel("Overall Avg");
		overallTextArea = new JTextArea(1, 20);
		
		GradesPanel.add(overallLabel);
		GradesPanel.add(overallTextArea);
		
		//******************************************************
		//FUNCTIONALITY FOR THE JFRAME FILE DROPDOWN:
		//******************************************************
		m_openButton = new JButton(); //Creates an Instance of m_openButton on JButton
		m_openButton.setText("Open"); // Adds text to button
		m_openButton.addActionListener(this); //Adds listener for ActionEvent feedback
		
		//SaveAs button
		m_saveButton = new JButton(); //Creates an Instance of m_saveButton on JButton
		m_saveButton.setText("Save As"); // Adds text to button
		m_saveButton.addActionListener(this); //Adds listener for ActionEvent feedback
		
		//Exit button functionality
		m_exitButton = new JButton(); //Creates an Instance of m_exitButton on JButton
		m_exitButton.setText("EXIT"); // Adds text to button
		m_exitButton.addActionListener(this); //Adds listener for ActionEvent feedback
		
		//*********************************************************
		//This is the menu bar for the program. It allows the user to open, save
		// or close 
		//*********************************************************
		// MENU BAR SET UP:
		JMenu menu;
		JMenuItem item;

		menuBar = new JMenuBar();
		menu = new JMenu("File");
		item = new JMenuItem("Open");
		
		item.addActionListener(this); //Clicks and then ActionPerformed is called
		menu.add(m_openButton); //Adds an item to the menu list
		item = new JMenuItem("Open");
		item.addActionListener(this); 
		
		
		item.addActionListener(this); // and then ActionPerformed is called
		menu.add(m_saveButton);
		item = new JMenuItem("Save As");
		item.addActionListener(this); 
		
		item.addActionListener(this); //Clicks and then ActionPerformed is called
		menu.add(m_exitButton);
		item = new JMenuItem("Exit");
		item.addActionListener(this); 

		//placing the actual menubar
		menuBar.add(menu); 
		setJMenuBar(menuBar); //Adds Menu Bar the window
		
		
		tabPane.addTab("Grades", GradesPanel);
		add(tabPane);
		
	}

	//OTHER METHODS:
	//Add other methods as necessary to perform the required tasks.
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		JFileChooser fileChooser = new JFileChooser();//creating a new instance of JFileChoose
		
	    if (ae.getSource() == m_openButton)
		{
			String filename = "CourseMember.txt"; //name of the actual file
			
			//try statement
			try 
			{
				FileReader fr = new FileReader(filename);
				Scanner file = new Scanner(fr);
				CourseMember.Read(file);//calling the read method for the file
				Student First;
				Student Last;
				Student ID;
				Student Major;
				
				//GETTING THE VALUES FROM STUDENT FOR EACH TEXT AREA
				First = CourseMember.getStudent();
				Last = CourseMember.getStudent();
				ID= CourseMember.getStudent();
				Major = CourseMember.getStudent();
				
				firstNameTextArea.setText(String.valueOf(First));
				lastNameTextArea.setText(String.valueOf(Last));
				IDTextArea.setText(String.valueOf(ID));
				majorTextArea.setText(String.valueOf(Major));	
			}
			//Automated catch statements by eclipse
			catch (FileNotFoundException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} 
	    
	    //if statement to declare when the user opens the save button
	    if (ae.getSource() == m_saveButton)
		{

			String First;
			int ID;
			
			//CODE TO GENERATE JFileChooser
			FileNameExtensionFilter filter = new FileNameExtensionFilter
				
				("JPG & GIF Images", "jpg", "gif");
			    fileChooser.setFileFilter(filter);
			    int returnVal = fileChooser.showOpenDialog(fileChooser);
			   
			    if(returnVal == JFileChooser.APPROVE_OPTION)
			    {
			       System.out.println("You have chosen to open this file: " +
			       fileChooser.getSelectedFile().getName());
			    }
			    
			
	
		}
			    //Allows the program to close when the button "exit" is pressed
			    if (ae.getSource() == m_exitButton) 
				{
			    	System.exit(0); //exit command
			    	
				}
	}
	     
}
//END
	
	
	
