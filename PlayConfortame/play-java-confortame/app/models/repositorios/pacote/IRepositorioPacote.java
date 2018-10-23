package models.repositorios.pacote;

import java.util.List;
import models.entidades.Pacote;

public interface IRepositorioPacote {		
		public List<Pacote> all();
		
		public Pacote findId(long id);
		
		public void save(Pacote pacote);
		
		public void delete(long id);
}
