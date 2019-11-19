/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.tris.facade;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MXI01020253A
 */
public class TrisMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        System.out.println("*** Inicia proceso principal ***");
        
        //Descarga historico
        DescargaHistoricoTrisFacade descargaHistoricoTrisFacade = new DescargaHistoricoTrisFacade();
        descargaHistoricoTrisFacade.DescargaHistorico();
        
        //Procesa historico
        ProcesaHistoricoFacade procesaHistoricoFacade = new ProcesaHistoricoFacade();
        procesaHistoricoFacade.ProcesaHitorico();
        
        System.out.println("*** Termina proceso principal ***");

    }
    
}
