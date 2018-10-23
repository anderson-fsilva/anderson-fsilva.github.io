package controllers;

import java.util.*;
import play.mvc.*;
import views.html.*;
import models.entidades.Pacote;
import models.Fachada;
import javax.inject.*;
import play.data.*;



public class ResumoPedidoController extends Controller {
    private FormFactory formFactory;

    @Inject
    public ResumoPedidoController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    public Result indexResumo(String valorDesejado) {
        ArrayList<String> resumo = new ArrayList<String>();
        Fachada fachada = Fachada.obterInstancia();
        ArrayList<String> itensDoPacote = fachada.getItensPacote();
        ArrayList<String> valoresInformadosPeloUsuario = fachada.getValoresInformados();

        resumo.add("Valor desejado: " + valorDesejado);

        for(int i = 0; i < itensDoPacote.size(); i ++) {
            resumo.add(itensDoPacote.get(i) + ": " + valoresInformadosPeloUsuario.get(i));
        }

        return ok(resumoPedido.render(resumo));
    }

    public Result onPostResumo(){
        DynamicForm requestData = formFactory.form().bindFromRequest();
        
        String locOrigem = requestData.get("locOrigem");
        String locDestino= requestData.get("locDestino");

        //TODO
        //Criar o pedido
        //Armazenar as informações do pacote e do usuario no pedido
        //Persistir Pedido
        return ok("Seu pedido foi realizado. Aguarde o envio das propostas das funerarias.");
    }
}