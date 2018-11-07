package controllers;

import play.mvc.*;

public class PreSepultamentoController extends Controller {

    public Result index() {
        return ok(views.html.tela_procedimento_presepultamento.render());
    }

    public Result onPost() {
        return redirect(routes.HomeController.index());
    }
}
