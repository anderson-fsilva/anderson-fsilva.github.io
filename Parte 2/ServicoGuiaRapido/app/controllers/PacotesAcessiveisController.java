/*
    Nesse controller, o usuário escolherá um dos pacotes disponíveis para a customização no próximo passo.
*/
package controllers;

import play.mvc.*;
import java.util.*;
import models.entidades.Pacote;
import models.Fachada;
import views.html.*;
import play.data.*;
import javax.inject.*;
import play.Logger;
import play.libs.Json;
import com.fasterxml.jackson.databind.ObjectMapper;
import play.libs.ws.*;
import java.util.concurrent.CompletionStage;

public class PacotesAcessiveisController extends Controller implements WSBodyReadables, WSBodyWritables  {
    private FormFactory formFactory;
    private Fachada fachada;
    private List<Pacote> listaPacotes;
    private String locOrigem, locDestino, valorDesejado;
    private String nome_pacote;
    private final WSClient ws;
    private ObjectMapper mapper;

    private String jsonTest = "[{\"id\":1,\"nome\":\"Simples\",\"urnas\":1,\"coroaFlores\":1,\"transmissaoWeb\":false,\"buffet\":false,\"outros\":\"\",\"transladoNacional\":true,\"transladoInternacional\":false,\"valorPacote\":900.0,\"descricao\":\"Este pacote permite a escolha de uma urna e uma coroa de flores.\"},{\"id\":2,\"nome\":\"Intermediario\",\"urnas\":1,\"coroaFlores\":2,\"transmissaoWeb\":false,\"buffet\":true,\"outros\":\"\",\"transladoNacional\":true,\"transladoInternacional\":true,\"valorPacote\":1500.0,\"descricao\":\"Este pacote permite a escolha de até duas urnas, duas coroa de flores, buffete e translado internacional\"}]";
    private String jsonTest2 = "[{\"id\":1,\"nome\":\"Simples\",\"urnas\":1,\"coroaFlores\":1,\"transmissaoWeb\":false,\"buffet\":false,\"outros\":\"\",\"transladoNacional\":true,\"transladoInternacional\":false,\"valorPacote\":900.0,\"descricao\":\"Este pacote permite a escolha de uma urna e uma coroa de flores.\"}]";
    private String jsonTest3 = "{}";

    @Inject
    public PacotesAcessiveisController (FormFactory formFactory, WSClient ws) {
        this.formFactory = formFactory;
        this.fachada = Fachada.obterInstancia();
        this.mapper = new ObjectMapper();
        this.ws = ws;
    }

    public CompletionStage<Result> exibirPacotesAcessiveis(String valor) {
        this.valorDesejado = valor;

        return ws.url("http://localhost:9000/pacoteJson")
                  .addQueryParameter("valor", this.valorDesejado).get()
                  .thenApply(response -> {
            jsonTest3 = response.getBody();
            try {
              listaPacotes = Arrays.asList(mapper.readValue(jsonTest3, Pacote[].class));
            } catch (Exception e) {
              return ok("Erro na Requisição do JSON");
            }

            return ok(views.html.tela_pacotes_disponiveis.render(listaPacotes));
        });
    }

    public Result customizarPacote() {
        DynamicForm requestData = formFactory.form().bindFromRequest();

        this.nome_pacote = requestData.get("nome_pacote");

        return redirect(routes.CustomizarPedidoController.indexCustomizar(nome_pacote, this.valorDesejado));
    }

}