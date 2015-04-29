package EquaDiff;

import Function.*;
import Interfaces.IFunction;
import Interfaces.IMailleur;
import Interfaces.IResolveur;
import Mailleur.MailleurLagrange;
import Matrices.MatriceDF1;
import Matrices.MatriceVF1;
import Matrices.MatriceEchelonnee;
import Resolveur.ResolveurDF;

public class DirichletEquaDiff extends DefaultEquaDiff{
	
	IFunction u;

	public DirichletEquaDiff(){
		setA(new FunctionConstante(-1.0));
		setB(new FunctionConstante(0.0));
		setC(new FunctionConstante(0.0));
	}
	
	public DirichletEquaDiff(IMailleur mailleur){
		setA(new FunctionConstante(-1.0));
		setB(new FunctionConstante(0.0));
		setC(new FunctionConstante(0.0));
		setMailleur(mailleur);
	}
	
	@Override
	public IFunction resoudreAvecDF() {
		//IResolveur solve = new ResolveurDF(this);
		MatriceEchelonnee A =  new MatriceEchelonnee(new MatriceDF1(this));
		try {
			u = new Function(this.getMailleur(), A.remontee());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;		
	}
	
	@Override
	public IFunction resoudreAvecVF() {
		MatriceEchelonnee A =  new MatriceEchelonnee(new MatriceVF1(this));
		try {
			u = new Function(this.getMailleur(), A.remontee());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public void construireMatrice() {
		
	}
	
}
