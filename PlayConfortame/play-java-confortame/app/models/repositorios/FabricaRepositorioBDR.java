package models.repositorios;

import models.repositorios.pacote.IRepositorioPacote;
import models.repositorios.pedido.IRepositorioPedido;
import models.repositorios.funeraria.IRepositorioFuneraria;
import models.repositorios.pacote.RepositorioPacoteBDR;
import models.repositorios.pedido.RepositorioPedidoBDR;
import models.repositorios.funeraria.RepositorioFunerariaBDR;

public class FabricaRepositorioBDR implements FabricaInterface {
    
    public IRepositorioPacote makeRepPacote(){
        return new RepositorioPacoteBDR();
    }
    
    public IRepositorioFuneraria makeRepFuneraria(){
        return new RepositorioFunerariaBDR();
    }

    public IRepositorioPedido makeRepPedido(){
    	return new RepositorioPedidoBDR();
    }
    
}