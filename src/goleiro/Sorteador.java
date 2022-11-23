package goleiro;

import java.util.Random;

import cenario.CriarCenario;

public class Sorteador {
	private Posicao posGoleiro;
	private Posicao maoDireita;
	private Posicao maoEsquerda;
	private CriarCenario c;
	
	public Sorteador(CriarCenario c) {
		this.c=c;
		sortearPosicoes();
	}
	private void sortearPosicoes() {
		Random rd= new Random();
		sortearGoleiro(rd);
		sortearMaoEsquerda(rd);
		sortearMaoDireita(rd);
		
	}
	private void sortearGoleiro(Random rd) {
		int x=c.getNumeroLinhas()-1;
		int y=rd.nextInt(c.getNumeroColunas());
		posGoleiro= new Posicao(x,y,c);
		
	}
	private void sortearMaoEsquerda(Random rd) {
		int x;
		int y;
		boolean flag= false;
		do {
			x=rd.nextInt(c.getNumeroLinhas());
			y=rd.nextInt(c.getNumeroColunas());
			flag=y<=posGoleiro.getY()?true:false;
		}while(flag==false);
		maoEsquerda= new Posicao(x,y,c);
	}
	private void sortearMaoDireita(Random rd) {
		int x;
		int y;
		boolean flag=false;
		do {
			x=rd.nextInt(c.getNumeroLinhas());
			y=rd.nextInt(c.getNumeroColunas());
			flag=y>=posGoleiro.getY()? true:false;
		}while(flag==false);
		maoDireita= new Posicao(x,y,c);
	}
	public Posicao getPosGoleiro() {
		return posGoleiro;
	}
	public Posicao getMaoDireita() {
		return maoDireita;
	}
	public Posicao getMaoEsquerda() {
		return maoEsquerda;
	}
	
}
