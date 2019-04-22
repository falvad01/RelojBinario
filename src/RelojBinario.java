import java.awt.BasicStroke;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;

public class RelojBinario extends JPanel {

	Main a = new Main();  //pausar o continuar el cronometro
	JLabel mostrarReloj;

	boolean selectorModo = false; //nos permite selecionar entre relo y cronometro, es reloj por defento

	private int radio = 15;
	private int diametro = radio * 2;

	private static final Color colorOn = Color.WHITE;
	private static final Color colorOff = Color.BLACK;
	
	
	private static final int initX = 380; //variable que ayuda a pintar los elementos

	private int segundoDerecha = 0;
	private int segundoIzquierda = 0;
	private int minutoDerecha = 0;
	private int minutoIzquierda = 0;
	private int horaDerecha = 0;
	private int horaIzquierda = 0;
	
	//Variables de los colores de cada punto del reloj

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

	private Color HD1 = Color.WHITE;
	private Color HD2 = Color.WHITE;
	private Color HD4 = Color.WHITE;
	private Color HD8 = Color.WHITE;

	private Color HI1 = Color.WHITE;
	private Color HI2 = Color.WHITE;

	/**
	 * Create the frame.
	 */
	public RelojBinario() {

		setBackground(Color.BLACK);

		this.setLayout(null);

		JLabel uno = new JLabel("1");
		uno.setBackground(Color.WHITE);
		uno.setForeground(Color.WHITE);
		uno.setBounds(initX + 40, 205, 20, 20);
		uno.setVisible(true);
		add(uno);

		mostrarReloj = new JLabel("00:00:00");
		mostrarReloj.setForeground(Color.WHITE);
		mostrarReloj.setFont(new Font("Tahoma", Font.BOLD, 17));
		mostrarReloj.setBackground(Color.RED);
		mostrarReloj.setBounds(10, 178, 89, 28);
		mostrarReloj.setVisible(true);
		add(mostrarReloj);

		JLabel dos = new JLabel("2");
		dos.setForeground(Color.WHITE);
		dos.setBounds(initX + 40, 145, 20, 20);
		dos.setVisible(true);
		add(dos);

		JLabel cuatro = new JLabel("4");
		cuatro.setForeground(Color.WHITE);
		cuatro.setBounds(initX + 40, 85, 20, 20);
		cuatro.setVisible(true);
		add(cuatro);

		JLabel ocho = new JLabel("8");
		ocho.setForeground(Color.WHITE);
		ocho.setBounds(initX + 40, 25, 20, 20);
		ocho.setVisible(true);
		add(ocho);

		
		/////BOTONES//////////
		JButton start = new JButton("Start");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.setStartFlag(true);
			}
		});

		start.setBounds(10, 75, 89, 23);
		start.setVisible(false);
		
		add(start);

		JButton stop = new JButton("Stop");
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.setStartFlag(false);
			}
		});
		stop.setBounds(10, 109, 89, 23);
		add(stop);
		
		stop.setVisible(false);
		

		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reset();
			}
		});
		reset.setBounds(10, 143, 89, 23);
		reset.setVisible(false);
		add(reset);

		JButton reloj = new JButton("Reloj");
		reloj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectorModo = false;
				a.setStartFlag(true);
				start.setVisible(false);
				stop.setVisible(false);
				reset.setVisible(false);

			}
		});
		reloj.setBounds(10, 11, 89, 23);
		add(reloj);

		JButton cronometro = new JButton("Cronometro");
		cronometro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectorModo = true;
				start.setVisible(true);
				stop.setVisible(true);
				reset.setVisible(true);
				a.setStartFlag(false);
				reset();
			}
		});
		cronometro.setBounds(10, 41, 89, 23);
		add(cronometro);
		
		//////////////////////
		
		JLabel lblSsss = new JLabel("SS:SS");
		lblSsss.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSsss.setForeground(Color.WHITE);
		lblSsss.setBackground(Color.WHITE);
		lblSsss.setBounds(357, 242, 56, 20);
		add(lblSsss);
		
		JLabel label = new JLabel("MM:MM");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBackground(Color.WHITE);
		label.setBounds(259, 242, 66, 20);
		add(label);
		
		JLabel label_1 = new JLabel("HH:HH");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(173, 242, 66, 20);
		add(label_1);
		
	}

	public void paint(Graphics g) {

		super.paint(g);
		
		//Pintamos los puntos del reloj
		
		
		////////////////////////SEGUNDOS
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

		//////////////////////MINUTos//////////////////////
		//////////////////////////////////////////////////////

		Graphics2D minutosD_8 = (Graphics2D) g;
		minutosD_8.setStroke(new BasicStroke(10f)); // Grosor contorno
		minutosD_8.setPaint(MD8);
		minutosD_8.fillOval(initX - 90, 20, diametro, diametro);

		Graphics2D minutosD_4 = (Graphics2D) g;
		minutosD_4.setStroke(new BasicStroke(10f)); // Grosor contorno
		minutosD_4.setPaint(MD4);
		minutosD_4.fillOval(initX - 90, 80, diametro, diametro);

		Graphics2D minutosD_2 = (Graphics2D) g;
		minutosD_2.setStroke(new BasicStroke(10f)); // Grosor contorno
		minutosD_2.setPaint(MD2);
		minutosD_2.fillOval(initX - 90, 140, diametro, diametro);

		Graphics2D minutosD_1 = (Graphics2D) g;
		minutosD_1.setStroke(new BasicStroke(10f)); // Grosor contorno
		minutosD_1.setPaint(MD1);
		minutosD_1.fillOval(initX - 90, 200, diametro, diametro);

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

		/////////////////HORAS///////////////////
		//////////////////////////////////////////

		Graphics2D horasD_8 = (Graphics2D) g;
		horasD_8.setStroke(new BasicStroke(10f)); // Grosor contorno
		horasD_8.setPaint(HD8);
		horasD_8.fillOval(initX - 180, 20, diametro, diametro);

		Graphics2D horasD_4 = (Graphics2D) g;
		horasD_4.setStroke(new BasicStroke(10f)); // Grosor contorno
		horasD_4.setPaint(HD4);
		horasD_4.fillOval(initX - 180, 80, diametro, diametro);

		Graphics2D horasD_2 = (Graphics2D) g;
		horasD_2.setStroke(new BasicStroke(10f)); // Grosor contorno
		horasD_2.setPaint(HD2);
		horasD_2.fillOval(initX - 180, 140, diametro, diametro);

		Graphics2D horasD_1 = (Graphics2D) g;
		horasD_1.setStroke(new BasicStroke(10f)); // Grosor contorno
		horasD_1.setPaint(HD1);
		horasD_1.fillOval(initX - 180, 200, diametro, diametro);

		///////////////////////////

		Graphics2D horasI_2 = (Graphics2D) g;
		horasI_2.setStroke(new BasicStroke(10f)); // Grosor contorno
		horasI_2.setPaint(HI2);
		horasI_2.fillOval(initX - 220, 140, diametro, diametro);

		Graphics2D horasI_1 = (Graphics2D) g;
		horasI_1.setStroke(new BasicStroke(10f)); // Grosor contorno
		horasI_1.setPaint(HI1);
		horasI_1.fillOval(initX - 220, 200, diametro, diametro);

		////////////////////////////////////
		//////////////////////////////////////////

	}

	public void bucleReloj() {

		if (selectorModo) { //Modo cronometro
		
			
			segundoDerecha++;// TODO codigo cronometro

			if (segundoDerecha == 10) { // CAmbiamos el segundo digito de los segundos
				segundoIzquierda++;
				segundoDerecha = 0;
			}

			if (segundoIzquierda == 6) { // cambiamos el segundo digito de los minutos

				minutoDerecha++;
				segundoIzquierda = 0;
			}

			if (minutoDerecha == 10) { //cambiamos el primer digito de los minutos
				minutoIzquierda++;
				minutoDerecha = 0;
			}

			if (minutoIzquierda == 6) { //Cambiamos el segundo digito de las horas
				horaDerecha++;
				minutoIzquierda = 0;
			}

			if (horaDerecha == 10) { //cambiamos el primer digito de la hora
				horaIzquierda++;
				horaDerecha = 0;
			}

			if (horaIzquierda == 2 && horaDerecha == 4) { //paramos el cronometro al fina(duracion: UN DIA)

				a.setStartFlag(false);
			}

		} else { //Modo reloj

			
			Calendar calendario = Calendar.getInstance();//Obtenemos la hora a cada segndo

			int hora = calendario.get(Calendar.HOUR_OF_DAY);
			int minutos = calendario.get(Calendar.MINUTE);
			int segundos = calendario.get(Calendar.SECOND);

			

			separarNumeros(segundos, "seg");
			separarNumeros(minutos, "min");
			separarNumeros(hora, "hor");

		}

		
		//Cambiamos los colores de los circulos pintados arriba
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

		Color[] colorMI = decimalToColor(minutoIzquierda);

		MI4 = colorMI[1];
		MI2 = colorMI[2];
		MI1 = colorMI[3];

		Color[] colorHD = decimalToColor(horaDerecha);

		HD8 = colorHD[0];
		HD4 = colorHD[1];
		HD2 = colorHD[2];
		HD1 = colorHD[3];

		Color[] colorHI = decimalToColor(horaIzquierda);

		HI2 = colorHI[2];
		HI1 = colorHI[3];

		StringBuilder reloj = new StringBuilder();
		reloj.append(horaIzquierda + "" + horaDerecha + ":" + minutoIzquierda + "" + minutoDerecha + ":"
				+ segundoIzquierda + "" + segundoDerecha);

		mostrarReloj.setText(reloj.toString()); //mostramos el reloj decimal en un Jlabel

	}

	/**
	 * Tranformamos un numero decimal en sus colores binarios
	 * 
	 * @param numero a convertir
	 * @return array de colores de cada fila de circulos binarios
	 */
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

			ret[0] = colorOn;
			ret[1] = colorOn;
			ret[2] = colorOn;
			ret[3] = colorOn;
			break;
		}

		return ret;

	}

	
	/**
	 * Separamos un numero decimal en decenas y unidades y lo metemos en las variables a transformar
	 * @param n  numero a convertir
	 * @param tipo  tipo de dato a guardar
	 */
	private void separarNumeros(int n, String tipo) {

		int millares = n / 1000;
		int centenas = (n - (millares * 1000)) / 100;
		int decenas = (n - (millares * 1000 + centenas * 100)) / 10;
		int unidades = n - (millares * 1000 + centenas * 100 + decenas * 10);

		switch (tipo) {

		case "seg":

			segundoDerecha = unidades;
			segundoIzquierda = decenas;

			break;
		case "min":

			minutoDerecha = unidades;
			minutoIzquierda = decenas;

			break;
		case "hor":

			horaDerecha = unidades;
			horaIzquierda = decenas;

			break;

		default:
			break;
		}

	}

	
	/**
	 * Metodo que resetea el reloj del cronometro
	 */
	private void reset() {

		segundoIzquierda = segundoDerecha = minutoDerecha = minutoIzquierda = horaDerecha = horaIzquierda = 0;

		StringBuilder reloj = new StringBuilder();
		reloj.append(horaIzquierda + "" + horaDerecha + ":" + minutoIzquierda + "" + minutoDerecha + ":"
				+ segundoIzquierda + "" + segundoDerecha);

		mostrarReloj.setText(reloj.toString());

		SD8 = colorOn;
		SD4 = colorOn;
		SD2 = colorOn;
		SD1 = colorOn;
		SI4 = colorOn;
		SI2 = colorOn;
		SI1 = colorOn;
		MD8 = colorOn;
		MD4 = colorOn;
		MD2 = colorOn;
		MD1 = colorOn;
		MI4 = colorOn;
		MI2 = colorOn;
		MI1 = colorOn;
		HD8 = colorOn;
		HD4 = colorOn;
		HD2 = colorOn;
		HD1 = colorOn;
		HI2 = colorOn;
		HI1 = colorOn;

		repaint();

	}
}
