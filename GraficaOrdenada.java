import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;


public class GraficaOrdenada extends JPanel {


    Frecuencia[] f;

	public void paintComponent(Graphics g) {
	    super.paintComponent(g);

	    Color c = new Color(234, 34, 192);

	    g.drawLine(10, 30, 10, 500);

	    g.drawLine(10, 500, 570, 500);

	    g.drawString(Integer.toString(f[0].edad), 45, 525); //De 10 a 80
	    
	    g.drawString(Integer.toString(f[1].edad), 115, 525); //De 80 a 150

	    g.drawString(Integer.toString(f[2].edad), 185, 525); //De 150 a 220

	    g.drawString(Integer.toString(f[3].edad), 255, 525); //De 220 a 290 

	    g.drawString(Integer.toString(f[4].edad), 325, 525); //De 290 a 360
	    
	    g.drawString(Integer.toString(f[5].edad), 395, 525); //De 360 a 430

	    g.drawString(Integer.toString(f[6].edad), 465, 525); //De 430 a 500

	    g.drawString(Integer.toString(f[7].edad), 535, 525); //De 500 a 570

	    if (f[0].frecuencia != 0){
		int valor = 500 - (f[0].frecuencia * 50);
		g.fillRect(10, 30+valor, 80, 500-(30+valor));
	    }

	    if (f[1].frecuencia != 0){
		int valor = 500 - (f[1].frecuencia * 50);
		g.fillRect(80, 30+valor, 150, 500-(30+valor));
	    }

	    if (f[2].frecuencia != 0){
		int valor = 500 - (f[2].frecuencia * 50);
		g.fillRect(150, 30+valor, 220, 500-(30+valor));
	    }

	    if (f[3].frecuencia != 0){
		int valor = 500 - (f[3].frecuencia * 50);
		g.fillRect(220, 30+valor, 290, 500-(30+valor));
	    }

	    if (f[4].frecuencia != 0){
		int valor = 500 - (f[4].frecuencia * 50);
		g.fillRect(290, 30+valor, 360, 500-(30+valor));
	    }

	    if (f[5].frecuencia != 0){
		int valor = 500 - (f[5].frecuencia * 50);
		g.fillRect(360, 30+valor, 430, 500-(30+valor));
	    }

	    if (f[6].frecuencia != 0){
		int valor = 500 - (f[6].frecuencia * 50);
		g.fillRect(430, 30+valor, 500, 500-(30+valor));
	    }

	    if (f[7].frecuencia != 0){
		int valor = 500 - (f[7].frecuencia * 50);
		g.fillRect(500, 30+valor, 530, 500-(30+valor));
	    }
	        
	}

    public void tomaValores(Frecuencia[] f){
	this.f = f;
    }

}
			 
