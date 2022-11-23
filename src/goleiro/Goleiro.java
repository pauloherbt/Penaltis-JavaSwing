package goleiro;

import java.util.ArrayList;

import cenario.Celula;

public class Goleiro {
	private ArrayList<Celula> celulas;
	private Posicao posGoleiro;
	private Posicao maoDireita;
	private Posicao maoEsquerda;

	public Goleiro(Sorteador sc,ArrayList<Celula> celulas) {
		this.posGoleiro = sc.getPosGoleiro();
		this.maoDireita = sc.getMaoDireita();
		this.maoEsquerda = sc.getMaoEsquerda();
		this.celulas= celulas;
		mapearArea();
	}

	public void mapearArea() {
		addPosIniciais();
		criarSegmentoEsquerdo();
		criarSegmentoDireito();
	}
	private void addPosIniciais() {
		Posicao pos[]= {posGoleiro,maoDireita,maoEsquerda}; 
		for (Posicao posicao : pos) {
			addArea(posicao.getX(), posicao.getY());
		}
		
	}

	private void criarSegmentoEsquerdo() {
		mesmaLinhaEsquerda();
		int linhaLimite = maoEsquerda.getX();
		int contador = razaoGolMaoEsquerda();
		for (int x = posGoleiro.getX() - 1; x >= linhaLimite; x--) {
			int y = posGoleiro.getY();
			addArea(x, y);
			criarAdjacenteEsquerda(x, y, contador);
			contador += contador;
		}

	}

	private void criarSegmentoDireito() {
		mesmaLinhaDireita();
		int linhaLimite = maoDireita.getX();
		int contador = razaoGolMaoDireita();
		for (int x = posGoleiro.getX() - 1; x >= linhaLimite; x--) {
			int y = posGoleiro.getY();
			addArea(x, y);
			criarAdjacenteDireita(x, y, contador);
			contador += contador;
		}
	}

	private void criarAdjacenteDireita(int x, int y, int contador) {
		for (int i = 0; i < contador; i++) {
			y++;
			if (y < maoDireita.getY()) {
				addArea(x, y);
			}
		}
	}

	private void criarAdjacenteEsquerda(int x, int y, int contador) {
		for (int i = 0; i < contador; i++) {
			y--;
			if (y > maoEsquerda.getY()) {
				addArea(x, y);
			}
		}
	}

	private void mesmaLinhaEsquerda() {
		if (posGoleiro.getX() == maoEsquerda.getX()) {
			for (int y = posGoleiro.getY(); y > maoEsquerda.getY(); y--) {
				addArea(posGoleiro.getX(), y);
			}
		}
	}

	private void mesmaLinhaDireita() {
		if (posGoleiro.getX() == maoDireita.getX()) {
			for (int y = posGoleiro.getY(); y < maoDireita.getY(); y++) {
				addArea(posGoleiro.getX(), y);
			}
		}
	}

	private int razaoGolMaoDireita() {
		int diffColuna = (maoDireita.getY() - posGoleiro.getY()) - 1;
		int diffLinha = (posGoleiro.getX() - maoDireita.getX()) - 1;
		return verificaRazao(diffColuna, diffLinha);
	}

	private int razaoGolMaoEsquerda() {
		int diffColuna = (posGoleiro.getY() - maoEsquerda.getY()) - 1;
		int diffLinha = (posGoleiro.getX() - maoEsquerda.getX()) - 1;
		return verificaRazao(diffColuna, diffLinha);
	}

	private int verificaRazao(int diffColuna, int diffLinha) {
		int razao = 0;
		try {
			razao = diffColuna / diffLinha;
		} catch (Exception e) {
			return 0;
		}
		if (diffColuna % diffLinha == 0) {
			return razao;
		} else
			return razao + 1;
	}
	public void addArea(int x, int y) {
		for (Celula celula : celulas) {
			if(celula.getPosicaoX() == x&&celula.getPosicaoY()==y) {
				celula.setArea(true);
			}
		}
	}

	public ArrayList<Celula> getCelulas() {
		return celulas;
	}

}
