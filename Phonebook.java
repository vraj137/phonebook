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
import java.io.*;


// An object that holds all the contacts
public class Phonebook {
    Scanner input = new Scanner(System.in);
    //arraylist for the contacts
    ArrayList<ContactObject> list = new ArrayList<ContactObject>();
    
    //Adds the contact to the arraylist
    public void addingContact(ContactObject contactAdd){
        list.add(contactAdd);
    }

    //outputs each contact
    public String outputContact() {
        int contactNumber = 1;
        String output = "";
        
        //goes through each contact and adds them on the output list
        for (int i = 0; i < this.list.size(); i++){
            output += "Contact #" + contactNumber + ": " + this.list.get(i).toString() + "\n\n";
            //increases the contact number if needed
            contactNumber++;
        }
        return output; // returns the final contacts followed by the format
    }
    
    //returns the size of the contacts
    public int sizeContact() {
        return list.size();
    }
    
    //remove contact from phonebook
    public void removingContact(ContactObject remove) {
        this.list.remove(remove);
    }
    
    //looks to match the contact user presents
    public int findContact(String firstName, String lastName, int begin, int end) {
        
        if(end >= begin) {
            // Calculate the midpoint 
    	    int mid = begin + (end - begin)/2;
            
    	    //stores first and last name
            int ln = 0;
            int fn = this.list.get(mid).getFName().compareToIgnoreCase(firstName);
            
    	    //base case to check to see if the middle value is equal to the name
    	    if(fn == 0) {
                //changes last name to the comparison of the last name entered
                ln = this.list.get(mid).getLName().compareToIgnoreCase(lastName);
                if(ln == 0) {
                    return mid;
    	    }
            }

    	    //looks to see if name is near the beginning or end
    	    if(fn >= 0) {
                if(ln >= 0) {
                    //looks at the beginning
                    return findContact(firstName, lastName, begin, mid - 1);
                }
            } else {
                //looks at the the end
                return findContact(firstName, lastName, mid + 1, end);
            }
    	        
        }
		return -1; //Alternate Base Case if not found.
    }
    //switches the index value to the name
    public ContactObject indexSwitch(int index){
        return this.list.get(index);
    }
    
    //Sorting first name by selection sort
    public void firstNameSort(){
        int smallIndex;
        //outer for-loop
        for (int i = 0; i < this.list.size(); i++) {
            //find index of smallest value
            smallIndex = i; 
            //inner for loop to find the smallest value
            for (int k = i + 1; k < this.list.size(); k++){
                if (this.list.get(smallIndex).getFName().compareToIgnoreCase(this.list.get(k).getFName()) > 0){
                    smallIndex = k;
                }
            }
            // swaps the last name element
            ContactObject temp = this.list.get(i);
            this.list.set(i, this.list.get(smallIndex));
            this.list.set(smallIndex, temp);
        }
    }
    // Sorting last name by bubble sort
    public void lastNameSort(){
        ContactObject temp; 
        for (int i = 0; i < this.list.size(); i++){
            for (int k = 1; k < this.list.size() - i; k++){
                //comparing to see if the name is in the contacts
                if(this.list.get(k).getLName().compareToIgnoreCase(this.list.get(k - 1).getLName()) < 0){
                    //swap adjacent out of order elements
                    temp = this.list.get(k);
                    this.list.set(k, this.list.get(k-1));
                    this.list.set(k-1, temp);
                }
            }
        }
    
    }
    //exports the file 
    public void exportFile(String name) throws FileNotFoundException{
        PrintWriter export = new PrintWriter(name);
          //goes through the contacts list
        for(int i = 0; i < list.size(); i++) {
          ContactObject eachContact = list.get(i);
  
          //exports the identification of each value stored followed by a ","
          export.print(eachContact.getFName());
          export.print(", ");
          export.print(eachContact.getLName());
          export.print(", ");
          export.print(eachContact.getPhoneNum());
          export.print(", ");
          export.print(eachContact.getEmail());
          export.print(", ");
          export.print(eachContact.getBirthday());
          export.print(", ");
          export.print(eachContact.getHome());
          export.print(", ");
          export.print(eachContact.getGender());
          export.println("");
          
        //confirmation
          System.out.println("\nFile has been Exported.\n");
        }
        export.close();
      }

    // allows user to import file successfully
    public void importFile(String name) throws FileNotFoundException {

        //creating file object
        Scanner file = new Scanner(new File(name));
        while(file.hasNext()){
            String line = file.nextLine();
            Scanner items = new Scanner(line);

            //sequence characters that specifies the boundary between plain text
            items.useDelimiter(", ");
            
            String firstName = items.next();
            String lastName  = items.next();
            //new contact object being created and stores first and last name
            ContactObject newContacts = new ContactObject(firstName, lastName);

            //reads each value followed by the ","
            String phoneNumber = items.next();
            String email = items.next();
            String birthday = items.next();
            String homeAdd =  items.next();
            String gender = items.next();

            //sets the following data according to the import
            newContacts.setPhoneNum(phoneNumber);
            newContacts.setEmail(email);
            newContacts.setBirthday(birthday);
            newContacts.setHomeAddress(homeAdd);
            newContacts.setGender(gender);

            //add the contacts to the phonebook
            addingContact(newContacts);
            items.close();
            
        }

        file.close();
    }
    
}