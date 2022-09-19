package com.works.dataStructures.StackQueue.examples;

import java.util.Stack;

public class Navegador {

  private Stack<String> visitados;
  private Stack<String> devueltos;
  private static String HOME = "google.com";

  public Navegador() {
    visitados = new Stack<String>();
    devueltos = new Stack<String>();
    visitados.push(HOME);
    visitarPagina(HOME);
  }

  public void visitarPagina(String pagina) {
    System.out.println("Abriendo " + pagina + "...");
  }

  public void irAtras() {
    if (visitados.size() == 1) {
      System.out.println("No hay páginas anteriores");
      return;
    }
    String pagina = visitados.pop();
    devueltos.push(pagina);
    visitarPagina(visitados.peek());
  }

  public void irAdelante() {
    if (devueltos.size() == 0) {
      System.out.println("No hay páginas siguientes");
      return;
    }
    String pagina = devueltos.pop();
    visitados.push(pagina);
    visitarPagina(visitados.peek());
  }

  public void nuevaPagina(String pagina) {
    visitados.push(pagina);
    devueltos.clear();
    visitarPagina(pagina);
  }
}