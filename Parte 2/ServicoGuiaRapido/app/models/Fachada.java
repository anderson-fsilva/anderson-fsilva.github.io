package models;

import java.util.*;

import models.controladores.*;
import models.entidades.*;
import models.repositorios.*;


public class Fachada { 
    private static Fachada fachadaSingleton = null;
    private ControlaContratacao controlaContratacao;
    private FabricaInterface fabrica;

    private Fachada() {
        this.fabrica = new FabricaRepositorioBDR();
        this.controlaContratacao = new ControlaContratacao(fabrica);
    }

    public static Fachada obterInstancia() {
        if (Fachada.fachadaSingleton == null)
            Fachada.fachadaSingleton = new Fachada();

        return fachadaSingleton;
    }

    public ArrayList<Pacote> exibirPacotesAcessiveis(Double valor) {
       return this.controlaContratacao.obterPacotesAcessiveis(valor);
    }

    public Pacote obterPacote(String nomePacote) {
        return this.controlaContratacao.obterPacote(nomePacote);
    }

    public ArrayList<String> exibirDetalhesPacote(String nomePacote) {
        Pacote pacoteDetalhes = this.controlaContratacao.obterDetalhesPacote(nomePacote);
        
        ArrayList<String> itensDoPacote = new ArrayList<String>();

        if(pacoteDetalhes.getUrnas() > 0) {
            itensDoPacote.add("Urnas");
        }
        if(pacoteDetalhes.getCoroaFlores() > 0) {
            itensDoPacote.add("CoroaFlores");
        }

        if(pacoteDetalhes.getBuffet() == true) {
            itensDoPacote.add("Buffet");
        }
        if(pacoteDetalhes.getTransmissaoWeb() == true) {
            itensDoPacote.add("TransmissaoWeb");
        }            
        
        return itensDoPacote;
    }


    private ArrayList<String> itensDoPacote;
    private ArrayList<String> valoresInformados;
    
    public void setItensPacote(ArrayList<String> itens) {
        this.itensDoPacote = itens;
    }
    public ArrayList<String> getItensPacote() {
        return this.itensDoPacote;
    }
    public void setValoresInformados(ArrayList<String> valores) {
        this.valoresInformados = valores;
    }
    public ArrayList<String> getValoresInformados() {
        return this.valoresInformados;
    }

    public void armazenarPedido(Pedido pedido) {
        this.controlaContratacao.armazenarPedido(pedido);
    }


}