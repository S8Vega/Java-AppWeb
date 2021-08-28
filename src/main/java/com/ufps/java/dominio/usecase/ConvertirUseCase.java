package com.ufps.java.dominio.usecase;

import com.ufps.java.dominio.modelo.Archivo;

public interface ConvertirUseCase {

    Archivo ejecutar(Archivo archivo) throws Exception;

}
