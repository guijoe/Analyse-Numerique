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
		return valeurs[xBelongsToMeshI(x)];
	}
	
	public int xBelongsToMeshI(double x){
		int i=0;
		while(i < mailleur.getN() && x > mailleur.getElementi(i)){
			++i;
		}
		return i;
	}
}
