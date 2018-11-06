/*
    Nesse controller, o usuário escolherá um dos pacotes disponíveis para a customização no próximo passo.
*/
package controllers;

import play.mvc.*;
import java.util.*;
import models.entidades.Pacote;
import models.Fachada;
import views.html.*;
import play.data.*;
import javax.inject.*;
import play.Logger;

public class PacotesAcessiveisController extends Controller {
    private FormFactory formFactory;
    private Fachada fachada;
    private ArrayList<Pacote> listaPacotes;
    private String locOrigem, locDestino, valorDesejado;
    private String nome_pacote;

    @Inject
    public PacotesAcessiveisController (FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    public Result exibirPacotesAcessiveis(String valor) {
        this.fachada = Fachada.obterInstancia();
        this.valorDesejado = valor;

        this.listaPacotes = this.fachada.exibirPacotesAcessiveis(Double.valueOf(valor));
		return ok(list.render(listaPacotes));
    }

    public Result customizarPacote() {
        DynamicForm requestData = formFactory.form().bindFromRequest();

        this.nome_pacote = requestData.get("nome_pacote");

        return redirect(routes.CustomizarPedidoController.indexCustomizar(nome_pacote, this.valorDesejado));
    }
}