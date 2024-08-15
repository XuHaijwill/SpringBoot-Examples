使用docx4j实现docx转pdf（解决linux环境下中文乱码问题）
1.在pom.xml中添加docx4j相关依赖
<dependency>
<groupId>org.docx4j</groupId>
<artifactId>docx4j-JAXB-Internal</artifactId>
<version>8.3.1</version>
</dependency>
<dependency>
<groupId>org.docx4j</groupId>
<artifactId>docx4j-JAXB-ReferenceImpl</artifactId>
<version>8.3.1</version>
</dependency>
<dependency>
<groupId>org.docx4j</groupId>
<artifactId>docx4j-export-fo</artifactId>
<version>8.3.1</version>
</dependency>
2.新增WordUtils工具类

import lombok.extern.slf4j.Slf4j;
import org.docx4j.Docx4J;
import org.docx4j.fonts.IdentityPlusMapper;
import org.docx4j.fonts.Mapper;
import org.docx4j.fonts.PhysicalFont;
import org.docx4j.fonts.PhysicalFonts;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.org.apache.poi.util.IOUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;
@Slf4j
public class WordUtils {

    public static void main(String[] args) throws Exception {
        WordUtils.convertDocxToPdf("D:/test/test.docx","D:/test/test.pdf");
    }
  
    /**
     * docx文档转换为PDF
     * @param body 文档
     * @param response 响应给前端
     * @return pdf 输出流
     * @throws Exception 可能为Docx4JException, FileNotFoundException, IOException等
     */
    public static void convertDocxToPdf(byte[] body , HttpServletResponse response) throws Exception {
        response.setContentType("application/pdf");
        File docxFile = FileUtil.byteToFile(body, UUID.randomUUID().toString() + ".docx");
        try {
            WordprocessingMLPackage mlPackage = WordprocessingMLPackage.load(docxFile);
            setFontMapper(mlPackage);
            Docx4J.toPDF(mlPackage, response.getOutputStream());
        }catch (Exception e){
            e.printStackTrace();
            log.error("docx文档转换为PDF失败");
        }
       FileUtil.deleteTempFile(docxFile);
    }
  
  
  
    /**
     * docx文档转换为PDF
     *
     * @param pdfPath PDF文档存储路径
     * @throws Exception 可能为Docx4JException, FileNotFoundException, IOException等
     */
    public static void convertDocxToPdf(String docxPath, String pdfPath) throws Exception {
  
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(docxPath);
            fileOutputStream = new FileOutputStream(new File(pdfPath));
            WordprocessingMLPackage mlPackage = WordprocessingMLPackage.load(file);
            setFontMapper(mlPackage);
            Docx4J.toPDF(mlPackage, new FileOutputStream(new File(pdfPath)));
        }catch (Exception e){
            e.printStackTrace();
            log.error("docx文档转换为PDF失败");
        }finally {
            IOUtils.closeQuietly(fileOutputStream);
        }
    }
  
    private static void setFontMapper(WordprocessingMLPackage mlPackage) throws Exception {       
        Mapper fontMapper = new IdentityPlusMapper();
        //加载字体文件（解决linux环境下无中文字体问题）
        if(PhysicalFonts.get("SimSun") == null) {
            System.out.println("加载本地SimSun字体库");
//          PhysicalFonts.addPhysicalFonts("SimSun", WordUtils.class.getResource("/fonts/SIMSUN.TTC"));
}
fontMapper.put("隶书", PhysicalFonts.get("LiSu"));
fontMapper.put("宋体", PhysicalFonts.get("SimSun"));
fontMapper.put("微软雅黑", PhysicalFonts.get("Microsoft Yahei"));
fontMapper.put("黑体", PhysicalFonts.get("SimHei"));
fontMapper.put("楷体", PhysicalFonts.get("KaiTi"));
fontMapper.put("新宋体", PhysicalFonts.get("NSimSun"));
fontMapper.put("华文行楷", PhysicalFonts.get("STXingkai"));
fontMapper.put("华文仿宋", PhysicalFonts.get("STFangsong"));
fontMapper.put("仿宋", PhysicalFonts.get("FangSong"));
fontMapper.put("幼圆", PhysicalFonts.get("YouYuan"));
fontMapper.put("华文宋体", PhysicalFonts.get("STSong"));
fontMapper.put("华文中宋", PhysicalFonts.get("STZhongsong"));
fontMapper.put("等线", PhysicalFonts.get("SimSun"));
fontMapper.put("等线 Light", PhysicalFonts.get("SimSun"));
fontMapper.put("华文琥珀", PhysicalFonts.get("STHupo"));
fontMapper.put("华文隶书", PhysicalFonts.get("STLiti"));
fontMapper.put("华文新魏", PhysicalFonts.get("STXinwei"));
fontMapper.put("华文彩云", PhysicalFonts.get("STCaiyun"));
fontMapper.put("方正姚体", PhysicalFonts.get("FZYaoti"));
fontMapper.put("方正舒体", PhysicalFonts.get("FZShuTi"));
fontMapper.put("华文细黑", PhysicalFonts.get("STXihei"));
fontMapper.put("宋体扩展", PhysicalFonts.get("simsun-extB"));
fontMapper.put("仿宋_GB2312", PhysicalFonts.get("FangSong_GB2312"));
fontMapper.put("新細明體", PhysicalFonts.get("SimSun"));
//解决宋体（正文）和宋体（标题）的乱码问题
PhysicalFonts.put("PMingLiU", PhysicalFonts.get("SimSun"));
PhysicalFonts.put("新細明體", PhysicalFonts.get("SimSun"));
//宋体&新宋体
PhysicalFont simsunFont = PhysicalFonts.get("SimSun");
fontMapper.put("SimSun", simsunFont);
//设置字体
mlPackage.setFontMapper(fontMapper);
}

}
3.在linux环境中安装windows字体
（1）在linux（CentOS7）环境中新建文件夹/usr/share/fonts/win_font

（2）将C:\Windows\Fonts（win10）中的字体文件拷贝到/usr/share/fonts/win_font文件夹中

（3）加载字体文件


mkfontscale       //字体扩展
mkfontdir           //新增字体目录
fc-cache -fv      //刷新缓存
（4）查看字体安装情况

fc-list :lang=zh
4.打包部署并启动程序即可查看最终效果，亲测通过，希望对你有所帮助。
