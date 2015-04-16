package Matrices;

import java.io.FileNotFoundException;
import DataProviders.*;
import Interfaces.*;
import Interfaces.IDataProvider.Seperator;
import DataResolvers.*;


public class MatriceCCS extends DefaultMatrice {
	private double val[];
	private int[] row_ind;
	private int col_ptr[];
	private int nonzeros = 0;
	

	public int getNonzeros() {
		return nonzeros;
	}

	public void setNonzeros(int nonzeros) {
		this.nonzeros = nonzeros;
	}

	public MatriceCCS(){
		
	}
	
	public MatriceCCS(int n, int m, int z){
		setNombreDeLignes(n);
		setNombreDeColonnes(m);
		setNonzeros(z);
	}
	
	public void init(String file) throws FileNotFoundException {
		
		IDataProvider dp = null;
		
		if(file.substring(file.lastIndexOf(".") + 1).equals("tab")){
			dp = new TabFileProvider(file, Seperator.WHITESPACE);
		}
		if(file.substring(file.lastIndexOf(".") + 1).equals("coord")){
			dp = new CoordFileProvider(file, Seperator.WHITESPACE);
		}
		if(file.substring(file.lastIndexOf(".") + 1).equals("crs")){
			dp = new CRSFileProvider(file, Seperator.WHITESPACE);
		}
		if(file.substring(file.lastIndexOf(".") + 1).equals("ccs")){
			dp = new CCSFileProvider(file, Seperator.WHITESPACE);
		}
		if(file.substring(file.lastIndexOf(".") + 1).equals("cds")){
			dp = new CDSFileProvider(file, Seperator.WHITESPACE);
		}
		
		setNombreDeLignes(dp.getTab().size());
		setNombreDeColonnes(dp.getTab().get(0).size());
		
		col_ptr = new int[getNombreDeColonnes() + 1];
		col_ptr[0] = 0;
		
		for(int j=0; j < getNombreDeColonnes(); ++j){
			int i=0;
			
			while(i < getNombreDeLignes()){
				double valeur = dp.getTab().get(i).get(j);
				if(valeur != 0.0){
					nonzeros++;
				}
				i++;
			}
			col_ptr[j+1]= nonzeros;
		}
		
		val = new double[nonzeros];
		row_ind = new int[nonzeros];
		int k=0;
		for(int j=0; j < getNombreDeColonnes(); ++j){
			int i=0;
			
			while(i < getNombreDeLignes()){
				double valeur = dp.getTab().get(i).get(j);
				if(valeur != 0.0){
					val[k] = valeur;
					row_ind[k] = i;
					k++;
				}
				i++;
			}
		}	
	}

	public String toString(){
		String matrice = "";
		for(int i=0; i<nonzeros; ++i){
			matrice += val[i] + " ";
		}
		matrice += "\n";
		for(int i=0; i<nonzeros; ++i){
			matrice += row_ind[i] + " ";
		}
		matrice += "\n";
		for(int i=0; i<col_ptr.length; ++i){
			matrice += col_ptr[i] + " ";
		}
		return matrice;
	}
	
	public void printMatrice(){
		System.out.println("nonzeros : " + nonzeros);
		System.out.print("val     : ");
		for(int i=0; i<nonzeros; ++i){
			System.out.print(val[i] + " ");
		}
		System.out.println();
		System.out.print("row_ind : ");
		for(int i=0; i<nonzeros; ++i){
			System.out.print(row_ind[i] + " ");
		}
		System.out.println();
		System.out.print("col_ptr : ");
		for(int i=0; i<col_ptr.length; ++i){
			System.out.print(col_ptr[i] + " ");
		}
	}

	@Override
	public void resolve(String file, String resolveType) {
		// TODO Auto-generated method stub
		
	}

}
