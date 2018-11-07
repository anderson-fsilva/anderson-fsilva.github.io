package models.repositorios;

import java.util.List;
import models.repositorios.pacote.IRepositorioPacote;
import models.repositorios.funeraria.IRepositorioFuneraria;

public interface FabricaInterface {
		
		public IRepositorioPacote makeRepPacote();

    	public IRepositorioFuneraria makeRepFuneraria();
		
}
