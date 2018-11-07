package controllers;

import play.mvc.*;
import java.util.*;
import models.*;
import models.entidades.*;
import views.html.*;
import play.data.*;
import javax.inject.*;

public class CadastroFunerariaController extends Controller {
    private FormFactory formFactory;
    private Fachada fachada;

    @Inject
    public CadastroFunerariaController(FormFactory formFactory) {
        this.formFactory = formFactory;
        this.fachada = Fachada.obterInstancia();
    }

    public Result index() {
        Form<Funeraria> formFuneraria = formFactory.form(Funeraria.class);
        return ok(views.html.tela_cadastro_funeraria.render());
    }

    public Result onPost() {
        DynamicForm requestData = formFactory.form().bindFromRequest();
        Funeraria funeraria = new Funeraria();

        funeraria.nome = requestData.get("name");
        funeraria.cnpj = requestData.get("cnpj");
        funeraria.telefone = requestData.get("telephone");
        funeraria.endereco = requestData.get("address");
        funeraria.cep = requestData.get("cep");
        funeraria.cidade = requestData.get("city");
        funeraria.estado = requestData.get("state");
        funeraria.email = requestData.get("email");

        Boolean cadastroSucedido = false;
        cadastroSucedido = this.fachada.cadastrarFuneraria(funeraria);

        if (!cadastroSucedido) {
            String mensagemErro = "CNPJ Invalido, por favor recomece o cadastro.";
            return ok(views.html.tela_mensagem.render(mensagemErro));
        }

        return redirect(routes.CadastroServicosController.index(funeraria.cnpj));
    }

}