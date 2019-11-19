/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.tris.facade;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 *
 * @author smarv
 */
public class DescargaHistoricoTrisFacade {
    
        public void DescargaHistorico(){
            System.out.println("** Inicia descarga de archivo con historicos **");
            try {    
            
                //URL url2 = new URL("https://www.pronosticos.gob.mx/Documentos/Historicos/Tris.csv");
                URL url2 = new URL("");
                InputStream in = new BufferedInputStream(url2.openStream());
                OutputStream out = new BufferedOutputStream(new FileOutputStream("tris.csv"));

                for ( int i; (i = in.read()) != -1; ) {
                out.write(i);
                }
                in.close();
                out.close();
        
            } catch (Exception e) {
                System.err.println("error al descargar el archivo historico: " + e);
            }   
            System.out.println("** Termina descarga de archivo con historicos **");
        }
    

    
}
