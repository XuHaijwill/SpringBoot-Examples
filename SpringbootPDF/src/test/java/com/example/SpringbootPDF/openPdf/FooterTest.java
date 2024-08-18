package com.example.SpringbootPDF.openPdf;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @ClassName FooterTest
 * @Description //TODO
 * @Author XuHaijwill
 * @Date 2024/8/18 18:18
 * @Version 1.0
 **/
public class FooterTest {

    private static final String PATH = "D:\\TEMP\\";
    /**
     * Create a document with 2 empty pages and custom numbered footer without before part.
     *
     * @param args
     */

    public static void main(String[] args) {
        Document document = new Document(PageSize.A4, 10f, 10f, 10f, 10f);

        try {
            PdfWriter.getInstance(document,
                    new FileOutputStream(PATH + "footer.pdf"));
            HeaderFooter header = new HeaderFooter(false,new Phrase("hello"));
            HeaderFooter footer = new HeaderFooter(true, new Phrase(" page"));
            footer.setAlignment(Element.ALIGN_CENTER);
            footer.setBorderWidthBottom(0);
            document.setHeader(header);
            document.setFooter(footer);



            document.open();
            document.add(new Paragraph(" "));
            document.newPage();
            document.add(new Paragraph(" "));
            document.newPage();
            document.add(new Paragraph(" "));
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        document.close();
    }
}
