package Matrices;

import Interfaces.*;
import DataProviders.*; 


public abstract class DefaultMatrice implements IMatrice {
	
	private int nombreDeLignes;
	private int nombreDeColonnes;
	
	public int getNombreDeLignes() {
		return nombreDeLignes;
	}

	public void setNombreDeLignes(int nombreDeLignes) {
		this.nombreDeLignes = nombreDeLignes;
	}

	public int getNombreDeColonnes() {
		return nombreDeColonnes;
	}

	public void setNombreDeColonnes(int nombreDeColonnes) {
		this.nombreDeColonnes = nombreDeColonnes;
	}
	
	@Override
	public double get(int i, int j) throws Exception {
		throw new Exception("Méthode pas encore implémentée !");
	}

	@Override
	public void set(int i, int j, double x) {
		// TODO Auto-generated method stub

	}

	@Override
	public double trace() throws Exception {
		// TODO Auto-generated method stub
		if(getNombreDeColonnes() != getNombreDeLignes()){
			throw new Exception("L'opération 'trace' n'est pas définie pour cette matrice");
		}
		double trace = 0.0;
		for(int i=0; i<getNombreDeColonnes(); ++i){
			trace += get(i,i);
		}
		return trace;
	}

	@Override
	public double determinant() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IMatrice transpose() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMatrice inverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMatrice produit(IMatrice B) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMatrice somme(IMatrice B) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMatrice produitParScalaire(double a) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public double[] produitParVecteur(double x[]){
		return x;
	}
	
	public void resolve(String file, String resolveType){
		
	}
}
