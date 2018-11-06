package models.repositorios;

import java.util.List;
import models.repositorios.funeraria.IRepositorioFuneraria;

public interface FabricaInterface {

    	public IRepositorioFuneraria makeRepFuneraria();
		
}
