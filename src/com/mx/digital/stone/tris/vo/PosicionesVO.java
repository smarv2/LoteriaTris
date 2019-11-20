/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.digital.stone.tris.vo;

/**
 *
 * @author smarv
 */
public class PosicionesVO implements Comparable<PosicionesVO> {
    
    private int posicion;
    private int numero;
    private int repeticiones;
    
    /*public PosicionesVO (int posicion, int numero, int repeticiones){
        this.posicion = posicion;
        this.numero = numero;
        this.repeticiones = repeticiones;
    }*/

    /**
     * @return the posicion
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * @param posicion the posicion to set
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the repeticiones
     */
    public int getRepeticiones() {
        return repeticiones;
    }

    /**
     * @param repeticiones the repeticiones to set
     */
    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    @Override
    public int compareTo(PosicionesVO o) {
        if(o.getRepeticiones() > repeticiones){
            return -1;
        }else if(o.getRepeticiones() > repeticiones){
            return 0;
        }else{
            return 1;
        }
    }

    
    
}
