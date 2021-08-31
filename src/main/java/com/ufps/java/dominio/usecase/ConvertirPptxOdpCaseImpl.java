package com.ufps.java.dominio.usecase;

import com.aspose.slides.Presentation;
import com.aspose.slides.SaveFormat;
import com.ufps.java.dominio.modelo.Archivo;
import com.ufps.java.dominio.utilidad.UbicacionUtilidad;

import java.io.File;

public class ConvertirPptxOdpCaseImpl implements ConvertirUseCase{
    @Override
    public Archivo ejecutar(Archivo archivo) throws Exception {
        Presentation presentacion = new Presentation(archivo.getUbicacion());
        String nombreNuevo = archivo.getNombreSinExtension().concat(".odp");
        presentacion.save(UbicacionUtilidad.getUbicacion().concat(nombreNuevo), SaveFormat.Odp);
        return Archivo.builder()
                .nombre(nombreNuevo)
                .fichero(new File(UbicacionUtilidad.getUbicacion().concat(nombreNuevo)))
                .build();
    }
}
