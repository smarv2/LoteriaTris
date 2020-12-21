/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.digital.stone.tris.blogic;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Mario Ramirez
 */
public class TrisMainFacade {
    
    protected static final Logger LOG = LogManager.getLogger(TrisMainFacade.class);

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        LOG.info("*** Inicia proceso principal ***");
        
        boolean mostrarDetalles = false;
        //mostrarDetalles = true;        
        //Descarga historico
        DescargaHistoricoTrisFacade descargaHistoricoTrisFacade = new DescargaHistoricoTrisFacade();
        descargaHistoricoTrisFacade.DescargaHistorico();
        
        //Procesa historico
        ProcesaHistoricoFacade procesaHistoricoFacade = new ProcesaHistoricoFacade();
        procesaHistoricoFacade.ProcesaHitorico(mostrarDetalles);
        
        LOG.info("*** Termina proceso principal ***");
        
    }
    
}
