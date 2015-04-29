package Test;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Function.FunctionPolynomiale;

public class TestFunction {
	public static void main(String args[]){
		/*
		String input = "2x^3-3x^-2+2x^1+1x^0";
		Pattern p = Pattern.compile( "(-?\\b\\d+)[xX]\\^(-?\\d+\\b)" );
		Matcher m = p.matcher( input );
		while (m.find()) {
		    System.out.println("Coef: " + m.group(1));
		    System.out.println("Degree: " + m.group(2));
		}
		*/
		FunctionPolynomiale p = new FunctionPolynomiale("-12x^2");
		System.out.println(p.f(0));
		System.out.println(p.f(0.0) + " " + p.f(0.2) + " " + " " + p.f(0.4) + " " + p.f(0.6) + 
						   " " + p.f(0.8) + " " + p.f(1));
		//System.out.printf(Locale.ENGLISH, "%1.2f", 0.2*6.0);
	}
}
