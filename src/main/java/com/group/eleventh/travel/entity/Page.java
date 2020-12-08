package com.group.eleventh.travel.entity;

import org.springframework.stereotype.Service;

@Service
public class Page {
    private int index=1; //当前页面， 默认页面 初始值=1
    private int num; //每页显示的数据
    private int numCount; //从数据库共查询的数据
    private int pageCount;//一共有多少页   numcount/num

    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public int getNumCount() {
        return numCount;
    }
    public void setNumCount(int numCount) {
        this.numCount = numCount;
        //设置一共有多少条数据 同时计算出 一共有多少页
        pageCount=numCount/num;
        if(numCount%num!=0){
            pageCount++;
        }
    }
    public int getPageCount() {
        return pageCount;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }


}