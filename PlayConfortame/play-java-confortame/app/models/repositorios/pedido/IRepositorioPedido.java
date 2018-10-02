package models.repositorios.pedido;

import java.util.List;
import models.entidades.Pedido;

public interface IRepositorioPedido {
		
		
		public List<Pedido> all();
		
		public Pedido findId(long id);
		
		public void save(Pedido pedido);
		
		public void delete(long id);
}
