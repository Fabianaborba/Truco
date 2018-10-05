// representa uma carta do baralho
public class Carta {
	private final String face; // face da carta ("As", "Dois", "Três"...)
	private final String naipe; //  naipe da carta ("Ouros", "Copas" ...)
	private int valor; // valor da carta - no caso do truco pode mudar, de acordo com a carta virada
	
	// construtor de dois argumentos, inicializa face e naipe
	public Carta(String face, String naipe, int valor) {
		this.face = face;
		this.naipe = naipe;
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getFace() {
		return face;
	}

	public String getNaipe() {
		return naipe;
	}

	// retorna a representação em string
	@Override
	public String toString() {
		return face + " de " + naipe;
	}
	
} // fim da classe Carta
