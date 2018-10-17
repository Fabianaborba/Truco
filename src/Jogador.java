import java.util.Arrays;

public class Jogador {
	public static final int TAMANHO_MAO = 3;
	private Carta[] mao;
	private int pontuacao;
	private int pontuacaoRodada;
	private int indiceMao;
	
	public Jogador() {
		mao = new Carta[TAMANHO_MAO];
		pontuacao = 0;
		indiceMao = 0;
	}

	public int getPontuacaoRodada() {
		return pontuacaoRodada;
	}
	
	public void incPontuacaoRodada() {
		pontuacaoRodada++;
	}
	
	public void zeraPontuacaoRodada() {
		pontuacaoRodada = 0;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Carta[] getMao() {
		return mao;
	}
	
	public void limpaMao() {
		Arrays.fill(mao, null);
		indiceMao = 0;
	}
	
	public void recebeCarta(Carta carta) {
		if (indiceMao < 3)
			mao[indiceMao++] = carta;
	}
	
	public Carta getCarta(int indice) {
		Carta descarte = mao[indice];
		mao[indice] = null;
		return descarte;
	}
	
	private int obtemCartaMaior() {
		int maior = -1;
		for (int i = 0; i < mao.length; i++) {
			Carta c = mao[i];
			if (c != null && c.getValor() > maior) {
				maior = c.getValor();
			}
		}
		return maior;
	}
	
	public Carta jogaCarta() {
		return getCarta(obtemCartaMaior());
	}
	
	@Override
	public String toString() {
		String retorno = "";
		for (int i = 0; i < mao.length; i++) {
			retorno += i + ": " + mao[i] + (i < mao.length - 1 ? " | " : "");
		}
		
		return retorno;
	}
	
}
