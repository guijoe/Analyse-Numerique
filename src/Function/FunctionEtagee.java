package Function;

import Interfaces.IMailleur;

public class FunctionEtagee extends DefaultFunction{

	private IMailleur mailleur;
	double[] valeurs;
	
	public FunctionEtagee(IMailleur m, double[] val){
		setMailleur(m);
		setValeurs(val);
	}
	
	public IMailleur getMailleur() {
		return mailleur;
	}

	public void setMailleur(IMailleur mailleur) {
		this.mailleur = mailleur;
	}

	public double[] getValeurs() {
		return valeurs;
	}

	public void setValeurs(double[] valeurs) {
		this.valeurs = valeurs;
	}

	@Override
	public double f(double x) throws Exception {
		
		return 0;
	}

}
