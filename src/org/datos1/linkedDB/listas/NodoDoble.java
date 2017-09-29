package org.datos1.linkedDB.listas;

/**
 * Nodo genérico para la listaDoble
 * @author cris
 * @param <Type> tipo que se le asigna al nodo
 */

public class NodoDoble<Type> {
    
    /**
     * atributos del nodo
     */
    public Type dato;
    NodoDoble<Type> siguiente, anterior;
    
    
    /**
     * Contructor del nodo
     * @param elemento le asigna valor 
     */
    public NodoDoble(Type elemento){
        this(elemento,null,null);
                
    }
    
    public NodoDoble(Type elemento, NodoDoble<Type> s, NodoDoble<Type> a){
        
        dato = elemento;
        siguiente = s;
        anterior = a;
    }
     
    /**
     * saca el dato que contiene un nodo
     * @return dato
     */
    public Type getDato() {
        return dato;
    }

    /**
     * Define el valor que va a guardar un Nodo
     * @param valor 
     */
    public void setDato(Type dato) {
        this.dato = dato;
    }

    
    /**
     * saca el nodo siguiente
     * @return siguiente
     */
    public NodoDoble<Type> getSiguiente() {
        return siguiente;
    }

    
    /**
     * define cual va a ser el siguiente 
     * @param siguiente recibe el nodo que se quiere asignar como siguiente
     */
    public void setSiguiente(NodoDoble<Type> siguiente) {
        this.siguiente = siguiente;
    }

    
    
    /**
     * saca el nodo anterior
     * @return anterior
     */
    public NodoDoble<Type> getAnterior() {
        return anterior;
    }
    /**
     * asigna el nodo anterior 
     * @param anterior nodo que va a ser el anterior
     */
    public void setAnterior(NodoDoble<Type> anterior) {
        this.anterior = anterior;
    }
    
    
    
    
}
