/**
 * Clase para representar la frecuencia de las edades
 * 
 * @author Eduardo Vargas Perez, Ernesto Yahir Rivera Hernandez
 * @version mayo 2022
 */
public class Frecuencia {

    int edad;
    int frecuencia;

    public Frecuencia(int ed, int fre){
	edad = ed;
	frecuencia = fre;
    }

    public int compareTo(Frecuencia a){
	if(this.frecuencia == a.frecuencia){
	    return 0;
    }else if(this.frecuencia < a.frecuencia){
	    return -1;
    }else{
        return 1;
    }
    }

    public String toString(){
	return "edad: " + edad + " Frecuencia: " + frecuencia;
    }
	    
    
}
	
