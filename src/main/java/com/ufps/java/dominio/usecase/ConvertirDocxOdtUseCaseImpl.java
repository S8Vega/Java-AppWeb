package com.ufps.java.dominio.usecase;

import com.aspose.words.Document;
import com.aspose.words.SaveFormat;
import com.ufps.java.dominio.modelo.Archivo;
import com.ufps.java.dominio.utilidad.UbicacionUtilidad;

import java.io.File;

public class ConvertirDocxOdtUseCaseImpl implements ConvertirUseCase {

    @Override
    public Archivo ejecutar(Archivo archivo) throws Exception {
        Document documento = new Document(archivo.getUbicacion());
        String nombreNuevo = archivo.getNombreSinExtension().concat(".odt");
        documento.save(UbicacionUtilidad.getUbicacion().concat(nombreNuevo), SaveFormat.ODT);
        return Archivo.builder()
                .nombre(nombreNuevo)
                .fichero(new File(UbicacionUtilidad.getUbicacion().concat(nombreNuevo)))
                .build();
    }

}
