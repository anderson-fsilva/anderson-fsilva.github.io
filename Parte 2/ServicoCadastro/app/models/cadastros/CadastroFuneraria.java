package models.cadastros;

import java.util.*;

import models.entidades.Funeraria;
import models.repositorios.*;
import models.repositorios.funeraria.*;

public class CadastroFuneraria { 
    private IRepositorioFuneraria repFuneraria;
    
    public CadastroFuneraria(FabricaInterface fabrica) {
        this.repFuneraria = fabrica.makeRepFuneraria();
    }

    public void cadastraNovaFuneraria(Funeraria funeraria){
        repFuneraria.save(funeraria);
    }

    public List<Funeraria> obterListaFunerarias() {
        return repFuneraria.all();
    }

    public Funeraria obterFunerariaPeloCNPJ(String cnpj){
        Funeraria funerariaObtida = null;
        List<Funeraria> listaFunerarias = this.obterListaFunerarias();

        for (Funeraria fun : listaFunerarias) {
            if (fun.cnpj.equals(cnpj))
                funerariaObtida = fun;
        }

        return funerariaObtida;
    }
}