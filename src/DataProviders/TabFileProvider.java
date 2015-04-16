package DataProviders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import Interfaces.IMatrice;

public class TabFileProvider extends FileProvider{
	
	String file;
	
	public TabFileProvider(String file, Seperator sep) throws FileNotFoundException {
		super(file);
		this.seperator = sep;
		this.lireMatrice();
	}
	
	public void lireMatrice(){
		tab = new ArrayList<ArrayList<Double>>();
		StringBuilder sb = new StringBuilder();
		
		String elements[];
		String line;
		int i=0;
		
		try {
			while ((line = super.br.readLine()) != null) {	
				elements = line.split(StringFromSeperator(this.seperator));
				ArrayList<Double> tmp = new ArrayList<Double>();
				for(int j=0; j<elements.length; ++j){
					tmp.add(Double.parseDouble(elements[j]));
				}
				tab.add(tmp);
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (super.inputStream != null) {
				try {
					super.inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (super.br != null) {
				try {
					super.br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
