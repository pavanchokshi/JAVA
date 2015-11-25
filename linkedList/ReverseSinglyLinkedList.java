/**
 * @File : ReverseSinglyLinkedList.java
 * @Description : class for singly linked list, filling elements and traversal in forward and reverse direction
 * @author Pavan Chokshi
 * 
 */

class ReverseSinglyLinkedList
{
   private int data;
   private ReverseSinglyLinkedList next;
 
   public ReverseSinglyLinkedList()
   {
      data = 0;
      next = null;
   }
 
   public ReverseSinglyLinkedList(int value)
   {
      data = value;
      next = null;
   }
 
 
   public ReverseSinglyLinkedList InsertNext(int value)
   {
      ReverseSinglyLinkedList node = new ReverseSinglyLinkedList(value);
      if(this.next == null)
      {
         // Easy to handle
         node.next = null; // already set in constructor
         this.next = node;
      }
      else
      {
         // Insert in the middle
         ReverseSinglyLinkedList temp = this.next;
         node.next = temp;
         this.next = node;
       }
       return node;
   }
 
   public int DeleteNext()
   {
      if(next == null)
         return 0;
 
       ReverseSinglyLinkedList node = this.next;
       this.next = this.next.next;  // can be NULL here
       node = null;
       return 1;
   }
 
   public void Traverse(ReverseSinglyLinkedList node)
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
       public ReverseSinglyLinkedList Reverse_With_Bubble(ReverseSinglyLinkedList head)
      {
         ReverseSinglyLinkedList testnode = null;
         if (head == null)
            return head;
 
         while (true)
         {
            ReverseSinglyLinkedList p = head;
            if (p.next == testnode)
               break;
            while (true)
            {
               int temp = p.data;
               p.data = p.next.data;
               p.next.data = temp;
               p = p.next;
               if (p.next == testnode)
               {
                  testnode = p;
                  break;
               }
            }
         }
         return head;
      }
 
      public ReverseSinglyLinkedList Reverse(ReverseSinglyLinkedList head)
      {
         if (head == null)
            return head;
 
         ReverseSinglyLinkedList cp = head;
         ReverseSinglyLinkedList prev = null;
 
         while (cp != null)
         {
            ReverseSinglyLinkedList next = cp.next;
            cp.next = prev;
            prev = cp;
            cp = next;
         }
         head = prev;
         return head;
      }

 
   public ReverseSinglyLinkedList Reverse_with_copy(ReverseSinglyLinkedList head)
   {
      ReverseSinglyLinkedList p = head;
      ReverseSinglyLinkedList newhead = null;
      while(true)
      {
            if(p == null)
                  return newhead;
            ReverseSinglyLinkedList newnode = new ReverseSinglyLinkedList(p.data);
            newnode.next = newhead;
            newhead = newnode;
            p = p.next;
      }
   }
  
   public static void main(String[] args)
   {
      ReverseSinglyLinkedList head = new ReverseSinglyLinkedList(1);
      ReverseSinglyLinkedList p = head.InsertNext(2);
      p = p.InsertNext(3);
      p = p.InsertNext(4);
      p = p.InsertNext(5);
      p = p.InsertNext(6);
      p = p.InsertNext(7);
      p = p.InsertNext(8);
 
      head.Traverse(null);
 
      ReverseSinglyLinkedList newhead = head.Reverse(head);
      newhead.Traverse(null);
     
   }
}