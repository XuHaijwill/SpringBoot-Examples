package com.hendisantika.utils;

import com.fasterxml.jackson.databind.JsonNode;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.junit.jupiter.api.Assertions.*;

class WebHttpApiTest {

    private String baseUrl = "https://www.cnblogs.com/zys2019/p/17010214.html#_label2_0";
    private String url1 = "";
    private String url2 ="";

    @Test
    public void test() {
        MultiValueMap<String, String> listParams = new LinkedMultiValueMap<>();
        listParams.add("num", "3");
        //同步请求
        System.out.println("------开始同步请求--------");
        JsonNode jsonNode = WebHttpApi.get(url1, listParams);
        System.out.println("响应的结果");
        System.out.println(jsonNode);
        //将结果转为字符串，格式化
        System.out.println(jsonNode.toPrettyString());
        //获取结果中的data数据
        System.out.println(jsonNode.get("data"));
        System.out.println("------完成同步请求--------");
        //异步请求
        System.out.println("\n*******开始异步请求*******");
        WebHttpApi.get(url1, listParams, data -> {
            //对返回的结果进行处理，异步的。这里模拟打印
            System.out.println(data);
        });
        System.out.println("*******完成异步请求*******");
    }

    @Test
    public void test2() {
        LinkedMultiValueMap<String, Object> regParams = new LinkedMultiValueMap<>();
        regParams.add("username", "张无忌123");
        //同步请求
        JsonNode jsonNode2 = WebHttpApi.post(url2, regParams);
        System.out.println(jsonNode2.toPrettyString());
        //异步请求
        regParams.add("username", "张无忌456");
        WebHttpApi.post(url2, regParams, data -> {
            //对返回的结果进行处理，异步的。这里模拟打印
            System.out.println(data);
        });
    }

    @Test
    public void test3(){
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("ip", "183.95.251.19");
        params.add("json", "true");
        String resp = WebHttpApi.get("http://whois.pconline.com.cn/ipJson.jsp", params, null, String.class);
        System.out.println(resp);
//        JSONObject data = JSON.parseObject(resp);
//        System.out.println(String.format("%s%s", data.getString("pro"), data.getString("city")));//湖北省武汉市
    }
}