package Matrices;

import java.io.FileNotFoundException;

import Interfaces.IEquaDiff;

public class MatriceVF1 extends DefaultMatrice{
	private IEquaDiff equation; 
	
	public MatriceVF1(IEquaDiff equadiff){
		setEquation(equadiff);
		setNombreDeLignes(equadiff.getN() - 1);
		setNombreDeColonnes(equadiff.getN());
	}
	
	@Override
	public double get(int i, int j) throws Exception {
		double unSurH = 1.0/equation.hi(i);
		double unSurHPlus1 = 1.0/equation.hi(i+1);
		//double bSur2 = equation.getB().f(equation.getElementi(i))/2.0;
		//double c = equation.getC().f(equation.getElementi(i));
		
		if(i == j-1 && j != getNombreDeColonnes() - 1){
			return -unSurH;
		}
		else if(i == j && j != getNombreDeColonnes() - 1){
			return unSurH + unSurHPlus1;
		}
		else if(i == j+1 && j != getNombreDeColonnes() - 1){
			return -unSurHPlus1;
		}
		
		else if(j == getNombreDeColonnes() - 1){
			double fi = equation.getF().f(equation.getElementi(i+1)); 
			if(i==0){
				return  fi * equation.hi(i) + unSurH * equation.getU0();
			}
			else if(i == getNombreDeLignes() - 1){
	
				return fi * equation.hi(i) + unSurHPlus1 * equation.getU1();
			}
			else{
				return fi * equation.hi(i); 
			}
		}
		else{
			return 0.0;
		}
	}

	@Override
	public void init(String file) throws FileNotFoundException {
		
	}

	@Override
	public void printMatrice() {
		for(int i=0; i < getNombreDeLignes(); ++i){
			for(int j=0; j <getNombreDeColonnes(); j++){
				try {
					System.out.print(get(i, j) + " ");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println();
		}
	}
	
	public void setEquation(IEquaDiff equation) {
		this.equation = equation;
	}
	
	public IEquaDiff getEquation() {
		return equation;
	}
}
