package Interfaces;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface IMatrice {
	public int getNombreDeLignes();			
	public int getNombreDeColonnes();
	public double get(int i,int j) throws Exception;
	public void set(int i, int j, double x);
	
	public double trace() throws Exception;
	public double determinant();
	public IMatrice transpose();
	public IMatrice inverse();
	
	public IMatrice produit(IMatrice B);
	public double[] produitParVecteur(double x[]);
	public IMatrice somme(IMatrice B);
	public IMatrice produitParScalaire(double a);
	public void init(String file) throws FileNotFoundException;
	public void resolve(String file, String resolveType);
	public String toString();
	public void printMatrice();
}
