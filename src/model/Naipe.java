package model;

public enum Naipe {
	ESPADAS("E", "Preto"), // ♠
	COPAS("C", "Vermelho"),  // ♥
	PAUS("P", "Preto"), // ♣
	OUROS("O", "Vermelho"); //♦
	
	private String simbolo;
	private String cor;
	
    private Naipe(String simbolo, String cor) {
    	this.simbolo = simbolo;
    	this.cor = cor;
    }
    
    public String getCor() {
		return cor;
	}

	@Override
    public String toString() {
    	return this.simbolo;
    }
}
