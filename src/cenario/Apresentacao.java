package cenario;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import goleiro.Goleiro;
import goleiro.ProcessarDados;
import goleiro.Sorteador;
import ui.Janela;

public class Apresentacao implements ActionListener{
	private CriarCenario cenario;
	private ProcessarDados process;
	private Sorteador sortear;
	private Goleiro goleiro;
	public Apresentacao() {
		cenario= new CriarCenario(9, 17);
		process= new ProcessarDados();
		Janela janela= new Janela("Programa", cenario,this);
	}
	public void start(int x, int y) {
		sortear= new Sorteador(cenario);
		goleiro = new Goleiro(sortear,cenario.getCelulasVariaveis());
		process.computar(x, y,goleiro.getCelulas());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Celula botao = (Celula) e.getSource();
		start(botao.getPosicaoX(),botao.getPosicaoY());
		marcarArea();
		long Time= 1L;
		TimeUnit time = TimeUnit.SECONDS;
		try {
			time.sleep(Time);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		marcarChute(botao);
		marcarGoleiro();
		marcarMaoEsquerda();
		marcarMaoDireita();
		
		
		System.out.println("Gols:"+process.getGols()+"defesas:"+process.getDefesas()+botao.getSize());
		
		
	}
	private void marcarGoleiro() {
		Icon imageIcon = new ImageIcon("src/golicon.png");
		marcarPosicoes(sortear.getPosGoleiro().getX(),sortear.getPosGoleiro().getY(),imageIcon);
	}
	private void marcarMaoEsquerda() {
		Icon imageIcon= new ImageIcon("src/maoesquerda.png");
		marcarPosicoes(sortear.getMaoEsquerda().getX(),sortear.getMaoEsquerda().getY(),imageIcon);
	}
	private void marcarMaoDireita() {
		Icon imageIcon= new ImageIcon("src/download.png");
		marcarPosicoes(sortear.getMaoDireita().getX(),sortear.getMaoDireita().getY(),imageIcon);
	}
	private void marcarChute(Celula botao) {
		Icon imageIcon = new ImageIcon("src/bola.png");
		marcarPosicoes(botao.getPosicaoX(),botao.getPosicaoY(),imageIcon);	
		}
	private void marcarArea() {
		Icon imageIcon = new ImageIcon("src/bola.png");
		for (Celula celula : goleiro.getCelulas()) {
			if(celula.isArea()==true) {
				celula.setBackground(Color.orange);
			}
			
		}
	}
	private void marcarPosicoes(int x,int y,Icon imageIcon) {
		for (Celula celula : cenario.getCelulasVariaveis()) {
			if(x==celula.getPosicaoX()&&y==celula.getPosicaoY()) {
				celula.setIcon(imageIcon);
			}
		}
	}
	
	
}
