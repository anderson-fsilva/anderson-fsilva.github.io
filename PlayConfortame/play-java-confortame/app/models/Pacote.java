package models;

import java.util.*;

public class Pacote {

    public String nome;
    public int urnas;
    public int coroaFlores;
    public Boolean transmissaoWeb;
    public Boolean buffet;
    public String outros;
    public Boolean transladoNacional;
    public Boolean transladoInternacional;
    public Double valorPacote;

    Pacote() {
        //
    }

    Pacote(String nome, int urnas, Boolean buffet, Double valorPacote) {
        this.nome = nome;
        this.buffet = buffet;
        this.urnas = urnas;
        this.valorPacote = valorPacote;
    }

    Double obterPreco() {
        return this.valorPacote;
    }

    String obterNome() {
        return this.nome;
    }

   


}