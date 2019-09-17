/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author MXI01020253A
 */
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        List<String> listaCadenas = new ArrayList<String>();
        
        //Leer un archivo
        String archivoTris = "C:\\Tris\\tris.txt";
        listaCadenas = obtenerArchivo(archivoTris);
        procesarLista(listaCadenas);
    }
    
    public static void procesarLista(List<String> listaCadenas){
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
                contarRepeticiones(cadenaFinal);
                System.out.println("*************************");
        }
    }
    
    public static void contarRepeticiones(String num){
        
    //String num = String.valueOf(n);
        for(int d = 0; d < 10; d++) {
            int rep = 0;
            for(int i = 0; i < num.length(); i++) {
                if(Integer.valueOf(String.valueOf(num.charAt(i))) == d) {
                    rep++;
                }
            }
            if(rep > 0) {
                System.out.println(
                    String.format("El número %d se repite %d %s", 
                                  d, rep, (rep == 1 ? "vez" : "veces"))
                );
            }
        }
    }
    
    static List<String> obtenerArchivo(String archivo) throws FileNotFoundException, IOException {
      String cadena;
      FileReader f = new FileReader(archivo);
      BufferedReader b = new BufferedReader(f);
      List<String> listaCadenas = new ArrayList<String>();
      while((cadena = b.readLine())!=null) {
          //System.out.println(cadena);
          listaCadenas.add(cadena);
      }
      b.close();
      
      return listaCadenas;
    }
    
}
