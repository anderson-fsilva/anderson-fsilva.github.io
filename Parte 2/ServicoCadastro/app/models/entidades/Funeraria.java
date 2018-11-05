package models.entidades;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;
// import javax.persistence.ManyToOne;

import play.data.validation.Constraints.Required;
import io.ebean.*;

@Entity
public class Funeraria extends Model {
    
    @Id
    public long id;

    //Dados 
    public String nome;
    public String cnpj;
    public String telefone;
    public String endereco;
    public String cep;
    public String estado;
    public String cidade;
    public String email;

    //Servicos oferecidos
    public Boolean cremacao;
    public Boolean sepultamento;
    public Boolean coroaDeFlores;
    public Boolean buffet;
    public Boolean web;
    public Boolean transladoInternacional;
    
    public Funeraria() {
        //
    }

    public long getId() {
        return id;
    }

}
