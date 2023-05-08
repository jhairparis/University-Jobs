package com.works.dataStructures.TreeSet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeSet<T extends Comparable<T>> {

  public Node root;
  private int size;

  public TreeSet() {
    root = null;
    size = 0;
  }

  public int height() {
    int h = 0;
    Queue<Node> Q = new LinkedList<Node>();
    Q.add(root);
    int nextLevel = 0;
    while (!Q.isEmpty()) {
      Node node = Q.poll();

      if (Q.size() == (nextLevel - 1)) {
        h++;
        nextLevel = 0;
      }

      if (node.left != null) {
        Q.offer(node.left);
        nextLevel++;
      }

      if (node.right != null) {
        Q.offer(node.right);
        nextLevel++;
      }

    }
    return h;
  }

  public boolean add(T val) {
    if (contains(val))
      return false;
    root = add_rec(root, val);
    size++;
    return true;
  }

  private Node add_rec(Node root, T val) {
    if (root == null)
      return new Node(val);
    if (val.compareTo(root.val) < 0)
      root.left = add_rec(root.left, val);
    else if (val.compareTo(root.val) > 0)
      root.right = add_rec(root.right, val);
    return root;
  }

  public boolean remove(T val) {
    if (contains(val)) {
      root = remove_rec(root, val);
      size--;
      return true;
    }
    return false;
  }

  private Node remove_rec(Node root, T val) {
    if (root == null)
      return null;
    if (val.compareTo(root.val) < 0)
      root.left = remove_rec(root.left, val);
    else if (val.compareTo(root.val) > 0)
      root.right = remove_rec(root.right, val);
    else {
      if (root.left == null && root.right == null) // si no tiene hijos
        return null;
      if (root.right == null) // si tiene solo hijo izq
        return root.left;
      if (root.left == null) // si tiene solo hijo der
        return root.right;
      // el nodo tiene dos hijos
      Node suc = root.right;
      while (suc.left != null)
        suc = suc.left;
      root.val = suc.val;
      root.right = remove_rec(root.right, suc.val);
    }
    return root;
  }

  public boolean contains(T val) {
    return contains_rec(root, val);
  }

  private boolean contains_rec(Node root, T val) {
    if (root == null)
      return false;
    if (root.val.equals(val))
      return true;
    if (val.compareTo(root.val) < 0)
      return contains_rec(root.left, val);
    return contains_rec(root.right, val);
  }

  public T first() {
    ArrayList<T> all = new ArrayList<T>();
    traverse(root, all);
    return all.get(0);
  }

  public T last() {
    ArrayList<T> all = new ArrayList<T>();
    traverse(root, all);
    return all.get(all.size() - 1);
  }

  public void bfs(Node root, ArrayList<T> list) {
    Queue<Node> Q = new LinkedList<Node>();
    Q.add(root);
    while (!Q.isEmpty()) {
      Node node = Q.poll();
      list.add(node.val);
      if (node.left != null)
        Q.offer(node.left);
      if (node.right != null)
        Q.offer(node.right);
    }
  }

  private void traverse(Node root, ArrayList<T> list) {
    if (root == null)
      return;
    traverse(root.left, list);
    list.add(root.val);
    traverse(root.right, list);
  }

  public String toString() {
    ArrayList<T> list = new ArrayList<T>();
    traverse(root, list);
    return list.toString();
  }

  private class Node {
    T val;
    Node left, right;

    Node(T v) {
      val = v;
      left = right = null;
    }
  }

}