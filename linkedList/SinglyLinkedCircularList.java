/**
 * @File : SinglyLinkedCircularList.java
 * @Description : class for for singly linked circular list, filling elements and 
 *                traversal in forward direction and counting the number of elements in the list.
 * @author Pavan Chokshi
 * 
 */

class SinglyLinkedCircularList
{
   private int data;
   private SinglyLinkedCircularList next;
 
 
   public SinglyLinkedCircularList()
   {
      data = 0;
      next = this;
   }
 
   public SinglyLinkedCircularList(int value)
   {
      data = value;
      next = this;
   }
 
   public SinglyLinkedCircularList InsertNext(int value)
   {
      SinglyLinkedCircularList node = new SinglyLinkedCircularList(value);
      if (this.next == this) // only one node in the circular list
      {
         // Easy to handle, after the two lines of executions,
         // there will be two nodes in the circular list
         node.next = this;
         this.next = node;
      }
      else
      {
         // Insert in the middle
 
         SinglyLinkedCircularList temp = this.next;
         node.next = temp;
         this.next = node;
      }
      return node;
 
   }
 
   public int DeleteNext()
   {
      if (this.next == this)
      {
         System.out.println("\nThe node can not be deleted as there is only one node in the circular list");
         return 0;
      }
 
      SinglyLinkedCircularList node = this.next;
      this.next = this.next.next;
      node = null;
      return 1;
   }
 
   public void Traverse()
   {
      Traverse(this);
   }
 
   public void Traverse(SinglyLinkedCircularList node)
   {
      if (node == null)
         node = this;
      System.out.println("\n\nTraversing in Forward Direction\n\n");
      SinglyLinkedCircularList startnode = node;
 
      do
      {
         System.out.println(node.data);
         node = node.next;
      }
      while (node != startnode);
   }
 
   public int GetNumberOfNodes()
   {
      return GetNumberOfNodes(this);
   }
 
   public int GetNumberOfNodes(SinglyLinkedCircularList node)
   {
      if (node == null)
         node = this;
 
      int count = 0;
      SinglyLinkedCircularList startnode = node;
      do
      {
         count++;
         node = node.next;
      }
      while (node != startnode);
 
      System.out.println("\nCurrent Node Value: " + node.data);
      System.out.println("\nTotal nodes in Circular List: " + count);
 
      return count;
   }
 
   public static void main(String[] args)
   {
 
      SinglyLinkedCircularList node1 = new SinglyLinkedCircularList(1);
      node1.DeleteNext(); // Delete will fail in this case.
 
      SinglyLinkedCircularList node2 = node1.InsertNext(2);
      node1.DeleteNext(); // It will delete the node2.
 
      node2 = node1.InsertNext(2); // Insert it again
 
      SinglyLinkedCircularList node3 = node2.InsertNext(3);
      SinglyLinkedCircularList node4 = node3.InsertNext(4);
      SinglyLinkedCircularList node5 = node4.InsertNext(5);
 
      node1.GetNumberOfNodes();
      node3.GetNumberOfNodes();
      node5.GetNumberOfNodes();
 
      node1.Traverse();
      node3.DeleteNext(); // delete the node "4"
      node2.Traverse();
 
      node1.GetNumberOfNodes();
      node3.GetNumberOfNodes();
      node5.GetNumberOfNodes();
   }
}