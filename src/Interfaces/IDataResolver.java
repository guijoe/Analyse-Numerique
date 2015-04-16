package Interfaces;

public interface IDataResolver {
	public void ecrireMatrice(IMatrice mat);
	//public void resolveInTab(IMatrice mat);
	//public void resolveInCoord(IMatrice mat);
	public void resolveInCoordWithoutZeros(IMatrice mat);
}
