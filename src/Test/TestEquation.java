package Test;

import EquaDiff.DirichletEquaDiff;
import Function.FunctionConstante;
import Function.FunctionEtagee;
import Function.FunctionPolynomiale;
import Interfaces.IMailleur;
import Mailleur.MailleurLagrange;
import Matrices.MatriceDF1;
import Matrices.MatriceEchelonnee;
import Matrices.MatriceVF1;

public class TestEquation {
	public static void main(String args[]){
		
		DirichletEquaDiff e = new DirichletEquaDiff();
		
		
		IMailleur mailleur = new MailleurLagrange(32);
		//e.setF(new FunctionConstante(-2.0));
		/*
		double val[] = {-1.2, -2.4, -3.6, -4.8}; 
		e.setF(new FunctionEtagee(mailleur, val));
		//*/
		//*
		e.setF(new FunctionPolynomiale("-12x^2"));
		//*/
		
		e.setMailleur(mailleur);
		e.setU0(0.0);
		e.setU1(1.0);
		System.out.println("Différences finies");
		e.resoudreAvecDF();
		System.out.println("\nVolumes finies");
		e.resoudreAvecVF();
		
		MatriceDF1 matDF = new MatriceDF1(e);
		MatriceVF1 matVF = new MatriceVF1(e);
		MatriceEchelonnee mat1 = new MatriceEchelonnee(matVF);
		/*
		System.out.println("\nDifférences finies");
		matDF.printMatrice();
		System.out.println("\nVolumes finies");
		matVF.printMatrice();
		*/
	}
}
