package com.example.SpringbootPDF.utils;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName OpenPDFUtils
 * @Description //TODO
 * @Author XuHaijwill
 * @Date 2024/8/17 16:30
 * @Version 1.0
 **/
public class OpenPDFUtils {

    public static void newParaph() throws IOException {
        System.out.println("the Paragraph object");

        // step 1: creation of a document-object
        Document document = new Document();
        try {
            // step 2:
            // we create a writer that listens to the document
            PdfWriter.getInstance(document, new FileOutputStream("Paragraphs.pdf"));

            // step 3: we open the document
            document.open();
            // step 4:
            Paragraph p1 = new Paragraph(new Chunk(
                    "This is my first paragraph. ",
                    FontFactory.getFont(FontFactory.HELVETICA, 10)));
            p1.add("The leading of this paragraph is calculated automagically. ");
            p1.add("The default leading is 1.5 times the fontsize. ");
            p1.add(new Chunk("You can add chunks "));
            p1.add(new Phrase("or you can add phrases. "));
            p1.add(new Phrase(
                    "Unless you change the leading with the method setLeading, the leading doesn't change if you add text with another leading. This can lead to some problems.",
                    FontFactory.getFont(FontFactory.HELVETICA, 18)));
            document.add(p1);
            document.newPage();
            Paragraph p2 = new Paragraph(new Phrase(
                    "This is my second paragraph. ", FontFactory.getFont(
                    FontFactory.HELVETICA, 12)));
            p2.add("As you can see, it started on a new line.");
            document.add(p2);
            document.newPage();
            Paragraph p3 = new Paragraph("This is my third paragraph.",
                    FontFactory.getFont(FontFactory.HELVETICA, 12));
            document.add(p3);
        } catch (DocumentException | IOException de) {
            System.err.println(de.getMessage());
        }

        // step 5: we close the document
        document.close();
    }

    public static void main(String[] args) throws IOException {
        newParaph();
    }
}
