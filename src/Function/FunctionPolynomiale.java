package Function;

import java.util.ArrayList;
import java.util.regex.*;

public class FunctionPolynomiale extends DefaultFunction{
	
	ArrayList<Float> coefs = new ArrayList<Float>();
	ArrayList<Integer> degres = new ArrayList<Integer>();
	
	public FunctionPolynomiale(String pol){
		String input = "2x^3-3x^-2+2x^1+1x^0";
		Pattern p = Pattern.compile( "(-?\\b\\d+)[xX]\\^(-?\\d+\\b)" );
		Matcher m = p.matcher( pol );
		while (m.find()) {
			coefs.add((Float.parseFloat(m.group(1))));
			degres.add(Integer.parseInt(m.group(2)));
			
		}
	}
	
	public double f(double x){
		double val = 0.0;
		
		for(int i=0; i<coefs.size(); ++i){
			double ai = coefs.get(i);
			double pi = degres.get(i);
			
			double puisX = 1.0;
			
			if(ai != 0.0){
				if(pi == 0){
					val += ai;
				}
				else{
					for(int j=0; j<pi; j++){
						puisX *= x;
						//System.out.println(puisX);
					}
					val += ai * puisX;
				}
			}
			
			/*
			if(degres.get(i) == 0){
				System.out.println("égal à zero");
				val += coefs.get(i);
			}
			else if(coefs.get(i) == 0){
				
			}
			else{
				val += coefs.get(i) * Math.pow(x, (double) degres.get(i));
			}
			*/
		}
		
		return val;
	}
}
