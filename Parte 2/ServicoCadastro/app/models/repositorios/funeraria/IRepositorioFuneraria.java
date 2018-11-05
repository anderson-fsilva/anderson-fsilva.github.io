package models.repositorios.funeraria;

import java.util.List;
import models.entidades.Funeraria;

public interface IRepositorioFuneraria {
		
		
		public List<Funeraria> all();
		
		public Funeraria findId(long id);
		
		public void save(Funeraria funeraria);
		
		public void delete(long id);
}
