package Matrices;
import java.io.FileNotFoundException;
import DataProviders.*;
import Interfaces.*;
import Interfaces.IDataProvider.Seperator;
import DataResolvers.*;



public class MatriceCRS extends DefaultMatrice {
	private double val[];
	private int[] col_ind;
	private int row_ptr[];
	private int nonzeros = 0;
	

	public int getNonzeros() {
		return nonzeros;
	}

	public void setNonzeros(int nonzeros) {
		this.nonzeros = nonzeros;
	}
	
	public MatriceCRS(){
		
	}
	
	public MatriceCRS(int n, int m, int z){
		setNombreDeLignes(n);
		setNombreDeColonnes(m);
		setNonzeros(z);
	}
	
	public double get(int i, int j){
		i--;j--;
		if(row_ptr[i+1]-row_ptr[i]==0) return 0;
		else{
			int k=row_ptr[i];
			while(k!=row_ptr[i] && k < row_ptr[i]) k++;
			if(k==row_ptr[i+1]) return 0;
			else return val[k];
		}
	}
	
	public double[] productParVecteur(double[] x){
		double[] y=null;
		for(int i=0;i<=val.length;i++){
			for(int j=row_ptr[i];j<row_ptr[i+1]-1;j++){
				y[col_ind[j]]+=val[j]*x[i];
			}
		}
		return y;
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
		
		row_ptr = new int[getNombreDeLignes() + 1];
		row_ptr[0] = 0;
		
		for(int i=0; i < getNombreDeLignes(); ++i){
			int j=0;
			
			while(j < getNombreDeColonnes()){
				double valeur = dp.getTab().get(i).get(j);
				if(valeur != 0.0){
					nonzeros++;
				}
				j++;
			}
			row_ptr[i+1]= nonzeros;
		}
		
		val = new double[nonzeros];
		col_ind = new int[nonzeros];
		int k=0;
		for(int i=0; i < getNombreDeLignes(); ++i){
			int j=0;
			
			while(j < getNombreDeColonnes()){
				double valeur = dp.getTab().get(i).get(j);
				if(valeur != 0.0){
					val[k] = valeur;
					col_ind[k] = j;
					k++;
				}
				j++;
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
			matrice += col_ind[i] + " ";
		}
		matrice += "\n";
		for(int i=0; i<row_ptr.length; ++i){
			matrice += row_ptr[i] + " ";
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
		System.out.print("col_ind : ");
		for(int i=0; i<nonzeros; ++i){
			System.out.print(col_ind[i] + " ");
		}
		System.out.println();
		System.out.print("row_ptr : ");
		for(int i=0; i<row_ptr.length; ++i){
			System.out.print(row_ptr[i] + " ");
		}
	}

	@Override
	public void resolve(String file, String resolveType) {
		// TODO Auto-generated method stub
		
	}
}
