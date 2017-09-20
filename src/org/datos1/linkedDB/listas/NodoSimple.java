package org.datos1.linkedDB.listas;

public class NodoSimple<Type> {
    
    private Type valor;
    private NodoSimple siguiente;
    
    public NodoSimple(){};
    
    
    public NodoSimple(Type valor)
    {
        this.valor = valor;
    }
    
        public NodoSimple getSiguiente(){
            return siguiente;       
    }
        
    public void setSiguiente(NodoSimple siguiente){
        this.siguiente = siguiente;
    }   
    
    
    public void setValor(Type valor){
        this.valor = valor;
    }
    
    public Type getValor(){
        return valor;
    }

}




