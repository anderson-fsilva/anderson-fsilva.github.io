package models.entidades;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import io.ebean.*;

@Entity
public class Pedido extends Model {
	
	@Id
    public long id;

    @Required
    public Usuario usuario;
    public Pacote pacote;
    public Double orcamento;
    public String localizacaoOrigem;
    public String localizacaoDestino;
    public String opcaoUrna;
    public String opcaoCoroa;
    public String outros;

    public Pedido(){
    	//
    }

}