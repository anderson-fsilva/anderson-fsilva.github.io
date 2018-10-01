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
        return this.cadastroPacote.obterPacotesAbaixoDoPreco(valor);
    }

    public Pacote obterDetalhesPacote(String nomePacote) {
        return this.cadastroPacote.obterPacotePeloNome(nomePacote);
    }


}