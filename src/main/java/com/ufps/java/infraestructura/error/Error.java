package com.ufps.java.infraestructura.error;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Error {
    private String nombre;
    private String mensaje;
}
