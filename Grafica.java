import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;


public class Grafica extends JPanel {

    int e18, e19, e20, e21, e22, e23, e24, e25;

	public void paintComponent(Graphics g) {
	    super.paintComponent(g);

	    Color c = new Color(234, 34, 192);

	    g.drawLine(10, 30, 10, 500);

	    g.drawLine(10, 500, 570, 500);

	    g.drawString("18", 45, 525); //De 10 a 80
	    
	    g.drawString("19", 115, 525); //De 80 a 150

	    g.drawString("20", 185, 525); //De 150 a 220

	    g.drawString("21", 255, 525); //De 220 a 290 

	    g.drawString("22", 325, 525); //De 290 a 360

	    g.drawString("23", 395, 525); //De 360 a 430

	    g.drawString("24", 465, 525); //De 430 a 500

	    g.drawString("25", 535, 525); //De 500 a 570

	    if (e18 != 0){
		int valor = 500 - (e18 * 50);
		g.fillRect(10, 30+valor, 80, 500-(30+valor));
	    }

	    if (e19 != 0){
		int valor = 500 - (e19 * 50);
		g.fillRect(80, 30+valor, 150, 500-(30+valor));
	    }

	    if (e20 != 0){
		int valor = 500 - (e20 * 50);
		g.fillRect(150, 30+valor, 220, 500-(30+valor));
	    }

	    if (e21 != 0){
		int valor = 500 - (e21 * 50);
		g.fillRect(220, 30+valor, 290, 500-(30+valor));
	    }

	    if (e22 != 0){
		int valor = 500 - (e22 * 50);
		g.fillRect(290, 30+valor, 360, 500-(30+valor));
	    }

	    if (e23 != 0){
		int valor = 500 - (e23 * 50);
		g.fillRect(360, 30+valor, 430, 500-(30+valor));
	    }

	    if (e24 != 0){
		int valor = 500 - (e24 * 50);
		g.fillRect(430, 30+valor, 500, 500-(30+valor));
	    }

	    if (e25 != 0){
		int valor = 500 - (e25 * 50);
		g.fillRect(500, 30+valor, 570, 500-(30+valor));
	    }
	        
	}

    public void tomaValores(int e18, int e19, int e20, int e21, int e22, int e23,
			    int e24, int e25){
	this.e18 = e18;
	this.e19 = e19;
	this.e20 = e20;
	this.e21 = e21;
	this.e22 = e22;
	this.e23 = e23;
	this.e24 = e24;
	this.e25 = e25;
    }

}
			 
