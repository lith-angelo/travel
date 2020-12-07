package com.group.eleventh.travel.service;

import com.group.eleventh.travel.bean.Result;
import com.group.eleventh.travel.controller.ValidateCodeController;
import com.group.eleventh.travel.entity.Customer;
import com.group.eleventh.travel.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Service
public class CustomerService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 注册
     * @param customer 参数封装
     * @return Result
     */
    public Result regist(@RequestParam("code") String code, Customer customer, HttpSession session) {

        ValidateCodeController vcc = new ValidateCodeController();
        boolean isCaptchaValid = vcc.checkCaptcha(code, session);

        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        if(isCaptchaValid) {
            try {
                Customer existCustomer = userMapper.finduserByName(customer.getAccount());
                if (existCustomer != null) {
                    result.setMsg("用户名已存在");
                } else {
                    userMapper.regist(customer);
                    result.setMsg("注册成功");
                    result.setSuccess(true);
                    result.setDetail(null);
                }
            } catch (Exception e) {
                result.setMsg(e.getMessage());
                e.printStackTrace();
            }
        }else {
            result.setDetail("验证码错误");
        }
        return result;
    }

    /**
     * 登录
     * @param customer 用户名和密码
     * @return Result
     */
    public Result login(Customer customer) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            Integer userID = userMapper.login(customer);
            if(userID == null) {
                result.setMsg("用户名或密码错误");
            }else {
                result.setMsg("登录成功");
                result.setSuccess(true);
                customer.setCustomerID(userID);
                result.setDetail(null);
            }

        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
