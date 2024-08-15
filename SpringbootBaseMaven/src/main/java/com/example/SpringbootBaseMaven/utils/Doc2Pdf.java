package com.example.SpringbootBaseMaven.utils;

import com.itextpdf.text.DocumentException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Doc2Pdf {

    public static void main(String[] args) throws IOException, DocumentException {
        // 加载Word文件
        FileInputStream fis = new FileInputStream("C:\\xhj\\sources\\tmp\\output.docx");
        XWPFDocument document = new XWPFDocument(fis);

        // 创建PDF文档
        Document pdfDocument = new Document();
        PdfWriter.getInstance(pdfDocument, new FileOutputStream("C:\\xhj\\sources\\tmp\\output_123.pdf"));
        pdfDocument.open();

    }
}
