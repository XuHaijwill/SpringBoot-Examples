package com.example.SpringbootBaseMaven.utils;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Html2PDF {


    public static void main(String[] args) throws IOException {
        String htmlTemplate = "C:\\xhj\\sources\\tmp\\a.html";
        // 默认加载系统所有字体，设置默认字体为微软雅黑
        // 字体需要生效的话，需要安装ttf或otf结尾的字体，ttc结尾的不生效，而且需要为所有用户安装
        DefaultFontProvider defaultFontProvider = new DefaultFontProvider(false, false, true, "Microsoft YaHei");
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setFontProvider(defaultFontProvider);
        // 加载中文字体, 创建一个输出流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        HtmlConverter.convertToPdf(htmlTemplate, bos, converterProperties);
        OutputStream outputStream = new FileOutputStream("output1.pdf"); // 初始化 outputStream
        bos.writeTo(outputStream);
    }
}
