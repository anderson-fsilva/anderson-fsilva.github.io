package models.repositorios;

import models.repositorios.funeraria.IRepositorioFuneraria;
import models.repositorios.funeraria.RepositorioFunerariaBDR;

public class FabricaRepositorioBDR implements FabricaInterface {
    
    public IRepositorioFuneraria makeRepFuneraria(){
        return new RepositorioFunerariaBDR();
    }
    
}