package com.ufps.java.dominio.modelo;

import com.ufps.java.dominio.error.ConstantesError;
import com.ufps.java.dominio.utilidad.ConstantesUtilidad;
import lombok.Builder;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

@Builder
public class Archivo {

    private String nombre;
    private String base64;
    private File fichero;

    public String getNombre() {
        return nombre;
    }

    public String getNombreSinExtencion() {
        int punto = nombre.lastIndexOf(".");
        return nombre.substring(0, punto);
    }

    public String getBase64() throws IOException {
        if (base64 != null) return base64;
        byte[] bytes = FileUtils.readFileToByteArray(fichero);
        base64 = Base64.getEncoder().encodeToString(bytes);
        return base64;
    }

    public File getFichero() {
        if (fichero != null) return fichero;
        byte[] bytes = Base64.getDecoder().decode(base64);
        try (OutputStream stream = new FileOutputStream(ConstantesUtilidad.DIR.concat(nombre))) {
            stream.write(bytes);
        } catch (Exception e) {
            System.err.println(ConstantesError.NO_SE_PUEDE_CONVERTIR_A_ARCHIVO);
        }
        fichero = new File(ConstantesUtilidad.DIR.concat(nombre));
        return fichero;
    }

}
