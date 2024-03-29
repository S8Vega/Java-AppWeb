package com.ufps.java.dominio.usecase;

import com.aspose.cells.Workbook;
import com.aspose.cells.SaveFormat;
import com.ufps.java.dominio.modelo.Archivo;
import com.ufps.java.dominio.utilidad.UbicacionUtilidad;

import java.io.File;

public class ConvertirXlsxPdfUseCaseImpl implements ConvertirUseCase{
    @Override
    public Archivo ejecutar(Archivo archivo) throws Exception {
        Workbook book = new Workbook(archivo.getUbicacion());
        String nombreNuevo = archivo.getNombreSinExtension().concat(".pdf");
        book.save(UbicacionUtilidad.getUbicacion().concat(nombreNuevo), SaveFormat.PDF);
        return Archivo.builder()
                .nombre(nombreNuevo)
                .fichero(new File(UbicacionUtilidad.getUbicacion().concat(nombreNuevo)))
                .build();
    }
}
