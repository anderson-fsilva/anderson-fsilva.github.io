package models.cadastros;

import java.util.*;

import models.entidades.Pacote;
import models.repositorios.FabricaInterface;
import models.repositorios.FabricaRepositorioBDR;
import models.repositorios.pacote.IRepositorioPacote;
import models.repositorios.pacote.RepositorioPacoteBDR;

public class CadastroPacote { 
    private FabricaInterface repBDR;
    private IRepositorioPacote repPacote;

    public CadastroPacote(FabricaInterface repBDR) {
        repBDR = new FabricaRepositorioBDR();
        repPacote = repBDR.makeRepPacote();
        preencherPacotes();
    }

    //atualizar pacote
    public void atualizarPacote(Pacote pacote){
        repPacote.save(pacote);
    }
    
    //remover pacote pelo id
    public void removerPacote(long id){
        if(repPacote.findId(id) != null){
            repPacote.delete(id);
        }
    }
    
    //obter pacote pelo id
    public Pacote recuperarPacote(long id){
        return repPacote.findId(id);
    }
    
    //obter todos os pacotes
    public List<Pacote> recuperarPacotes(){
        return repPacote.all();
    }
    
    //cadastro de pacotes disponiveis
    public void preencherPacotes() {
        //Remover pacotes pré-existentes (Evita erros)
        List<Pacote> pacotes = this.recuperarPacotes();
        for (Pacote pacote : pacotes) {
            this.removerPacote(pacote.id);
        }

        //Adicionar pacotes basicos
        atualizarPacote(new Pacote("Simples", 1, 1,false,900.00,"Este pacote permite a escolha de uma urna e uma coroa de flores.",
                        false, true, false, ""));
        atualizarPacote(new Pacote("Intermediario", 1, 2,true,1500.0,"Este pacote permite a escolha de até duas urnas, duas coroa de flores, buffete e translado internacional",
                        false, true, true, ""));
        atualizarPacote(new Pacote("Avancado", 2, 2,true,5000.0,"Este pacote permite a escolha de até três urnas, podendo ser urna para cremacao e/ou urna para as cinzas, transmissão web, translado internacional, três coroas de flores e buffet", 
                        true, true, true, ""));
    }

    //retorna pacote selecionado pelo nome
    public Pacote obterPacotePeloNome(String nomePacote) {
        Pacote pacoteSelecionado = null;

        List<Pacote> todosPacotes = recuperarPacotes();
        for (Pacote pacote : todosPacotes) {
            if (pacote.getNome().equals(nomePacote))
                pacoteSelecionado = pacote; 
        }

        return pacoteSelecionado;
    } 
}
