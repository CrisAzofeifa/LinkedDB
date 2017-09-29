package org.datos1.linkedDB.listas;

/**
 * listaDoble genérica
 * @author cris
 * @param <Type>  tipo de la lista
 */
public class ListaDoble<Type> {
    /**
     * atributos de la lista
     */
    private NodoDoble<Type> inicio, fin;
    private int total_nodos = 0;
    
    /**
     * constructor
     */
    public ListaDoble(){
        inicio=fin=null;
    }
    
    /**
     * revisa si está vacía o no
     * @return true o false
     */
    public boolean esta_vacia(){
        return inicio==null;
    }
    
    
    /**
     * agrega al final de la lista
     * @param elemento dato que va a agregar
     */
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
    
    
    /**
     * agrega al inicio de la lista
     * @param elemento dato que va a agregar
     */
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
    
    /**
     * imprime la lista
     */
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
    
    /**
     * verifica si existe el elemento en la lista
     * @param elemento dato que se desea revisar si existe
     * @return true o false
     */
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
    
    
    /**
     * elimina un nodo de la lista
     * @param elemento dato que se desea eliminar
     * @return true o false 
     */
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
 
    /**
     * saca el nodo inicial
     * @return inicio
     */
    public NodoDoble<Type> getInicio() {
        return inicio;
    }

    /**
     * define el inicio
     * @param inicio nodo que será el incio
     */
    public void setInicio(NodoDoble<Type> inicio) {
        this.inicio = inicio;
    }

    /**
     * saca el final de la lista
     * @return fin
     */
    public NodoDoble<Type> getFin() {
        return fin;
    }

    
    /**
     * define el final de la lista 
     * @param fin nodo que va a ser el nuevo fin 
     */
    public void setFin(NodoDoble<Type> fin) {
        this.fin = fin;
    }
    
    /**
     * saca el largo
     * @return total de nodos
     */
    public int getTotal_nodos() {
        return total_nodos;
    }
    
}
