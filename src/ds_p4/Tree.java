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
 * Provides properties and methods for a binary search tree
 */
public class Tree {
    private Node root;
    
    
    /**
     * Constructor for tree class
     * @param none
     * @return constructor 
     */
    public Tree(){
        root = null;
    }//end constructor
    
    
    
    /**
     * Displays tree with an iterative preorder scan
     * @param none
     * @return void
     */
    public void preorderIt(){
        LinkyStack nodeStack = new LinkyStack();
        
        nodeStack.push(root);
        
        while(!nodeStack.isEmpty()){
            Node current = nodeStack.pop();
            current.displayNode();
        
            if (current.rightChild != null){
                nodeStack.push(current.rightChild);
            }//end if
            if (current.leftChild != null){
                nodeStack.push(current.leftChild);
            }//end if
        }//end while
    }//end preorderIt()
    
    
    /**
     * Displays tree with an iterative inorder scan
     * @param none
     * @return void
     */
    public void inorderIt(){
        LinkyStack nodeStack = new LinkyStack();
        Node current = root;
        Node temp;
        
        while(!nodeStack.isEmpty() || current!= null){
            if (current != null){
                nodeStack.push(current);
                current = current.leftChild;
            }else{
                temp = nodeStack.pop();
                temp.displayNode();
                current = temp.rightChild;
            }//end if
        }//end while
    }//end inorderIt()
    
   
    
    /**
     * Displays tree with an iterative postorder scan
     * @param none
     * @return void
     */
    public void postorderIt(){
        LinkyStack nodeStack = new LinkyStack();
        Node current = root;
        nodeStack.push(current);
        
        while(!nodeStack.isEmpty()){
            Node next = nodeStack.peek();
            
            boolean finishedSubtrees = (next.rightChild == current || next.leftChild == current);
            boolean isLeaf = (next.leftChild == null && next.rightChild == null);
            
            if (finishedSubtrees || isLeaf){
                nodeStack.pop();
                next.displayNode();
                current = next;
            }else{
                if (next.rightChild != null){
                    nodeStack.push(next.rightChild);
                }//end if
                if (next.leftChild != null){
                    nodeStack.push(next.leftChild);
                }//end if
            }//end if
        }//end while        
    }//end postorderIt()
    
    
    /**
     * Displays the tree with a recursive preorder scan
     * @param localRoot The root
     * @return void
     */
    public void preorderRec(Node localRoot){

        if (localRoot != null){
            localRoot.displayNode();
            preorderRec(localRoot.leftChild);
            preorderRec(localRoot.rightChild);
        }//end if
    }//end preorderRec()
    
    
    /**
     * Displays the tree with a recursive inorder scan
     * @param localRoot The root
     * @return void
     */
    public void inorderRec(Node localRoot){
        
        if (localRoot !=null){
            inorderRec(localRoot.leftChild);
            localRoot.displayNode();
            inorderRec(localRoot.rightChild);
        }//end if
    }//end inorderRec()
    
    
    /**
     * Displays the tree with a recursive postorder scan
     * @param localRoot The root
     * @return void
     */
    public void postorderRec(Node localRoot){
        
        if (localRoot != null){
            postorderRec(localRoot.leftChild);
            postorderRec(localRoot.rightChild);
            localRoot.displayNode();
        }//end if
    }//end postorderRec()
    
    
    /**
     * Inserts a president into the tree
     * @param president The president being inserted
     * @return void
     */
    public void insert(String last, String party, String num, String term){
        Node newNode = new Node();
        newNode.last = last;
        newNode.party = party;
        newNode.number = Integer.parseInt(num);
        newNode.term = Integer.parseInt(term);
        
        if (root == null){
            root = newNode;
        }else{
            Node current = root;
            Node parent;
            
            while (true){
                parent = current;
                
                if (last.compareTo(current.last)<0){
                    current = current.leftChild;
                    if (current == null){
                        parent.leftChild = newNode;
                        return;
                    }//end if
                }else{
                    current = current.rightChild;
                    if (current == null){
                        parent.rightChild = newNode;
                        return;
                    }//end if
                }//end if
            }//end while
        }//end if
    }//end insert()
    
   

    /**
     * Deletes a node from the tree
     * @param key The node to be deleted
     * @return True if found and deleted
     */
    public boolean delete(String key){
        
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        
       
        while(!current.last.equals(key)){
            parent = current;
            
            if (key.compareTo(current.last) <0){
                isLeftChild = true;
                current = current.leftChild;
            }else{
                isLeftChild = false;
                current = current.rightChild;
            }//end if
            
            if (current == null){
                return false;
            }//end if
        }//end while
        
        if(current.leftChild == null && current.rightChild == null){
            if(isLeftChild){
                parent.leftChild = null;
            }else{
                parent.rightChild = null;
            }//end if
        }else if (current.rightChild == null){
            if (current == root){
                root = current.leftChild;
            }else if(isLeftChild){
                parent.leftChild = current.leftChild;
            }else{
                parent.rightChild = current.leftChild;
            }//end if
        }else if(current.leftChild ==null){
            if (current == root){
                root = current.rightChild;
            }else if(isLeftChild){
                parent.leftChild = current.rightChild;
            }else {
                parent.rightChild = current.rightChild;
            }//end if
        }else{
            Node successor = getSuccessor(current);

            if(current == root){
                root = successor;
            }else if(isLeftChild){
                parent.leftChild = successor;
            }else{
                parent.rightChild = successor;
            }//end if
            successor.leftChild = current.leftChild;
        }//end if
        return true;
    }//end delete()
    
    
    
    /**
     * Gets the successor node of a deleted node
     * @param delNode The node to be deleted
     * @return The successor to the deleted node
     */
    private Node getSuccessor(Node delNode){
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        
        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }//end while
        
        if(successor != delNode.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }//end if
        return successor;
    }//end getScussessor
    
    /**
     * Gets the root of the tree
     * @param none
     * @return the root
     */
    public Node getRoot(){
        return root;
    }//end getRoot()
}//end Tree class
