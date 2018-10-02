package models.repositorios.funeraria;

import java.util.List;

import models.entidades.Funeraria;
import io.ebean.*;

public class RepositorioFunerariaBDR implements IRepositorioFuneraria{
	
	public Finder<Long, Funeraria> funerariaFinder;
	
	public RepositorioFunerariaBDR(){
		funerariaFinder = new Finder<Long, Funeraria>(Funeraria.class);
	}
	
	public List<Funeraria> all(){
		return funerariaFinder.all();
	}
	
	public Funeraria findId(long id){
		return funerariaFinder.byId(id);
	}
	
	public void save(Funeraria funeraria){
		funeraria.save();
	}
	
	public void delete(long id){
		funerariaFinder.ref(id).delete();
	}

}
