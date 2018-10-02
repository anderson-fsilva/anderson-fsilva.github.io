package models.repositorios;

import models.repositorios.pacote.IRepositorioPacote;
import models.repositorios.funeraria.IRepositorioFuneraria;
import models.repositorios.pacote.RepositorioPacoteBDR;
import models.repositorios.funeraria.RepositorioFunerariaBDR;

public class FabricaRepositorioBDR implements FabricaInterface {
    
    public IRepositorioPacote makeRepPacote(){
        return new RepositorioPacoteBDR();
    }
    
    public IRepositorioFuneraria makeRepFuneraria(){
        return new RepositorioFunerariaBDR();
    }
    
}