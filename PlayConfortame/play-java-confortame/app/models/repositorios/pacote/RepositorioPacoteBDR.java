package models.repositorios.pacote;

import java.util.List;

import models.entidades.Pacote;
import play.db.ebean.Model.Finder;

public class RepositorioPacoteBDR implements IRepositorioPacote{
	
	public Finder<Long, Pacote> pacoteFinder;
	
	public RepositorioPacoteBDR(){
		pacoteFinder = new Finder<Long, Pacote>(Long.class, Pacote.class);
	}
	
	public List<Pacote> all(){
		return pacoteFinder.all();
	}
	
	public Pacote findId(long id){
		return pacoteFinder.byId(id);
	}
	
	public void save(Pacote pacote){
		pacote.save();
	}
	
	public void delete(long  id){
		pacoteFinder.ref(id).delete();
	}


}
