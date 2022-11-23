package ui;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import actions.ActionButton;
import cenario.Celula;
import cenario.CriarCenario;

public class LabelBotoes extends JLabel {
	private CriarCenario c;
	private ActionListener action;
	public LabelBotoes(CriarCenario c,ActionListener action) {
		//this.botoes = botoes;
		this.action=action;
		this.c=c;
		setLayout(new GridLayout(9,17));
		addBotoes();
	}

	private void addBotoes() {
		for (int x = 0; x < c.getNumeroLinhas(); x++) {
			for (int y = 0; y < c.getNumeroColunas(); y++) {
				for (Celula botao : c.getCelulas()) {
					if (botao.getPosicaoX() == x && botao.getPosicaoY() == y) {
						botao.addActionListener(action);
						add(botao);
					}
				}
			}
			// System.out.println(celulas.size());
		}
	}
}
