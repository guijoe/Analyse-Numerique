package Matrices;

import java.io.FileNotFoundException;

import Interfaces.IEquaDiff;

public class MatriceEquaDiff2ndDegre extends DefaultMatrice{

	private IEquaDiff equation; 
	
	public MatriceEquaDiff2ndDegre(IEquaDiff equadiff){
		setEquation(equadiff);
		setNombreDeLignes(equadiff.getN() - 1);
		setNombreDeColonnes(equadiff.getN());
	}
	
	public IEquaDiff getEquation() {
		return equation;
	}

	public void setEquation(IEquaDiff equation) {
		this.equation = equation;
	}
	
	@Override
	public double get(int i, int j) throws Exception {
		double unSurH = 1.0/equation.hi(i);
		double aSurH = equation.getA().f(equation.getElementi(i))* unSurH;
		double bSur2 = equation.getB().f(equation.getElementi(i))/2.0;
		double c = equation.getC().f(equation.getElementi(i));
		
		if(i == j-1 && j != getNombreDeColonnes() - 1){
			return unSurH * (aSurH + bSur2);
		}
		else if(i == j && j != getNombreDeColonnes() - 1){
			return -2 * aSurH*unSurH + c;
		}
		else if(i == j+1 && j != getNombreDeColonnes() - 1){
			return unSurH * (aSurH - bSur2);
		}
		/*
		else{
			return 0.0;
		}
		*/
		else if(j == getNombreDeColonnes() - 1){
			double fi = equation.getF().f(equation.getElementi(i)); 
			if(i==0){
				return  fi - (unSurH * (aSurH + bSur2)) * equation.getU0();
			}
			else if(i == getNombreDeLignes() - 1){
	
				return fi - (unSurH * (aSurH - bSur2)) * equation.getU1();
			}
			else{
				return fi; 
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
}
