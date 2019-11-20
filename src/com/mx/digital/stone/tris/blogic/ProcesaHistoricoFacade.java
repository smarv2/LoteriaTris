/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.digital.stone.tris.blogic;


import com.mx.digital.stone.tris.vo.PosicionesVO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author smarv
 */
public class ProcesaHistoricoFacade {
    
    protected static final Logger LOG = Logger.getLogger(ProcesaHistoricoFacade.class);
    
    public void ProcesaHitorico(boolean mostrarDetalles){
        
        LOG.info("** Inicia procesamiento de registros **");
        List<String> listaCadenas = null;
        List<List<PosicionesVO>> listadelistaPosiciones;
        File archivo = new File("tris.csv");
        if (!archivo.exists()) {
            LOG.info("¡¡No existe el archivo de historicos.!!");
        } else {        
            LOG.info("Existe el archivo de historicos.");
            listaCadenas = new ArrayList<String>();

            //Leer archivo
            listaCadenas = leerArchivo();

            try {
                listadelistaPosiciones = procesarLista(listaCadenas);    
                imprimirLista(listadelistaPosiciones, mostrarDetalles);
            } catch (Exception e) {
                LOG.error("Error  al procesar registros: " + e);
            }
        
        }
        LOG.info("** Termina procesamiento de registros **");
        
        
 
        
        /*ArrayList<Empleado> empleados = new ArrayList<>();
 
        Empleado e1 = new Empleado("fer1", "ure1", 60, 1500);
        Empleado e2 = new Empleado("fer2", "ure2", 50, 2000);
        Empleado e3 = new Empleado("fer3", "ure3", 42, 1000);
 
        empleados.add(e1);
        empleados.add(e2);
        empleados.add(e3);
         
        Collections.sort(empleados);
         
        for(Empleado aux: empleados){
            System.out.println(aux);
        }*/
    }
    
    /**
     * Metodo procesarLista
     * @param listaCadenas {@code List<String>}
     * @return 
     */
    public static List<List<PosicionesVO>> procesarLista(List<String> listaCadenas){
        List<List<PosicionesVO>> listadelistaPosiciones = new ArrayList<List<PosicionesVO>>();
        LOG.info("PROCESANDO POSICIONES.");
        for(int i = 1; i <= 5; i = i + 1){
                List<PosicionesVO> listaPosiciones;
                //System.out.println("indice: " + i);
                int ini = i-1;
                int fin = i;
                //LOG.info("PROCESANDO POSICION " + fin);

                String cadenaFinal = "";
                for(String numero : listaCadenas){
                   cadenaFinal = cadenaFinal + numero.substring(ini, fin);
                }
                //System.out.println("Cadena final: " + cadenaFinal);
                listaPosiciones = obtenerRepeticiones(cadenaFinal, fin);
                //System.out.println("*************************");
                
                //muestra resultados
                //mostrarResultados(listaPosiciones);
                
                //Ordena la lista por repeticiones
                Collections.sort(listaPosiciones);
                
                //Agrega lista ordenada
                listadelistaPosiciones.add(listaPosiciones);
        }
        
        return listadelistaPosiciones;
        
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
                //LOG.info(String.format("El número %d se repite %d %s", d, rep, (rep == 1 ? "vez" : "veces")));
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
        LOG.info("** Inicia lectorua de archivo csv **");
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
                        LOG.error("error: " + e);
                    }
                } 
            }

        } catch (FileNotFoundException e) {
            LOG.error("error: " + e);
        } catch (IOException e) {
            LOG.error("error: " + e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    LOG.error("error: " + e);
                }
            }
        }

        return listaResultados;
        
    }
    
    /*private static void mostrarResultados(List<PosicionesVO> listaPosiciones) {
        for(PosicionesVO posicionesVO : listaPosiciones){
            System.out.println("Posicion: " + posicionesVO.getPosicion() + ", numero: " + posicionesVO.getNumero() + ", repeticiones: " + posicionesVO.getRepeticiones());
        }
        
    }    */

    private void imprimirLista(List<List<PosicionesVO>> listadelistaPosiciones, boolean mostrarDetalles) {
        String numeroMasProbable = "";
        String numeroMenosProbable = "";
        
        
        for(List<PosicionesVO> listaPosiciones : listadelistaPosiciones){

            PosicionesVO posicionesMasVO = listaPosiciones.get(listaPosiciones.size() -1 );
            numeroMasProbable = numeroMasProbable + posicionesMasVO.getNumero();
            PosicionesVO posicionesMenosVO = listaPosiciones.get(0);
            numeroMenosProbable = numeroMenosProbable + posicionesMenosVO.getNumero();
            
            if(mostrarDetalles){
                for(PosicionesVO posicionesVO : listaPosiciones){
                LOG.info("Posicion: " + posicionesVO.getPosicion() + ", numero: " + posicionesVO.getNumero() + ", repeticiones: " + posicionesVO.getRepeticiones());
                }
            }
        }
        LOG.info("*** LA COMBINACION MAS PROBABLE ES: " + numeroMasProbable + " ***");
        LOG.info("*** LA COMBINACION MENOS PROBABLE ES: " + numeroMenosProbable + " ***");
    }
    
    
        
    
}
