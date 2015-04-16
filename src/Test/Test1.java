package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test1{
	InputStream inputStream = null;
	OutputStream outputStream = null;

	public Test1(String fileIn, String fileOut){
		try {
			// read this file into InputStream
			inputStream = new FileInputStream(fileIn);
	 
			// write the inputStream to a FileOutputStream
			outputStream = new FileOutputStream(new File(fileOut));
	 
			int read = 0;
			byte[] bytes = new byte[1024];
	 
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
	 
			System.out.println("Done!");
	 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					// outputStream.flush();
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	 
			}
		}
		
	}
	
	/*
	public static void main(String args[]){
		FileResolver fr = new FileResolver("Ressources/TestIn.tab", "Ressources/TestOut.tab");
	}
	*/
	/*
	finally {
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
	*/
}
