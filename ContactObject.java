/****************************************************************
 Name: Vraj Bhavsar
 Date: Thursday, Jan 20, 2022
 
 Description:  Functional Phonebook that allows users to enter 
 unlimited amount of contacts with their full name, phone number, email
 address, birthday and gender in a organized list. Users have the ability 
 modify their contacts later on as well as remove them. Users can sort the 
 contacts through first and last name to keep everything organized and can
 import or export their contacts within this program. 
 
*****************************************************************/

import java.util.*;

public class ContactObject {
    // private variables to store contact details 
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String bday;
    private String homeLocation;
    private String gender;
    
    // object to hold the two required contact details; first and last name
    public ContactObject(String fName, String lName){
        this.firstName = fName;
        this.lastName = lName;
    }
    
    //stores the first name of user
    public String getFName(){
        return this.firstName; 
    }
    
    //stores the last name of user
    public String getLName(){
        return this.lastName; 
    }
    
    //stores the phone number of user
    public String getPhoneNum(){
        return this.phoneNumber; 
    }
    
    //stores the email address of user
    public String getEmail(){
        return this.emailAddress; 
    }
    
    //stores the birthday of user
    public String getBirthday(){
        return this.bday; 
    }
    
    //stores the home address of user
    public String getHome(){
        return this.homeLocation; 
    }
    
    //stores the gender of user
    public String getGender(){
        return this.gender; 
    }
    
    //sets the first name
    public void setFName(String fName){
        this.firstName = fName; 
    }
    //sets the last name 
    public void setLName(String lName){
        this.lastName = lName; 
    }
    //sets the phone number
    public void setPhoneNum(String phoneNum){
        this.phoneNumber = phoneNum; 
    }
    //sets the email address
    public void setEmail(String emailAdd){
        this.emailAddress = emailAdd; 
    }
    //sets the birthday
    public void setBirthday(String birthdate){
        this.bday = birthdate; 
    }
    //sets the home address
    public void setHomeAddress(String homeAdd){
        this.homeLocation = homeAdd; 
    }
    //sets the gender 
    public void setGender(String gender){
        this.gender = gender; 
    }
    
    //formats the contacts when outputing
    public String toString() {
        return "\nFirst Name: " + this.firstName + "\nLast Name: " + this.lastName + "\nPhone Number: " + this.phoneNumber + "\nEmail Address: " + this.emailAddress + "\nBirthday: " + this.bday + "\nAddress: " + this.homeLocation + "\nGender: " + this.gender;
    }
    

    
    
}