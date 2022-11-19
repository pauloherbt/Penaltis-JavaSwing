package cenario;

import javax.swing.JButton;

import ui.Janela;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CriarCenario cenario= new CriarCenario(9, 17);
		//cenario.imprimirGol();
		Janela j= new Janela("Botoes",cenario);
		
	}

}
