/*
    Controller para inicio do guia rápido, serão informados as localizações e o valor desejado que o usuário quer pagar.
*/
package controllers;

import play.mvc.*;
import java.util.*;
import models.entidades.Pacote;
import models.Fachada;
import views.html.*;
import play.data.*;
import javax.inject.*;

public class GuiaRapidoController extends Controller{
    private FormFactory formFactory;
    private Fachada fachada;
    private ArrayList<Pacote> listaPacotes;
    private String localizacaoOrigem, localizacaoDestino, valorDesejadoString, opcaoUrna, opcaoCoroa;
  
    @Inject
    public GuiaRapidoController(FormFactory formFactory) {
        this.formFactory = formFactory;
        this.fachada = Fachada.obterInstancia();
    }

    public Result index() {
        return ok(views.html.tela_guia_rapido.render());
    }

    public Result onPost() {
        DynamicForm requestData = formFactory.form().bindFromRequest();
        this.valorDesejadoString = requestData.get("value");
        return redirect(routes.PacotesAcessiveisController.exibirPacotesAcessiveis(this.valorDesejadoString));
    }
 


}