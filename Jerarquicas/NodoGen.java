public class NodoGen {
    private NodoGen hijoIzquierdo;
    private NodoGen hermanoDerecho;
    private Object elem;

    NodoGen(Object elem, NodoGen hijoIzquierdo, NodoGen hermanoDerecho){
        this.elem = elem;
        this.hijoIzquierdo = hijoIzquierdo;
        this.hermanoDerecho = hermanoDerecho;
    }

    public Object getElem(){
        return elem;
    }

    public NodoGen getHijoIzquierdo(){
        return hijoIzquierdo;
    }

    public NodoGen getHermanoDerecho(){
        return hermanoDerecho;
    }

    public void setElem(Object elem){
        this.elem = elem;
    }

    public void setHijoIzquierdo(NodoGen hijoIzquierdo){
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public void setHermanoDerecho(NodoGen hermanoDerecho){
        this.hermanoDerecho = hermanoDerecho;
    }
}
