package models.controladores;

import java.util.*;

import models.cadastros.CadastroPacote;
import models.entidades.Pacote;
import models.repositorios.*;

public class ControlaContratacao { 
    private CadastroPacote cadastroPacote;

    public ControlaContratacao(FabricaInterface fabrica) {
        this.cadastroPacote = new CadastroPacote(fabrica);
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