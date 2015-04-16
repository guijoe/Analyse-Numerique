package Test;

import java.io.FileNotFoundException;
import DataProviders.*;
import Interfaces.*;
import Interfaces.IDataProvider.Seperator;
import DataResolvers.*;

public class TestMatrice {
	
	private IMatrice matriceDeTest;
	
	public IMatrice newMatrice(String classe){
		try {
			matriceDeTest = (IMatrice) Class.forName(classe).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return matriceDeTest;
	}
	
	@SuppressWarnings("null")
	public static void main(String args[]){
		TestMatrice test = new TestMatrice();
		
		IMatrice testMat = test.newMatrice("Matrices.MatriceCCS");
		try {
			testMat.init("Ressources/TestIn.tab");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileResolver fr = new FileResolver("Ressources/TestOut.ccs", Seperator.WHITESPACE);
		fr.ecrireMatrice(testMat);
		//testMat.printMatrice();
		//System.out.println(testMat.toString());
		
	}
}
