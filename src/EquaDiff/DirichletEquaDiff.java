package EquaDiff;

import Function.FunctionConstante;
import Interfaces.IFunction;
import Interfaces.IMailleur;
import Interfaces.IResolveur;
import Mailleur.MailleurLagrange;
import Resolveur.ResolveurDifferencesFinies;

public class DirichletEquaDiff extends DefaultEquaDiff{

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
	public IFunction resoudre() {
		IResolveur solve = new ResolveurDifferencesFinies(this);
		return null;		
	}

	@Override
	public void construireMatrice() {
		
	}
	
}
