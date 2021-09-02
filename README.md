# **Java-AppWeb**

API REST en Spring para la conversión de archivos.

## Como utilizar

La API tiene un solo endpoint (/convertir) con dos métodos HTTP, el método POST recibe un body de tipo json con el siguiente formato:

```json
{
  "nombreArchivo": "nombre-del-archivo.docx",
  "extensionFuente": "DOCX",
  "extensionDestino": "PDF",
  "base64": "decodificacion-del-archivo-en-base64"
}
```

Y si la petición se completa exitosamente se recibe una respuesta con el siguiente formato:

```json
{
    "nombreArchivo": "nombre-del-archivo.pdf",
    "base64": "decodificacion-del-archivo-en-base64"
}
```

El método (GET /convertir) retorna una lista con todas las conversiones disponibles:

```json
[
    "DOCX a ODT",
    "DOCX a PDF",
    "ODT a DOCX",
    "ODT a PDF"
    "XLSX a ODS"
    "XLSX a PDF"
    "ODS a XLSX"
    "ODS a PDF"
    "PPTX a ODP"
    "PPTX a PDF"
    "ODP a PPTX"
    "ODP a PDF"
]
```

Para mayor información se puede observar la documentación con [swagger](https://swagger.io/) con (GET /swagger-ui.html)

## **Contribuciones**

Para agregar una conversion de una extencion A a una extencion B:

1. Crear una clase que implemente la interfaz ConvertirUseCase en el paquete com.ufps.java.dominio.usecase
- Para colocar la ubicación destino del archivo se recomienda utilizar UbicacionUtilidad.getUbicacion()
2. Registrar el Bean en com.ufps.java.infraestructura.configuracion.BeanConfiguracion, esto se hace agregando un método así:

```java
@Bean(name = "A_B")
ConvertirUseCase getConvertirABUseCaseImpl() {
        return new ConvertirABUseCaseImpl();
}
```

- Donde A es la extensión fuente y B es la extensión destino.

## Demo

Actualmente la API se encuentra en una instancia de [EC2](https://aws.amazon.com/es/ec2/?ec2-whats-new.sort-by=item.additionalFields.postDateTime&ec2-whats-new.sort-order=desc), accediendo al [link de swagger](http://54.163.147.33:8080/swagger-ui.html#/) se puede ver la documentación de la api.

## Contribuidores

- [@S8Vega](https://github.com/S8Vega)
- [@coltdeus](https://github.com/coltdeus)
- [@nicolaspa1](https://github.com/nicolaspa1)
- [@SHUNNIORR](https://github.com/SHUNNIORR)

## **Licencia**

[MIT](https://choosealicense.com/licenses/mit/)
