package models.entidades;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;
// import javax.persistence.ManyToOne;

import play.data.validation.Constraints.Required;
import io.ebean.*;

@Entity
public class Cliente extends Model {

    @Id
    public long id;

    //Dados
    public String nome;
    
    public Cliente () {
        //
    }

    public Cliente (String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

}

