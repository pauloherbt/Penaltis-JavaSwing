package cenario;

import java.util.ArrayList;

import actions.ActionButton;

public class CriarCenario {
	private ArrayList<Celula> celulas;
	private int numeroLinhas;
	private int numeroColunas;
	private ActionButton action;

	public CriarCenario(int numeroLinhas, int numeroColunas) {
		this.celulas = new ArrayList<>();
		this.action=new ActionButton();
		this.numeroColunas = numeroColunas;
		this.numeroLinhas = numeroLinhas;
		mapearGol();
	}

	private void mapearGol() {
		criarTraveEsquerda();
		criarTraveDireita();
		criarTravessao();
		criarDentroGol();
		criarForaDoGol();
	}

	private void criarTraveEsquerda() {
		for (int i = 2; i < numeroLinhas; i++) {
			celulas.add(new TraveEsquerda(i, 1,action));
		}
	}

	private void criarTraveDireita() {
		for (int i = 2; i < numeroLinhas; i++) {
			celulas.add(new TraveDireita(i, numeroColunas - 2,action));
		}
	}

	private void criarTravessao() {
		for (int i = 1; i < numeroColunas - 1; i++) {
			celulas.add(new Travessao(1, i,action));
		}
	}

	private void criarDentroGol() {
		for (int i = 2; i < numeroLinhas; i++) {
			for (int j = 2; j < numeroColunas - 2; j++) {
				celulas.add(new DentroGol(i, j,action));
			}
		}
	}

	private void criarForaDoGol() {
		// parte esquerda
		for (int i = 1; i < numeroLinhas; i++) {
			celulas.add(new Fora(i, 0,action));
		}
		// parte superior
		for (int i = 0; i < numeroColunas; i++) {
			celulas.add(new Fora(0, i,action));
		}
		// parte direita
		for (int i = 1; i < numeroLinhas; i++) {
			celulas.add(new Fora(i, numeroColunas - 1,action));
		}
	}

	public void imprimirGol() {
		for (int x = 0; x < numeroLinhas; x++) {
			for (int y = 0; y < numeroColunas; y++) {
				for (Celula celula : celulas) {
					if (celula.getPosicaoX() == x && celula.getPosicaoY() == y) {
						System.out.print(celula.getClass() + " ");
					}
				}
				if (y == 16) {
					System.out.println();
				}
			}
			// System.out.println(celulas.size());
		}
	}

	public int getNumeroLinhas() {
		return numeroLinhas;
	}

	public int getNumeroColunas() {
		return numeroColunas;
	}

	public ArrayList<Celula> getCelulas() {
		return celulas;
	}
	
}
