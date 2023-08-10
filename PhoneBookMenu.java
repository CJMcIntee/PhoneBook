/*Programmer: Christine McIntee
  Date: August 10th 2023
  Program: Phone Book
  Menu that allows user to interact with program.*/

import java.util.Scanner;
import java.io.*;
  
public class PhoneBookMenu {
   //Fields
   private String fName;
   private String lName;
   private String addr;
   private String city;
   private String phoneNum;
   private PhoneBookManager list;

   //PhoneBookMenu constructor
   public PhoneBookMenu() {
   } //end constructor

   //Program menu allows user to create, view, and print entries
   public void menu() throws FileNotFoundException {
      System.out.println("Welcome to your Phone Book Manager!");
      File phone = new File("PhoneBook.txt");
      PrintStream out = new PrintStream(phone);
      Scanner input = new Scanner(System.in);
      PhoneBookManager list = new PhoneBookManager();
      menuOptions();
      String option = input.nextLine();
      while (!option.equals("q")) {
         //Create entry
         if (option.equals("c")) {
            createEntry(list, input);
            menuOptions();
            option = input.nextLine();
         //View phonebook entry
         } else if (option.equals("v")) {
            System.out.println(list.toString());
            menuOptions();
            option = input.nextLine();
         //Edit entry
         } else if (option.equals("e")) {
            editEntry(list, input);
            menuOptions();
            option = input.nextLine();
         //Delete entry by removing all data
         } else if (option.equals("d")) {
            if (list.isEmpty()) {
               System.out.println("List is empty. Please create an entry first.");
            } else { 
               System.out.println("Are you sure you want to delete this entry?");
               System.out.println("Enter \"yes\" to confirm OR enter any ");
               System.out.println("other character to go back to the menu: ");
               String delete = input.nextLine();
               switch (delete) {
                  case "yes":
                     list.removeAll(list);
                     System.out.println("Entry successfully deleted.");
                     break;
               }
            }
            menuOptions();
            option = input.nextLine();
         //Print phone book entry to file
         } else if (option.equals("p")) {
            out.println(list.toString());
            System.out.println("Entry saved to PhoneBook.txt");
            menuOptions();
            option = input.nextLine();
         //Handle input errors by telling user that input was invalid
         } else {
            System.out.print("Invalid input. ");
            menuOptions();
            option = input.nextLine();
         }
      }
      //Quit program
      System.out.print("Goodbye!");
   } //end menu method
   
   //Create entry by adding nodes with user data
   private void createEntry(PhoneBookManager list, Scanner input) {
      System.out.println("Please enter first name: ");
      String fName = input.nextLine();
      list.add(fName);
      System.out.println("Please enter last name: ");
      String lName = input.nextLine();
      list.add(lName);
      System.out.println("Please enter address: ");
      String addr = input.nextLine();
      list.add(addr);
      System.out.println("Please enter city name: ");
      String city = input.nextLine();
      list.add(city);
      System.out.println("Please enter phone number: ");
      String phoneNum = input.nextLine();
      list.add(phoneNum);
      System.out.println("Entry successfully created.");
      System.out.println(list.toString());
   } //end createEntry method
   
   //Edit entry by removing and adding list node data
   private void editEntry(PhoneBookManager list, Scanner input) {
      if (list.isEmpty()) {
         System.out.println("List is empty. Please create an entry first.");
      } else {
         System.out.println("Which field do you want to edit?");
         System.out.println("  (f)irst name?");
         System.out.println("  (l)ast name?");
         System.out.println("  (a)ddress");
         System.out.println("  (c)ity");
         System.out.println("  (p)hone number?");
         System.out.println("Enter first letter of chosen field: ");
         String editChoice = input.nextLine();
         switch(editChoice) {
            case "f":
               System.out.println("Enter new first name: ");
               String newfName = input.nextLine();
               list.remove(0);
               list.add(newfName, 0);
               System.out.println("Entry successfully edited.");
               System.out.println(list.toString());
               break;
            case "l":
               System.out.println("Enter new last name: ");
               String newlName = input.nextLine();
               list.remove(1);
               list.add(newlName, 1);
               System.out.println("Entry successfully edited.");
               System.out.println(list.toString());
               break;
            case "a":
               System.out.println("Enter new address: ");
               String newAddr = input.nextLine();
               list.remove(2);
               list.add(newAddr, 2);
               System.out.println("Entry successfully edited.");
               System.out.println(list.toString());
               break;
            case "c":
               System.out.println("Enter new city: ");
               String newCity = input.nextLine();
               list.remove(3);
               list.add(newCity, 3);
               System.out.println("Entry successfully edited.");
               System.out.println(list.toString());
               break;
            case "p":
               System.out.println("Enter new phone number: ");
               String newNum = input.nextLine();
               list.remove(4);
               list.add(newNum, 4);
               System.out.println("Entry successfully edited.");
               System.out.println(list.toString());
               break;
         } //end switch case
      }
   } //end editEntry method

   //Display menu command options
   private static void menuOptions() {
      System.out.println("Please enter a command:");
      System.out.println("   c) Create entry");
      System.out.println("   v) View entry");
      System.out.println("   e) Edit entry");
      System.out.println("   d) Delete entry");
      System.out.println("   p) Print entry");
      System.out.println("   q) Quit");
   } //end menuOptions method
   
} //end PhoneBookMenu class