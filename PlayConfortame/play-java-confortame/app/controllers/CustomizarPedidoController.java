package controllers;

import java.util.*;
import play.mvc.*;
import views.html.*;
import models.entidades.Pacote;
import models.Fachada;
import play.data.*;
import javax.inject.*;
import play.Logger;



public class CustomizarPedidoController extends Controller {

    private FormFactory formFactory;
    private String opcaoUrna, opcaoCoroa;
    private String locOrigem, locDestino, valorDesejado;
    private ArrayList<String> itensDoPacote;
    private Fachada fachada;


    @Inject
    public CustomizarPedidoController(FormFactory formFactory) {
        this.formFactory = formFactory;
        this.fachada = Fachada.obterInstancia();
    }



    public Result indexCustomizar(String nome_pacote, String locOrigem, String locDestino, String valorDesejado) {
        this.locDestino = locDestino;
        this.locOrigem = locOrigem;
        this.valorDesejado = valorDesejado;
        
        Fachada fachada = Fachada.obterInstancia();

        // Objeto para armazenar todos os itens presentes no pacote escolhido. Isso será utilizado para disponibilizar as 
        // opções na tela de customização dos pacotes.
        this.itensDoPacote = fachada.exibirDetalhesPacote(nome_pacote);

    
        return ok(views.html.customizarPedido.render(nome_pacote, itensDoPacote));
    }




    public Result onPostCustomizar() {
        DynamicForm requestData = formFactory.form().bindFromRequest(); // Necessário para pegarmos os campos informados pelo usuário.
        ArrayList<String> valoresInformados = new ArrayList<String>();  // Armazenará os valores informados pelo usuário.

        // Pecorrendo a lista que contém os itens do pacote escolhido.
        for(String item : this.itensDoPacote) {
                 
            valoresInformados.add(requestData.get(item));  // Para cada item, será obtido o valor informado pelo usuário          
        }

        // Guardando os valores na fachada (melhor forma encontrada para armazenar temporariamente esses dados do ArrayList).
        fachada.setItensPacote(this.itensDoPacote);
        fachada.setValoresInformados(valoresInformados);
        

        return redirect(routes.ResumoPedidoController.indexResumo(this.locOrigem, this.locDestino, this.valorDesejado));
    }
    

}