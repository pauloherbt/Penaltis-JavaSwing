package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cenario.Celula;

public class ActionButton implements ActionListener {

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Celula botao= (Celula)e.getSource();
		System.out.println(botao.getPosicaoX()+", "+botao.getPosicaoY());
	}

}
