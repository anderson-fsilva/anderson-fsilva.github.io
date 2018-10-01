package controllers;

import java.util.*;
import play.mvc.*;
import views.html.*;
import models.entidades.Pacote;
import models.Fachada;
import javax.inject.*;



public class ResumoPedidoController extends Controller {



    public Result indexResumo(String locOrigem, String locDestino, String valorDesejado) {
      
        ArrayList<String> resumo = new ArrayList<String>();
        Fachada fachada = Fachada.obterInstancia();
        ArrayList<String> itensDoPacote = fachada.getItensPacote();
        ArrayList<String> valoresInformadosPeloUsuario = fachada.getValoresInformados();

        resumo.add("Localizacao origem: " + locOrigem);
        resumo.add("Localizacao destino: " + locDestino);
        resumo.add("Valor desejado: " + valorDesejado);


        for(int i = 0; i < itensDoPacote.size(); i ++) {
            resumo.add(itensDoPacote.get(i) + ": " + valoresInformadosPeloUsuario.get(i));
        }

        return ok(resumoPedido.render(resumo));
    }

    public Result onPostResumo(){
        return ok("Seu pedido foi realizado. Aguarde o envio das propostas das funerarias.");
    }



}