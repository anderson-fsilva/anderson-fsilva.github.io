package models.repositorios;

import models.repositorios.pacote.RepositorioPacote;
import models.repositorios.funeraria.RepositorioFuneraria;
import models.repositorios.pacote.RepositorioPacoteBDR;
import models.repositorios.funeraria.RepositorioFunerariaBDR;

class FabricaRepositorioBDR implements FabricaInterface {
    
    public RepositorioPacote makeRepPacote(){
        return new RepositorioPacoteBDR();
    }
    
    public RepositorioFuneraria makeRepFuneraria(){
        return new RepositorioFunerariaBDR();
    }
    
}