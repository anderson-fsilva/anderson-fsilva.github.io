package models.controladores;

import java.util.*;

import models.cadastros.*;
import models.entidades.*;
import models.repositorios.*;

public class ControlaContratacao { 
    private CadastroPacote cadastroPacote;
    private CadastroPedido cadastroPedido;

    public ControlaContratacao(FabricaInterface fabrica) {
        this.cadastroPacote = new CadastroPacote(fabrica);
        this.cadastroPedido = new CadastroPedido(fabrica);
    }

    public Pacote obterPacote(String nome) {
        return this.cadastroPacote.obterPacotePeloNome(nome);
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

    public void armazenarPedido(Pedido pedido) {
        this.cadastroPedido.atualizarPedido(pedido);
    }


}