package com.works.dataStructures.StackQueue.examples;

class QueueDriver {
  public static void main(String[] args) {
    Impresora imp = new Impresora();
    imp.nuevoDocumento("tarea.pdf");
    imp.nuevoDocumento("formulario.pdf");
    imp.nuevoDocumento("abc.docx");
    imp.nuevoDocumento("dibujo.png");
    imp.imprimirSiguiente();
    imp.imprimirSiguiente();
    imp.imprimirSiguiente();
    imp.imprimirSiguiente();
    imp.imprimirSiguiente();
  }
}