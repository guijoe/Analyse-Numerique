package Resolveur;

import Interfaces.IEquaDiff;
import Matrices.MatriceEquaDiff2ndDegre;
import Matrices.MatriceEquaDiff2ndDegreEchelonnee;

public class ResolveurDifferencesFinies extends DefaultResolveur{
	
	public ResolveurDifferencesFinies(IEquaDiff equation) {
		super(equation);
		MatriceEquaDiff2ndDegreEchelonnee A =  new MatriceEquaDiff2ndDegreEchelonnee(new MatriceEquaDiff2ndDegre(equation));
		try {
			//System.out.println("je suis dans le try");
			A.remontee();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
