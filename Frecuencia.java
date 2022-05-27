public class Frecuencia {

    int edad;
    int frecuencia;

    public Frecuencia(int ed, int fre){
	edad = ed;
	frecuencia = fre;
    }

    public int compareTo(Frecuencia a){
	if(this.frecuencia == a.frecuencia)
	    return 0;
	if(this.frecuencia < a.frecuencia)
	    return -1;
	return 1;
    }

    public String toString(){
	return "edad: " + edad + " Frecuencia: " + frecuencia;
    }
	    
    
}
	
