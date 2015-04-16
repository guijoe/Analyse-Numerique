package DataProviders;

import java.io.OutputStream;
import java.util.ArrayList;

import Interfaces.IDataProvider;

public abstract class DefaultDataProvider implements IDataProvider {
	protected ArrayList<ArrayList<Double>> tab;
	public ArrayList<ArrayList<Double>> getTab(){
		return tab;
	}
}
