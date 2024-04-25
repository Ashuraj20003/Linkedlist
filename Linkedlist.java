import java.util.*;

public class Linkedlist {

  public static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static Node head;
  public static Node tail;
  public static int size;

  public void firstAdd(int data) {

    Node newNode = new Node(data);
    size++;
    if (head == null) {
      head = tail = newNode;
      return;
    }

    newNode.next = head;

    head = newNode;

  }

  public void print() {

    if (head == null) {
      System.out.print("LInkedlist is Empty");
      return;
    }
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + "--> ");
      temp = temp.next;
    }
    System.out.println("null");

  }

  public void lastAdd(int data) {
    Node newNode = new Node(data);
    size++;
    if (head == null) {
      head = tail = newNode;
      return;
    }
    tail.next = newNode;
    tail = newNode;
  }

  public void add(int idx, int data) {
    if (idx == 0) {
      firstAdd(data);
      return;
    }
    Node newNode = new Node(data);
    size++;
    Node temp = head;
    int i = 0;
    while (i < idx - 1) {
      temp = temp.next;
      i++;
    }
    newNode.next = temp.next;
    temp.next = newNode;

  }

  public int removeFirst() {
    int val = head.data;
    head = head.next;
    return val;

  }

  public int removeLast() {
    if (size == 0) {
      System.out.print("ll is empty");
      return Integer.MIN_VALUE;
    } else if (size == 1) {
      int val = head.data;
      head = tail = null;
      size = 0;
      return val;

    }
    Node prev = head;
    for (int i = 0; i < size - 2; i++) {
      prev = prev.next;
    }
    int val = tail.data;
    prev.next = null;
    tail = prev;
    size--;
    return val;

  }

  public int itrSearch(int key) {
    Node temp = head;
    int i = 0;
    while (temp != null) {
      if (temp.data == key) {
        return i;
      }
      temp = temp.next;
      i++;
    }
    return -1;
  }

  public int helper(Node head, int key) {
    if (head == null) {
      return -1;
    }
    if (head.data == key) {
      return 0;
    }
    int idx = helper(head.next, key);

    if (idx == -1) {
      return -1;
    }
    return idx + 1;

  }

  public void reverLL() {
    Node prev = null;
    Node curr = tail = head;
    Node next;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    head = prev;
  }

  public int recSearch(int key) {
    return helper(head, key);
  }

  public void removeNthNodeToEnde(int n) {
    int sz = 0;
    Node temp = head;
    while (temp != null) {
      temp = temp.next;
      sz++;
    }

    if (sz == 0) {
      head = head.next;
      return;
    }
    int i = 1;
    int iToNth = sz - n;
    Node prev = head;
    while (i < iToNth) {
      prev = prev.next;
      i++;
    }
    prev.next = prev.next.next;
    return;

  }

  public Node findMid(Node head) {
    Node slow = head;
    Node fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public boolean checkPelindrom() {
    if (head == null || head.next == null) {
      return true;
    }
    Node mid = findMid(head);

    /// reverce
    Node prev = null;
    Node curr = mid;
    Node next;

    while (curr != null) {

      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    Node right = prev;
    Node left = head;

    while (right != null) {
      if (right.data != left.data) {
        return false;
      }

      right = right.next;
      left = left.next;

    }
    return true;
  }

  public static boolean isCycle() {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (fast == slow) {
        return true;

      }
    }
    return false;

  }

  public static void removeCycle() {
    Node fast = head;
    Node slow = head;
    boolean cycle = false;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        cycle = true;
        break;
      }
      if (cycle == false) {
        return;
      }
      Node prev = null;
      while (slow != fast) {
        prev = fast;
        slow = slow.next;
        fast = fast.next;

      }
      prev.next = null;

    }
  }

  public static void main(String[] args) {
    Linkedlist ll = new Linkedlist();
    // ll.firstAdd(2);
    // ll.firstAdd(1);
    // ll.lastAdd(4);
    // ll.lastAdd(5);
    // ll.add(2, 3);
    // ll.firstAdd(0);
    // ll.removeFirst();
    // ll.print();
    // System.out.println("size of Linkedlist:>" + ll.size);
    // ll.print();
    // ll.removeLast();
    // System.out.println("size of Linkedlist:>" + ll.size);

    // System.out.print(ll.recSearch(2));
    // System.out.print(ll.recSearch(100));
    // ll.firstAdd(1);
    // ll.firstAdd(2);
    // ll.firstAdd(2);
    // ll.firstAdd(1);
    // ll.print();
    // ll.reverLL();
    // ll.print();
    // ll.removeNthNodeToEnde(3);
    // ll.print();
    // System.out.println(ll.checkPelindrom());

    head = new Node(1);
    head.next = new Node(2);
    Node temp = new Node(3);
    temp.next = head.next;

    System.out.println(isCycle());
    removeCycle();
    System.out.print(isCycle());
    ll.print();

  }
}
