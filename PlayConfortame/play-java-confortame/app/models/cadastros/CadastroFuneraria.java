package models.cadastros;

import java.util.*;

import models.entidades.Funeraria;

public class CadastroFuneraria { 
    private ArrayList<Funeraria> funerarias = new ArrayList<>();

    public CadastroFuneraria() {
        //
    }

    public void cadastraNovaFuneraria(Funeraria funeraria){
        this.funerarias.add(funeraria);
    }

    public ArrayList<Funeraria> obterListaFunerarias() {
        return this.funerarias;
    }

    public Funeraria obterFunerariaPeloCNPJ(String cnpj){
        Funeraria funerariaObtida = null;
        ArrayList<Funeraria> listaFunerarias = this.funerarias;

        for (Funeraria fun : listaFunerarias) {
            if (fun.cnpj.equals(cnpj))
                funerariaObtida = fun;
        }

        return funerariaObtida;
    }
}