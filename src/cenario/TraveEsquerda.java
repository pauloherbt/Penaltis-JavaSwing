package cenario;

import java.awt.Color;
import java.awt.event.ActionListener;

public class TraveEsquerda extends Celula {
	private static final long serialVersionUID = 1L;

	public TraveEsquerda(int posicaoX, int posicaoY, ActionListener action) {
		super(posicaoX, posicaoY, action);
		setBackground(Color.WHITE);	
	}

}
