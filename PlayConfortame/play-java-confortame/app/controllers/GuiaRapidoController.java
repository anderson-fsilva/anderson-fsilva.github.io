package controllers;

import play.mvc.*;
import java.util.*;
import models.*;
import views.html.*;
import play.data.*;
import javax.inject.*;

public class GuiaRapidoController extends Controller{
    private FormFactory formFactory;
    private Fachada fachada;
    private ArrayList<Pacote> listaPacotes;
    private String localizacaoOrigem, localizacaoDestino, valorDesejadoString, opcaoUrna, opcaoCoroa;
  
    @Inject
    public GuiaRapidoController(FormFactory formFactory) {
        this.formFactory = formFactory;
        this.fachada = Fachada.obterInstancia();
    }

    public Result index() {
        return ok(views.html.guiarapido.render());
    }

    public Result onPost() {
        DynamicForm requestData = formFactory.form().bindFromRequest();
        
        this.localizacaoOrigem = requestData.get("localizacaoOrigem");
        this.localizacaoDestino = requestData.get("localizacaoDestino");
        this.valorDesejadoString = requestData.get("valorDesejado");
        Double valorDesejado = Double.valueOf(valorDesejadoString);

        return this.exibirPacotesAcessiveis(valorDesejado);
    }

    public Result obterInfoPacote(String nomePacote) {
        return ok(this.fachada.exibirDetalhesPacote(nomePacote));
    }

    public Result exibirPacotesAcessiveis(Double valor) {
        this.listaPacotes = this.fachada.exibirPacotesAcessiveis(valor);
		return ok(list.render(listaPacotes));
    }

    public Result indexCustomizar(String nome_pacote) {
        return ok(views.html.customizarPedido.render());
    }

    public Result onPostCustomizar() {
        DynamicForm requestData = formFactory.form().bindFromRequest();
        
        this.opcaoUrna = requestData.get("opcaoUrna");
        this.opcaoCoroa = requestData.get("opcaoCoroa");

        return indexResumo();
    }

    public Result indexResumo() {
        ArrayList<String> resumo = new ArrayList<>();
        resumo.add("Localizacao origem: "+this.localizacaoOrigem);
        resumo.add("Localizacao destino: "+this.localizacaoDestino);
        resumo.add("Valor desejado: "+this.valorDesejadoString);
        resumo.add("Opcao de urna: "+this.opcaoUrna);
        resumo.add("Opcao de coroa de flores: "+this.opcaoCoroa);
        return ok(resumoPedido.render(resumo));
    }

    public Result onPostResumo(){
        return ok("Seu pedido foi realizado. Aguarde o envio das propostas das funerarias.");
    }

}