package controllers;

import play.mvc.*;

public class HomeController extends Controller {

    public Result index() {
        return ok(views.html.tela_usuario_logado.render());
    }

}
