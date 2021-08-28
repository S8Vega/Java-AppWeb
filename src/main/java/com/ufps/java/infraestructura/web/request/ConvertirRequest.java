package com.ufps.java.infraestructura.web.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConvertirRequest {

    private String nombreArchivo;
    private String extencionFuente;
    private String extencionDestino;
    private String base64;

}
