package goleiro;

import java.util.ArrayList;

import cenario.Celula;
import cenario.CriarCenario;
import cenario.DentroGol;

public class ProcessarDados {
	private int gols;
	private int defesas;

	public ProcessarDados() {
		gols = 0;
		defesas = 0;
	}
	public void computar(int chuteX, int chuteY,ArrayList<Celula> celulas) {
		Celula celulaEncontrada= pesquisarPosicao(chuteX, chuteY, celulas);
		if(verificarDentroGol(celulaEncontrada)==true&&celulaEncontrada.isArea()==false) {
			gols++;
		}
		else if(celulaEncontrada.isArea()==true)
			defesas++;
	}
	private boolean verificarDentroGol(Celula celula) {
		if(celula instanceof DentroGol) {
			return true;
		}
		return false;
	}
	private Celula pesquisarPosicao(int chuteX, int chuteY, ArrayList<Celula> celulas) {
		for (Celula celula : celulas) {
			if (celula.getPosicaoX() == chuteX && celula.getPosicaoY() == chuteY){
				return celula;
			}
		}
		return null;
	}

	public int getGols() {
		return gols;
	}

	public int getDefesas() {
		return defesas;
	}

}
