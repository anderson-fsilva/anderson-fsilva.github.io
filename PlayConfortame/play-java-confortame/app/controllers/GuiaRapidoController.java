package controllers;

import play.mvc.*;
import java.util.*;
import models.*;
import views.html.*;
import play.data.*;
import javax.inject.*;

public class GuiaRapidoController extends Controller{
    private FormFactory formFactory;
    private Fachada fachada;
    private ArrayList<Pacote> listaPacotes;
  
    @Inject
    public GuiaRapidoController(FormFactory formFactory) {
        this.formFactory = formFactory;
        this.fachada = Fachada.obterInstancia();
    }

    public Result index() {
        return ok(views.html.guiarapido.render());
    }

    public Result onPost() {
        DynamicForm requestData = formFactory.form().bindFromRequest();
        
        String localizacaoOrigem = requestData.get("localizacaoOrigem");
        String localizacaoDestino = requestData.get("localizacaoDestino");
        String valorDesejadoString = requestData.get("valorDesejado");
        Double valorDesejado = Double.valueOf(valorDesejadoString);

        return this.exibirPacotesAcessiveis(valorDesejado);
    }

    public Result obterInfoPacote(String nomePacote) {


        return ok(nomePacote);
    }


    public Result exibirPacotesAcessiveis(Double valor) {
        this.listaPacotes = this.fachada.exibirPacotesAcessiveis(valor);
		return ok(list.render(listaPacotes));
    }



}