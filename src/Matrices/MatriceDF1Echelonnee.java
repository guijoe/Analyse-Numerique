package Matrices;

import java.io.FileNotFoundException;

import Interfaces.IEquaDiff;

public class MatriceDF1Echelonnee extends DefaultMatrice{
	
	MatriceDF1 mat;
	double[] tab;

	public MatriceDF1Echelonnee(MatriceDF1 mat){
		
		this.mat = mat;
		setNombreDeLignes(mat.getNombreDeLignes());
		setNombreDeColonnes(mat.getNombreDeColonnes());
		tab = new double[getNombreDeLignes()];
	}

	public double get(int i, int j) throws Exception {
		if(j != getNombreDeColonnes() - 1){
			if(i == j-1){
				if(i == 0)
					 return mat.get(i, i+1);
				else{
					// On retourne a(i-1) * Li
					return mat.get(i, i+1); //* get(i-1, j-2)/get(i, j-2);
				} 
			}
			
			else if(i == j){
				if(i == 0)
					return mat.get(i, i);
				else{
					// On retourne  Li - (ai/a(i-1)) * L(i-1)
					return mat.get(i, i)  - (mat.get(i, i-1)/get(i-1, i-1)) * mat.get(i, i-1);
				}
			}
			else{
				return 0.0;
			}
		}
		
		else{
			
			if(i==0){
				return mat.get(i, j);
			}
			else if(i == getNombreDeLignes() - 1){
				return mat.get(i, j) - get(i-1, j) * (mat.get(i, i-1) / get(i-1, i-1));
			}
			else{
				return mat.get(i, j) - get(i-1, j) * (mat.get(i, i-1) / get(i-1, i-1));
			}
		}
	}
	
	public double[] remontee() throws Exception{
		
		double ui = get(getNombreDeLignes() - 1, getNombreDeColonnes()-1)/get(getNombreDeLignes() - 1, getNombreDeColonnes()-2);
		
		//System.out.println(getNombreDeLignes() + " : " + ui);
		tab[getNombreDeLignes() - 1] = ui;
		for(int i=getNombreDeLignes() - 2; i>=0; --i){
			
			double fi = get(i, getNombreDeColonnes() - 1);
			double ai = get(i, i);
			double bi = get(i, i+1);
			ui = (fi - bi*ui)/ai;
			tab[i] = ui;
			//System.out.println( i+1 + " : " + ui);
		}
		return tab;
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
