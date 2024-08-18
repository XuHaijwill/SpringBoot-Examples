package com.example.SpringbootBaseMaven.utils;




//https://blog.51cto.com/u_16213315/10574674
public class OfficeUtil {

}
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfWriter;
//import org.apache.poi.xwpf.usermodel.XWPFDocument;
//import org.apache.poi.xwpf.usermodel.XWPFParagraph;
//
//import java.io.*;
//import java.util.List;
//
///**
// * 使用poi+itextpdf进行word转pdf
// * 先将word转成html，再将html转成pdf
// *
// * @author ：hewie
// * @date ：Created in 2020/2/27 22:41
// */
////https://blog.csdn.net/somehow1002/article/details/104685854
//
////https://blog.51cto.com/u_16213390/8135256
//public class OfficeUtil {
//
//    private final static String fileFolder = "D:\\xhj\\sources\\tmp\\";
//
//    public static void docx2pdf() {
//        InputStream docxInputStream = null;
//        try {
//            docxInputStream = new FileInputStream(fileFolder + "output.docx");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        try (XWPFDocument document = new XWPFDocument(docxInputStream);
//             OutputStream pdfOutputStream = new FileOutputStream(fileFolder + "output.pdf");) {
//            Document pdfDocument = new Document();
//            PdfWriter.getInstance(pdfDocument, pdfOutputStream);
//            pdfDocument.open();
//
//            List<XWPFParagraph> paragraphs = document.getParagraphs();
//            for (XWPFParagraph paragraph : paragraphs) {
//                pdfDocument.add(new Paragraph(paragraph.getText()));
//            }
//            pdfDocument.close();
//        } catch (DocumentException | IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static void main(String[] args) {
//        docx2pdf();
//    }
//}