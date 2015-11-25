/**
 * @File : DoublyLinkedList.java
 * @Description : class for implementing Stack using Linked List
 * @author Pavan Chokshi
 * 
 */

public class StackLinkedListApp {
    public static void main(String[] args) {
    
           StackLinkedList stackLinkedList=new StackLinkedList();
           stackLinkedList.push(39);  //push node.
           stackLinkedList.push(71);  //push node.
           stackLinkedList.push(11);  //push node.
           stackLinkedList.push(76);  //push node.
 
           stackLinkedList.displayStack(); // display LinkedList
                        
           stackLinkedList.pop();  //pop Node
           stackLinkedList.pop();  //pop Node
           
           stackLinkedList.displayStack(); //Again display LinkedList
           
           
           
 
    }
}
/**
 *Exception to indicate that LinkedList is empty.
 */
class LinkedListEmptyException extends RuntimeException{
       public LinkedListEmptyException(){
         super();
       }
      
     public LinkedListEmptyException(String message){
         super(message);
       }  
}
 
/**
 *Exception to indicate that Stack is empty.
 */
class StackEmptyException extends RuntimeException {
     
    public StackEmptyException(){
        super();
    }
    
    public StackEmptyException(String message){
        super(message);
    }
    
}
 
/**
 *Node class, which holds data and contains next which points to next Node.
 */
class Node {
    public int data; // data in Node.
    public Node next; // points to next Node in list.
 
    /**
     * Constructor
     */
    public Node(int data){
           this.data = data;
    }
 
    /**
     * Display Node's data
     */
    public void displayNode() {
           System.out.print( data + " ");
    }
}
 
 
/**
 * LinkedList class
 */
class LinkedList {
    private Node first; // ref to first link on list
 
    /**
     * LinkedList constructor
     */
    public LinkedList(){
           first = null;
    }
 
    /**
     * Insert New Node at first position
     */
    public void insertFirst(int data) {
           Node newNode = new Node(data); //Creation of New Node.
           newNode.next = first;   //newLink ---> old first
           first = newNode;  //first ---> newNode
    }
 
    /**
     * Deletes first Node
     */
    public Node deleteFirst()
    {
           if(first==null){  //means LinkedList in empty, throw exception.              
                  throw new LinkedListEmptyException("LinkedList doesn't contain any Nodes.");
           }
           Node tempNode = first; // save reference to first Node in tempNode- so that we could return saved reference.
           first = first.next; // delete first Node (make first point to second node)
           return tempNode; // return tempNode (i.e. deleted Node)
    }
    
           
    /**
     * Display LinkedList
     */
    public void displayLinkedList() {
           Node tempDisplay = first; // start at the beginning of linkedList
           while (tempDisplay != null){ // Executes until we don't find end of list.
                  tempDisplay.displayNode();
                  tempDisplay = tempDisplay.next; // move to next Node
           }
           System.out.println();
           
    }
 
}
 
 
/**
 * For implementing stack using using LinkedList- This StackLinkedList class internally maintains LinkedList reference.
 */
 
class StackLinkedList{
    
    LinkedList linkedList = new LinkedList(); // creation of Linked List
    
    /**
     * Push items in stack, it will put items on top of Stack.
     */
    public void push(int value){
           linkedList.insertFirst(value);
    }
 
    /**
     * Pop items in stack, it will remove items from top of Stack.
     */
    public void pop() throws StackEmptyException {
           try{
           linkedList.deleteFirst();
           }catch(LinkedListEmptyException llee){
                  throw new StackEmptyException();
           }
    }
 
    /**
     * Display stack.
     */
    public void displayStack() {
           System.out.print("Displaying Stack >  Top to Bottom : ");
           linkedList.displayLinkedList();
    }
 
    
}
  
