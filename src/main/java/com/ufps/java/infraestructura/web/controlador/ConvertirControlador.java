package com.ufps.java.infraestructura.web.controlador;

import com.ufps.java.dominio.modelo.Archivo;
import com.ufps.java.dominio.usecase.ConvertirUseCase;
import com.ufps.java.infraestructura.configuracion.BeanConfiguracion;
import com.ufps.java.infraestructura.web.request.ConvertirRequest;
import com.ufps.java.infraestructura.web.response.ConvertirResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/convertir")
public class ConvertirControlador {

    private ConvertirUseCase convertirUseCase;
    private ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguracion.class);

    @PostMapping
    public ResponseEntity<ConvertirResponse> convertir(@RequestBody ConvertirRequest request) throws Exception {
        convertirUseCase = (ConvertirUseCase) context.getBean(getBean(request.getExtencionFuente(), request.getExtencionDestino()));
        Archivo archivo = convertirUseCase.ejecutar(
                Archivo.builder()
                        .nombre(request.getNombreArchivo())
                        .base64(request.getBase64())
                        .build()
        );
        ConvertirResponse response = ConvertirResponse.builder()
                .nombreArchivo(archivo.getNombre())
                .base64(archivo.getBase64())
                .build();
        return ResponseEntity.ok(response);
    }

    private String getBean(String fuente, String destino) {
        return fuente.toUpperCase().concat("_").concat(destino.toUpperCase());
    }

}
