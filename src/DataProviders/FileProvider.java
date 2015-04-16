package DataProviders;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileProvider extends DefaultDataProvider {
	
	protected InputStream inputStream = null;
	protected BufferedReader br = null;
	protected Seperator seperator;
	
	public FileProvider(String file){
		
		super();
		
		try {
			inputStream = new FileInputStream(file);
			br = new BufferedReader(new InputStreamReader(inputStream));
			
			 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	protected String StringFromSeperator(Seperator sep){
		String strsep = "";
		switch(sep){
			case WHITESPACE : strsep = " "; break;
			case COMMA : strsep = ","; break;
			case COLUMN : strsep = ":"; break;
			case TABULATION : strsep = "\t"; break;
		}
		return strsep;
	}
	
	public void lireMatrice(){
		tab = new ArrayList<ArrayList<Double>>();
		
		String elements[];
		String line;
		
		try {
			while ((line = br.readLine()) != null) {	
				elements = line.split(StringFromSeperator(this.seperator));
				ArrayList<Double> tmp = new ArrayList<Double>();
				for(int j=0; j<elements.length; ++j){
					tmp.add(Double.parseDouble(elements[j]));
				}
				tab.add(tmp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
