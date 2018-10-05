import java.security.SecureRandom;

// classe que representa um baralho
public class Baralho {
	private Carta[] baralho;
	private int cartaAtual;
	private static final int NUMERO_DE_CARTAS = 40;
	private final SecureRandom numeroAleatorio;
	
	public Baralho() {	
		numeroAleatorio = new SecureRandom();
		
		String[] faces = { "Quatro", "Cinco", "Seis",
				"Sete", "Dama", "Valete", "Rei", "Ás", "Dois", "Três" };
		
		String[] naipes = { "Ouros", "Espadas", "Copas", "Paus" };
		
		baralho = new Carta[NUMERO_DE_CARTAS]; // cria vetor de cartas
		cartaAtual = 0; // a primeira carta será o primeiro índice de baralho baralho[0]
		
		// preenche o vetor com objetos de carta
		for (int contador = 0; contador < baralho.length; contador++) {
			baralho[contador] = new Carta(faces[contador % 10], naipes[contador / 10], contador % 10);
		}		
	}
	
	public void embaralha() {
		// zeramos o ponteiro de carta
		cartaAtual = 0;
		
		// para cada Carta, seleciona outra Carta aleatória (0-51) e as troca 
		for (int primeiro = 0; primeiro < baralho.length; primeiro++) {
			// seleciona um número aleatório entre 0 e 51
			int segundo = numeroAleatorio.nextInt(NUMERO_DE_CARTAS);
			
			// troca a Carta atual com a Carta escolhida aleatoriamente
			Carta temp = baralho[primeiro];
			baralho[primeiro] = baralho[segundo];
			baralho[segundo] = temp;
		}
	}
	
	public Carta distribuiCarta() {
		// determina se ainda há cartas
		if (cartaAtual < baralho.length)
			return baralho[cartaAtual++];
		else
			return null;
	}
} // fim de Baralho
