/*********************************************************************
*Author:Atif Tirmizi
*File:CourseMemberSwingUI.java
*Professor: Arthur Hoskey
*Date: 12/7/2015
*********************************************************************/
package Tirmizi.bcs345.grades.presentation;

/**
 * Contains main program code. 
 * 
 * 
 * @author Atif Tirmizi
 * @version 1.0
 * @since 12/1/2015
 *
 *This file creates an instance for CourseMemberWindowUI and calls it. This is so it can be called throughout 
 *another class
 */
public class CourseMemberSwingUI 
{

	//Shows the user interface. When this method is called 
	//it should create a new instance of CourseMemberWindow and display it. 
	//See below for a screen shot of the window.
	public void ShowUI()
	{
		CourseMemberWindow w = new CourseMemberWindow();//creating the instance
		w.setVisible(true);
	}
	
	
}
