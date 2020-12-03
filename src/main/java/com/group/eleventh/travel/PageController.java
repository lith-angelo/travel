package com.group.eleventh.travel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping({"/", "/index.html"})
    public String index(ModelMap map) {
        ///stop
//        map.addAttribute("host", "http://www.baidu.com");
        return "qt/index";
    }

    @RequestMapping("/cart.html")
    public String cart(ModelMap map) {
        return "qt/cart";
    }

    @RequestMapping("/detail.html")
    public String detail(ModelMap map) {
        return "qt/detail";
    }

    @RequestMapping("/group.html")
    public String group(ModelMap map) {
        return "qt/group";
    }

    @RequestMapping("/login.html")
    public String login(ModelMap map) {
        return "qt/login";
    }

    @RequestMapping("/order.html")
    public String order(ModelMap map) {
        return "qt/order";
    }

    @RequestMapping("/regist.html")
    public String regist(ModelMap map) {
        return "qt/regist";
    }

    @RequestMapping("/type.html")
    public String type(ModelMap map) {
        return "qt/type";
    }

    @RequestMapping("/ht/_right.html")
    public String htRight(ModelMap map) {
        return "ht/_right";
    }

    @RequestMapping("/ht/adminLogin.html")
    public String htAdminLogin(ModelMap map) {
        return "ht/adminLogin";
    }

    @RequestMapping("/ht/admintop.html")
    public String htAdminTop(ModelMap map) {
        return "ht/admintop";
    }

    @RequestMapping("/ht/index.html")
    public String htIndex(ModelMap map) {
        return "ht/index";
    }

    @RequestMapping("/ht/left.html")
    public String htLeft(ModelMap map) {
        return "ht/left";
    }
}
