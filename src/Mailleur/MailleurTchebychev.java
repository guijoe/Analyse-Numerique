package Mailleur;

public class MailleurTchebychev extends DefaultMailleur {

	public MailleurTchebychev(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double[] retournerMaille(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getElementi(int i) {
		// TODO Auto-generated method stub
		return Math.cos(((2*i-1)*Math.PI)/(2*i));
	}
}
