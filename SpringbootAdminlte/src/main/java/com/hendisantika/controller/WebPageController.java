package com.hendisantika.controller;

import com.hendisantika.entity.Order;
import com.hendisantika.entity.User;
import com.hendisantika.repository.UserRepository;
import com.hendisantika.utils.DateUtil;
import com.hendisantika.utils.ExcelUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-adminlte3
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 25/11/20
 * Time: 08.40
 */
@Controller
public class WebPageController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index() {
        return "dashboard";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/releaseNotice")
    public String releaseNotice(Model model) {
        model.addAttribute("user", new User());
        Order order = new Order();
        Map<String, String> weekDate = DateUtil.getWeekDate();
        order.setMinOrderTimeStr(weekDate.get("mondayDate") + " 00:00 AM");
        order.setMaxOrderTimeStr(weekDate.get("nextMondayDate") + " 00:00 AM");
        model.addAttribute("order",order);
        model.addAttribute("users", userRepository.findAll());
        return "releaseNotice";
    }

    @RequestMapping("/releaseNotice/export")
    public void exportReleaseNotice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Order> orderList = new ArrayList<>();
        //导出excel
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<String, String>();
        fieldMap.put("orderId", "订单id");
        fieldMap.put("payment", "实付金额");
        fieldMap.put("paymentType", "支付类型，1、在线支付，2、货到付款");
        fieldMap.put("postFee", "邮费");
        fieldMap.put("status", "状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭");
        fieldMap.put("createTime", "订单创建时间");
        fieldMap.put("updateTime", "订单更新时间");
        fieldMap.put("paymentTime", "付款时间");
        fieldMap.put("consignTime", "发货时间");
        fieldMap.put("endTime", "交易完成时间");
        fieldMap.put("closeTime", "交易关闭时间");
        fieldMap.put("shippingName", "物流名称");
        fieldMap.put("shippingCode", "物流单号");
        fieldMap.put("userId", "用户id");
        fieldMap.put("buyerMessage", "买家留言");
        fieldMap.put("buyerNick", "买家昵称");
        fieldMap.put("buyerRate", "买家是否已经评价");
        String sheetName = "订单报表";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=OrderManage.xls");//默认Excel名称
        response.flushBuffer();
        OutputStream fos = response.getOutputStream();
        String result="1";
        try {
            ExcelUtil.listToExcel(orderList, fieldMap, sheetName, fos);
        } catch (Exception e) {
            e.printStackTrace();
            result="0";
        }finally {
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write("{\"msg\":\""+result+"\"}");
        }
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/table")
    public String table(Model model) {
        return "table";
    }
}
