package Mailleur;

public class MailleurGeneral extends DefaultMailleur{
	
	private double[] points;
	public MailleurGeneral(int n) {
		super(n);
		points = new double[n];
		
	}

	@Override
	public double[] retournerMaille(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getElementi(int i) {
		return points[i];
	}

}
