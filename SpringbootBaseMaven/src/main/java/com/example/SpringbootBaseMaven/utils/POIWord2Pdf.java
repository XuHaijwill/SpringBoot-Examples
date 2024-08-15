package com.example.SpringbootBaseMaven.utils;

import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * https://blog.51cto.com/u_15067238/4155952
 * 丢失一部分数据
 */
public class POIWord2Pdf {

    public static void main(String[] args) {
        try {

            //读取word文档
            XWPFDocument document = null;
            try (InputStream in = Files.newInputStream(Paths.get("C:\\xhj\\sources\\tmp\\output.docx"))) {
                document = new XWPFDocument(in);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //将word转成pdf
            PdfOptions options = PdfOptions.create();
            try (OutputStream outPDF = Files.newOutputStream(Paths.get("C:\\xhj\\sources\\tmp\\output_0815.pdf"))) {
                PdfConverter.getInstance().convert(document, outPDF, options);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
