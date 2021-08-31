package com.ufps.java.infraestructura.configuracion;

import com.ufps.java.dominio.usecase.*;
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

    @Bean(name = "ODT_DOCX")
    ConvertirUseCase getConvertirOdtDocxUseCaseImpl() {
        return new ConvertirOdtDocxUseCaseImpl();
    }

    @Bean(name = "ODT_PDF")
    ConvertirUseCase getConvertirOdtPdfUseCaseImpl() {
        return new ConvertirOdtPdfUseCaseImpl();
    }

    @Bean(name = "XLSX_ODS")
    ConvertirUseCase getConvertirXlsxOdsUseCaseImpl() {
        return new ConvertirXlsxOdsUseCaseImpl();
    }

    @Bean(name = "XLSX_PDF")
    ConvertirUseCase getConvertirXlsxPdfUseCaseImpl() {
        return new ConvertirXlsxPdfUseCaseImpl();
    }

    @Bean(name = "ODS_XLSX")
    ConvertirUseCase getConvertirOdsXlsxUseCaseImpl() {
        return new ConvertirOdsXlsxUseCaseImpl();
    }

    @Bean(name = "ODS_PDF")
    ConvertirUseCase getConvertirOdsPdfUseCaseImpl() {
        return new ConvertirOdsPdfUseCaseImpl();
    }

}
