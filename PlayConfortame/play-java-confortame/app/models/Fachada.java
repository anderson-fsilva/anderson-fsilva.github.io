package models;

import java.util.*;


public class Fachada { 

    private static Fachada fachadaSingleton = null;

    private ControlaContratacao controlaContratacao;

    private Fachada() {
        this.controlaContratacao = new ControlaContratacao();
    }

    public static Fachada obterInstancia() {
        if (Fachada.fachadaSingleton == null)
            Fachada.fachadaSingleton = new Fachada();

        return fachadaSingleton;
    }

    public ArrayList<Pacote> exibirPacotesAcessiveis(Double valor) {
       return this.controlaContratacao.obterPacotesAcessiveis(valor);
    }


    public String exibirDetalhesPacote(String nomePacote) {
        Pacote pacoteDetalhes = this.controlaContratacao.obterDetalhesPacote(nomePacote);
        String pacoteDt = "Pacote " + nomePacote + '\n' + 
                            "Buffet: " + String.valueOf(pacoteDetalhes.buffet) + '\n' +
                            "Urnas: " + pacoteDetalhes.urnas + '\n' +
                            "Valor medio do pacote: " + pacoteDetalhes.valorPacote + '\n';
        return pacoteDt;
    }


}