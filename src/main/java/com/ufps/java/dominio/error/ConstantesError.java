package com.ufps.java.dominio.error;

public class ConstantesError {

    public static final String NO_INSTANCIA = "No se puede instanciar esta clase.";
    public static final String NO_SE_PUEDE_CONVERTIR_A_ARCHIVO = "No se pudo convertir de base64 a archivo.";

    private ConstantesError() {
        throw new IllegalStateException(ConstantesError.NO_INSTANCIA);
    }

}
