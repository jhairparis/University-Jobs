package com.works.dataStructures.List;

import java.util.Arrays;

public class ArrayList<T> {

  private T[] arr;
  private int size;
  private static int INIT_CAPACITY = 10;

  public ArrayList() {
    arr = (T[]) new Object[INIT_CAPACITY];
    size = 0;
  }

  public void add(int i, T val) {
    if (i < 0 || i > size)
      throw new IndexOutOfBoundsException();
    if (arr.length == size)
      arr = Arrays.copyOf(arr, arr.length * 2);
    for (int k = size - 1; k >= i; k--)
      arr[k + 1] = arr[k];
    arr[i] = val;
    size++;
  }

  public void addFirst(T val) {
    add(0, val);
  }

  public void addLast(T val) {
    add(size(), val);
  }

  public void addAll(ArrayList<T> val) {
    arr = Arrays.copyOf(arr, arr.length + val.size());
    for (int i = 0; i < val.size(); i++) {
      arr[size] = val.get(i);
      size++;
    }
  }

  public boolean remove(T val) {
    for (int i = 0; i < size; i++) {
      if (arr[i] == val) {
        remove(i);
        return true;
      }
    }
    return false;
  }

  public boolean removeAll(T val) {
    int k = 0;

    for (int i = 0; i < size; i++) {
      if (arr[i] == val) {
        remove(i);
        k++;
      }
    }

    if (k > 0)
      return true;

    return false;
  }

  public int findLast(T val) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i < size; i++)
      if (arr[i] == val)
        list.addLast(i);

    if (list.size() > 0)
      return list.get(list.size() - 1);

    return -1;
  }

  public ArrayList<Integer> findAll(T val) {
    ArrayList<Integer> list = new ArrayList<Integer>();

    for (int i = 0; i < size; i++)
      if (arr[i] == val)
        list.addLast(i);

    return list;
  }

  // comparable aarryas.sort(0,size)
  private void mergeSort(T[] arr) {
    if (arr.length <= 1)
      return;
    T[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
    T[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
    mergeSort(left);
    mergeSort(right);
    merge(left, right, arr);
  }

  private void merge(T[] a, T[] b, T[] c) {
    int i = 0, j = 0;
    for (int k = 0; k < c.length; k++) {
      if (i < a.length && (j >= b.length ||  ((Comparable) a[i]).compareTo(b[j]) < 0))
        c[k] = a[i++];
      else
        c[k] = b[j++];
    }
  }

  public void sort() {
    try {
      int l = arr.length;
      arr = Arrays.copyOf(arr, size);
      mergeSort(arr);
      arr = Arrays.copyOf(arr, l);
    } catch (Exception e) {
      System.out.println("No es posible organizar el arreglo\n intenta con otro tipo de dato");
    }
  }

  public T get(int i) {
    if (i < 0 || i >= size)
      throw new IndexOutOfBoundsException();
    return arr[i];
  }

  public void set(int i, T val) {
    if (i < 0 || i >= size)
      throw new IndexOutOfBoundsException();
    arr[i] = val;
  }

  public T remove(int i) {
    if (i < 0 || i >= size)
      throw new IndexOutOfBoundsException();
    T val = arr[i];
    for (int k = i + 1; k < size; k++)
      arr[k - 1] = arr[k];
    size--;
    if (size < arr.length / 4 && arr.length / 2 >= INIT_CAPACITY)
      arr = Arrays.copyOf(arr, arr.length / 2);
    return val;
  }

  public int size() {
    return size;
  }

  public String toString() {
    String s = "[";
    for (int k = 0; k < size; k++)
      s += arr[k] + ", ";
    return s + "]";
  }
}