package model;

public enum Numeracao {
	AS("A", 1),
	DOIS("2", 2),
	TRES("3", 3),
	QUATRO("4", 4),
	CINCO("5", 5),
	SEIS("6", 6),
	SETE("7", 7),
	OITO("8", 8),
	NOVE("9", 9),
	DEZ("10", 10),
	VALETE("J", 11),
	DAMA("Q", 12),
	REI("K", 13);
	
	private String simbolo;
	private int valor;
	
    private Numeracao(String simbolo, int valor) {
    	this.simbolo = simbolo;
    	this.valor = valor;
    }

    public int getValor() {
		return valor;
	}


	@Override
    public String toString() {
    	return this.simbolo;
    }
}
