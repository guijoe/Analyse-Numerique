package Test;

import EquaDiff.DirichletEquaDiff;
import Function.FunctionConstante;
import Interfaces.IMailleur;
import Mailleur.MailleurLagrange;
import Matrices.MatriceEquaDiff2ndDegre;
import Matrices.MatriceEquaDiff2ndDegreEchelonnee;
import Matrices.MatriceEquaDiff2ndEchelonneeMod;

public class TestEquation {
	public static void main(String args[]){
		
		DirichletEquaDiff e = new DirichletEquaDiff();
		/*
		e.setA(new FunctionConstante(-1.0));
		e.setB(new FunctionConstante(0.0));
		e.setC(new FunctionConstante(0.0));
		*/
		e.setF(new FunctionConstante(0.0));
		IMailleur mailleur = new MailleurLagrange(10);
		
		/*
		for(int i=0; i<=10; i++){
			System.out.println(mailleur.getElementi(i));
		}
		*/
		
		e.setMailleur(mailleur);
		e.setU0(0.0);
		e.setU1(1.0);
		
		e.resoudre();
		
		//System.out.println("hello");
		MatriceEquaDiff2ndDegre mat = new MatriceEquaDiff2ndDegre(e);
		MatriceEquaDiff2ndDegreEchelonnee mat1 = new MatriceEquaDiff2ndDegreEchelonnee(mat);
		//MatriceEquaDiff2ndEchelonneeMod mat1 = new MatriceEquaDiff2ndEchelonneeMod(mat);
		mat1.printMatrice();
	}
}
