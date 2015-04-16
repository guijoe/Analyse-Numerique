package DataResolvers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import Interfaces.IDataProvider.Seperator;
import Interfaces.IDataResolver;

public abstract class DefaultDataResolver implements IDataResolver {
	
	OutputStream outputStream = null;
	BufferedWriter bw = null;
	Seperator seperator;
	
	public DefaultDataResolver(String fileOut) {
		try {
			// write the inputStream to a FileOutputStream
			outputStream = new FileOutputStream(new File(fileOut));
			bw =  new BufferedWriter(new OutputStreamWriter(outputStream));
	 
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}
	/*
	@Override
	public void ecrireMatrice(){
		
	}
	*/
}
