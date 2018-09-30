package models;

import java.util.*;


public class CadastroPacote { 

    public ArrayList<Pacote> pacotes = new ArrayList<>();

    CadastroPacote() {
        preencherPacotes();
    }

    public void preencherPacotes() {
        this.pacotes.add(new Pacote("Simples", 1,false,900.00));
        this.pacotes.add(new Pacote("Intermediario",1,false,2000.0));
        this.pacotes.add(new Pacote("Avancado",1,true,5000.0));
    }

    public ArrayList<Pacote> obterPacotesAbaixoDoPreco(Double valor) {
        ArrayList<Pacote> pacotesAbaixoDoPreco = new ArrayList<>();

        for (Pacote pacote : this.pacotes) {
            if (pacote.obterPreco() <= valor) pacotesAbaixoDoPreco.add(pacote);
        }

        return pacotesAbaixoDoPreco;
    }

    public Pacote obterPacotePeloNome(String nomePacote) {
        Pacote pacoteSelecionado = null;

        for (Pacote pacote : this.pacotes) {
            if (pacote.obterNome().equals(nomePacote))
                pacoteSelecionado = pacote;
        }

        return pacoteSelecionado;
    } 
}