import java.awt.BufferCapabilities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {

	private static boolean startFlag = true;

	public static void main(String[] args) throws InterruptedException {
		/*
		MenuWindow menu = new MenuWindow();
		
		menu.setVisible(true);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		*/
		
		
		JFrame frame = new JFrame("Binario");
		RelojBinario reloj = new RelojBinario();
		frame.add(reloj);


		frame.setSize(450, 300);
		frame.setBackground(Color.BLACK);
		frame.setResizable(false);// No dejamos poner en pantalla completa
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setBackground(Color.BLACK);

		frame.setLayout(null);

		while (true) { // Loop del programa
			
			if (startFlag) { //siempre activo en caso del reloj, variable en caso del cronometro

				reloj.bucleReloj();
				reloj.repaint();
			}
			Thread.sleep(1000);//Dormimos durante un segundo
		}
		
	}

	/**
	 * Premite apagar y encender el bucle desde la clase del reloj
	 * @param f
	 */
	public void setStartFlag(boolean f) {
		
		Main.startFlag = f;
	}

}
