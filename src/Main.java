import java.awt.BufferCapabilities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {

	private static boolean startFlag = false;

	public static void main(String[] args) throws InterruptedException {

		JFrame frame = new JFrame("Binario");
		RelojBinario reloj = new RelojBinario();
		frame.add(reloj);

		Toolkit mipantalla = Toolkit.getDefaultToolkit();// Guardado sistema de vemtanas nativo
		Dimension tamanioPantalla = mipantalla.getScreenSize();// Guardado la dimension de mi pantalla
		int alturaPantalla = tamanioPantalla.height;// alto
		int anchoPantalla = tamanioPantalla.width;// ancho
		frame.setLocation(anchoPantalla / 4, alturaPantalla / 32);// Marco centrado

		frame.setSize(400, 320);
		frame.setBackground(Color.BLACK);
		frame.setResizable(false);// No dejamos poner en pantalla completa
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setBackground(Color.BLACK);

		frame.setLayout(null);

		while (true) { // Loop del juego

			
			if (startFlag) {

				reloj.bucleReloj();
				reloj.repaint();

			}

			Thread.sleep(1000);

		}

	}

	public void setStartFlag(boolean f) {
		System.out.println("A");
		Main.startFlag = f;
	}

}
