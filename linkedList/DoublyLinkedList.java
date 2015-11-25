/**
 * @File : DoublyLinkedList.java
 * @Description : class for doubly linked list, filling elements and traversal in forward and backward direction
 * @author Pavan Chokshi
 * 
 */

class DoublyLinkedList
{
   private int data;
 
   private DoublyLinkedList next;
   private DoublyLinkedList prev;
 
   public DoublyLinkedList()
   {
      data = 0;
      next = null;
      prev = null;
   }
 
   public DoublyLinkedList(int value)
   {
      data = value;
      next = null;
      prev = null;
   }
 
   public DoublyLinkedList InsertNext(int value)
   {
      DoublyLinkedList node = new DoublyLinkedList(value);
      if(this.next == null)
      {
 
            // Easy to handle
            node.prev = this;
            node.next = null; // already set in constructor
            this.next = node;
      }
      else
      {
            // Insert in the middle
            DoublyLinkedList temp = this.next;
            node.prev = this;
            node.next = temp;
            this.next = node;
            temp.prev = node;
            // temp.next does not have to be changed
      }
      return node;
   }
 
   public DoublyLinkedList InsertPrev(int value)
   {
      DoublyLinkedList node = new DoublyLinkedList(value);
      if(this.prev == null)
      {
            node.prev = null; // already set on constructor
            node.next = this;
            this.prev = node;
      }
      else
      {
 
            // Insert in the middle
            DoublyLinkedList temp = this.prev;
            node.prev = temp;
            node.next = this;
            this.prev = node;
            temp.next = node;
            // temp.prev does not have to be changed
      }
      return node;
   }
 
   public void TraverseFront()
   {
      TraverseFront(this);
   }
 
   public void TraverseFront(DoublyLinkedList node)
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
 
   public void TraverseBack()
   {
      TraverseBack(this);
   }
 
   public void TraverseBack(DoublyLinkedList node)
   {
      if(node == null)
            node = this;
      System.out.println("\n\nTraversing in Backward Direction\n\n");
      while(node != null)
      {
            System.out.println(node.data);
            node = node.prev;
      }
   }
 
   public static void main(String[] args)
   {
 
      DoublyLinkedList node1 = new DoublyLinkedList(1);
      DoublyLinkedList node3 = node1.InsertNext(3);
      DoublyLinkedList node2 = node3.InsertPrev(2);
      DoublyLinkedList node5 = node3.InsertNext(5);
      DoublyLinkedList node4 = node5.InsertPrev(4);
 
      node1.TraverseFront();
      node5.TraverseBack();
   }
} 