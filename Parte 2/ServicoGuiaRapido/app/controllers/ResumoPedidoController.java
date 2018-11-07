package controllers;

import java.util.*;
import play.mvc.*;
import views.html.*;
import models.entidades.*;
import models.Fachada;
import javax.inject.*;
import play.data.*;



public class ResumoPedidoController extends Controller {
    private FormFactory formFactory;
    private String nomePacote;
    private String valorDesejado;
    private int idCliente = 1;
    private Fachada fachada;

    @Inject
    public ResumoPedidoController(FormFactory formFactory) {
        this.formFactory = formFactory;
        this.fachada = Fachada.obterInstancia();
    }

    public Result indexResumo(String valorDesejado, String nomePacote) {
        ArrayList<String> resumo = new ArrayList<String>();
        Fachada fachada = Fachada.obterInstancia();
        ArrayList<String> itensDoPacote = fachada.getItensPacote();
        ArrayList<String> valoresInformadosPeloUsuario = fachada.getValoresInformados();

        this.nomePacote = nomePacote;
        this.valorDesejado = valorDesejado;

        resumo.add("Valor desejado: " + this.valorDesejado);

        for(int i = 0; i < itensDoPacote.size(); i ++) {
            resumo.add(itensDoPacote.get(i) + ": " + valoresInformadosPeloUsuario.get(i));
        }

        return ok(views.html.tela_resumo_pedido.render(resumo));
    }

    public Result onPostResumo(){
        DynamicForm requestData = formFactory.form().bindFromRequest();
        
        String locOrigem = requestData.get("locOrigem");
        String locDestino= requestData.get("locDestino");

        
        Pedido novoPedido = new Pedido();
        Pacote pacote = this.fachada.obterPacote(this.nomePacote);

        novoPedido.pacote = pacote;
        novoPedido.idCliente = this.idCliente;
        novoPedido.orcamento = Double.valueOf(this.valorDesejado);
        novoPedido.localizacaoOrigem = locOrigem;
        novoPedido.localizacaoDestino = locDestino;

        this.fachada.armazenarPedido(novoPedido);
    
        String mensagem = "Seu pedido foi realizado. Aguarde o envio das propostas das funerarias.";
        return ok(views.html.tela_mensagem.render(mensagem));
    }
}