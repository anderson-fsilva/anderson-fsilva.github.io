package controllers;

import play.mvc.*;
import java.util.*;
import models.*;
import models.entidades.Usuario;
import views.html.*;
import play.data.*;
import javax.inject.*;


public class CadastroController extends Controller {

    private FormFactory formFactory;
    private Usuario usuario;

    @Inject
    public CadastroController(FormFactory formFactory) {
        this.formFactory = formFactory;
		this.usuario = new Usuario();
    }

    public Result index() {
        Form<Usuario> usuarioForm = formFactory.form(Usuario.class);
        return ok(views.html.cadastro.render(usuarioForm));
    }
    public Result save(){
        return ok("Usuario cadastrado com Sucesso!");
    }
}
