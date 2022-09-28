package com.works.dataStructures.List;

//import java.util.ArrayList;
//import java.util.LinkedList;

class Josephus {

  static String josephus(LinkedList<String> lista, int k) {
    int inicio = 0;
    while (lista.size() > 1) {
      int sig = (inicio + k - 1) % lista.size();
      System.out.println("Eliminado: " + lista.remove(sig));
      inicio = sig % lista.size();
    }
    return lista.get(0);
  }

  public static void main(String[] args) {
    LinkedList<String> lista = new LinkedList<String>();
    lista.add(0, "María");
    lista.add(1, "Sara");
    lista.add(2, "Juan");
    lista.add(3, "Pedro");
    lista.add(4, "José");
    lista.add(5, "Lucía");
    System.out.println(lista);
    String ganador = josephus(lista, 4);
    System.out.println("Ganador: " + ganador);
  }
}