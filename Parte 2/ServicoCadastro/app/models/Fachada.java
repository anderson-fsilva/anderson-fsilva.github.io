package models;

import java.util.*;

import models.controladores.*;
import models.entidades.*;
import models.repositorios.*;
import models.cadastros.*;


public class Fachada { 
    private static Fachada fachadaSingleton = null;
    private ControlaCadastroFuneraria controlaCadastroFuneraria;
    private CadastroPacote cadastroPacote;
    private FabricaInterface fabrica;

    private Fachada() {
        this.fabrica = new FabricaRepositorioBDR();
        this.controlaCadastroFuneraria = new ControlaCadastroFuneraria(fabrica);
        this.cadastroPacote = new CadastroPacote(fabrica);
    }

    public static Fachada obterInstancia() {
        if (Fachada.fachadaSingleton == null)
            Fachada.fachadaSingleton = new Fachada();

        return fachadaSingleton;
    }

    public Boolean cadastrarFuneraria(Funeraria funeraria){
        Boolean success = true;
        success = this.controlaCadastroFuneraria.cadastrarFuneraria(funeraria);
        return success;
    }

    public void cadastrarServicosFuneraria(String cnpj, Boolean cremacao, Boolean sepultamento, Boolean coroaDeFlores, Boolean buffet, Boolean web, Boolean transladoInternacional){
        this.controlaCadastroFuneraria.cadastrarServicos(cnpj,cremacao,sepultamento,coroaDeFlores,buffet,web,transladoInternacional);
    }  

    public void cadastrarPacote(Pacote pacote) {
        cadastroPacote.atualizarPacote(pacote);
    }

    public ArrayList<Pacote> obterPacotesAcessiveis(Double valor) {
        ArrayList<Pacote> pacotesAbaixoDoPreco = new ArrayList<>();

        List<Pacote> todosPacotes = cadastroPacote.recuperarPacotes();
        for (Pacote pacote : todosPacotes) {
            if (pacote.getValorPacote() <= valor) pacotesAbaixoDoPreco.add(pacote);
        }

        return pacotesAbaixoDoPreco;
    }

}