package com.group.eleventh.travel.controller;

import com.group.eleventh.travel.bean.Result;
import com.group.eleventh.travel.entity.Customer;
import com.group.eleventh.travel.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/customer")
/**
 * 顾客Controller
 * @author angelo
 */
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/regist")
    public Result regist(Customer customer) {
        return customerService.regist(customer);
    }

    @PostMapping(path = "/login")
    public Result login(HttpSession session, Customer customer) {
        System.out.println("customer is " + customer);
        Result res = customerService.login(customer);
        if (res.isSuccess()) {
            session.setAttribute("userName", customer.getAccount());
        }
        return res;
    }

    @GetMapping("/logout")
    public RedirectView logout(HttpSession session) {
        session.removeAttribute("userName");
        RedirectView redirectTarget = new RedirectView();
        redirectTarget.setContextRelative(true);
        redirectTarget.setUrl("/login.html");
        return redirectTarget;
    }
}
