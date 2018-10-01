package models.controladores;

import java.util.*;

import models.cadastros.CadastroFuneraria;
import models.entidades.Funeraria;


public class ControlaCadastroFuneraria { 
    private CadastroFuneraria cadastroFuneraria;

    public ControlaCadastroFuneraria() {
        this.cadastroFuneraria = new CadastroFuneraria();
    }

    public Boolean cadastrarFuneraria(Funeraria funeraria) {
        Boolean success = false;
        
        if (this.checaCnpjUnico(funeraria)){
            success = true;
            this.cadastroFuneraria.cadastraNovaFuneraria(funeraria);
        }
            
        return success;
    }

    public void cadastrarServicos(String cnpj, Boolean cremacao, Boolean sepultamento, Boolean coroaDeFlores) {
        Funeraria funeraria = this.cadastroFuneraria.obterFunerariaPeloCNPJ(cnpj);

        funeraria.cremacao = cremacao;
        funeraria.sepultamento = sepultamento;
        funeraria.coroaDeFlores = coroaDeFlores;
    }

    public Boolean checaCnpjUnico(Funeraria funeraria){
        Boolean cnpjUnico = true;
        ArrayList<Funeraria> listaFunerarias = this.cadastroFuneraria.obterListaFunerarias();

        for (Funeraria fun : listaFunerarias){
            if (fun.cnpj.equals(funeraria.cnpj))
                cnpjUnico = false;
        }

        return cnpjUnico;
    }


}