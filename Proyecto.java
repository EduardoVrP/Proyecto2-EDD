import java.util.Hashtable;
import java.util.Enumeration;
import javax.swing.*;
import java.util.Comparator;
/**
 * Clase para desarrollar el proyecto
 * 
 * @author Eduardo Vargas Perez, Ernesto Rivera
 * @version mayo 2022
 */
public class Proyecto {
    /**
     * Metodo main donde se desarrolla el programa
     * 
     * @param args Los argumentos
     */
    public static void main(String[] args) {
        //OBJETOS, CONSTANTES Y VARIABLES A USAR
        Arbol arbol = new Arbol();
        JFrame frame = new JFrame();
        JFrame frame2 = new JFrame();
        ImageIcon menuImagen = new ImageIcon("Menu.jpeg"); //Imagen parann el menu
        Hashtable<Integer,Integer> alumnos = new Hashtable<Integer,Integer>(); //Donde se guardaran los alumnos
	    Grafica g = new Grafica();
	    GraficaOrdenada g2 = new GraficaOrdenada();

        //Para las opciones del menu
        String[] menu = new String[5];
        for(int i = 0; i < menu.length; i++){
            menu[i] = Integer.toString(i+1);
        }

        //Para las edades que se mostraran en el menu
        int edad = 18;
        String[] edades = new String[8];
        //Para llenar el arreglo con las edades
        for(int i = 0; i < edades.length; i++){
            edades[i] = Integer.toString(edad);
            edad++;
        }

        //Para seguir viendo o no las graficas
        String[] continuar = new String[2];
        continuar[0] = "si";
        continuar[1] = "no";
        
        //Mostramos el menu y lo repetimos hasta que el usuario decida salir
        int auxiliar = 0;
        while(auxiliar != 5){
            try{
                String usuario = (String)JOptionPane.showInputDialog(null, "Selecciona una opcion", "Menu",
								     JOptionPane.QUESTION_MESSAGE, menuImagen, menu, menu[0]);
                int seleccion = Integer.parseInt(usuario);
                switch(seleccion){
                    case 1:
                        System.out.println("Opcion 1");//Esto es para ver en la terminal que funciona el menu
                        //Pedimos la edad del alumno
                        String edadUsuario = (String)JOptionPane.showInputDialog(null, "Seleciona la edad del alumno",
										 "Cuestionario", JOptionPane.QUESTION_MESSAGE,
										 null, edades, edades[0]);
                        int anios = Integer.parseInt(edadUsuario);
                        System.out.println(anios);//Esto es para ver en la terminal lo que se recibe

                        //Hacemos un ciclo para que se pida el numero de cuenta hasta que se ingrese correctamente
                        boolean seAgrego = false;
                        while(!seAgrego){
                            //Pedimos el numero de cuenta
                            String cuenta = JOptionPane.showInputDialog(frame, "Escribe el numero de cuenta:");
                            try{
                                int numCuenta = Integer.parseInt(cuenta);
                                //Revisamos que el numero de cuenta este en el rango permitido
                                if(numCuenta >= 300000000 && numCuenta<= 500000000 && !alumnos.containsKey(numCuenta)){
                                    //Si esta en el rango lo agregamos al Hashtable y al arbol
                                    alumnos.put(numCuenta, anios);
                                    arbol.insertarNodo(numCuenta);
                                    //Indicamos que se agrego al hashtable y al arbol
                                    seAgrego = true;
                                    System.out.println(alumnos.containsKey(numCuenta));//Para revisar en la terminal si se agrego bien
                                    
                                }else{
                                    JOptionPane.showMessageDialog(null, "Ingresa un numero entre 300,000,000 y 500,000,000", "Error",
								  JOptionPane.INFORMATION_MESSAGE);
                                }
                            }catch(Exception e){
                                JOptionPane.showMessageDialog(null, "Ingresa lo solicitado", "Error", JOptionPane.INFORMATION_MESSAGE);
                                System.out.println("opcion no valida");
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Opcion 2");//Esto es para ver que funciona el menu
			            int e18 = 0, e19 = 0, e20 = 0, e21 = 0, e22 = 0, e23 = 0, e24 = 0, e25 = 0;
			            int[] ed = obtenerValores(alumnos);
			            for(int i = 0; i < ed.length; i++){
			                if(ed[i] == 18){
				                e18++;
                            }
			                if(ed[i] == 19){
				                e19++;
                            }
			                if(ed[i] == 20){
				                e20++;
                            }
			                if(ed[i] == 21){
				                e21++;
                            }
			                if(ed[i] == 22){
				                e22++;
                            }
			                if(ed[i] == 23){
				                e23++;
                            }
			                if(ed[i] == 24){
				                e24++;
                            }
			                if(ed[i] == 25){
				                e25++;
                            }
			            }
			            g.tomaValores(e18, e19, e20, e21, e22, e23, e24, e25);
			            frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			            frame.add(g);		//agrega el panel al marco
			            frame.setSize(600,600);	//establece tamaño del marco
                        boolean visible = true;
                        while(visible){
			                frame.setVisible(visible);
                            String seguir = (String)JOptionPane.showInputDialog(null, "¿Deseas regresar el menu?", "Menu",
								     JOptionPane.QUESTION_MESSAGE, null, continuar, continuar[0]);
                            if(seguir.equals("si")){
                                visible = false;
                                frame.setVisible(visible);
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Opcion 3");//Esto es para ver que funciona el menu
			            int eda18 = 0, eda19 = 0, eda20 = 0, eda21 = 0, eda22 = 0, eda23 = 0, eda24 = 0, eda25 = 0;
			            int[] edd = obtenerValores(alumnos);
			            for(int i = 0; i < edd.length; i++){
			                if(edd[i] == 18){
				                eda18++;
                            }
			                if(edd[i] == 19){
				                eda19++;
                            }
			                if(edd[i] == 20){
				                eda20++;
                            }
			                if(edd[i] == 21){                            
    				            eda21++;
                            }
	    		            if(edd[i] == 22){
		    		            eda22++;
                            }
			                if(edd[i] == 23){
				                eda23++;
                            }
			                if(edd[i] == 24){
				                eda24++;
                            }
			                if(edd[i] == 25){
				                eda25++;
                            }
			            }
			            Frecuencia[] f = new Frecuencia[8];
        			    Frecuencia ed18 = new Frecuencia(18, eda18);
	        		    Frecuencia ed19 = new Frecuencia(19, eda19);
		        	    Frecuencia ed20 = new Frecuencia(20, eda20);
			            Frecuencia ed21 = new Frecuencia(21, eda21);
			            Frecuencia ed22 = new Frecuencia(22, eda22);
			            Frecuencia ed23 = new Frecuencia(23, eda23);
    			        Frecuencia ed24 = new Frecuencia(24, eda24);
	    		        Frecuencia ed25 = new Frecuencia(25, eda25);
    	    		    f[0] = ed18;
	    	    	    f[1] = ed19;
		    	        f[2] = ed20;
			            f[3] = ed21;
    			        f[4] = ed22;
	    		        f[5] = ed23;
    	    		    f[6] = ed24;
	                    f[7] = ed25;
			            for(int z = 0; z < f.length;z++){
				            System.out.println(f[z]);
			                bubblesort(f);
                        }
			            for(int z = 0; z < f.length;z++){
    				        System.out.println(f[z]);
	    		            g2.tomaValores(f);
                        }
			            frame2.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			            frame2.add(g2);		//agrega el panel al marco
			            frame2.setSize(600,600);	//establece tamaño del marco
                        boolean vis = true;
                        while(vis){
			                frame2.setVisible(vis);
                            String seguir = (String)JOptionPane.showInputDialog(null, "¿Deseas regresar el menu?", "Menu",
								     JOptionPane.QUESTION_MESSAGE, null, continuar, continuar[0]);
                            if(seguir.equals("si")){
                                vis = false;
                                frame2.setVisible(vis);
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Opcion 4");//Esto es para ver que funciona el menu
                        //Si no esta vacio lo mostramos
                        if(arbol.raiz ==null){
                            System.out.println("No hay alumnos");
                            JOptionPane.showMessageDialog(null, "No se han agregado alumnos", "Arbol", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            System.out.println(arbol);
                            JOptionPane.showMessageDialog(null, "Este es el arbol:\n" + arbol, "Arbol", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Gracias por usar este programa", "Salir", JOptionPane.INFORMATION_MESSAGE);
                        auxiliar = 5;
                        break;
                }
	    }catch(Exception e){
		    System.out.println("OPCION NO VALIDA");
	    }
        }

        //Para cerrar el programa al terminar la ejecucion
        System.exit(0);
    }
    
    /**
     * Metodo estatico que devuelve un arreglo de enteros con los valores 
     * de una tabla hash
     * 
     * @param table La tabla hash
     * @return El arreglo con los valores
     */
    public static int[] obtenerValores(Hashtable<Integer,Integer> tabla){
        Enumeration valores = tabla.elements();
        int[] resultado = new int[tabla.size()];
        int i = 0;
        while(valores.hasMoreElements()){
            resultado[i] = (int) valores.nextElement();
            i++;
        }
        return resultado;
    }

    /**
     * Metodo bubblesort para ordenar
     * 
     * @param l El arreglo de frecuencias a ordenar
     * @return El arreglo ordenado
     */
    public static Frecuencia[] bubblesort(Frecuencia[] l){
	    return bubblesort(l, (a,b) -> a.frecuencia - b.frecuencia);
	}

    /**
     * Metodo auxiliar para el bubblesort
     * 
     */
    public static Frecuencia[] bubblesort(Frecuencia[] datos, Comparator<Frecuencia> cmp) {
    Frecuencia orden[] = datos;
    for (int i = 0; i < orden.length; i++)
      for (int j = i + 1; j < orden.length; j++)
        if (cmp.compare(datos[i], datos[j]) > 0) {
          Frecuencia temp = orden[i];
          orden[i] = orden[j];
          orden[j] = temp;
        }
    return orden;
  }

}
