/*Programmer: Christine McIntee
  Date: August 10th 2023
  Program: Phone Book
  Main class to test ListNode, PhoneBookManager, 
  and PhoneBookMenu classes.*/

import java.util.Scanner;
import java.io.*;
  
public class PhoneMain {
   
   //Main method 
   public static void main(String[] args) throws FileNotFoundException {
      PhoneBookMenu phoneBook = new PhoneBookMenu();
      phoneBook.menu();
   } //end main method

} //end PhoneMain class