/*
    Controller responsável para fazer a seleção de qual guia o usuário vai querer: guia rápido ou completo.
*/



package controllers;

import play.mvc.*;


public class SelecaoGuiaController extends Controller {


    public Result index() {
       
        return ok(views.html.selecaoGuia.render());
    } 

}