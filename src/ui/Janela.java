package ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import cenario.CriarCenario;

public class Janela extends JFrame {
	private CriarCenario c;
	public Janela(String title,CriarCenario c)  {
		this.c=c;
		setTitle(title);
		setLayout(new BorderLayout());
		setSize(1280,720);
		setLocation(100, 50);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		add(BorderLayout.CENTER,new LabelBotoes(c));
	}
	

}
