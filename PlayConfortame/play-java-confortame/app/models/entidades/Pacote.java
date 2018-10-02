package models.entidades;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;
// import javax.persistence.ManyToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Pacote extends Model {

    @Id
    public long id;

    @Required
    public String nome;
    public int urnas;
    public int coroaFlores;
    public Boolean transmissaoWeb;
    public Boolean buffet;
    public String outros;
    public Boolean transladoNacional;
    public Boolean transladoInternacional;
    public Double valorPacote;
    public String descricao;

   

    public Pacote(long id, String nome, int urnas, int coroaFlores, Boolean buffet, Double valorPacote, String descricao, Boolean transmissaoWeb,
                    Boolean transladoNacional, Boolean transladoInternacional, String outros) {
        
        this.id = id;
        this.nome = nome;
        this.buffet = buffet;
        this.urnas = urnas;
        this.coroaFlores = coroaFlores;
        this.valorPacote = valorPacote;
        this.descricao = descricao;
        this.transmissaoWeb = transmissaoWeb;
        this.transladoNacional = transladoNacional;
        this.transladoInternacional = transladoInternacional;
        this.outros = outros;
    }

    public long getId() {
        return id;
    }

    public String getNome(){
        return this.nome;
    }
    public int getUrnas(){
        return this.urnas;
    }
    public int getCoroaFlores(){
        return this.coroaFlores;
    }
    public Boolean getTransmissaoWeb(){
        return this.transmissaoWeb;
    }
    public Boolean getBuffet(){
        return this.buffet;
    }
    public String getOutros(){
        return this.outros;
    }
    public Boolean getTransladoNacional(){
        return this.transladoNacional;
    }
    public Boolean getTransladoInternacional(){
        return this.transladoInternacional;
    }
    public Double getValorPacote(){
        return this.valorPacote;
    }
    public String getDescricao(){
        return this.descricao;
    }

    public Double obterPreco() {
        return this.valorPacote;
    }

    public String obterNome() {
        return this.nome;
    }

   


}