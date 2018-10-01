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
    private Funeraria funeraria;
    private Fachada fachada;

    @Inject
    public CadastroFunerariaController(FormFactory formFactory) {
        this.formFactory = formFactory;
        this.funeraria = new Funeraria();
        this.fachada = Fachada.obterInstancia();
    }

    public Result index() {
        Form<Funeraria> formFuneraria = formFactory.form(Funeraria.class);
        return ok(views.html.cadastroFuneraria.render(formFuneraria));
    }

    public Result onPost() {
        Form<Funeraria> formFuneraria = formFactory.form(Funeraria.class);
        Funeraria funeraria = formFuneraria.bindFromRequest().get();

        Boolean cadastroSucedido = false;
        cadastroSucedido = this.fachada.cadastrarFuneraria(funeraria);

        if (!cadastroSucedido) {
            return ok("CNPJ Invalido, por favor recomece o cadastro.");
        }

        return redirect(routes.CadastroServicosController.index(funeraria.cnpj));
    }

}