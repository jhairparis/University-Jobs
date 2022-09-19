package com.works.dataStructures.StackQueue.examples;

class StackDriver {
  public static void main(String[] args) {
    Navegador nav = new Navegador();
    nav.nuevaPagina("poli.edu.co");
    nav.nuevaPagina("elearn.poligran.edu.co");
    nav.nuevaPagina("replit.com");
    nav.irAtras();
    nav.irAtras();
    nav.irAdelante();
    nav.irAdelante();
    nav.irAtras();
    nav.nuevaPagina("abc.com");
    nav.irAdelante();
  }
}