package org.datos1.linkedDB.listas;


public final class ListaSimple<Type> {
    /**
     * atributos de la clase
     */
    public NodoSimple<Type> primero, ultimo;
    private int total_nodos;
    
    /**
     * constructor 
     */

    public ListaSimple(){}
    public ListaSimple(Type dato)
            
    {
        insertar_en_vacia(dato);
    }
    
    /**
     * saca el primero nodo de la lista
     * @return primero
     */
    public NodoSimple<Type> getPrimero() {
        return primero;
    }

     /**
     * define el primero nodo de la lista
     * @param primero el nuevo nodo primero
     */
    public void setPrimero(NodoSimple<Type> primero) {
        this.primero = primero;
    }

    /**
     * saca el último de la lista
     * @return último
     */
    public NodoSimple<Type> getUltimo() {
        return ultimo;
    }

    /**
     * define el ultimo
     * @param ultimo nuevo nodo último
     */
    public void setUltimo(NodoSimple<Type> ultimo) {
        this.ultimo = ultimo;
    }

    /**
     * saca el largo
     * @return total de nodos
     */
    public int getTotal_nodos() {
        return total_nodos;
    }
    /**
     * revisa si está vacía
     * @return true o false
     */
    public boolean vacia()
    {
        return primero == null;
    }
    
    /**
     * inserta en una lista vacía
     * @param dato nuevo dato
     */
    public void insertar_en_vacia(Type dato)
    {
        primero = ultimo = new NodoSimple<>(dato);
        total_nodos++;
    }
    
    /**
     * inserta al final de la lista
     * @param dato nuevo dato
     */
    public void insertar_al_final(Type dato)
    {
        if (vacia())
        {
            insertar_en_vacia(dato);
        }
        else
        {
               NodoSimple<Type> nuevo = new NodoSimple<>(dato);
               ultimo.setSiguiente(nuevo);
               ultimo = nuevo;
               total_nodos++;
        }
    }

    /**
     * inserta al incio de la lista
     * @param dato nuevo dato
     */
    public void insertar_al_inicio(Type dato)
    {
        if (vacia())
        {
            insertar_en_vacia(dato);
        }
        else               
        {
            NodoSimple<Type> t = new NodoSimple<>(dato);
            t.setSiguiente(primero);
            primero = t;
            total_nodos++;
        }
        
    }
    
    /**
     * inserta por indice
     * @param dato nuevo dato
     * @param indice indice en el que se va a colocar
     * @return true o false
     */
    public boolean insertar_en_indice(Type dato, int indice)
    {
        if (vacia() || total_nodos == 1 || total_nodos <= indice || indice == 0)
        {
            return false;
        }
        else
        {
            NodoSimple<Type> medio = new NodoSimple<Type>(dato);
            NodoSimple<Type> pivote = primero;

            for (int i=0; i < indice - 1; i++)
            {
                pivote = pivote.getSiguiente();
            }
            medio.setSiguiente(pivote.getSiguiente());
            pivote.setSiguiente(medio);
            total_nodos++;
            return true;
        }

    }
   /**
    * elimina el dato del indice
    * @param indice 
    */
    private void eliminar_indice_cualquiera(Type indice)
    {
        NodoSimple<Type> pivote = primero;
        for (int i = 0; i < total_nodos - 1; i++)
        {
            pivote = pivote.getSiguiente();
        }
        pivote.setSiguiente(pivote.getSiguiente().getSiguiente());

        total_nodos--;

    }


    /**
     * elimina un dato especifico
     * @param dato que se desea elminar
     */
    public void eliminar_especifico(Type dato)
    {
        NodoSimple<Type> pivote = primero;
        for (int i = 0; i < total_nodos; i++)
        {
            if (pivote.getValor().equals(dato))
            {
                eliminar_indice_cualquiera(dato);
            }
            else
            {
                pivote = pivote.getSiguiente();
            }
        }
    }

    /**
     * imprime la lista
     */
    public void print()
    {
        System.out.print("[");
        
        if (vacia()) {
            System.out.println("[->]");
        }
        else {
            NodoSimple<Type> pivote = primero;
            for (int i=0; i < total_nodos; i++){
                if (i == 0){
                    System.out.print(pivote.getValor() + ",");
                }
                else if (i == total_nodos-1){
                    System.out.print(pivote.getValor() + ",");
                }
                else {
                    System.out.print(pivote.getValor() + ",");
                }
                pivote = pivote.getSiguiente();
            }
            System.out.print("]");

        }
    }
    
    public void vaciarLista(){
        setPrimero(null);
        setUltimo(null);
        total_nodos = 0;
    }


}



