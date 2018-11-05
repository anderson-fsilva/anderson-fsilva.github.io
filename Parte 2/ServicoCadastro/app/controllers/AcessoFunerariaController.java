package controllers;

import play.mvc.*;


public class AcessoFunerariaController extends Controller {

    public Result index() {
        return ok(views.html.tela_login_funeraria.render());
    }

}
