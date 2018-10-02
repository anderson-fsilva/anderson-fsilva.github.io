package models.repositorios.pedido;

import java.util.List;

import models.entidades.Pedido;
import io.ebean.*;

public class RepositorioPedidoBDR implements IRepositorioPedido{
	
	public Finder<Long, Pedido> pedidoFinder;
	
	public RepositorioPedidoBDR(){
		pedidoFinder = new Finder<Long, Pedido>(Pedido.class);
	}
	
	public List<Pedido> all(){
		return pedidoFinder.all();
	}
	
	public Pedido findId(long id){
		return pedidoFinder.byId(id);
	}
	
	public void save(Pedido pedido){
		pedido.save();
	}
	
	public void delete(long  id){
		pedidoFinder.ref(id).delete();
	}


}
