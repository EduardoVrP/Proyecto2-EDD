import java.util.Hashtable;
import java.util.Enumeration;
import javax.swing.*;  
/**
 * Clase para desarrollar el proyecto
 * 
 * @author Eduardo Vargas Perez, Ernesto
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
        JFrame frame = new JFrame();
        ImageIcon menuImagen = new ImageIcon("Menu.jpeg"); //Imagen para el menu
        Hashtable<Integer,Integer> alumnos = new Hashtable<Integer,Integer>(); //Donde se guardaran los alumnos
        

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
        
        //Mostramos el menu y lo repetimos hasta que el usuario decida salir
        int auxiliar = 0;
        while(auxiliar != 5){
            try{
                String usuario = (String)JOptionPane.showInputDialog(null, "Selecciona una opcion", "Menu", JOptionPane.QUESTION_MESSAGE, menuImagen, menu, menu[0]);
                int seleccion = Integer.parseInt(usuario);
                switch(seleccion){
                    case 1:
                        System.out.println("Opcion 1");//Esto es para ver en la terminal que funciona el menu
                        //Pedimos la edad del alumno
                        String edadUsuario = (String)JOptionPane.showInputDialog(null, "Seleciona la edad del alumno", "Cuestionario", JOptionPane.QUESTION_MESSAGE, null, edades, edades[0]);
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
                                if(numCuenta >= 300000000 && numCuenta<= 500000000){
                                    //Si esta en el rango lo agregamos al Hashtable y al arbol
                                    alumnos.put(numCuenta, anios);
                                    //Indicamos que se agrego al hashtable y al arbol
                                    seAgrego = true;
                                    System.out.println(alumnos.containsKey(numCuenta));//Para revisar en la terminal si se agrego bien
                                    
                                }else{
                                    JOptionPane.showMessageDialog(null, "Ingresa un numero entre 300,000,000 y 500,000,000", "Error", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }catch(Exception e){
                                JOptionPane.showMessageDialog(null, "Ingresa lo solicitado", "Error", JOptionPane.INFORMATION_MESSAGE);
                                System.out.println("opcion no valida");
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Opcion 2");//Esto es para ver que funciona el menu
                        break;
                    case 3:
                        System.out.println("Opcion 3");//Esto es para ver que funciona el menu
                        break;
                    case 4:
                        System.out.println("Opcion 4");//Esto es para ver que funciona el menu
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
}
