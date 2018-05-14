/*
Author: Kevin Bell
Course: COP3538
Project#: 4
Title: Binary Search Tree
Due Date: 11/15/2016

Builds, traverses, and modifies a binary search tree
 */
package ds_p4;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Builds, traverses, and modifies a binary search tree
 */
public class Main {

    
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        int order0 = 0;
        int order1 = 1;
        int order2 = 2;
        
        President_Controller Drvr = new President_Controller(); 
        
        FileInterface prezData = new FileInterface("TreePres.txt");
        prezData.parse();
        prezData.buildStrings();
        
        for (String president: prezData.getDataStrings()){
            Drvr.insertArray(president);
        }//end for
               
        Drvr.buildTree();
        Drvr.scan();
        Drvr.delete(order0);
        
        Drvr.buildTree();
        Drvr.delete(order1);
        
        Drvr.buildTree();
        Drvr.delete(order2);
        
     }//end main
}//end Main class
