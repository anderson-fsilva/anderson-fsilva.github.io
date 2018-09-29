package models;

import java.util.*;

public class Cliente {

    private String nome;
    private static ArrayList<Cliente> clientes = new ArrayList();


    public Cliente () {
        //
    }

    public Cliente (String nome) {
        this.nome = nome;
    }

    public void addCliente(Cliente cliente) {
       Cliente.clientes.add(cliente);
    }

    public String getNome() {
        return this.nome;
    }

    public ArrayList<Cliente> getAllClientes() {
        return this.clientes;
    }

}

