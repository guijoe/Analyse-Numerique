package Mailleur;

public class MailleurLagrange extends DefaultMailleur{

	public MailleurLagrange(int n) {
		super(n);
	}

	@Override
	public double[] retournerMaille(int n) {
		return null;
	}

	@Override
	public double getElementi(int i) {
		return (double) i/n;
	}
	
	public double h(){
		return 1.0/n;
	}
}
