/*Programmer: Christine McIntee
  Date: August 10th 2023
  Program: Phone Book
  Constructs list node.*/
  
public class ListNode {
   //Fields
   public String data;
   public ListNode next;
   
   //Constructs empty ListNode
   public ListNode() {
      this.data = null;
      this.next = null;
   } //end empty ListNode

   //Constructs ListNode with given data
   public ListNode(String data) {
      this.data = data;
      this.next = null;
   } //end ListNode with data
   
   //Construct ListNode with given data and link
   public ListNode(String data, ListNode next) {
      this.data = data;
      this.next = next;
   } //end ListNode with data and link
   
} //end ListNode class