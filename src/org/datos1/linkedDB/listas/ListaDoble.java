package org.datos1.linkedDB.listas;

public class ListaDoble<Type> {
    
    private NodoDoble<Type> inicio, fin;
    private int total_nodos = 0;
    
    public ListaDoble(){
        inicio=fin=null;
    }
    
    public boolean esta_vacia(){
        return inicio==null;
    }
    
    public void agregar_final(Type elemento){
        if(!esta_vacia()){
            fin = new NodoDoble(elemento, null, fin);
            fin.anterior.siguiente=fin;
            total_nodos++;
    }else{
            inicio = fin = new NodoDoble(elemento);
            total_nodos++;
        }
        
     
    }
    
    public void agregar_inicio(Type elemento){
        if(!esta_vacia()){
            inicio = new NodoDoble(elemento, inicio, null);
            inicio.siguiente.anterior=inicio;
            total_nodos++;
    }else{
            inicio = fin = new NodoDoble(elemento);
            total_nodos++;
        }
        
 
    }
    
    public void imprimir(){
        if(esta_vacia()){
            System.out.println("Está vacía");
        }else{
            
        NodoDoble pivote = inicio;
        
        while(pivote!=fin){
            System.out.print(pivote.getDato() + "--");
            pivote = pivote.getSiguiente();
                            
        }
        System.out.println(pivote.getDato());
        
        
    }       
        
        
    }
    
    public boolean existe(String elemento){
        NodoDoble pivote = inicio;
        while (pivote!=null) {
            if (pivote.getDato().equals(elemento)){
                return true;
            }else{
                pivote = pivote.getSiguiente();
            }
            
        }
        return false;
    }
    
    
    public boolean eliminar(Type elemento){  
        
        NodoDoble anterior = null;
        NodoDoble pivote = inicio;
        
        while(pivote!=fin){
            
            if(pivote.getDato()==elemento){
                
                if(anterior == null){
                    
                    inicio = pivote.getSiguiente();
                    inicio.anterior = null;
                }else{
                    
                    anterior.siguiente = pivote.getSiguiente();
                    NodoDoble temporal;
                    temporal = pivote.siguiente;
                    temporal.anterior = anterior;
                }
                return true;
            }
            anterior = pivote;
            pivote = pivote.siguiente;
        }
        if(elemento==fin.getDato())
        {
            fin = pivote.anterior;
            return true;
        }
        System.out.println(elemento + " No existe en la lista");
        return false;
    }
 
    
    public NodoDoble<Type> getInicio() {
        return inicio;
    }

    public void setInicio(NodoDoble<Type> inicio) {
        this.inicio = inicio;
    }

    public NodoDoble<Type> getFin() {
        return fin;
    }

    public void setFin(NodoDoble<Type> fin) {
        this.fin = fin;
    }

    public int getTotal_nodos() {
        return total_nodos;
    }

    public void setTotal_nodos(int total_nodos) {
        this.total_nodos = total_nodos;
    }
    
}
