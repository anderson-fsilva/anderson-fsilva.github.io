package models.entidades;

import java.util.*;




public class Usuario {

    private String nome;
    private String login;
    private String senha;
    private String email;
    private String telefone; 

    private static ArrayList<Usuario> usuarios = new ArrayList();


    public Usuario () {
        //
    }

    public Usuario (String nome) {
        this.nome = nome;
    }

    public void addCliente(Usuario usuario) {
       Usuario.usuarios.add(usuario);
    }

    public String getNome() {
        return this.nome;
    }

    public ArrayList<Usuario> getAllUsuarios() {
        return this.usuarios;
    }

}

