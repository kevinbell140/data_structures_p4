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
 * Contains methods and properties of a binary search tree
 */
public class President_Controller {
    
    private String[] prezArray;
    private int pElem;
    private Tree prezTree;

    
    /**
     * Constructor for President Controller
     * @param none
     * @return constructor
     */
    public President_Controller(){
        prezArray = new String[16];
        pElem = 0;
    }//end President_Controller()
    
    
    /**
     * Inserts a president into the array
     * @param president President to be inserted
     * @return void
     */
    public void insertArray(String president){
        prezArray[pElem++] = president;
    }//end insertArray
    
    
    /**
     * Displays president array
     * @param none
     * @return void
     */
    public void displayArray(){          
        
        for (String president: prezArray){
            System.out.println(president);
        }//end for
    }//end displayArray()
    
    
    /**
     * Inserts presidents into the binary search tree
     * @param none
     * @return void
     */
    public void buildTree(){
        
        prezTree = new Tree();
        
        for (String president: prezArray){
            String[] nodeData = new String[4];
            nodeData = president.split(",");
            prezTree.insert(nodeData[0], nodeData[1], nodeData[2], nodeData[3]);
        }//end for
    }//end buildTree()

    
    
    /**
     * Scans the tree iteratively and recursively
     * @param none
     * @return void
     */
    public void scan(){
        iterate();
        traverse();
    }//end scan()
    
    
    /**
     * Displays the tree with recrusive NLR, LNR, and LRN Scans
     * @param none
     * @return void
     */
    private void traverse(){
        
        System.out.println("\n\n\nTask 6: Recursive NLR Scan");
        getHeader();
        prezTree.preorderRec(prezTree.getRoot());
        System.out.println("\n\n\nTask 7: Recursive LNR Scan");
        getHeader();
        prezTree.inorderRec(prezTree.getRoot());
        System.out.println("\n\n\nTask 8: Recursive LRN Scan");
        getHeader();
        prezTree.postorderRec(prezTree.getRoot());
    }//end traverse()
    
    
    /**
     * Displays the tree with iterative NLR, LNR, and LRN Scans
     * @param none
     * @return void
     */
    private void iterate(){
        
        System.out.println("\nTask 3: Iterative NLR Scan ");
        getHeader();
        prezTree.preorderIt();
        System.out.println("\n\n\nTask 4: Iterative LNR Scan");
        getHeader();
        prezTree.inorderIt();
        System.out.println("\n\n\nTask 5: Iterative LRN Scan");
        getHeader();
        prezTree.postorderIt();
    }//end iterate()
    

    /**
     * Deletes a specified node from the tree
     * @param type The number of children of a given node
     * @return void
     */
    public void delete(int type){
      
        switch(type){
            case 0: 
                prezTree.delete("Nixon");
                System.out.println("\n\n\nFirst delete (zero children): Nixon ");
                getHeader();
                prezTree.inorderIt();
                break;
            case 1:
                prezTree.delete("Grant");
                prezTree.delete("Taylor");
                System.out.println("\n\n\nSecond delete (one child): Grant, Taylor");
                getHeader();
                prezTree.inorderIt();
                break;
            case 2: 
                prezTree.delete("Van_Buren");
                prezTree.delete("Clinton");
                System.out.println("\n\n\nThird delete (two children): Van_Buren, Clinton ");
                getHeader();
                prezTree.inorderIt();
                break;
        }//end switch    
    }//end delete()
    
    
    /**
     * Gets the formated column header
     * @param none
     * @return void
     */
    private void getHeader(){
        
        String columns = String.format("\n%-15s%-15s%-3s%-1s%-4s", "Last Name", "Party", "#", " ", "Term");
        String lines = String.format("%-15s%-14s%-3s%-4s", "------------", "---------", "--- ", "------");
        System.out.println(columns);
        System.out.print(lines);
    }//end getHeader()
    
}//end President_Controller class
