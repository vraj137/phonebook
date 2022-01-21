/****************************************************************
 Name: Vraj Bhavsar
 Date: Thursday, Jan 20, 2022
*****************************************************************/

import java.util.Scanner;
import java.util.*;
import java.io.*;

public class MyProgram {
    //Relates to Modify Menu, to ensure there is a name in the phonebook or not
    public static boolean ifContactIsMade(int contactCheck){
        if (contactCheck == -1) {
            System.out.println("No Name Found. Please try again! \n");
            return false;
        } return true;
    }
    
    //Checks to see if email contains '@' or '.' (formatted perfectly)
    public static boolean emailChecker(String check) {
        if(check.contains("@") && check.contains(".")){
            return true;
        }
        return false;
    }
    
    //checks to see if user has entered valid gender from the three options
    public static boolean genderChecker(String checkGender) {
        if(checkGender.equals("M") || checkGender.equals("F") || checkGender.equals("O")){
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) throws FileNotFoundException
    {
        //Creating user input
        Scanner input = new Scanner(System.in);
        
        //Creating phonebook object
        Phonebook allContacts = new Phonebook();
        
        //Introduction of the Phonebook
        System.out.println("Welcome to the Phone Book!\n");
        
        boolean runProgram = true;
        
        //Menu Options
        while(runProgram){
            
        // asks user for their selection
        System.out.println("Enter 1 to Enter a New Contact");
        System.out.println("Enter 2 to Display all Contacts");
        System.out.println("Enter 3 to Modify a Contact");
        System.out.println("Enter 4 to Remove a Contact");
        System.out.println("Enter 5 to Search for a Contact");
        System.out.println("Enter 6 to Sort Contacts by First Name");
        System.out.println("Enter 7 to Sort Contacts by Last Name");
        System.out.println("Enter 8 to Export Data");
        System.out.println("Enter 9 to Import Data");
        System.out.println("Enter 10 to Exit");
        
        //asks for users decisison 
        System.out.print("Enter your number here: ");
        int choice = input.nextInt();
        System.out.println();
        
        //avoiding extra input
        String extraInput = input.nextLine();
        
        // if user chooses this option
        if (choice == 1) {
            System.out.println("You have selected to Create a New Contact.");
            //asks for first and last name
            System.out.print("Enter the First Name: ");
            String fName = input.nextLine();
            System.out.print("Enter the Last Name: ");
            String lName = input.nextLine();
            
            //creates contact object for the first and last name
            ContactObject contact = new ContactObject(fName, lName);
            
            //asks user for phone number if applicable 
            System.out.print("Enter the Phone Number (As ###-###-###): ");
            String phoneNum = input.nextLine();
            contact.setPhoneNum(phoneNum);
            
            //asks user for email address if applicable 
            System.out.print("Enter Email Address (---@----.---): ");
            String emailAdd = input.nextLine();
            //checks if user has '@' or '.' in email
            boolean my = emailChecker(emailAdd);
            
            //if user does not input valid email it repeats until properly formatted
            while(my == false){
                System.out.println("Error. Please Try Again.");
                System.out.print("Enter Email Address (---@----.---): ");
                emailAdd = input.nextLine();
                my = emailChecker(emailAdd);
            }
            //sets the email with proper format
            contact.setEmail(emailAdd);
            
            //asks user for birthday
            System.out.print("Enter the Birthdate (MMM-DD-YYYY): ");
            String birthdate = input.nextLine();
            contact.setBirthday(birthdate);
            
            //asks user for home address if applicable 
            System.out.print("Enter Home Address: ");
            String homeAdd = input.nextLine();
            contact.setHomeAddress(homeAdd);
            
            //asks user for gender if applicable 
            System.out.print("Enter the Gender (M/F/O): ");
            String gender = input.nextLine().toUpperCase();

            //checks if user has entered the gender value correctly
            boolean genderStatus = genderChecker(gender);
            
            // runs until the user enters the correct gender style
            while(genderStatus == false){
                System.out.println("Error. Please Try Again.");
                System.out.print("Enter the Gender (M/F/O): ");
                gender = input.nextLine().toUpperCase();
                genderStatus = genderChecker(gender);
            }
            // sets the gender
            contact.setGender(gender);

        
            //adds the contact to the phonebook
            allContacts.addingContact(contact);
            
            //Confirmation 
            System.out.println("Thank you! Contact has been added!");
            System.out.println();
            
        } 
        // shows the contacts that are currently stored
        else if (choice == 2) {
            System.out.println(allContacts.outputContact());
        }
        // allows user to modify a contact
        else if (choice == 3) {
            //asks for first and last name to confirm identity
            System.out.println("You have selcted to Modify a Contact.");
            System.out.print("Enter First Name: ");
            String firstN = input.nextLine();
            System.out.print("Enter Last Name: ");
            String lastN = input.nextLine();
            
            //sorts the first name
            allContacts.firstNameSort();
            
            //verifies if there is a contact made
            int numContact = allContacts.sizeContact() - 1; 
            int index = allContacts.findContact(firstN, lastN, 0, numContact);
            boolean existingContactChecker = ifContactIsMade(index);
            
            // if the contact is made then asks user which section they wish to edit
            boolean programMenu = true;
            while(programMenu && existingContactChecker) {
                
                ContactObject temp = allContacts.indexSwitch(index);
                
                System.out.println("Enter 1 to Modify First Name");
                System.out.println("Enter 2 to Modify Last Name");
                System.out.println("Enter 3 to Modify Phone Number");
                System.out.println("Enter 4 to Modify Email Address");
                System.out.println("Enter 5 to Modify Birthday");
                System.out.println("Enter 6 to Modify Home Address");
                System.out.println("Enter 7 to Modify Gender");
                System.out.println("Enter 8 to Exit");
                
                //asks user for their modification selection 
                System.out.print("Enter your number here: ");
                int choiceCheck = input.nextInt();
                System.out.println();
                
                //avoiding the extra input line
                extraInput = input.nextLine();
                
                // modifies the first name as provided
                if(choiceCheck == 1){
                    System.out.print("Enter new First Name: ");
                    String firstName = input.nextLine();
                    //sets the new first name in the phonebook 
                    temp.setFName(firstName);
                    //Comfirmation 
                    System.out.println("Thank you! Modified!\n");
                }
                // modifies the last name as provided
                else if(choiceCheck == 2){
                    System.out.print("Enter new Last Name: ");
                    String lastName = input.nextLine();
                    //sets the new last name in the phonebook 
                    temp.setLName(lastName);
                    //Comfirmation 
                    System.out.println("Thank you! Modified!\n");
                }
                // modifies the phone number as provided
                else if(choiceCheck == 3){
                    System.out.print("Enter new Phone Number (###-###-####): ");
                    String phoneNumber = input.nextLine();
                    //sets the new phone number in the phonebook 
                    temp.setPhoneNum(phoneNumber);
                    //Comfirmation 
                    System.out.println("Thank you! Modified!\n");
                }
                // modifies the email address as provided
                else if(choiceCheck == 4){
                    System.out.print("Enter new Email Address (---@----.---): ");
                    String emailAdd = input.nextLine();
                    // sets the new email address in the phonebook 
                    temp.setEmail(emailAdd);
                    //Comfirmation 
                    System.out.println("Thank you! Modified!\n");
                }
                // modifies the birthday as provided
                else if(choiceCheck == 5){
                    System.out.print("Enter new Birthdate (MMM-DD-YYYY): ");
                    String birthday = input.nextLine();
                    // sets the new birthday in the phonebook
                    temp.setBirthday(birthday);
                    //Comfirmation 
                    System.out.println("Thank you! Modified!\n"); 
                }
                // modifies the home address as provided
                else if(choiceCheck == 6){
                    System.out.print("Enter new Home Address ");
                    String homeAdd = input.nextLine();
                    // sets the new home address in the phonebook 
                    temp.setHomeAddress(homeAdd);
                    //Comfirmation 
                    System.out.println("Thank you! Modified!\n");
                }
                // modifies the gender as provided
                else if(choiceCheck == 7){
                    System.out.print("Enter new Gender (M/F/O): ");
                    String gender = input.nextLine();
                    //sets the gender in the phonebook
                    temp.setGender(gender);
                    //Comfirmation 
                    System.out.println("Thank you! Modified!\n");
                }
                // if user selects 8 then program option will exit
                else if(choiceCheck == 8){
                    System.out.println("Exiting!\n");
                    programMenu = false;
                    
                } 
                // if number is not 1-8 then will ask user to enter again 
                else {
                    System.out.println("Error. Please Try Again");
                }
            }
        }
        //removes an existing contact
        else if (choice == 4) {
            // asks the user for the first and last name of the user they wish to remove
            System.out.println("You have selcted to Remove Contact");
            System.out.print("Enter First Name: ");
            String firstN = input.nextLine().toUpperCase();
            System.out.print("Enter Last Name: ");
            String lastN = input.nextLine().toUpperCase();
            
            // sorts the contacts by first name
            allContacts.firstNameSort();
            
            int numContact = allContacts.sizeContact() - 1; 
            int index = allContacts.findContact(firstN, lastN, 0, numContact);
            boolean existingContactChecker = ifContactIsMade(index);
            
            //asks user if they wish to delete the the existing contact
            String response = " ";
            if(existingContactChecker) {
                System.out.print("Are you sure you want to delete " + firstN + " " + lastN + "'s contact? (YES/NO) \n");
                response = input.nextLine().toUpperCase();
                
            }
            //if user selects yes then it will delete the contact
            if(response.equals("YES") || response.equals("Y") && existingContactChecker) {
                ContactObject temp = allContacts.indexSwitch(index);
                allContacts.removingContact(temp);
                //confirmation 
                System.out.println(firstN + " " + lastN + "'s contact has been removed. Thank you!\n");
            } 
            //if user selects no then contact will not be removed
            else if(response.equals("NO")|| response.equals("N")) {
                System.out.println(firstN + " " + lastN + "'s contact is not removed\n");
            }
            //if option is not yes or no then error is found
            else {
                System.out.println("Oh no! You ran into an error. Please try again. \n");
            }
        } 
        // allows user to search for a contact 
        else if (choice == 5) {
            // asks user for first and last name of the contact they wish to find
            System.out.println("You have selected to Search for a Contact.");
            System.out.print("Enter First Name: ");
            String firstN = input.nextLine();
            System.out.print("Enter Last Name: ");
            String lastN = input.nextLine();
            
            // sorts the contact by first name
            allContacts.firstNameSort();
            
            int numContact = allContacts.sizeContact() - 1; 
            int index = allContacts.findContact(firstN, lastN, 0, numContact);
            boolean existingContactChecker = ifContactIsMade(index);
            
            // if it exists then provides the detail for the contact they wish to see
            if (existingContactChecker) {
                System.out.println("Here is the detail for " + firstN + " " + lastN + ":");
                ContactObject temp = allContacts.indexSwitch(index);
                System.out.println(allContacts.indexSwitch(index).toString() + "\n");
            }
        }
        // sorts the contacts by first name
        else if (choice  == 6) {
            allContacts.firstNameSort();
            System.out.println("Contacts have been sorted by First Name. To view them, please select 2.\n");
        }
        // sorts the contacts by last name 
        else if (choice == 7){
            allContacts.lastNameSort();
            System.out.println("Contacts have been sorted by Last Name. To view them, please select 2.\n");
        }
        //allows user to export contacts data
        else if (choice == 8) {
            //asks user what they wish to call their file
            System.out.println("Enter the name of the export file (.csv)");
            String exportFile = input.nextLine();
            
            allContacts.exportFile(exportFile);
            // creating printwriter object to allow exportation 
            
        }
        // allows users to import contacts data
        else if (choice == 9) {
            //asks user to enter the file they wish to import followed by .csv
            System.out.println("Enter the file name you wish to import (.csv)");
            String importName = input.nextLine();

            //imports the contacts into the contacts
            allContacts.importFile(importName);

            //confirmation 
            System.out.println(importName + " has been imported to program successfully!\n");
            
        }
        // exits menu if user selects 10
        else if (choice == 10) {
            System.out.println("Have a great day! Goodbye.");
            //Exits menu
            runProgram = false; 
        }
        //if a value between 1-10 is not selected then user is asked to try again
        else {
            System.out.println("Enter a valid number. Please try again:");
            System.out.println();
        }
      }
    }
}