package controllers;

import play.mvc.*;
import java.util.*;
import models.*;
import models.entidades.*;
import views.html.*;
import play.data.*;
import javax.inject.*;
import play.libs.Json;

public class PacoteJSONController extends Controller {
    private Fachada fachada;

    @Inject
    public PacoteJSONController(){
        this.fachada = Fachada.obterInstancia();
    }

    //Formula JSON com os Pacotes Acessiveis de acordo com o Valor
    public Result index(String valor) {
        ArrayList<Pacote> pacotes = this.fachada.obterPacotesAcessiveis(Double.valueOf(valor));
        return ok(Json.toJson(pacotes));
    }



}
