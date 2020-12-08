package com.group.eleventh.travel.controller;

import com.group.eleventh.travel.entity.Line;
import com.group.eleventh.travel.entity.Page;
import com.group.eleventh.travel.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class GoodsShowController {
    @Autowired
    LineService lineservice;

    //首页
    @RequestMapping("index")
    public String index(HttpSession session){
        List<Line> list;
        //首页左边分类 ‘境内游’
        list=lineservice.LineTypeShow("境内游");
        session.setAttribute("DomesticTrip", list);
        //首页左边分类 ‘境外游’
        list=lineservice.LineTypeShow("境外游");
        session.setAttribute("TravelAbroad", list);
        //首页 下面的内容
        list=lineservice.LineTypeShow("境内游");
        session.setAttribute("bottom", list);
        return "index";
    }

    //首页下面分类显示
    @RequestMapping("IndexBottom")
    public String IndexBottom(HttpSession session, @RequestParam("typename")String typename){
        List<Line> list =new ArrayList<Line>();
        list=lineservice.LineTypeShow(typename);
        session.setAttribute("bottom", list);
        return "index::AjaxLine";
    }

    //商品详情页
    @RequestMapping("/detail")
    public String detail(@RequestParam("lineid")int lineid,HttpSession session){
        Line line =lineservice.detail(lineid);
        session.setAttribute("detail", line);
        return "detail";
    }

    //分类页
    @RequestMapping("/type")
    public String type(HttpSession session,Page page,
                       @RequestParam("typename")String typename){
        /**
         * 顶端功能
         * 最新活动
         * */
        session.setAttribute("typename", typename);
        page.setNum(4);
        page.setNumCount(lineservice.typeAll(typename).size());
        //分页的 初始页（第一页）
        List<Line> list =lineservice.paging(typename, 0, page.getNum());
        session.setAttribute("paging", list);
        session.setAttribute("page", page);
        return "type";
    }

    //分页
    @RequestMapping("/paging")
    public String paging(@RequestParam("index")int index,HttpSession session){
        Page page=(Page) session.getAttribute("page");
        String typename=(String) session.getAttribute("typename");
        page.setIndex(index);
        /**
         * 1  0
         * 2  4
         * 3  8
         * */
        List<Line> list=lineservice.paging(typename,(page.getIndex()-1)*page.getNum(), page.getNum());
        session.setAttribute("page", page);
        session.setAttribute("paging", list);
        return "type";
    }
}
