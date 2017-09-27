package org.datos1.linkedDB.listas;

public class ListaCircular<Type> {
    
   private NodoCircular primerNodo; 
   private int total_nodos;

    public NodoCircular getPrimerNodo() {
        return primerNodo;
    }

    public void setPrimerNodo(NodoCircular primerNodo) {
        this.primerNodo = primerNodo;
    }

    public int getTotal_nodos() {
        return total_nodos;
    }

    public void setTotal_nodos(int total_nodos) {
        this.total_nodos = total_nodos;
    }

   public ListaCircular() {
      primerNodo = null;
    }


   public boolean esta_vacia(){
       return (primerNodo==null);
   }
   
   
   public void insertar( Type elemento ) {
      if ( esta_vacia()) {
         primerNodo = new NodoCircular( elemento );
         primerNodo.siguiente = primerNodo;
         primerNodo.anterior = primerNodo;
         
      }
      else {
      	   NodoCircular actual = primerNodo;
      	 while(actual.siguiente != primerNodo) {
      	 	actual = actual.siguiente;
      	 }
      	 NodoCircular ultimoNodo = actual;
         
         NodoCircular desplazado = primerNodo;
         primerNodo = new NodoCircular( elemento ,desplazado ,ultimoNodo );
         ultimoNodo.siguiente = primerNodo;
     	 
      	 desplazado.anterior = primerNodo;
      }
   }

   public void imprimir() {
      if ( esta_vacia()) {
         System.out.println( "Vacía"  );
         return;
      }

      System.out.print( "La lista es: " );

      NodoCircular actual = primerNodo;

      do {
         System.out.print( actual.dato.toString() + " " );
         actual = actual.siguiente;
      } while ( actual != primerNodo );

      System.out.println( "\n" );
   }
   
    public void insertar_al_final(Type elemento) {
        NodoCircular nuevo = new NodoCircular<>(elemento);
        if (primerNodo == null) {
            primerNodo = nuevo;
            primerNodo.siguiente = primerNodo;
        } else {
            NodoCircular pivote = primerNodo;
            while (pivote.getSiguiente() != primerNodo) {
                pivote = pivote.getSiguiente();
            }
            pivote.setSiguiente(nuevo);
            nuevo.setAnterior(pivote);
            nuevo.setSiguiente(primerNodo);
            primerNodo.setAnterior(nuevo);
        }
    }
    
    public boolean existe_elemento(Type elemento) {
        NodoCircular pivote;
        pivote = primerNodo;
        if (pivote.getDato().equals(elemento)) {
            return true;

        } else {
            pivote = pivote.getSiguiente();
            while (pivote != primerNodo) {
                if (pivote.getDato().equals(elemento)) {
                    return true;
                }else{
                    pivote = pivote.getSiguiente();
                }

            }
            return false;
        }
    }
}
