package ui;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;

import cenario.Celula;
import cenario.CriarCenario;

public class LabelBotoes extends JLabel {
	private CriarCenario c;

	public LabelBotoes(CriarCenario c) {
		//this.botoes = botoes;
		this.c=c;
		setLayout(new GridLayout(9,17));
		addBotoes();
	}

	private void addBotoes() {
		for (int x = 0; x < c.getNumeroLinhas(); x++) {
			for (int y = 0; y < c.getNumeroColunas(); y++) {
				for (Celula botao : c.getCelulas()) {
					if (botao.getPosicaoX() == x && botao.getPosicaoY() == y) {
						add(botao);
					}
				}
			}
			// System.out.println(celulas.size());
		}
	}
}
