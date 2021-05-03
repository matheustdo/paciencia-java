package model;

/**
* Esta classe representa uma Carta de baralho.
*/
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
	
	public void esconder() {
		this.lado = Lado.BAIXO;
	}
	
	@Override
	public String toString() {
		if (this.lado == Lado.BAIXO) return "[< >]";
		
		String bordaInicio = "[";
		String bordaFim = "]";
		
		if (naipe.getCor() == "Preto") {
			bordaInicio = "(";
			bordaFim = ")";
		}
		
		/* Para formatar a string da carta, se o valor dela tiver apenas 1 caractere, um espaço
		 * é inserido para que o conteúdo da carta possua 3 caracteres, exemplo: [5 ♥] */
		if (numeracao.toString().length() == 1) {
			return (bordaInicio + numeracao.toString() + " " + naipe.toString() + bordaFim);
		}

		/* Se a carta possuir dois caracteres, ela ficará como: [10 ♥] */
		return (bordaInicio + numeracao.toString() + naipe.toString() + bordaFim);
	}
}
