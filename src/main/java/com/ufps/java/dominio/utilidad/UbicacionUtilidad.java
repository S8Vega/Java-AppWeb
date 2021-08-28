package com.ufps.java.dominio.utilidad;

import java.io.File;

public class UbicacionUtilidad {

    public static String getUbicacion() {
        File archivo = new File("");
        return archivo.getAbsolutePath().concat("/");
    }

}
