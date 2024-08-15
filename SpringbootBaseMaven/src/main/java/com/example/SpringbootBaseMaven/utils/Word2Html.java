package com.example.SpringbootBaseMaven.utils;

import fr.opensagres.poi.xwpf.converter.core.FileImageExtractor;
import fr.opensagres.poi.xwpf.converter.core.IURIResolver;
import fr.opensagres.poi.xwpf.converter.core.ImageManager;
import fr.opensagres.poi.xwpf.converter.xhtml.XHTMLConverter;
import fr.opensagres.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * https://github.com/sunmaolin/wordToHtml/blob/master/docxToHtml/src/test/java/TestHtml.java
 */
public class Word2Html {
    private static final String sourceFile = "C:\\xhj\\sources\\tmp\\output.docx";
    private static final String targetFile = "C:\\xhj\\sources\\tmp\\ab.html";
    private static final String imageDir = "C:\\xhj\\sources\\tmp\\aImg";

    /**
     * .docx文档转html（老版本使用方法）
     */
    public static void poiDocx() throws Exception{
        FileInputStream inputStream = new FileInputStream(sourceFile);

        XWPFDocument wordDocument = new XWPFDocument(inputStream);

        File imageFile = new File(imageDir);
        // 解析 XHTML配置
        XHTMLOptions xhtmlOptions = XHTMLOptions.create();
        // 设置image的存放路径（会默认在imageFile文件夹中创建word/media文件）
        xhtmlOptions.setExtractor(new FileImageExtractor(imageFile));
        // 将图片地址解析到生成的html标签中
        xhtmlOptions.URIResolver(new IURIResolver() {
            @Override
            public String resolve(String url) {
                // 从word保存的图像 在imageDir/word/media下。参数url是word/media/文件名。所以这里拼接下。也可以拼接相对路径
                return imageDir + "\\" + url;
//                return "aImg"+"\\"+url;
            }
        });

        // 将样式都写为内联样式，而不是写到style标签中 默认false
        xhtmlOptions.setFragment(true);
        // 省略掉footer，header标签 默认false
        xhtmlOptions.setOmitHeaderFooterPages(true);
        // 忽略未用到的样式 默认true
        xhtmlOptions.setIgnoreStylesIfUnused(true);
        // 缩进 默认不缩进
        // xhtmlOptions.indent(10);

        XHTMLConverter.getInstance().convert(wordDocument, new FileOutputStream(targetFile), xhtmlOptions);

    }


    /**
     * .docx文档转html（新版本使用方法）
     */

    public void poiDocxNew() throws Exception {

        FileInputStream fileInputStream = new FileInputStream(sourceFile);

        XWPFDocument wordDocument = new XWPFDocument(fileInputStream);

        // ImageManager就是将老版本中的Extractor和UrlResolver整合到一个类中处理了
        XHTMLOptions xhtmlOptions = XHTMLOptions.create().setImageManager(new ImageManager(new File("C:\\Users\\QM\\Desktop"), "aImage"));

        XHTMLConverter.getInstance().convert(wordDocument, new FileOutputStream(targetFile), xhtmlOptions);

        // 生成后,word中的图片存在aImage文件夹中
    }

    public static void main(String[] args) throws Exception {
        poiDocx();
    }
}
