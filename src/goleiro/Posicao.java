package goleiro;

import cenario.CriarCenario;

public class Posicao {
	private int x;
	private int y;
	
	public Posicao(int x, int y,CriarCenario c) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
	

	public int getY() {
		return y;
	}

	
	
}
