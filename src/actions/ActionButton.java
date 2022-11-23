package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cenario.Celula;
import cenario.CriarCenario;
import goleiro.ProcessarDados;

public class ActionButton implements ActionListener {
	ProcessarDados process;
	
	public ActionButton() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Celula botao= (Celula)e.getSource();
		//process.verificarChute(botao.getPosicaoX(), botao.getPosicaoY());
		System.out.println(botao.getPosicaoX()+", "+botao.getPosicaoY());
	}

}
