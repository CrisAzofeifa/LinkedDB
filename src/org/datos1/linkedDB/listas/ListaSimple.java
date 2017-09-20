package org.datos1.linkedDB.listas;

public final class ListaSimple<Type> {
    
    public NodoSimple<Type> primero, ultimo;
    private int total_nodos;

    public ListaSimple(){}
    public ListaSimple(Type dato)
            
    {
        insertar_en_vacia(dato);
    }
    
    public NodoSimple<Type> getPrimero() {
        return primero;
    }

    public void setPrimero(NodoSimple<Type> primero) {
        this.primero = primero;
    }

    public NodoSimple<Type> getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoSimple<Type> ultimo) {
        this.ultimo = ultimo;
    }

    public int getTotal_nodos() {
        return total_nodos;
    }

    public void setTotal_nodos(int total_nodos) {
        this.total_nodos = total_nodos;
    }
    
    public boolean vacia()
    {
        return primero == null;
    }
    
    
    public void insertar_en_vacia(Type dato)
    {
        primero = ultimo = new NodoSimple<>(dato);
        total_nodos++;
    }
    
    public void instertar_al_final(Type dato)
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

    public void eliminar_primero()
    {   
        if (!vacia())
        {
            NodoSimple<Type> segundo = primero.getSiguiente();
            primero = segundo;
            total_nodos--;
        }
    }

    public boolean eliminar_ultimo()
    {
        if (total_nodos == 0)
        {
            return false;
        }
        else if (total_nodos == 1)
        {
            primero.setSiguiente(null);
            primero = null;
            return true;
        }
        else{
                NodoSimple<Type> pivote = primero;
                for (int i = 0; i < total_nodos - 1; i++) {
                pivote = pivote.getSiguiente();
            }
            pivote.setSiguiente(null);
            ultimo = pivote;
            total_nodos--;
            return true;
        }
    }

    public boolean eliminar_indice(int indice)
    {
        if (total_nodos == 0 || total_nodos == 1 || indice == 0 || indice >= total_nodos - 1)
        {
            return false;
        }
        else
        {
            NodoSimple<Type> pivote = primero;
            for (int i = 0; i < indice - 1; i++)
            {
                pivote = pivote.getSiguiente();
            }
            pivote.setSiguiente(pivote.getSiguiente().getSiguiente());
            total_nodos--;
            return true;
        }
    }

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


}



