package models.controladores;

import java.util.*;

import models.cadastros.CadastroFuneraria;
import models.entidades.Funeraria;
import models.repositorios.*;


public class ControlaCadastroFuneraria { 
    private CadastroFuneraria cadastroFuneraria;

    public ControlaCadastroFuneraria(FabricaInterface fabrica) {
        this.cadastroFuneraria = new CadastroFuneraria(fabrica);
    }

    public Boolean cadastrarFuneraria(Funeraria funeraria) {
        Boolean success = false;
        
        if (this.checaCnpjUnico(funeraria)){
            success = true;
            this.cadastroFuneraria.cadastraNovaFuneraria(funeraria);
        }
            
        return success;
    }

    public void cadastrarServicos(String cnpj, Boolean cremacao, Boolean sepultamento, Boolean coroaDeFlores, Boolean buffet, Boolean web, Boolean transladoInternacional) {
        Funeraria funeraria = this.cadastroFuneraria.obterFunerariaPeloCNPJ(cnpj);

        funeraria.cremacao = cremacao;
        funeraria.sepultamento = sepultamento;
        funeraria.coroaDeFlores = coroaDeFlores;
        funeraria.buffet = buffet;
        funeraria.web = web;
        funeraria.transladoInternacional = transladoInternacional;
    }

    public Boolean checaCnpjUnico(Funeraria funeraria){
        Boolean cnpjUnico = true;
        List<Funeraria> listaFunerarias = this.cadastroFuneraria.obterListaFunerarias();

        for (Funeraria fun : listaFunerarias){
            if (fun.cnpj.equals(funeraria.cnpj))
                cnpjUnico = false;
        }

        return cnpjUnico;
    }


}