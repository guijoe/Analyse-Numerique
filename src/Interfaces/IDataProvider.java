package Interfaces;

import java.util.ArrayList;

public interface IDataProvider {
	
	public enum Seperator{
		WHITESPACE,
		COMMA,
		COLUMN, 
		TABULATION
	}
	
	public void lireMatrice();

	public ArrayList<ArrayList<Double>> getTab();
}
