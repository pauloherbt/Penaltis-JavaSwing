package cenario;

import javax.swing.JButton;

public class Celula extends JButton implements Cloneable {
	private static final long serialVersionUID = 1L;
	private int posicaoX;
	private int posicaoY;
	private boolean isArea;
	
	public Celula(int posicaoX, int posicaoY) {
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
		this.isArea= false;
	}
	public Celula clone() {
		try {
			return (Celula) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public int getPosicaoX() {
		return posicaoX;
	}

	public int getPosicaoY() {
		return posicaoY;
	}

	public boolean isArea() {
		return isArea;
	}

	public void setArea(boolean isArea) {
		this.isArea = isArea;
	}
	
}
