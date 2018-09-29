package controllers;

import play.mvc.*;
import java.util.*;
import models.*;
import views.html.*;
import play.data.*;
import javax.inject.*;

public class GuiaRapidoController extends Controller{

    private FormFactory formFactory;

    @Inject
    public GuiaRapidoController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    public Result index() {
        return ok(views.html.guiarapido.render());
    }

    public Result onPost() {
        DynamicForm requestData = formFactory.form().bindFromRequest();
        String firstname = requestData.get("localizacao");
        String lastname = requestData.get("lastname");
        return ok("Hello " + firstname + " " + lastname);
    }

}