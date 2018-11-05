package models;

import java.util.*;

import models.controladores.*;
import models.entidades.*;
import models.repositorios.*;


public class Fachada { 
    private static Fachada fachadaSingleton = null;
    private ControlaCadastroFuneraria controlaCadastroFuneraria;
    private FabricaInterface fabrica;

    private Fachada() {
        this.fabrica = new FabricaRepositorioBDR();
        this.controlaCadastroFuneraria = new ControlaCadastroFuneraria(fabrica);
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

}