package Function;

import Interfaces.IMailleur;

public class Function extends DefaultFunction{
	IMailleur mailleur;
	double[] valeurs;
	
	public Function(IMailleur m, double[] img){
		mailleur = m;
		valeurs = img;
	}

	@Override
	public double f(double x) throws Exception {
		return valeurs[xBelongsToMeshI(x)];
	}
	
	public int xBelongsToMeshI(double x){
		int i=0;
		while(i < mailleur.getN() && x != mailleur.getElementi(i)){
			++i;
		}
		return i;
	}
}
