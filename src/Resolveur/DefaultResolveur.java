package Resolveur;

import Interfaces.IEquaDiff;
import Interfaces.IMatrice;
import Interfaces.IResolveur;

public abstract class DefaultResolveur implements IResolveur{
	protected IMatrice mat;
	
	public DefaultResolveur(IEquaDiff equation){
		
	}
}
