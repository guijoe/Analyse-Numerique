package Matrices;

import java.io.FileNotFoundException;
import DataProviders.*;
import Interfaces.*;
import Interfaces.IDataProvider.Seperator;
import DataResolvers.*;

public class MatriceDense extends DefaultMatrice {
	private double[][] tab;

	public MatriceDense(){
		
	}
	
	@Override
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
		
		tab = new double[getNombreDeLignes()][getNombreDeColonnes()];
		
		for(int i=0; i < getNombreDeLignes(); ++i){
			for(int j=0; j <getNombreDeColonnes(); j++){
				tab[i][j] = dp.getTab().get(i).get(j);
			}
		}
	}
	
	@Override
	public double get(int i, int j) throws Exception {
		return this.tab[i][j];
	}

	@Override
	public String toString() {
		String matrice = "";
		
		for(int i = 0; i < getNombreDeLignes(); ++i){
			for(int j = 0; j < getNombreDeColonnes(); ++j){
				matrice += tab[i][j] + " ";
			}
			matrice += "\n";
		}
		
		return matrice;
	}
	
	@Override
	public void resolve(String file, String resolveType) {

	}

	@Override
	public void printMatrice() {
		for(int i=0; i < getNombreDeLignes(); ++i){
			for(int j=0; j <getNombreDeColonnes(); j++){
				System.out.print(tab[i][j] + " ");
			}
			System.out.println();
		}

	}

}
