package models.repositorios;

import java.util.List;
import models.repositorios.pacote.RepositorioPacote;
import models.repositorios.funeraria.RepositorioFuneraria;

public interface FabricaInterface {
		
		public RepositorioPacote makeRepPacote();

    	public RepositorioFuneraria makeRepFuneraria();
		
}
