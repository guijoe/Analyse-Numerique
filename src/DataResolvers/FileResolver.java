package DataResolvers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import Interfaces.IDataProvider.Seperator;
import Interfaces.IMatrice;
import Matrices.*;

public class FileResolver extends DefaultDataResolver {

	public FileResolver(String fileOut, Seperator sep){
		super(fileOut);
		this.seperator = sep;
	}

	@Override
	public void ecrireMatrice(IMatrice mat){
		try{
			bw.write(mat.toString());
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (super.bw != null) {
				try {
					super.bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (super.outputStream != null) {
				try {
					super.outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	 
			}
		}
	}

	
	@Override
	public void resolveInCoordWithoutZeros(IMatrice mat) {
		try{
			for(int i=0; i<mat.getNombreDeLignes(); ++i){
				
				String line = "";
				for(int j=0; j<mat.getNombreDeColonnes(); ++j){
					if(mat.get(i, j) != 0.0){
						try {
							line = ""+ " " + i + " " + j + " " + mat.get(i, j);
							bw.write(line);
							bw.newLine();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (super.bw != null) {
				try {
					super.bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (super.outputStream != null) {
				try {
					super.outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	 
			}
		}
	}

}
