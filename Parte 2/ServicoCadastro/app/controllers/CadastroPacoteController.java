package controllers;

import play.mvc.*;
import java.util.*;
import models.*;
import models.entidades.*;
import views.html.*;
import play.data.*;
import javax.inject.*;

public class CadastroPacoteController extends Controller {
    private FormFactory formFactory;
    private Fachada fachada;

    @Inject
    public CadastroPacoteController(FormFactory formFactory){
        this.formFactory = formFactory;
        this.fachada = Fachada.obterInstancia();
    }

    public Result index() {
        return ok(views.html.tela_cadastro_pacote.render());
    }

    public Result onPost() {
        DynamicForm requestData = formFactory.form().bindFromRequest();

        String nomePacote = requestData.get("name");
        String valorPacote = requestData.get("value");
        String descricaoPacote = requestData.get("description");

        Pacote pacote = new Pacote();
        pacote.nome = nomePacote;
        pacote.valorPacote = Double.valueOf(valorPacote);
        pacote.descricao = descricaoPacote;

        this.fachada.cadastrarPacote(pacote);
        
        String mensagemSucesso = "Pacote cadastrado com Sucesso!";
        return ok(views.html.tela_mensagem.render(mensagemSucesso));
    }

}
