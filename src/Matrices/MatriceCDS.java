package Matrices;

import java.io.FileNotFoundException;
import DataProviders.*;
import Interfaces.*;
import Interfaces.IDataProvider.Seperator;
import DataResolvers.*;

public class MatriceCDS extends DefaultMatrice {
	
	private int rows[];
	private double elements[][];
	
	public MatriceCDS(int n){
		rows = new int[n];
		elements = new double[rows.length][getNombreDeColonnes()];
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
		//Algorithm a = new Algorithm();
		setNombreDeLignes(dp.getTab().size());
		setNombreDeColonnes(dp.getTab().get(0).size());
		
		
			
		
	}

	@Override
	public void resolve(String file, String resolveType) {
		

	}

	@Override
	public void printMatrice() {
		

	}

}
