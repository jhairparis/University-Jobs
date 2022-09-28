package com.works.dataStructures.List;


public class SinglyLinkedList<T> {

  Node head;
  int size;

  public SinglyLinkedList() {
    head = null;
    size = 0;
  }

  private Node nodeAt(int i) {
    Node node = head;
    for(int k=0; k<i; k++)
      node = node.next;
    return node;
  }
  
  public void add(int i, T val) {
    if (i < 0 || i > size)
      throw new IndexOutOfBoundsException();
    Node new_node = new Node(val);
    if (i==0) {
      new_node.next = head;
      head = new_node;
    } else {
      Node prev = nodeAt(i-1);
      new_node.next = prev.next;
      prev.next = new_node;
    }
    size++;
  }

  public T get(int i) {
    if (i < 0 || i >= size)
      throw new IndexOutOfBoundsException();
    Node node = nodeAt(i);
    return node.val;
  }

  public void set(int i, T val) {
    if (i < 0 || i >= size)
      throw new IndexOutOfBoundsException();
    Node node = nodeAt(i);
    node.val = val;
  }

  public T remove(int i) {
    if (i < 0 || i >= size)
      throw new IndexOutOfBoundsException();
    T val;
    if (i==0) {
      val = head.val;
      head = head.next;
    } else {
      Node prev = nodeAt(i-1);
      val = prev.next.val;
      prev.next = prev.next.next;
    }
    size--;
    return val;    
  }

  public int size() {
    return size;
  }

  public String toString() {
    String s = "[";
    Node node = head;
    while (node!=null) {
      s += node.val + ", ";
      node = node.next;
    }
    return s + "]";
  }
  
  private class Node {
    T val;
    Node next;

    Node(T v) {
      val = v;
      next = null;
    }
  }
  
}