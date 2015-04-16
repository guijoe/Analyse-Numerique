package DataProviders;

import java.io.IOException;
import java.util.ArrayList;

public class CCSFileProvider extends FileProvider {

	public CCSFileProvider(String file, Seperator sep) {
		super(file);
	}
	
	public void lireMatrice(){
		tab = new ArrayList<ArrayList<Double>>();
		
		
		String elements[];
		String line;
		
		
		try {
			while ((line = super.br.readLine()) != null) {	
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
