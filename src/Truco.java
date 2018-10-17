import java.util.concurrent.TimeUnit;

public class Truco {
	private Jogador jogador1;
	private Jogador jogador2;
	private Baralho baralho;
	private Carta cartaVirada;
	private Carta c1; // carta do jogador1
	private Carta c2; // carta do jogador2
	private EstadoJogo estado;
	
	private enum EstadoJogo { INICIO, CONTINUA, FINALIZADO }
	
	public Truco() {
		jogador1 = new Jogador();
		jogador2 = new Jogador();
		baralho = new Baralho();
		cartaVirada = null;
		estado = EstadoJogo.INICIO;
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
		while (estado != EstadoJogo.FINALIZADO) {
			embaralhaCartas();
			distribuiMaos();
			inicializaManilha();
			
			imprimeMesa();
			
			c1 = jogador1.jogaCarta();
			imprimeMesa();
			c2 = jogador2.jogaCarta();
			imprimeMesa();
			
			if (c1.getValor() > c2.getValor())
				jogador1.incPontuacaoRodada();
			else if (c2.getValor() > c1.getValor())
				jogador2.incPontuacaoRodada();
			
		}
		

		
	}
	
	private void imprimeMesa() {
		System.out.println(jogador1);
		System.out.println();
		System.out.println();
		System.out.println(c1);
		System.out.println();
		System.out.println();
		System.out.println(cartaVirada);
		System.out.println();
		System.out.println();
		System.out.println(c2);
		System.out.println();
		System.out.println();
		System.out.println(jogador2);
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	
}
