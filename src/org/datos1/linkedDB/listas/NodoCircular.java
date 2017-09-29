package org.datos1.linkedDB.listas;


public class NodoCircular<Type> {
    
    Type dato;    
    NodoCircular<Type> siguiente;
    NodoCircular<Type> anterior;

    NodoCircular( Type elemento ) { 
      this( elemento, null, null ); 
   }


   NodoCircular( Type elemento, NodoCircular prox, NodoCircular ant) {
      dato = elemento;    
      siguiente = prox;
      anterior = ant;
      
   }

    public Type getDato() {
        return dato;
    }

    public void setDato(Type dato) {
        this.dato = dato;
    }

    public NodoCircular<Type> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCircular<Type> siguiente) {
        this.siguiente = siguiente;
    }

    public NodoCircular<Type> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoCircular<Type> anterior) {
        this.anterior = anterior;
    }
   
}