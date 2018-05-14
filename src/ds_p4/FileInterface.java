/*
Author: Kevin Bell
Course: COP3538
Project#: 4
Title: Binary Search Tree
Due Date: 11/15/2016

Builds, traverses, and modifies a binary search tree
 */
package ds_p4;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author kbell
 */
public class FileInterface {
    private FileReader fr;
    private BufferedReader br;
    
    private ArrayList<President> fileData;
    private ArrayList<String> dataStrings;
    
    
    /**
     * Constructor for FileInterface
     * @param file the input file
     * @return constructor
     * @throws FileNotFoundException 
     */
    public FileInterface(String file) throws FileNotFoundException{
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        
        fileData = new ArrayList<>();
        dataStrings = new ArrayList<>();
    }//end FileInterface()
    
    
    /**
     * Parse input file
     * @param none
     * @return void
     * @throws IOException 
     */
    public void parse() throws IOException{
        int number;
        String name;
        String first;
        String last;
        String code;
        int term;
        String party;
        String state;
        String input;
        
        while((input = br.readLine()) != null){
            try{
                number = Integer.parseInt(input.substring(0,2).trim());
                name = input.substring(2,25).trim();
                first = null;
                last = null;
                code = input.substring(25,27).trim();
                term = Integer.parseInt(input.substring(27,29).trim());
                party = input.substring(29,49).trim();
                state = input.substring(49,input.length()).trim();
                
                fileData.add(new President(number, name, first, last, code, term, party, state));
                }
            
            catch(Exception e){
                }//end try
        }//end while  
    }//end parse()
    
    
    /**
     * Creates comma delimited strings
     * @param none
     * @return void
     */
    public void buildStrings(){
        
        for (President president: fileData){
            nameSplitter(president);
            dataStrings.add(president.getLast()+ ","+ president.getParty()+","+president.getNumber()+ ","+ president.getTerm());
        }//end for
    }//end buildStrings()
    
    
    /**
     * Splits president's full name into first and last name
     * @param president The president's name being split
     * @return void
     */
    private void nameSplitter(President president){
        String[] tempArray = new String[2];
        String name = president.getName();
        
        tempArray = name.split("\\s");
        
        president.setFirst(tempArray[0]);
        president.setLast(tempArray[1]);  
    }//end nameSplitter
    
    
    /**
     * Gets file data
     * @param none
     * @return The file data array
     */
    public ArrayList<String> getDataStrings(){
        return dataStrings;
    }//end getFileData
    

}//end FileInterface
