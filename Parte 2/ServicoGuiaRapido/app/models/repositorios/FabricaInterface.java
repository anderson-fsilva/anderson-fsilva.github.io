package models.repositorios;

import java.util.List;
import models.repositorios.pacote.IRepositorioPacote;
import models.repositorios.pedido.IRepositorioPedido;

public interface FabricaInterface {
		
		public IRepositorioPacote makeRepPacote();

    	public IRepositorioPedido makeRepPedido();
		
}
