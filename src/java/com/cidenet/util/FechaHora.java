/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cidenet.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author DarkJack
 */
public class FechaHora {

    Date date = Calendar.getInstance().getTime();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public String fecha() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        String dateString = sdf.format(date);
        return dateString;
    }

    public String hora() {
        SimpleDateFormat sdfHora = new SimpleDateFormat("hh:mm:ss");
        String horaString = sdfHora.format(date);
        return horaString;
    }

    public String fechaCorrecta(String fecha) {
        String dia = fecha.substring(3, 5);
        String mes = fecha.substring(0, 2);
        String anio = fecha.substring(6, 10);
        String fechaCompleta = anio + "-" + mes + "-" + dia;

        LocalDate fechaInicial = LocalDate.parse(fechaCompleta);

        LocalDate fechaMinima = LocalDate.now().minusMonths(1);
        if (fechaInicial.isBefore(fechaMinima)) {
            return "MENOR";
        } else if (fechaInicial.isAfter(LocalDate.now())) {
            return "MAYOR";
        } else {
            return "OK";
        }
    }

    public String ordenarFecha(String fecha) {
        String dia = fecha.substring(3, 5);
        String mes = fecha.substring(0, 2);
        String anio = fecha.substring(6, 10);
        String fechaCompleta = dia + "/" + mes + "/" + anio;
        return fechaCompleta;
    }
}
