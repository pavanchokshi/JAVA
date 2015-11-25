/**
 * @File : SinglyLinkedList.java
 * @Description : class for singly linked list, filling elements and traversal in forward direction
 * @author Pavan Chokshi
 * 
 */

class SinglyLinkedList
{
   private int data;
   private SinglyLinkedList next;
 
   public SinglyLinkedList()
   {
      data = 0;
      next = null;
   }
 
   public SinglyLinkedList(int value)
   {
      data = value;
      next = null;
   }
 
 
   public SinglyLinkedList InsertNext(int value)
   {
      SinglyLinkedList node = new SinglyLinkedList(value);
      if(this.next == null)
      {
         // Easy to handle
         node.next = null; // already set in constructor
         this.next = node;
      }
      else
      {
         // Insert in the middle
         SinglyLinkedList temp = this.next;
         node.next = temp;
         this.next = node;
       }
       return node;
   }
 
   public int DeleteNext()
   {
      if(next == null)
         return 0;
 
       SinglyLinkedList node = this.next;
       this.next = this.next.next;  // can be NULL here
       node = null;
       return 1;
   }
 
   public void Traverse(SinglyLinkedList node)
   {
      if(node == null)
         node = this;
      System.out.println("\n\nTraversing in Forward Direction\n\n");
 
      while(node != null)
      {
         System.out.println(node.data);
         node = node.next;
      }
   }
 
  
 
   public static void main(String[] args)
   {
      SinglyLinkedList node1 = new SinglyLinkedList(1);
      SinglyLinkedList node2 = node1.InsertNext(2);
      SinglyLinkedList node3 = node2.InsertNext(3);
      SinglyLinkedList node4 = node3.InsertNext(4);
      SinglyLinkedList node5 = node4.InsertNext(5);
 
      node1.Traverse(null);
      node3.DeleteNext(); // delete the node "4"
      node2.Traverse(null);
     
   }
}