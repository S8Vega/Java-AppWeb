
# Java-AppWeb

API REST en Spring para la conversion de archivos.


## Contribuciones

Para agregar una conversion de una extencion A a una extencion B:

1. Crear una clase que implemente la interfaz ConvertirUseCase en el paquete com.ufps.java.dominio.usecase
- Para colocar la ubicación destino del archivo se recomienda utilizar UbicacionUtilidad.getUbicacion()
1. Registrar el Bean en com.ufps.java.infraestructura.configuracion.BeanConfiguracion, esto se hace agregando un método así:

```java
@Bean(name = "A_B")
ConvertirUseCase getConvertirABUseCaseImpl() {
    return new ConvertirABUseCaseImpl();
}
```

- Donde A es la extensión fuente y B es la extensión destino.