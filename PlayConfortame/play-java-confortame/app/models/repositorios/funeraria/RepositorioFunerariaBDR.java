package models.repositorios.funeraria;

import java.util.List;

import models.entidades.Funeraria;
import play.db.ebean.Model.Finder;

public class RepositorioFunerariaBDR implements IRepositorioFuneraria{
	
	public Finder<Long, Funeraria> funerariaFinder;
	
	public RepositorioFunerariaBDR(){
		funerariaFinder = new Finder<Long, Funeraria>(Long.class, Funeraria.class);
	}
	
	public List<Funeraria> all(){
		return funerariaFinder.all();
	}
	
	public Agencia findId(long id){
		return funerariaFinder.byId(id);
	}
	
	public void save(Funeraria funeraria){
		funeraria.save();
	}
	
	public void delete(long id){
		funerariaFinder.ref(id).delete();
	}

}
