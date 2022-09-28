package com.works.dataStructures.List;


import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

  private Node head, tail;
  private int size;
  private int n_modifications;
  
  public LinkedList(){
    head = null;
    tail = null; 
    size = 0;
    n_modifications = 0;
  }

  private Node nodeAt(int i) {
    Node node;
    if (i<size/2) {
      node = head;
      for(int k=0; k<i; k++)
        node = node.next;
    } else {
      node = tail; 
      for(int k=0; k<size-i-1; k++)
        node = node.prev;
    }
    return node;
  }

  public void add(int i, T val) {
    if (i < 0 || i > size)
      throw new IndexOutOfBoundsException();
    Node new_node = new Node(val);
    if (size==0) {
      head = new_node;
      tail = new_node;
    } else if (i==0) {
      new_node.next = head;
      head.prev = new_node;
      head = new_node;
    } else if (i==size) {
      new_node.prev = tail;
      tail.next = new_node;
      tail = new_node;
    } else {
      Node p = nodeAt(i-1);
      new_node.prev = p;
      new_node.next = p.next;
      p.next.prev = new_node;
      p.next = new_node;
    }
    n_modifications++;
    size++;
  }

  public T remove(int i) {
    if (i < 0 || i >= size)
      throw new IndexOutOfBoundsException();
    T val;
    if (size==1) {
      val = head.val;
      head = null;
      tail = null;
    } else if (i==0) {
      val = head.val;
      head = head.next;
      head.prev = null;
    } else if (i==size-1) {
      val = tail.val;
      tail = tail.prev;
      tail.next = null;
    } else {
      Node p = nodeAt(i-1);
      val = p.next.val;
      p.next.next.prev = p;
      p.next = p.next.next;
    }
    n_modifications++;
    size--;
    return val;
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
    Node next, prev;

    Node(T v) {
      val = v;
      next = null;
      prev = null;
    }
  }

  public Iterator<T> iterator() {
      return new LinkedListIterator();
  }

  public class LinkedListIterator implements Iterator<T> {
    Node node;
    int current_modifications; 
    private LinkedListIterator() {
      node = head;
      current_modifications = n_modifications;
    }
    public T next() {
      if (current_modifications!=n_modifications)
        throw new ConcurrentModificationException();        
      if (!hasNext())
        throw new NoSuchElementException();
      T val = node.val;
      node = node.next;
      return val;
    }
    public boolean hasNext() {
      if (current_modifications!=n_modifications)
        throw new ConcurrentModificationException();      
      return node!=null;
    }
  }
}