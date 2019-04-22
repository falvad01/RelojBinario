import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
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

	Color SD1 = Color.WHITE;
	Color SD2 = Color.WHITE;
	Color SD4 = Color.WHITE;
	Color SD8 = Color.WHITE;

	private Color SI1 = Color.WHITE;
	private Color SI2 = Color.WHITE;
	private Color SI4 = Color.WHITE;

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

	}

	public void bucleReloj() {

		segundoDerecha++;
		Color[] colorSD = decimalToColor(segundoDerecha);

		SD8 = colorSD[0];
		SD4 = colorSD[1];
		SD2 = colorSD[2];
		SD1 = colorSD[3];

		if (segundoDerecha == 10) {
			segundoIzquierda++;
			segundoDerecha = 0;
		}
		
		Color[] colorSI = decimalToColor(segundoIzquierda);

		SI4 = colorSI[1];
		SI2 = colorSI[2];
		SI1 = colorSI[3];

		System.out.println("00:00:" + segundoIzquierda + "" + segundoDerecha);

	}

	private Color[] decimalToColor(int numero) {

		System.out.println("numero " + numero);

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
