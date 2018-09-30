package models;

import java.util.*;


public class ControlaContratacao { 

    private CadastroPacote cadastroPacote;

    public ControlaContratacao() {
        this.cadastroPacote = new CadastroPacote();
    }

    public ArrayList<Pacote> obterPacotesAcessiveis(Double valor) {
        return this.cadastroPacote.obterPacotesAbaixoDoPreco(valor);
    }

    public Pacote obterDetalhesPacote(String nomePacote) {
        return this.cadastroPacote.obterPacotePeloNome(nomePacote);
    }


}