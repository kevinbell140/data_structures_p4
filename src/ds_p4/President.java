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
 *Defines a president object
 */
public class President {
    private int number;
    private String name;
    private String firstName;
    private String lastName;
    private String code;
    private int term;
    private String party;
    private String state;
   


    public President(int inNumber, String inName, String inFN, String inLN, String inCode, int inTerm, String inParty, String inState){
        number = inNumber;
        name = inName;
        firstName = inFN;
        lastName = inLN;
        code = inCode;
        term = inTerm;
        party = inParty;
        state = inState;    
    }//end constructor
    
    
    /**
     * Gets president's full name
     * @param none
     * @return full name of president
     */
    public String getName(){
        return name;
    }//end getName()
    
    
    /**
     * Gets president's last name
     * @param none
     * @return last name of president
     */
    public String getLast(){
        return lastName;
    }//end getLast()
    
    
    /**
     * Gets president's party
     * @param none
     * @return party of president
     */
    public String getParty(){
        return party;
    }//end getParty()
    
    
    /**
     * Gets president's number
     * @param none
     * @return number of president
     */
    public int getNumber(){
        return number;
    }//end getNumber()
    
    
    /**
     * Gets president's term
     * @param none
     * @return term of a president
     */
    public int getTerm(){
        return term;
    }//end getTerm()
    
    
    /**
     * Sets president's first name
     * @param first First name of president
     * @return void
     */
    public void setFirst(String first){
        firstName = first;
    }//end setFirst
    
    
    /**
     * Sets president's last name
     * @param last Last name of president
     * @return void
     */
    public void setLast(String last){
        lastName = last;
    }//setLast() 
}//end President class