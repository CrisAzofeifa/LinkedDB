package org.datos1.linkedDB.listas;

public class NodoDoble<Type> {
    
    
    public Type dato;
    NodoDoble<Type> siguiente, anterior;
    
    
    public NodoDoble(Type elemento){
        this(elemento,null,null);
                
    }
    
    public NodoDoble(Type elemento, NodoDoble<Type> s, NodoDoble<Type> a){
        
        dato = elemento;
        siguiente = s;
        anterior = a;
    }

    public Type getDato() {
        return dato;
    }

    public void setDato(Type dato) {
        this.dato = dato;
    }

    public NodoDoble<Type> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble<Type> siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble<Type> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble<Type> anterior) {
        this.anterior = anterior;
    }
    
    
    
    
}
