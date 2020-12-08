package com.group.eleventh.travel.service;

import com.group.eleventh.travel.dao.LineMapper;
import com.group.eleventh.travel.entity.Line;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineService {
    @Autowired
    LineMapper lineMapper;

    //首页左边分类显示
    public List<Line> LineTypeShow(String typename){
        List<Line> list;
        list=lineMapper.lineTypeShow(typename);
        return list;

    }

    public Line detail(int lineid) {
        return lineMapper.detail(lineid);
    }

    public List<Line> typeAll(String typename) {
        return lineMapper.typeAll(typename);
    }

    public List<Line> paging(String typename, int index, int num) {
        return lineMapper.paging(typename, index, num);
    }
}
