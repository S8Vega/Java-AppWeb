package com.ufps.java.infraestructura.configuracion;

import com.ufps.java.dominio.usecase.ConvertirDocxOdtUseCaseImpl;
import com.ufps.java.dominio.usecase.ConvertirDocxPdfUseCaseImpl;
import com.ufps.java.dominio.usecase.ConvertirUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguracion {

    @Bean(name = "DOCX_ODT")
    ConvertirUseCase getConvertirDocxOdtUseCaseImpl() {
        return new ConvertirDocxOdtUseCaseImpl();
    }

    @Bean(name = "DOCX_PDF")
    ConvertirUseCase getConvertirDocxPdfUseCaseImpl() {
        return new ConvertirDocxPdfUseCaseImpl();
    }

}
