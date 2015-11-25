/**
 * @File : DoublyLinkedList.java
 * @Description : class for implementing Queue using LinkedList
 * @author Pavan Chokshi
 * 
 */

public class QueueLinkedListApp {
    public static void main(String[] args) {
           
           QueueLinkedList queueLinkedList=new QueueLinkedList();
           
           queueLinkedList.insert(39); //insert node.
           queueLinkedList.insert(71); //insert node.
           queueLinkedList.insert(11); //insert node.
           queueLinkedList.insert(76); //insert node.
 
           queueLinkedList.displayStack(); // display LinkedList
                        
           queueLinkedList.remove();  //remove Node
           queueLinkedList.remove();  //remove Node
           
           queueLinkedList.displayStack(); //Again display LinkedList
           
           
           
 
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
 *Exception to indicate that Queue is empty.
 */
class QueueEmptyException extends RuntimeException {
     
    public QueueEmptyException(){
        super();
    }
    
    public QueueEmptyException(String message){
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
     * removes last Node from LinkedList
     */
    public Node removeLast(){
           
           //Case1: when there is no element in LinkedList
           if(first==null){  //means LinkedList in empty, throw exception.              
                  throw new LinkedListEmptyException("LinkedList doesn't contain any Nodes.");
           }
           
           //Case2: when there is only one element in LinkedList
           if(first.next==null){   //means LinkedList consists of only one element, remove that.
                  Node tempNode = first; // save reference to first Node in tempNode- so that we could return saved reference.
                  first=first.next; // remove firstNode (make first point to secondNode)
                  return tempNode;  //return removed Node.
           }
           
           //Case3: when there are atLeast two elements in LinkedList
           Node previous=null; 
           Node current=first;
           
           while(current.next!=null){//Executes until we don't find last Node of LinkedList.
                                             //If next of some Node is pointing to null, that means it's a last Node.
                  previous=current;
                  current=current.next;   //move to next node.
           }
           
           previous.next=null;     //Now, previous is pointing to second last Node of LinkiedList,
                                                    //make it point to null [it byPasses current Node(last Node of LinkedList) which was in between]
           return current;
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
 * For implementing queue using using LinkedList- This QueueLinkedList class internally maintains LinkedList reference.
 */
 
class QueueLinkedList{
    
    LinkedList linkedList = new LinkedList(); // creation of Linked List
    
    /**
     * Insert element at rear in Queue
     */
    public void insert(int value){
           linkedList.insertFirst(value);
    }
 
    /**
     * Removes elements from front of Queue 
     */
    public void remove() throws QueueEmptyException {
           try{
           linkedList.removeLast();
           }catch(LinkedListEmptyException llee){
                  throw new QueueEmptyException();
           }
    }
 
    /**
     * Display queue.
     */
    public void displayStack() {
           System.out.print("Displaying Queue> Front to Rear: ");
           linkedList.displayLinkedList();
    }
 
    
}
 