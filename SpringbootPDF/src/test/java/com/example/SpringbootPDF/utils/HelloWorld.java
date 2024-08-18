package com.example.SpringbootPDF.utils;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfString;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName HelloWorld
 * @Description //TODO
 * @Author XuHaijwill
 * @Date 2024/8/17 16:16
 * @Version 1.0
 **/
public class HelloWorld {

    /**
     * Generates a PDF file with the text 'Hello World'
     *
     * @param args no arguments needed here
     */
    public static void main(String[] args) {

        System.out.println("Hello World");

        // step 1: creation of a document-object
//        Document document = new Document();
        // 创建PDF文档对象
        Document document = new Document(PageSize.A4);
        try {
            // step 2:
            // we create a writer that listens to the document
            // and directs a PDF-stream to a file
            final PdfWriter instance = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));

            // step 3: we open the document
            document.open();
            // 创建段落对象
            Paragraph paragraph = new Paragraph();

            // 向段落中添加内容
            paragraph.add("这是第一页的内容");

            // 将段落添加到文档中
            document.add(paragraph);

            instance.getInfo().put(PdfName.CREATOR, new PdfString(Document.getVersion()));
            // step 4: we add a paragraph to the document
            document.add(new Paragraph("Hello World"));

            document.newPage();

            // 清空段落中的内容
            paragraph.clear();
            document.add(new Paragraph("这是第二页的内容"));

        } catch (DocumentException | IOException de) {
            System.err.println(de.getMessage());
        }

        // step 5: we close the document
        document.close();
    }
}
