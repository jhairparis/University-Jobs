package com.works.dataStructures.StackQueue.custom;

import java.util.ArrayList;

public class Stack<T> {

  private ArrayList<T> list;

  public Stack() {
    list = new ArrayList<T>();
  }

  public void push(T val) {
    list.add(val);
  }

  public T pop() {
    return list.remove(list.size() - 1);
  }

  public T peek() {
    return list.get(list.size() - 1);
  }

  public int size() {
    return list.size();
  }

  public String toString() {
    return list.toString();
  }
}