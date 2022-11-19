package cenario;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Celula extends JButton {
	private static final long serialVersionUID = 1L;
	private int posicaoX;
	private int posicaoY;
	
	public Celula(int posicaoX, int posicaoY,ActionListener action) {
		addActionListener(action);
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
	}

	public int getPosicaoX() {
		return posicaoX;
	}

	public int getPosicaoY() {
		return posicaoY;
	}
	
}
