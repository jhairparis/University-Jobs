package com.works.dataStructures.TreeSet;

import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    TreeSet<Integer> T = new TreeSet<Integer>();
    T.add(50);
    T.add(49);
    T.add(51);
    T.add(45);
    T.add(46);
    T.add(44);
    T.add(21);

    T.add(101);
    T.add(201);
    T.add(300);
    T.add(400);

    System.out.println(T);
    System.out.println("Hola este es el primero: " + T.first());
    System.out.println("Hola este es el Ultimo: " + T.last());

    System.out.println("Hola la altura: ");
    System.out.println(T.height());

    ArrayList<Integer> T2 = new ArrayList<Integer>();
    T.bfs(T.root, T2);
    System.out.println(T2);
  }

}