/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cidenet.util;

/**
 *
 * @author DarkJack
 */
public class Letras {

    public boolean soloLetras(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.toUpperCase().charAt(i);
            int valorASCII = (int) caracter;

            if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90)) {
                return false; //Se ha encontrado un caracter que no es letra
            }
        }
        return true;
    }

    public String caracteresEspeciales(String nombre) {

        String resultado;

        resultado = nombre.toLowerCase().replace("ü", "u");
        resultado = resultado.replace("ñ", "n");
        resultado = resultado.replace("á", "a");
        resultado = resultado.replace("é", "e");
        resultado = resultado.replace("í", "i");
        resultado = resultado.replace("ó", "o");
        resultado = resultado.replace("ú", "u");

        return resultado;
    }

    public boolean letrasIdentificacion(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.toUpperCase().charAt(i);
            int valorASCII = (int) caracter;

            if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90)) {
                if (valorASCII < 48 || valorASCII > 57) {
                    if (valorASCII != 45) {
                        return false; //Se ha encontrado un caracter que no es letra        
                    }

                }
            }
        }
        return true;
    }

    public boolean letrasEspacio(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.toUpperCase().charAt(i);
            int valorASCII = (int) caracter;

            if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90)) {

                if (valorASCII != 32) {
                    return false; //Se ha encontrado un caracter que no es letra        
                }

            }
        }
        return true;
    }
}
