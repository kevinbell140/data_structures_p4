/*
Author: Kevin Bell
Course: COP3538
Project#: 4
Title: Binary Search Tree
Due Date: 11/15/2016

Builds, traverses, and modifies a binary search tree
 */

package ds_p4;

/**
 * Provides properties and methods for a node of a binary search tree
 */
public class Node {
   String last;
   String party;
   int number;
   int term;

   
   Node leftChild;
   Node rightChild;
   
   
   /**
    * Displays a node of the tree
    * @param none
    * @return void
    */
   public void displayNode(){
       System.out.format("\n%-15s%-15s%-5s%-4s", last, party, number, term);
   }//end displayNode()
}//end Node class
