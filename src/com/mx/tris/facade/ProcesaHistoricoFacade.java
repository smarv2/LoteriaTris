/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.tris.facade;

import com.mx.tris.vo.PosicionesVO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author smarv
 */
public class ProcesaHistoricoFacade {
    
    public void ProcesaHitorico(){
        
        System.out.println("** Inicia procesamiento de registros **");
        
        File archivo = new File("tris.csv");
        if (!archivo.exists()) {
            System.out.println("¡¡No existe el archivo de historicos.!!");
        } else {        
            System.out.println("Existe el archivo de historicos.");
            List<String> listaCadenas = new ArrayList<String>();

            //Leer archivo
            listaCadenas = leerArchivo();

            try {
                procesarLista(listaCadenas);    
            } catch (Exception e) {
                System.err.println("Error  al procesar registros: " + e);
            }
        
        }
        System.out.println("** Termina procesamiento de registros **");
    }
    
    /**
     * Metodo procesarLista
     * @param listaCadenas {@code List<String>}
     */
    public static void procesarLista(List<String> listaCadenas){
        List<PosicionesVO> listaPosiciones;
        for(int i = 1; i <= 5; i = i + 1){
                //System.out.println("indice: " + i);
                int ini = i-1;
                int fin = i;
                System.out.println("PROCESANDO POSICION " + fin);

                String cadenaFinal = "";
                for(String numero : listaCadenas){
                   cadenaFinal = cadenaFinal + numero.substring(ini, fin);
                }
                //System.out.println("Cadena final: " + cadenaFinal);
                listaPosiciones = obtenerRepeticiones(cadenaFinal, fin);
                //System.out.println("*************************");
                
                //muestra resultados
                mostrarResultados(listaPosiciones);
                
        }
    }
    
    public static List<PosicionesVO> obtenerRepeticiones(String num, int posicion){
        
        List<PosicionesVO> listaPosiciones = new ArrayList<PosicionesVO>();
        
    //String num = String.valueOf(n);
        for(int d = 0; d < 10; d++) {
            int rep = 0;
            for(int i = 0; i < num.length(); i++) {
                if(Integer.valueOf(String.valueOf(num.charAt(i))) == d) {
                    rep++;
                }
            }
            if(rep > 0) {
                System.out.println(String.format("El número %d se repite %d %s", d, rep, (rep == 1 ? "vez" : "veces")));
                //System.out.println("posicion: "+ posicion + " numero: " + d + " repeticiones: " + rep);
                PosicionesVO posicionesVO = new PosicionesVO();
                posicionesVO.setPosicion(posicion);
                posicionesVO.setNumero(d);
                posicionesVO.setRepeticiones(rep);
                listaPosiciones.add(posicionesVO);
            }
        }
        return listaPosiciones;
    }
    
    /*static List<String> obtenerArchivo(String archivo) throws FileNotFoundException, IOException {
      String cadena;
      FileReader f = new FileReader(archivo);
      BufferedReader b = new BufferedReader(f);
      List<String> listaCadenas = new ArrayList<>();
      while((cadena = b.readLine())!=null) {
          //System.out.println(cadena);
          listaCadenas.add(cadena);
      }
      b.close();
      
      return listaCadenas;
    }*/
    
    public List<String> leerArchivo(){
        
        List<String> listaResultados = new ArrayList<String>();
        System.out.println("** Inicia lectorua de archivo csv **");
        String csvFile = "tris.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                
                // use comma as separator
                String[] tris = line.split(cvsSplitBy);
                
                if(!tris[0].equalsIgnoreCase("NPRODUCTO")){
                    //System.out.println("Country [code= " + tris[4] + " , name=" + tris[5] + "]");
                    //System.out.println("Tris [R1= " + tris[2] + ", R2=" + tris[3] + ", R3=" + tris[4] + ", R4=" + tris[5] + ", R5=" + tris[6]+ "]");
                    try {
                        if(Integer.parseInt(tris[1]) >= 11033){
                            String resultado =  tris[2] +  tris[3] +  tris[4] +  tris[5] +  tris[6];
                            //System.out.println("resultado: " + resultado);
                            listaResultados.add(resultado);
                        }
                    } catch (Exception e) {
                        System.err.println("error: " + e);
                    }
                } 
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return listaResultados;
        
    }
    
    private static void mostrarResultados(List<PosicionesVO> listaPosiciones) {
        Collections.sort(listaPosiciones, (PosicionesVO p1, PosicionesVO p2) -> new Integer(p2.getRepeticiones()).compareTo(new Integer(p1.getRepeticiones())) // Aqui esta el truco, ahora comparamos p2 con p1 y no al reves como antes
        );
    }
    
}
