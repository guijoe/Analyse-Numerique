package EquaDiff;

import Interfaces.IEquaDiff;
import Interfaces.IFunction;
import Interfaces.IMailleur;

public abstract class DefaultEquaDiff implements IEquaDiff{
	protected IFunction f;
	protected IFunction a;
	protected IFunction b;
	protected IFunction c;
	protected double u0;
	protected double u1;
	protected int n;
	protected IMailleur mailleur;
	
	public double hi(int i){
		return this.getMailleur().hi(i);
	}
	
	public double getElementi(int i){
		return this.mailleur.getElementi(i);
	}
	
	public IFunction getA() {
		return a;
	}
	public void setA(IFunction a) {
		this.a = a;
	}
	public IFunction getB() {
		return b;
	}
	public void setB(IFunction b) {
		this.b = b;
	}
	public IFunction getC() {
		return c;
	}
	public void setC(IFunction c) {
		this.c = c;
	}
	
	public IFunction getF() {
		return f;
	}
	public void setF(IFunction f) {
		this.f = f;
	}
	public double getU0() {
		return u0;
	}
	public void setU0(double u0) {
		this.u0 = u0;
	}
	public double getU1() {
		return u1;
	}
	public void setU1(double u1) {
		this.u1 = u1;
	}
	public int getN() {
		return this.getMailleur().getN();
	}
	public void setN(int n) {
		this.n = n;
	}
	public IMailleur getMailleur() {
		return mailleur;
	}
	public void setMailleur(IMailleur mailleur) {
		this.mailleur = mailleur;
	}
}
