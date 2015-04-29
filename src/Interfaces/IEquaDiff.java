package Interfaces;

public interface IEquaDiff {
	public IFunction getA();
	public IFunction getB();
	public IFunction getC();
	public IFunction getF();
	public IMailleur getMailleur();
	public double getElementi(int i);
	public double hi(int i);
	public int getN();
	public double getU0();
	public double getU1();
	public IFunction resoudreAvecDF();
	public IFunction resoudreAvecVF();
	public void construireMatrice();
}
