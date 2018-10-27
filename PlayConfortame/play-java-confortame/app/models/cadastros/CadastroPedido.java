package models.cadastros;

import java.util.*;

import models.entidades.Pedido;
import models.repositorios.FabricaInterface;
import models.repositorios.FabricaRepositorioBDR;
import models.repositorios.pedido.IRepositorioPedido;
import models.repositorios.pedido.RepositorioPedidoBDR;

public class CadastroPedido{
    private IRepositorioPedido repPedido;

    public CadastroPedido(FabricaInterface fabrica) {
        repPedido = fabrica.makeRepPedido();
    }

    //atualizar pedido
    public void atualizarPedido(Pedido pedido){
        repPedido.save(pedido);
    }
    
    //remover pedido pelo id
    public void removerPedido(long id){
        if(repPedido.findId(id) != null){
            repPedido.delete(id);
        }
    }
    
    //obter pedido pelo id
    public Pedido recuperarPedido(long id){
        return repPedido.findId(id);
    }
    
    //obter todos os pedidos
    public List<Pedido> recuperarPedidos(){
        return repPedido.all();
    }

}