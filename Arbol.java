//PRACTICA 4
class NodoArbol {
    NodoArbol nodoIzq;
    int datos;
    NodoArbol nodoDer;
    int cantidadDescendientes;
    int nivel;


    public NodoArbol(int datosNodo) {
        datos = datosNodo;
        nodoIzq = nodoDer = null;
        cantidadDescendientes = 0;
    }

    public void insertar(int valorInsertar) {
        if(valorInsertar < datos) {
            if(nodoIzq==null) {
                nodoIzq = new NodoArbol(valorInsertar);
                nodoIzq.nivel = this.nivel + 1;
            } else {
                nodoIzq.insertar(valorInsertar);
            }
            cantidadDescendientes += 1;
        } else if(valorInsertar > datos) {
            if(nodoDer==null) {
                nodoDer = new NodoArbol(valorInsertar);
                nodoDer.nivel = this.nivel + 1;
            } else {
                nodoDer.insertar(valorInsertar);
            }
            cantidadDescendientes += 1;
        }
    }

    //COSAS DE LA PRACTICA
    //Metodo que verifica si un nodo esta en el arbol
    public boolean buscar(NodoArbol n){
        boolean resultado;
        if(n.datos == datos){
            resultado = true;
        }else if(n.datos < datos){
            if(nodoIzq != null){
                resultado = nodoIzq.buscar(n);
            }else{
                resultado = false;
            }
        }else{
            if(nodoDer != null){
                resultado = nodoDer.buscar(n);
            }else{
                resultado = false;
            }
        }
        return resultado;
    }

    //Metodo que busca un nodo y lo regresa si lo encuentra
    public NodoArbol buscarAux(NodoArbol n){
        NodoArbol resultado;
        if(n.datos == datos){
            resultado = this;
        }else if(n.datos < datos){
            if(nodoIzq != null){
                resultado = nodoIzq.buscarAux(n);
            }else{
                resultado = null;
            }
        }else{
            if(nodoDer != null){
                resultado = nodoDer.buscarAux(n);
            }else{
                resultado = null;
            }
        }
        return resultado;
    }
    //Metodo que devuelve la altura desde un nodo en particular
    public int altura(){
        if(this.nodoDer == null && this.nodoIzq == null){
            return 1;
        }else{
            //Variable para la altura del lado izquierdo
            int ld = 1 + nodoDer.altura();
            int lr = 1 + nodoIzq.altura();
            int mayor;
            if(ld < lr){
                mayor = lr;
            }else{
                mayor = ld;
            }
            return mayor;
        }
    }

    /**
     * Busqueda seguimiento
     * 
     * @param n El nodo a buscar
     * @return El camino
    */
    public String busquedaSeguimiento(NodoArbol n){
        if(this.buscar(n)){
            if(n.datos == datos){
                return  "";
            }else if(n.datos < datos){
                return "L" + nodoIzq.busquedaSeguimiento(n);
            }else {
                return "D" + nodoDer.busquedaSeguimiento(n);
            }
        }else{
            return "Nodo no encontrado";
        }
    }

    //Metodo para revisar si un arbol binario completo
    public boolean esCompleto(){
        NodoArbol n = this;
        //Revisamos si tiene un solo hijo
        if((n.nodoDer ==  null && n.nodoIzq != null) || (n.nodoDer !=  null && n.nodoIzq == null)){
            return false;
        //Si el árbol no tiene hijos regresamos true
        }else if((n.nodoDer ==  null && n.nodoIzq == null)){
            return true; 
        //Caso recursivo donde revisamos por cada subarbol
        }else{
            return n.nodoDer.esCompleto() && n.nodoIzq.esCompleto();
        }
    }

    //Metodo para revisar si un arbol es perfecto
    public boolean esPerfecto(){
        NodoArbol n = this;
        int a = this.altura();
        //Si tenenmos una hoja, revisamos que su nivel sea el ultimo posible
        if(n.nodoDer == null && n.nodoIzq == null){
            return n.nivel == a - 1;
        //Si tiene un hijo es false
        }else if(n.nodoDer == null || n.nodoIzq == null){
            return false;
        }else{
        //En otro caso los subarboles deben ser perfectos
            return n.nodoDer.esPerfecto() && n.nodoIzq.esPerfecto();
        }
    }

    //Metodo para revisar si es degenerated
    public boolean esDegenerate(){
        NodoArbol n = this;
        //Si no tiene hijos true
        if(n.nodoDer == null && n.nodoIzq == null){
            return true;
        //Si tiene dos hijos false
        }else if(n.nodoDer != null && n.nodoIzq != null){
            return false;
        //Si tiene un hijo revisamos que igual sea de este tipo
        }else if(n.nodoDer != null && n.nodoIzq == null){
            return n.nodoDer.esDegenerate();
        }else{
            return n.nodoIzq.esDegenerate();
        }
    }

    //Metodo para saber si el arbol es balanceado
    public boolean esBalanceado(){
        NodoArbol n = this;
        int a = n.nodoDer.altura() - n.nodoIzq.altura();
        //Si no tiene hijos se cumple
        if(n.nodoDer == null && n.nodoIzq == null){
            return true;
        //Si la diferencia de las alturas es distinta de 0 o 1 o -1 no es balanceado
        }else if(a > 1 || a < -1){
            return false;
        }else{
            //LOs dos subarboles deben ser balanceados
            return n.nodoDer.esBalanceado() && n.nodoIzq.esBalanceado();
        }
    }

    //toString
    public String toString(){
        return "" + datos;
    }

    //Get descendientes
    public int getNumeroDescendientes(){
        return cantidadDescendientes;
    }
}

public class Arbol {
    NodoArbol raiz;

    public Arbol() {
        raiz = null;
    }


    public void preorden() {
        recorrePreorden(raiz);
    }


    public void recorrePreorden(NodoArbol nodo) {
        if (nodo==null) {
            return;
        }
        System.out.print(nodo.datos + " ");
        recorrePreorden(nodo.nodoIzq);
        recorrePreorden(nodo.nodoDer);
    }


    public void Inorden(){
        recorreInorden(raiz);
    }


    public void recorreInorden(NodoArbol nodo) { 
        if (nodo==null) {
            return;
        }
        recorreInorden(nodo.nodoIzq);
        System.out.print(nodo.datos + " ");
        recorreInorden(nodo.nodoDer);
    }

    public void Postorden(){
        recorrePostorden(raiz);
    }

    public void recorrePostorden(NodoArbol nodo) { 
        if (nodo==null) {
            return;
        }
        recorrePostorden(nodo.nodoIzq);
        recorrePostorden(nodo.nodoDer);
        System.out.print(nodo.datos + " ");
    }

    
    //EJERCICIOS DE LA PRACTICA
    
    /**
     * Metodo toString
     * 
     * @author Eduardo Vargas Perez
     */
    public String toString(){
        return this.bfs(raiz);
        
    }
    
    /**
     * Metodo busquedaSeguimiento
     * 
     * @param i El elemento a buscar
     * @return La secuencia que se siguió para encontrar el nodo
     */
    public String busquedaSeguimiento(int i){
        NodoArbol n = new NodoArbol(i);
        return raiz.busquedaSeguimiento(n);
    }

    /**
     * Metodo que regresa el numero de decendientes de un nodo
     * 
     * @param n El nodo a verificar
     * @return La cantidad de decendientes que tiene
     */
    public int getNumeroDescendientes(NodoArbol n){
        if(raiz.buscar(n)){
            NodoArbol aux = raiz.buscarAux(n);
            return aux.getNumeroDescendientes();
        }else{
            return -1;
        }
    }

    /**
     * Metodo que regresa el tipo de arbol que es
     * 
     * @return Un String con el tipo de arbol que es
     */
    public String imprimeTipo(){
        String tipo;
        if(this.raiz.esBalanceado()){
            tipo = "Balanced binary tree";
            System.out.println(tipo);
        }else if(this.raiz.esCompleto()){
            tipo = "Full binary tree";
            System.out.println(tipo);
        }else if(this.raiz.esPerfecto()){
            tipo = "Perfect binary tree";
            System.out.println(tipo);
        }else if(this.raiz.esDegenerate()){
            tipo = "Degenerate binary tree";
            System.out.println(tipo);
        }else{
            tipo = "Binary tree";
            System.out.println(tipo);
        }
        return tipo;
    }
 
    //METODOS AUXILIARES
    public void insertarNodo(int valorInsertar) {
        if(raiz==null) {
            raiz = new NodoArbol(valorInsertar);
            //Modifique esto
            raiz.nivel = 0;
        } else {
            raiz.insertar(valorInsertar);
        }
    }
    //Metodo que devuelve la altura de todo el arbol
    public int altura(){
        if(raiz == null){
            return 0;
        }else{
            return raiz.altura();
        }
    }
    

    //Metodo que usa BFS para hacer una cadena de texto con los nodos
    private String bfs(NodoArbol n){
        String resultado = "";
        Cola<NodoArbol> cola = new Cola<NodoArbol>();
        cola.mete(n);
        int i = n.nivel;
        while(!cola.esVacia()){
            //Si cambia el nivel agregamos la flecha
            NodoArbol actual = cola.saca();
            if(actual.nivel == i){
                resultado = resultado + " " + actual;
            }else{
                resultado = resultado + " -> " + actual;
                i++;
            }
            if(actual.nodoDer != null){
                cola.mete(actual.nodoDer);
            }
            if(actual.nodoIzq != null){
                cola.mete(actual.nodoIzq);
            }
        }
        return resultado;
    }

    
}