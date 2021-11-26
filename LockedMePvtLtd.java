package com.lockedme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMePvtLtd 
{
	static final String folderpath="E:\\simplilearn\\SimpliLearn\\Files";
	public static void main(String[] args) 
	{
		int proceed=1;
		
		do
		{
		//Variable declaration 
		Scanner obj = new Scanner(System.in);
		int ch,subch,subcha;
		
		//Menu
		displayMenu();
		System.out.println("Enter Your Choice:");
		ch=Integer.parseInt(obj.nextLine());
		
		switch(ch)
			{
			case 1 : getAllFiles();
					break;
					
			case 2 : 
				
			{
				
			 do {
				 
			  System.out.println("Options to Perform operations ");
			  System.out.println("1. Add files");
			  System.out.println("2. Delete file");
			  System.out.println("3. search file");
			  System.out.println("4. Go to previous menu");
			  System.out.println("5.Exit");
			  subch=Integer.parseInt(obj.nextLine());
			  switch(subch) {
			  
			  case 1:createFiles();
			  		break;
			
			  case 2 : deleteFile();
					break;	
			  case 3 : searchFile();
					break;
			  case 4 : displayMenu();
			  		  System.out.println("Program terminated successfully");
			  case 5 : System.out.println("Thank you for using our service");
				  System.exit(0);
					break;
			  default :System.out.println("Invalid Option");
					break;
			}
		}while(proceed>0);
			}
			 
			 
			 case 3:System.out.println("Thank you for using our service"); 
				 System.exit(0);
			 break;
			 default :System.out.println("Invalid Option");
				break;
			}
			}while(proceed>0);
		}	
	public static void displayMenu()
	{
		System.out.println("==================================================");
		System.out.println("\tLockedMe.com(Developed by Puneeth H)\t\t");
		System.out.println("==================================================");
		System.out.println("1. Display all files");
		System.out.println("2. Options to Perform operations to files ");
		System.out.println("3. Exit");
		System.out.println("==================================================");
		
		
	}
	
	public static void getAllFiles()
	{
		//Getting all the files present in the folder
		List<String> fileNames = FileManager.getAllFiles(folderpath);
		
		for(String f:fileNames)
		System.out.println(f);

	}
	
	public static void createFiles()
	{
		// variable declaration 
		Scanner obj = new Scanner(System.in);
		String fileName;
		int linesCount;
		List<String> content = new ArrayList<String>();
				
		//read file name from the user
		System.out.println("Enter file name :");
		fileName=obj.nextLine();
				
		// read number of lines from user 
		System.out.println("Enter how many lines are required in the files :");
		linesCount=Integer.parseInt(obj.nextLine());
				
		//read Lines from user 
		for(int i=1;i<=linesCount;i++)
		{
			System.out.println("Enter line "+i+":");
			content.add(obj.nextLine());
		}
				
		// save the content into the file 
		boolean isSaved = FileManager.createFiles(folderpath, fileName, content);
				
		if(isSaved)
			System.out.println("File saved successfully");
		else
			System.out.println("some error occured.");
			
	}
	
	public static void deleteFile()
	{
		//Code for deleting a file 
		String fileName;
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter file name to be deleted");
		fileName=obj.nextLine();
				
		// Deleting a file 
		boolean isDeleted = FileManager.deleteFile(folderpath, fileName);
				
		if(isDeleted)
			System.out.println("File deleted sucessfully");
		else
			System.out.println("File not found or acess denied ");
		
		
	}
		
	public static void searchFile()
	{
		//declaration 
		String fileName;
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter file name to be searched");
		fileName=obj.nextLine();
		
		// searching a file 
		boolean isFound = FileManager.searchFile(folderpath, fileName);
		
		if(isFound)
			System.out.println("File exists");
		else
			System.out.println("File not found or acess denied ");
	

	}
	
}
