package models;

import java.util.*;


public class CadastroPacote { 

    public ArrayList<Pacote> pacotes = new ArrayList<>();

    CadastroPacote() {
        preencherPacotes();
    }
    
    
    //cadastro de pacotes disponiveis

    public void preencherPacotes() {
        this.pacotes.add(new Pacote("Simples", 1, 1,false,900.00,"Este pacote eh composto por uma urna e uma coroa de flores"));
        this.pacotes.add(new Pacote("Intermediario", 1, 2,false,1500.0,"Este pacote eh composto por uma urna de melhor qualidade e duas coroas de flores"));
        this.pacotes.add(new Pacote("Avancado", 2, 2,true,5000.0,"Este pacote eh composto por uma urna para cremacao, uma urna para as cinzas, duas coroas de flores e buffet"));
    }

    //obter pacotes abaixo do valor informado
    public ArrayList<Pacote> obterPacotesAbaixoDoPreco(Double valor) {
        ArrayList<Pacote> pacotesAbaixoDoPreco = new ArrayList<>();

        for (Pacote pacote : this.pacotes) {
            if (pacote.obterPreco() <= valor) pacotesAbaixoDoPreco.add(pacote);
        }

        return pacotesAbaixoDoPreco;
    }

<<<<<<< HEAD
<<<<<<< HEAD


=======
    //retorna pacote selecionado pelo nome
>>>>>>> a31ad70f6e1cc6029a895cbc1d4bc92515d0f57a
=======
    //retorna pacote selecionado pelo nome
>>>>>>> a31ad70f6e1cc6029a895cbc1d4bc92515d0f57a
    public Pacote obterPacotePeloNome(String nomePacote) {
        Pacote pacoteSelecionado = null;

        for (Pacote pacote : this.pacotes) {
            if (pacote.obterNome().equals(nomePacote))
                pacoteSelecionado = pacote;
        }

        return pacoteSelecionado;
    } 
}
