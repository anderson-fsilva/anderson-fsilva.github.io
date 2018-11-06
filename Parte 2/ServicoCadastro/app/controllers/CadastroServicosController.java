package controllers;

import play.mvc.*;
import java.util.*;
import models.*;
import models.entidades.*;
import views.html.*;
import play.data.*;
import javax.inject.*;

public class CadastroServicosController extends Controller {
    private FormFactory formFactory;
    private Fachada fachada;

    @Inject
    public CadastroServicosController(FormFactory formFactory){
        this.formFactory = formFactory;
        this.fachada = Fachada.obterInstancia();
    }

    public Result index(String cnpj) {
        Form<Funeraria> formFuneraria = formFactory.form(Funeraria.class);
        Funeraria funeraria = formFuneraria.bindFromRequest().get();
        
        return ok(views.html.tela_cadastro_servicos.render(cnpj));
    }

    public Result onPost() {
        DynamicForm requestData = formFactory.form().bindFromRequest();

        Boolean cremacao  = requestData.get("cremacao") != null;
        Boolean sepultamento = requestData.get("sepultamento") != null;  
        Boolean coroaDeFlores = requestData.get("coroaDeFlores") != null;
        Boolean buffet = requestData.get("buffet") != null;;
        Boolean web = requestData.get("web") != null;;
        Boolean transladoInternacional = requestData.get("transladoInternacional") != null;;
        
        String cnpj = requestData.get("cnpj");

        this.fachada.cadastrarServicosFuneraria(cnpj,cremacao,sepultamento,coroaDeFlores,buffet,web,transladoInternacional  );

        String mensagemSucesso = "Funerária cadastrada com Sucesso!";
        return ok(views.html.tela_mensagem.render(mensagemSucesso));
    }
    

}