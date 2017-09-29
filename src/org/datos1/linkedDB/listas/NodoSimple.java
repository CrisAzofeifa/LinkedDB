package org.datos1.linkedDB.listas;

/**
 * Nodo genérico para la listaSimple
 * @author cris
 * @param <Type> tipo que se le asigna al nodo
 */
public class NodoSimple<Type> {
    
    /**
     * atributos que tiene el nodo
     */
    private Type valor;
    private NodoSimple siguiente;
    
    
    /**
     * constructor
     */
    public NodoSimple(){};
    
    
    public NodoSimple(Type valor)
    {
        this.valor = valor;
    }
    
    /**
     * saca el siguiento nodo de la lista
     * @return el nodo siguiente
     */
    public NodoSimple getSiguiente(){
        return siguiente;       
    }
    
    /**
     * define cual va a ser el siguiente 
     * @param siguiente recibe el nodo que se quiere asignar como siguiente
     */
    public void setSiguiente(NodoSimple siguiente){
        this.siguiente = siguiente;
    }   
    
    /**
     * Define el valor que va a guardar un Nodo
     * @param valor 
     */
    public void setValor(Type valor){
        this.valor = valor;
    }
   
    /**
     * saca el valor que contiene un nodo
     * @return valor
     */
    public Type getValor(){
        return valor;
    }

}




