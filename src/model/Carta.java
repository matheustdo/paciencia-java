package model;

public class Carta {
	private Naipe naipe;
	private Numeracao numeracao;
	private Lado lado;
	
	public Carta(Naipe naipe, Numeracao valor) {
		this.naipe = naipe;
		this.numeracao = valor;
		this.lado = Lado.BAIXO;
	}

	public Naipe getNaipe() {
		return naipe;
	}

	public void setNaipe(Naipe naipe) {
		this.naipe = naipe;
	}

	public Numeracao getNumeracao() {
		return numeracao;
	}

	public void setNumeracao(Numeracao valor) {
		this.numeracao = valor;
	}

	public Lado getLado() {
		return this.lado;
	}
	
	public void mostrar() {
		this.lado = Lado.CIMA;
	}
	
	@Override
	public String toString() {
		if (this.lado == Lado.BAIXO) return "[< >]";
		
		/* Para formatar a string da carta, se o valor dela tiver apenas 1 caractere, um espaço
		 * é inserido para que o conteúdo da carta possua 3 caracteres, exemplo: [5 ♥] */
		if (numeracao.toString().length() == 1) {
			return ("[" + numeracao.toString() + " " + naipe.toString() + "]");
		}

		/* Se a carta possuir dois caracteres, ela ficará como: [10♥] */
		return ("[" + numeracao.toString() + naipe.toString() + "]");
	}
}
