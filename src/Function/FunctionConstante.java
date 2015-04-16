package Function;

public class FunctionConstante extends DefaultFunction{
	
	private double valeur;
	
	public FunctionConstante(double value){
		setValeur(value);
	}
	
	public double f(double x) throws Exception {
		return valeur;
	}
	
	public double f(){
		return valeur;
	}
	
	public double getValeur() {
		return valeur;
	}

	public void setValeur(double value) {
		this.valeur = value;
	}
	
}
