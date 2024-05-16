package Jerarquicas.Dinamicas;
import Lineales.Dinamicas.Lista;
import Lineales.Dinamicas.Cola;

public class ArbolGen {
    private NodoGen raiz;

    ArbolGen(){
        this.raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre){
        boolean exito = false;

        return exito;
    }

    public boolean insertarPorPosicion(Object elemNuevo, int posPadre){
        boolean exito = false;

        return exito;
    }

    public boolean pertenece(Object elem){
        boolean exito = false;

        return exito;
    }

    public Lista ancestros(Object elem){
        Lista ancestros = new Lista();

        return ancestros;
    }

    public boolean esVacio(){
        return (this.raiz == null);
    }

    public int altura(){
        int i = 0;

        return i;
    }

    public int nivel(Object elem){
        int i = 0;

        return i;
    }

    public Object padre(Object elem){
        Object papi = null;

        return papi;
    }

    public Lista listarPreorden(){
        Lista lista = new Lista();
        listarPreordenAux(this.raiz, lista);
        return lista;
    }

    public void listarPreordenAux(NodoGen n, Lista l){
        if(n!= null){
            l.insertar(n.getElem(), l.longitud()+1);
            NodoGen hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                listarPreordenAux(hijo, l);
                hijo = hijo.getHermanoDerecho();
            }
        }
    }

    public Lista listarInorden(){
        Lista lista = new Lista();
        listarInordenAux(this.raiz, lista);
        return lista;
    }

    public void listarInordenAux(NodoGen n, Lista l){
        if(n != null){
            if(n.getHijoIzquierdo() != null){
                listarInordenAux(n.getHijoIzquierdo(), l);
            }
            l.insertar(n.getElem(), l.longitud()+1);
            if(n.getHijoIzquierdo()!=null){
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    listarInordenAux(hijo, l);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    public Lista listarPosorden(){
        Lista lista = new Lista();
        listarPosordenAux(this.raiz, lista);
        return lista;
    }

    public void listarPosordenAux(NodoGen n, Lista l){
        if(n != null){
            if(n.getHijoIzquierdo() != null){
                listarInordenAux(n.getHijoIzquierdo(), l);
            }
            
            if(n.getHijoIzquierdo()!=null){
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    listarInordenAux(hijo, l);
                    hijo = hijo.getHermanoDerecho();
                }
            }
            l.insertar(n.getElem(), l.longitud()+1);
        }
    }

    public Lista listarNiveles(){
        Lista lista = new Lista();
        Cola q = new Cola();
        q.poner(this.raiz);
        listarNivelesAux(this.raiz, lista, q);
        return lista;
    }

    public void listarNivelesAux(NodoGen n, Lista l, Cola q){
        
    }

    public ArbolGen clone(){
        ArbolGen clon = new ArbolGen();

        return clon;
    }

    public void vaciar(){
        this.raiz = null;
    }

    public String toString(){
        return toStringAux(this.raiz);
    }

    public String toStringAux(NodoGen n){
        String cadena = "";
        if(n != null){
            cadena += n.getElem().toString() + " --> ";
            NodoGen hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                cadena += hijo.getElem().toString()+", ";
                hijo = hijo.getHermanoDerecho();
            }
            hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                cadena += "\n"+toStringAux(hijo);  
                hijo= hijo.getHermanoDerecho();              
            }
        }
        return cadena;
    }
    
}
