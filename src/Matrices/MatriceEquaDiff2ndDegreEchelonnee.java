package Matrices;

import java.io.FileNotFoundException;

import Interfaces.IEquaDiff;

public class MatriceEquaDiff2ndDegreEchelonnee extends DefaultMatrice{
	
	MatriceEquaDiff2ndDegre mat;
	double[] tab;

	public MatriceEquaDiff2ndDegreEchelonnee(MatriceEquaDiff2ndDegre mat){
		
		this.mat = mat;
		setNombreDeLignes(mat.getNombreDeLignes());
		setNombreDeColonnes(mat.getNombreDeColonnes());
		tab = new double[getNombreDeLignes()];
	}

	public double get(int i, int j) throws Exception {
		if(i == j-1 && j != getNombreDeColonnes() - 1){
			if(i == 0)
				 return mat.get(i, i+1);
			else{
				// On retourne a(i-1) * Li
				return mat.get(i, i+1); //* get(i-1, j-2)/get(i, j-2);
			} 
		}
		
		else if(i == j && j != getNombreDeColonnes() - 1 ){
			if(i == 0)
				return mat.get(i, i);
			else{
				// On retourne  Li - (ai/a(i-1)) * L(i-1)
				return mat.get(i, i)  - (mat.get(i, i-1)/get(i-1, i-1)) * mat.get(i, i-1);
			}
		}
		
		else if(i == j+1 && j != getNombreDeColonnes() - 1){
			return 0.0;
		}
		
		else if(j == getNombreDeColonnes() - 1){
			
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
		else{
			return 0.0;
		}
	}
	
	public void remontee() throws Exception{
		
		double ui = get(getNombreDeLignes() - 1, getNombreDeColonnes()-1)/get(getNombreDeLignes() - 1, getNombreDeColonnes()-2);
		//tab[9] = ui;
		//System.out.println(getNombreDeLignes());
		for(int i=getNombreDeLignes() - 1; i>=0; --i){
			
			
			
			double fi = get(i, getNombreDeColonnes() - 1);
			double ai = get(i, i);
			double bi = get(i, i+1);
			ui = (fi - bi*ui)/ai;
			tab[i] = ui;
			System.out.println( i+1 + " : " + ui);
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
