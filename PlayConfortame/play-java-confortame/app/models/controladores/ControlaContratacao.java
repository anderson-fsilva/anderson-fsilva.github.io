package models.controladores;

import java.util.*;

import models.cadastros.CadastroPacote;
import models.entidades.Pacote;


public class ControlaContratacao { 

    private CadastroPacote cadastroPacote;

    public ControlaContratacao() {
        this.cadastroPacote = new CadastroPacote();
    }

    public ArrayList<Pacote> obterPacotesAcessiveis(Double valor) {
        ArrayList<Pacote> pacotesAbaixoDoPreco = new ArrayList<>();

        List<Pacote> todosPacotes = cadastroPacote.recuperarPacotes();
        for (Pacote pacote : todosPacotes) {
            if (pacote.getValorPacote() <= valor) pacotesAbaixoDoPreco.add(pacote);
        }

        return pacotesAbaixoDoPreco;
    }

    public Pacote obterDetalhesPacote(String nomePacote) {
        return this.cadastroPacote.obterPacotePeloNome(nomePacote);
    }


}