package com.ufps.java.web;


import com.aspose.words.Document;
import com.aspose.words.SaveFormat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaAppWebApplicationTests {

    private static final String DIR = "src/main/resources/files/";

    @Test
    void docx() throws Exception {
        Document wpd = new Document(DIR + "nombre.docx");

        wpd.save(DIR + "output.odt", SaveFormat.ODT);

        wpd.save(DIR + "output.pdf", SaveFormat.PDF);
    }

}
