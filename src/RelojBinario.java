import java.awt.BasicStroke;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RelojBinario extends JPanel {

	private int radio = 15;
	private int diametro = radio * 2;

	private static final Color colorOn = Color.WHITE;
	private static final Color colorOff = Color.BLACK;
	private static final int PWIDTH = 300;
	private static final int PHEIGH = 400;
	private static final int initX = 320;

	private int segundoDerecha = 0;
	private int segundoIzquierda = 0;
	private int minutoDerecha = 0;
	private int minutoIzquierda = 0;

	private Color SD1 = Color.WHITE;
	private Color SD2 = Color.WHITE;
	private Color SD4 = Color.WHITE;
	private Color SD8 = Color.WHITE;

	private Color SI1 = Color.WHITE;
	private Color SI2 = Color.WHITE;
	private Color SI4 = Color.WHITE;
	
	private Color MD1 = Color.WHITE;
	private Color MD2 = Color.WHITE;
	private Color MD4 = Color.WHITE;
	private Color MD8 = Color.WHITE;
	
	private Color MI1 = Color.WHITE;
	private Color MI2 = Color.WHITE;
	private Color MI4 = Color.WHITE;

	/**
	 * Create the frame.
	 */
	public RelojBinario() {
		Main a = new Main();
		setBackground(Color.BLACK);

		this.setLayout(null);

		JLabel uno = new JLabel("1");
		uno.setForeground(Color.WHITE);
		uno.setBounds(367, 205, 20, 20);
		uno.setVisible(true);
		add(uno);

		JLabel dos = new JLabel("2");
		dos.setForeground(Color.WHITE);
		dos.setBounds(367, 145, 20, 20);
		dos.setVisible(true);
		add(dos);

		JLabel cuatro = new JLabel("4");
		cuatro.setForeground(Color.WHITE);
		cuatro.setBounds(367, 85, 20, 20);
		cuatro.setVisible(true);
		add(cuatro);

		JLabel ocho = new JLabel("8");
		ocho.setForeground(Color.WHITE);
		ocho.setBounds(367, 25, 20, 20);
		ocho.setVisible(true);
		add(ocho);

		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.setStartFlag(true);
			}
		});

		btnNewButton.setBounds(10, 265, 89, 23);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Stop");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.setStartFlag(false);
			}
		});
		btnNewButton_1.setBounds(108, 265, 89, 23);
		add(btnNewButton_1);

	}

	public void paint(Graphics g) {

		super.paint(g);

		Graphics2D segundosD_8 = (Graphics2D) g;
		segundosD_8.setStroke(new BasicStroke(10f)); // Grosor contorno
		segundosD_8.setPaint(SD8);
		segundosD_8.fillOval(initX, 20, diametro, diametro);

		Graphics2D segundosD_4 = (Graphics2D) g;
		segundosD_4.setStroke(new BasicStroke(10f)); // Grosor contorno
		segundosD_4.setPaint(SD4);
		segundosD_4.fillOval(initX, 80, diametro, diametro);

		Graphics2D segundosD_2 = (Graphics2D) g;
		segundosD_2.setStroke(new BasicStroke(10f)); // Grosor contorno
		segundosD_2.setPaint(SD2);
		segundosD_2.fillOval(initX, 140, diametro, diametro);

		Graphics2D segundosD_1 = (Graphics2D) g;
		segundosD_1.setStroke(new BasicStroke(10f)); // Grosor contorno
		segundosD_1.setPaint(SD1);
		segundosD_1.fillOval(initX, 200, diametro, diametro);
		
		///////////////////////////

		Graphics2D segundosI_4 = (Graphics2D) g;
		segundosI_4.setStroke(new BasicStroke(10f)); // Grosor contorno
		segundosI_4.setPaint(SI4);
		segundosI_4.fillOval(initX - 40, 80, diametro, diametro);

		Graphics2D segundosI_2 = (Graphics2D) g;
		segundosI_2.setStroke(new BasicStroke(10f)); // Grosor contorno
		segundosI_2.setPaint(SI2);
		segundosI_2.fillOval(initX - 40, 140, diametro, diametro);

		Graphics2D segundosI_1 = (Graphics2D) g;
		segundosI_1.setStroke(new BasicStroke(10f)); // Grosor contorno
		segundosI_1.setPaint(SI1);
		segundosI_1.fillOval(initX - 40, 200, diametro, diametro);

		Graphics2D lineaMinutosSegundos = (Graphics2D) g;
		segundosI_4.setStroke(new BasicStroke(1f)); // Grosor contorno
		lineaMinutosSegundos.setColor(Color.gray);
		lineaMinutosSegundos.drawLine(initX - 50, initX - 50, initX - 50, 0);

		/////////////////////////
		//////////////////////////
		
		
		
		
		Graphics2D minutosD_8 = (Graphics2D) g;
		minutosD_8.setStroke(new BasicStroke(10f)); // Grosor contorno
		minutosD_8.setPaint(MD8);
		minutosD_8.fillOval(initX-90, 20, diametro, diametro);

		Graphics2D minutosD_4 = (Graphics2D) g;
		minutosD_4.setStroke(new BasicStroke(10f)); // Grosor contorno
		minutosD_4.setPaint(MD4);
		minutosD_4.fillOval(initX-90, 80, diametro, diametro);

		Graphics2D minutosD_2 = (Graphics2D) g;
		minutosD_2.setStroke(new BasicStroke(10f)); // Grosor contorno
		minutosD_2.setPaint(MD2);
		minutosD_2.fillOval(initX-90, 140, diametro, diametro);

		Graphics2D minutosD_1 = (Graphics2D) g;
		minutosD_1.setStroke(new BasicStroke(10f)); // Grosor contorno
		minutosD_1.setPaint(MD1);
		minutosD_1.fillOval(initX-90, 200, diametro, diametro);
		
		///////////////////////////

		Graphics2D minutosI_4 = (Graphics2D) g;
		minutosI_4.setStroke(new BasicStroke(10f)); // Grosor contorno
		minutosI_4.setPaint(MI4);
		minutosI_4.fillOval(initX - 130, 80, diametro, diametro);

		Graphics2D minutosI_2 = (Graphics2D) g;
		minutosI_2.setStroke(new BasicStroke(10f)); // Grosor contorno
		minutosI_2.setPaint(MI2);
		minutosI_2.fillOval(initX - 130, 140, diametro, diametro);

		Graphics2D minutosI_1 = (Graphics2D) g;
		minutosI_1.setStroke(new BasicStroke(10f)); // Grosor contorno
		minutosI_1.setPaint(MI1);
		minutosI_1.fillOval(initX - 130, 200, diametro, diametro);

		Graphics2D lineaHorasMinutos = (Graphics2D) g;
		lineaHorasMinutos.setStroke(new BasicStroke(1f)); // Grosor contorno
		lineaHorasMinutos.setColor(Color.gray);
		lineaHorasMinutos.drawLine(initX - 140, initX - 50, initX - 140, 0);
		
		

	}

	public void bucleReloj() {

		segundoDerecha++;

		if (segundoDerecha == 10) { // CAmbiamos el segundo digito de los segundos
			segundoIzquierda++;
			segundoDerecha = 0;
		}

		if (segundoIzquierda == 6) { //cambiamos el segundo digito de los minutos
			
			
			minutoDerecha++;
			segundoIzquierda = 0;
		}

		Color[] colorSD = decimalToColor(segundoDerecha);

		SD8 = colorSD[0];
		SD4 = colorSD[1];
		SD2 = colorSD[2];
		SD1 = colorSD[3];

		Color[] colorSI = decimalToColor(segundoIzquierda);

		SI4 = colorSI[1];
		SI2 = colorSI[2];
		SI1 = colorSI[3];
		
		Color[] colorMD = decimalToColor(minutoDerecha);

		MD8 = colorMD[0];
		MD4 = colorMD[1];
		MD2 = colorMD[2];
		MD1 = colorMD[3];
		
		

		System.out
				.println("00:" + minutoIzquierda + "" + minutoDerecha + ":" + segundoIzquierda + "" + segundoDerecha);

	}

	private Color[] decimalToColor(int numero) {

		Color[] ret = new Color[4];

		switch (numero) {

		case 0:
			ret[0] = colorOff;
			ret[1] = colorOff;
			ret[2] = colorOff;
			ret[3] = colorOff;
			break;
		case 1:

			ret[0] = colorOff;
			ret[1] = colorOff;
			ret[2] = colorOff;
			ret[3] = colorOn;

			break;
		case 2:
			ret[0] = colorOff;
			ret[1] = colorOff;
			ret[2] = colorOn;
			ret[3] = colorOff;

			break;
		case 3:

			ret[0] = colorOff;
			ret[1] = colorOff;
			ret[2] = colorOn;
			ret[3] = colorOn;

			break;
		case 4:

			ret[0] = colorOff;
			ret[1] = colorOn;
			ret[2] = colorOff;
			ret[3] = colorOff;

			break;
		case 5:

			ret[0] = colorOff;
			ret[1] = colorOn;
			ret[2] = colorOff;
			ret[3] = colorOn;

			break;
		case 6:

			ret[0] = colorOff;
			ret[1] = colorOn;
			ret[2] = colorOn;
			ret[3] = colorOff;

			break;
		case 7:

			ret[0] = colorOff;
			ret[1] = colorOn;
			ret[2] = colorOn;
			ret[3] = colorOn;

			break;
		case 8:
			ret[0] = colorOn;
			ret[1] = colorOff;
			ret[2] = colorOff;
			ret[3] = colorOff;

			break;
		case 9:
			ret[0] = colorOn;
			ret[1] = colorOff;
			ret[2] = colorOff;
			ret[3] = colorOn;
			break;

		default:

			ret[0] = colorOff;
			ret[1] = colorOff;
			ret[2] = colorOff;
			ret[3] = colorOff;
			break;
		}

		return ret;

	}
}
