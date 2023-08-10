/*Programmer: Christine McIntee
  Date: August 10th 2023
  Program: Phone Book
  Creates and manages list nodes and phone book data.*/
  
import java.util.Scanner; 
  
public class PhoneBookManager {
   //Fields
   private ListNode front;

   //Constructs PhoneBookManager
   public PhoneBookManager() {
      front = null;
   } //end PhoneBookManager constructor
   
   //Add data to end of list
   public void add(String data) {
      if (front == null) {
         front = new ListNode(data);
      } else {
         ListNode current = front;
         while (current.next != null) {
            current = current.next;
         }
         current.next = new ListNode(data);
      }
   } //end add method
   
   //Add data to list at given index
   //Pre-condition: index <= size()
   public void add(String data, int index) {
      if (index == 0) {
         front = new ListNode(data, front);
      } else {
         ListNode current = nodeAt(index - 1);
         current.next = new ListNode(data, current.next);
      }
   } //end add method
   
   //Get data from list
   public String get(int index) {
      ListNode current = front;
      for (int i = 0; i < index; i++) {
         current = current.next;
      }
      return current.data;
   } //end get method
   
   //Return list as String
   public String toString() {
      if (front == null) {
         return "List is empty. Please create an entry first.";
      } else {
         String result = "[" + front.data;
         ListNode current = front.next;
         while (current != null) {
            result += " " + current.data;
            current = current.next;
         }
         result += "]";
         return result;
      }
   } //end toString method
   
   //Remove data from list at given index
   public void remove(int index) {
      if (index == 0) {
         front = front.next;
      } else {
         ListNode current = nodeAt(index - 1);
         current.next = current.next.next;
        }
   } //end remove method
   
   //Remove all data in list
   public void removeAll(PhoneBookManager list) {
      ListNode current = nodeAt(0);
      if (size() > 0) {
         front = null;
         current.next = null;
      }
   } //end removeAll method
   
   //Return number of nodes in list
   public int size() {
      int count = 0;
      ListNode current = front;
      while (current != null) {
         count++;
         current = current.next;
      }
      return count;
   } //end size method
   
   //Return reference to node at given index
   public ListNode nodeAt(int index) {
      ListNode current = front;
      for (int i = 0; i < index; i++) {
         current = current.next;
      }
      return current;
   } //end nodeAt method  
   
   //Return true if list is empty
   public boolean isEmpty() {
      if(this.front == null) {
         return true;
      } else
         return false;
   } //end isEmpty method
     
} //end PhoneBookManager class