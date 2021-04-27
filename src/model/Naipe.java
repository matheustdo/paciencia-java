package model;

public enum Naipe {
	ESPADAS("♠"),
	COPAS("♥"), 
	PAUS("♣"), 
	OUROS("♦");
	
	private String simbolo;
	
    private Naipe(String simbolo) {
    	this.simbolo = simbolo;
    }
    
    @Override
    public String toString() {
    	return simbolo;
    }
}
