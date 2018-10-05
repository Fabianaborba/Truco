import java.util.Arrays;

public class Jogador {
	public static final int TAMANHO_MAO = 3;
	private Carta[] mao;
	private int pontuacao;
	private int indiceMao;
	
	public Jogador() {
		mao = new Carta[TAMANHO_MAO];
		pontuacao = 0;
		indiceMao = 0;
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
	
	@Override
	public String toString() {
		String retorno = "";
		for (int i = 0; i < mao.length; i++) {
			retorno += i + ": " + mao[i] + (i < mao.length - 1 ? " | " : "");
		}
		
		return retorno;
	}
	
}
