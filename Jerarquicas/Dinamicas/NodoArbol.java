package Jerarquicas.Dinamicas;

public class NodoArbol {

    private Object elem;
    private NodoArbol izquierdo;
    private NodoArbol derecho;

    public NodoArbol(Object elem, NodoArbol izquierdo, NodoArbol derecho) {
        this.elem = elem;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    //modificadoras
    public void setElem(Object elem){
        this.elem = elem;
    }

    public void setIzquiedo(NodoArbol izquierdo){
        this.izquierdo = izquierdo;
    }

    public void setDerecho(NodoArbol derecho){
        this.derecho = derecho;
    }

    //Observadoras
    public Object getElem(){
        return elem;
    }

    public NodoArbol getIzquierdo(){
        return izquierdo;
    }

    public NodoArbol getDerecho(){
        return derecho;
    }
}