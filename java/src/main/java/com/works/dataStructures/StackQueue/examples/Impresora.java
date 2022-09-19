package com.works.dataStructures.StackQueue.examples;

import java.util.Queue;
import java.util.LinkedList;

public class Impresora {

  Queue<String> cola;

  public Impresora() {
    cola = new LinkedList<String>();
  }

  public void imprimirSiguiente() {
    if (cola.size() == 0) {
      System.out.println("Nada para imprimir");
      return;
    }
    String doc = cola.poll();
    System.out.println("Imprimiendo " + doc + "...");
  }

  public void nuevoDocumento(String doc) {
    cola.offer(doc);
  }

}