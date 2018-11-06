package models.repositorios;

import models.repositorios.pacote.IRepositorioPacote;
import models.repositorios.pedido.IRepositorioPedido;
import models.repositorios.pacote.RepositorioPacoteBDR;
import models.repositorios.pedido.RepositorioPedidoBDR;

public class FabricaRepositorioBDR implements FabricaInterface {
    
    public IRepositorioPacote makeRepPacote(){
        return new RepositorioPacoteBDR();
    }

    public IRepositorioPedido makeRepPedido(){
    	return new RepositorioPedidoBDR();
    }
    
}