package Mailleur;

public abstract class DefaultMailleur implements Interfaces.IMailleur{
	protected int n;
	public DefaultMailleur(int n){
		setN(n);
	}
	
	public double hi(int i){
		return getElementi(i+1) - getElementi(i);
	}
	
	public void setN(int n){
		this.n = n;
	}
	
	public int getN(){
		return this.n;
	}
}
