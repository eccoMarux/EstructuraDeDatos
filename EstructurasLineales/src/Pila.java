public class Pila{
    private int tope;
    private static final int TAMANIO = 5;
    private Object arreglo[];

    public Pila(){
        this.arreglo = new Object[TAMANIO];
        this.tope=-1;
    }

    public boolean apilar(Object nuevoElem){
        boolean exito;
        if(this.tope+1>= TAMANIO){
            exito = false;
        }else{
            this.tope++;
            this.arreglo[this.tope]=nuevoElem;
            exito =true;
        }
        return exito;
    }

    public boolean desapilar(){
        boolean exito=false;
        if(this.tope > -1){
            this.arreglo[this.tope] = null;
            exito =true;
            this.tope--;
        }
        return exito;
    }

    public Object obtenerTope(){
        Object elemento=null;
        if(this.tope > -1){
            elemento = this.arreglo[this.tope];
        }
        return elemento;
    }
    public boolean esVacia(){
        boolean vacia=false;
        if(this.tope == -1){
            vacia = true;
        }
        return vacia;
    }

    public void vaciar(){
        int i;
        for(i= this.tope; i>-1; i--){
            this.arreglo[i] = null;
        }
        this.tope = -1;
    }

    public Pila clone(){
        Pila copia = new Pila();
        copia.arreglo = this.arreglo.clone();
        copia.tope = this.tope;
        return copia;
    }

    public String toString(){
        String respuesta="";
        if(this.tope>-1){
            for(int i=0; i<=this.tope; i++){
                respuesta += "Posicion "+i+": "+this.arreglo[i].toString()+"\n";
            }
        }else{
            respuesta = "Pila Vacia";
        }
        return respuesta;
    }


}