package controllers;

import play.mvc.*;
import java.util.*;
import models.*;
import views.html.*;
import play.data.*;
import javax.inject.*;


public class CadastroController extends Controller {

    private FormFactory formFactory;
    private Cliente cliente;

    @Inject
    public CadastroController(FormFactory formFactory) {
        this.formFactory = formFactory;
		this.cliente = new Cliente();
    }

    
    public Result index() {
        Form<Cliente> clienteForm = formFactory.form(Cliente.class);
        return ok(views.html.cadastro.render(clienteForm));
    }
    public Result save(){
        return ok("Usuario cadastrado com Sucesso!");
    }
}
