package com.ufps.java.infraestructura.web.controlador;

import com.ufps.java.dominio.modelo.Archivo;
import com.ufps.java.dominio.usecase.ConvertirUseCase;
import com.ufps.java.infraestructura.configuracion.BeanConfiguracion;
import com.ufps.java.infraestructura.web.request.ConvertirRequest;
import com.ufps.java.infraestructura.web.response.ConvertirResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/convertir")
@CrossOrigin(origins = "*")
public class ConvertirControlador {

    private ConvertirUseCase convertirUseCase;
    private final ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguracion.class);

    @PostMapping
    public ResponseEntity<ConvertirResponse> convertir(@RequestBody ConvertirRequest request) throws Exception {
        try {
            convertirUseCase = (ConvertirUseCase) context.getBean(getBean(request.getExtensionFuente(), request.getExtensionDestino()));
        } catch (Exception e) {
            throw new Exception("La conversion con esas extenciones no esta disponible.");
        }
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

    @GetMapping
    public ResponseEntity<List<String>> listarCoversores() {
        List<String> conversores = new ArrayList<>();
        String[] beanNombres = context.getBeanDefinitionNames();
        for (String beanNombre : beanNombres) {
            if (beanNombre.contains("_")) {
                conversores.add(beanNombre.replace("_", " a "));
            }
        }
        return ResponseEntity.ok(conversores);
    }

}
