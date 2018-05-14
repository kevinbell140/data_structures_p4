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
 * Provides properties and methods for a stack
 */
public class LinkyStack {
    
        private Node[] prezStack;
        
        private int stackElem;
        private int top;
    
        
    /**
     * Constructor for LinkyStack
     * @return constructor
     * @param none
     */
    public LinkyStack(){
        prezStack = new Node[16];
        top = -1;
        stackElem = 0; 
    }//end constructor
    
    
    /**
     * Pushes presidents onto the stack
     * @return void
     * @param president The president object to be pushed onto stack 
     */
    public void push(Node president){
        prezStack[++top] = president;
        stackElem++; 
    }//end push()
    
    
    /**
     * Pops presidents off of the stack
     * @return The president removed from the top of the stack
     * @param none
     */
    public Node pop(){
        return prezStack[top--];   
    }//end pop()
    
    
    /**
     * Gets the president on top of the stack
     * @return The president on top of the stack
     * @param none
     */
    public Node peek(){
        return prezStack[top];
    }//end peek()
    
    
    /**
     * Determines if the stack is empty
     * @return True if stack is empty
     * @param none
     */
    public boolean isEmpty(){
        
        return(top == -1);
    }//end isEmpty()
        
    
    /**
     * Returns the number of objects in the stack
     * @return The number of objects in the stack
     * @param none
     */
    public int getSize(){
        return stackElem;
    }//end size()
    
    

    /**
     * Gets the header for stack when displayed
     * @return void
     * @param none
     */
    private void getStackHeader(){
        System.out.format("%-12s%-12s%-16s%-12s%-4s", "Last", "First", "State","Party", "Code");
        System.out.format("\n%-12s%-12s%-16s%-12s%-4s\n", "-------", "-------", "-----------", "----------", "-------");
    }//end getStackHeader()
}//end LinkyStack class
