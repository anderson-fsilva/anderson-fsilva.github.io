package models.cadastros;

import java.util.*;

import models.entidades.Pacote;




public class CadastroPacote { 

    public ArrayList<Pacote> pacotes = new ArrayList<>();

    public CadastroPacote() {
        preencherPacotes();
    }
    
    
    //cadastro de pacotes disponiveis
    public void preencherPacotes() {
        this.pacotes.add(new Pacote("Simples", 1, 1,false,900.00,"Este pacote permite a escolha de uma urna e uma coroa de flores.",
                        false, true, false, ""));
        this.pacotes.add(new Pacote("Intermediario", 1, 2,true,1500.0,"Este pacote permite a escolha de até duas urnas, duas coroa de flores, buffete e translado internacional",
                        false, true, true, ""));
        this.pacotes.add(new Pacote("Avancado", 2, 2,true,5000.0,"Este pacote permite a escolha de até três urnas, podendo ser urna para cremacao e/ou urna para as cinzas, transmissão web, translado internacional, três coroas de flores e buffet", 
                        true, true, true, ""));
    }

    //obter pacotes abaixo do valor informado
    public ArrayList<Pacote> obterPacotesAbaixoDoPreco(Double valor) {
        ArrayList<Pacote> pacotesAbaixoDoPreco = new ArrayList<>();

        for (Pacote pacote : this.pacotes) {
            if (pacote.obterPreco() <= valor) pacotesAbaixoDoPreco.add(pacote);
        }

        return pacotesAbaixoDoPreco;
    }

    //retorna pacote selecionado pelo nome
    public Pacote obterPacotePeloNome(String nomePacote) {
        Pacote pacoteSelecionado = null;

        for (Pacote pacote : this.pacotes) {
            if (pacote.obterNome().equals(nomePacote))
                pacoteSelecionado = pacote; 
        }

        return pacoteSelecionado;
    } 
}
