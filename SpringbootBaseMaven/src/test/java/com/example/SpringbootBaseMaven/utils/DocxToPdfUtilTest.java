package com.example.SpringbootBaseMaven.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * 在linux下离线安装libreoffice
 *
 * 需要安装 libreoffic
 * https://cloud.tencent.com/developer/article/2387673
 * libreoffice --headless --convert-to pdf --outdir /path/to/output/directory your_word_document.docx
 */
class DocxToPdfUtilTest {


    @Test
    void documents4jWordToPdf() {
        DocxToPdfUtil.documents4jWordToPdf("D:\\xhj\\sources\\tmp\\output.docx");
    }
}