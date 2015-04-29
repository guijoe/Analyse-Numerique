package Resolveur;

import Interfaces.IEquaDiff;
import Matrices.MatriceDF1;
import Matrices.MatriceDF1Echelonnee;


public class ResolveurDF extends DefaultResolveur{
	
	public ResolveurDF(IEquaDiff equation) {
		super(equation);
		MatriceDF1Echelonnee A =  new MatriceDF1Echelonnee(new MatriceDF1(equation));
		try {
			A.remontee();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
