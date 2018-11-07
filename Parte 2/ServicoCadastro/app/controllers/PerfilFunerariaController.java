package controllers;

import play.mvc.*;


public class PerfilFunerariaController extends Controller {

    public Result index() {
        return ok(views.html.tela_perfil_funeraria.render());
    }

}
