package Matrices;

import java.io.FileNotFoundException;

import Interfaces.IEquaDiff;

public class MatriceEquaDiff2ndEchelonneeMod extends DefaultMatrice{
	
	MatriceEquaDiff2ndDegre mat;

	public MatriceEquaDiff2ndEchelonneeMod(MatriceEquaDiff2ndDegre mat){
		
		this.mat = mat;
		//System.out.println(mat.getEquation().getN());
		setNombreDeLignes(mat.getEquation().getN() - 1);
		setNombreDeColonnes(mat.getEquation().getN());
	}
	
	public double get(int i, int j) throws Exception {
		double unSurH = 1.0/mat.getEquation().hi(i);
	  	double aSurH = mat.getEquation().getA().f(mat.getEquation().getElementi(i))* unSurH;
		double bSur2 = mat.getEquation().getB().f(mat.getEquation().getElementi(i))/2.0;
		
		
		if(i == j-1 && j != getNombreDeColonnes() - 1){
			if(i == 0)
				 return mat.get(i, j);
			else{
				// On retourne a(i-1) * Li
				return mat.get(i, j) * mat.get(i-1, j-2);
			} 
		}
		
		else if(i == j && j != getNombreDeColonnes() - 1 ){
			if(i == 0)
				return mat.get(i, j);
			else{
				// On retourne a(i-1) * Li - ai * L(i-1)
				return mat.get(i, j) * mat.get(i-1, j-1) - mat.get(i-1, j) * mat.get(i, j-1);
			}
		}
		
		else if(i == j+1 && j != getNombreDeColonnes() - 1){
			return 0.0;
		}
		
		else if(j == getNombreDeColonnes() - 1){
			double fi = mat.getEquation().getF().f(mat.getEquation().getElementi(i)); 
			if(i==0){
				return  fi + (unSurH * (aSurH + bSur2)) * mat.getEquation().getU0();
			}
			else if(i == getNombreDeLignes() - 1){
				fi = fi + (unSurH * (aSurH - bSur2)) * mat.getEquation().getU1();
				return fi * mat.get(i-1, i-2) - get(i, j-1) * mat.get(i, i-1);
			}
			else{
				return fi * mat.get(i-1, i-2) - get(i, j-1) * mat.get(i, i-1);
			}
		}
		else{
			return 0.0;
		}
	}
	
	public void remontee() throws Exception{
		
		double ui = get(getNombreDeLignes() - 1, getNombreDeColonnes()-1)/get(getNombreDeLignes() - 1, getNombreDeColonnes()-2);
		//System.out.println(getNombreDeLignes());
		for(int i=getNombreDeLignes() - 1; i>=0; --i){
			
			System.out.println( i+1 + " : " + ui);
			
			double fi = get(i, getNombreDeColonnes() - 1);
			double ai = get(i, i);
			double bi = get(i, i+1);
			ui = (1/ai)*(fi - bi*ui);
			
			//System.out.println(fi);
			//System.out.println(ai);
			//System.out.println(bi);
		}
	}
	
	@Override
	public void init(String file) throws FileNotFoundException {
		
	}

	@Override
	public void printMatrice() {
		// TODO Auto-generated method stub
		//System.out.println(getNombreDeLignes() + " " + getNombreDeColonnes());
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

