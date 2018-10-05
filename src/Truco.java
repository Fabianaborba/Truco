
public class Truco {
	private Jogador jogador1;
	private Jogador jogador2;
	private Baralho baralho;
	private Carta cartaVirada;
	
	public Truco() {
		jogador1 = new Jogador();
		jogador2 = new Jogador();
		baralho = new Baralho();
		cartaVirada = null;
	}
	
	public void embaralhaCartas() {
		baralho.embaralha();
	}
	
	public void distribuiMaos() {
		for (int contador = 0; contador < Jogador.TAMANHO_MAO; contador++) {
			jogador1.recebeCarta(baralho.distribuiCarta());
			jogador2.recebeCarta(baralho.distribuiCarta());
		}
	}
	
	public void setCartaVirada(Carta carta) {
		cartaVirada = carta;
	}
	
	private void inicializaManilha() {
		setCartaVirada(baralho.distribuiCarta());
	}
	
	public void jogar() {
		embaralhaCartas();
		distribuiMaos();
		inicializaManilha();
		
		imprimeMesa();
	}
	
	private void imprimeMesa() {
		System.out.println(jogador1);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(cartaVirada);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(jogador2);
		
	}
	
	
}
