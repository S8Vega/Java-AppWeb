package com.ufps.java.dominio.usecase;

import com.aspose.words.Document;
import com.aspose.words.SaveFormat;
import com.ufps.java.dominio.modelo.Archivo;
import com.ufps.java.dominio.utilidad.ConstantesUtilidad;

import java.io.File;

public class ConvertirDocxOdtUseCaseImpl implements ConvertirUseCase {

    @Override
    public Archivo ejecutar(Archivo archivo) throws Exception {
        Document documento = new Document(archivo.getFichero().getCanonicalPath());
        String nombreNuevo = archivo.getNombreSinExtencion().concat(".odt");
        documento.save(ConstantesUtilidad.DIR.concat(nombreNuevo), SaveFormat.ODT);
        return Archivo.builder()
                .nombre(nombreNuevo)
                .fichero(new File(ConstantesUtilidad.DIR.concat(nombreNuevo)))
                .build();
    }

}
