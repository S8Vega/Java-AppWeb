package com.ufps.java.infraestructura.web.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConvertirResponse {

    private String nombreArchivo;
    private String base64;

}
