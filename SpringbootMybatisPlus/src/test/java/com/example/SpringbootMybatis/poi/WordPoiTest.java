package com.example.SpringbootMybatis.poi;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.data.Pictures;
import com.deepoove.poi.data.RowRenderData;
import com.deepoove.poi.data.Rows;
import com.deepoove.poi.data.Tables;
import com.deepoove.poi.plugin.table.LoopRowTableRenderPolicy;
import com.example.SpringbootMybatis.domain.model.Good;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @ClassName WordPoiTest
 * @Description //TODO
 * @Author XuHaijwill
 * @Date 2024/7/14 16:07
 * @Version 1.0
 **/
@SpringBootTest
public class WordPoiTest {

    @Test
    public void test1() {
        // 定义模板对应的数据
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "张三");
        data.put("age", 18);

        // 加载本地模板文件
        InputStream inputStream = getClass().getResourceAsStream("/poi/demo1.docx");

        // 渲染模板
        XWPFTemplate template = XWPFTemplate.compile(inputStream).render(data);

        try {
            // 写出到文件
            template.writeAndClose(new FileOutputStream("D:\\sources\\tmp\\output.docx"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test2() {
        try {
            // 加载远程模板
            String templateUrl =
                    "https://szx-bucket1.oss-cn-hangzhou.aliyuncs.com/picgo/%E6%BC%94%E7%A4%BA%E6%A8%A1%E6%9D%BF1.docx";
            URL url = new URL(templateUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream inputStream = conn.getInputStream();

            // 定义模板对应的数据
            HashMap<String, Object> data = new HashMap<>();
            data.put("name", "张三");
            data.put("age", 18);

            // 渲染模板
            XWPFTemplate template = XWPFTemplate.compile(inputStream).render(data);

            // 写出到文件
            template.writeAndClose(new FileOutputStream("D:\\sources\\tmp\\output.docx"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 插入表格
    @Test
    public void test4() {
        // 定义模板对应的数据
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "张三");
        data.put("age", 18);
        data.put(
                "img", Pictures.ofUrl("http://deepoove.com/images/icecream.png").size(100, 100).create());

        // 第0行居中且背景为蓝色的表格
        RowRenderData row0 =
                Rows.of("学历", "时间").textColor("FFFFFF").bgColor("4472C4").center().create();
        RowRenderData row1 = Rows.create("本科", "2015~2019");
        RowRenderData row2 = Rows.create("研究生", "2019~2021");
        data.put("eduList", Tables.create(row0, row1, row2));

        // 加载本地模板文件
        InputStream inputStream = getClass().getResourceAsStream("/poi/demo1.docx");

        // 渲染模板
        XWPFTemplate template = XWPFTemplate.compile(inputStream).render(data);

        try {
            // 写出到文件
            template.writeAndClose(new FileOutputStream("output.docx"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 循环行表格
    @Test
    public void test5() {
        Good good = new Good();
        good.setName("小米14");
        good.setPrice("4599");
        good.setColor("黑色");
        good.setTime("2024-05-23");

        Good good2 = new Good();
        good2.setName("苹果15");
        good2.setPrice("7599");
        good2.setColor("黑色");
        good2.setTime("2024-05-23");

        Good good3 = new Good();
        good3.setName("华为Meta60");
        good3.setPrice("7999");
        good3.setColor("白色");
        good3.setTime("2024-05-23");

        ArrayList<Good> goods = new ArrayList<>();
        goods.add(good);
        goods.add(good2);
        goods.add(good3);

        // 定义模板对应的数据
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "张三");
        data.put("age", 18);
        data.put(
                "img", Pictures.ofUrl("http://deepoove.com/images/icecream.png").size(100, 100).create());

        // 第0行居中且背景为蓝色的表格
        RowRenderData row0 =
                Rows.of("学历", "时间").textColor("FFFFFF").bgColor("4472C4").center().create();
        RowRenderData row1 = Rows.create("本科", "2015~2019");
        RowRenderData row2 = Rows.create("研究生", "2019~2021");
        data.put("eduList", Tables.create(row0, row1, row2));

        // 添加采购列表数据
        data.put("goods", goods);

        // 加载本地模板文件
        InputStream inputStream = getClass().getResourceAsStream("/poi/demo1.docx");

        // 定义行循环插件
        LoopRowTableRenderPolicy policy = new LoopRowTableRenderPolicy();
        // 绑定插件
        Configure config = Configure.builder().bind("goods", policy).build();
        // 渲染模板
        XWPFTemplate template = XWPFTemplate.compile(inputStream, config).render(data);

        try {
            // 写出到文件
            template.writeAndClose(new FileOutputStream("output.docx"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
