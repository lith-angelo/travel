package com.group.eleventh.travel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.group.eleventh.travel.entity.Line;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LineMapper {
    //首页左边 分类显示
    @Select("SELECT * from line WHERE lineTypeID="
            + "(SELECT linetype.lineTypeID from linetype"
            + " WHERE typename=#{typename}) LIMIT 6")
    List<Line> lineTypeShow(String typename);

    //商品详情页
    @Select("SELECT * from line WHERE lineID=#{lineid}")
    Line detail(@Param("lineid")int lineid);

    //分类页  根据线路类型查询所有
    @Select("SELECT * from line WHERE  lineTypeID=(SELECT lineTypeID FROM linetype WHERE typename=#{typename})")
    List<Line> typeAll(@Param("typename")String typename);

    //分类页中的  分页功能
    @Select("SELECT * from line WHERE  lineTypeID="
            + "(SELECT lineTypeID FROM linetype WHERE typename=#{typename})"
            + " LIMIT #{index},#{num}")
    List<Line> paging(@Param("typename")String typename,@Param("index")int index,@Param("num")int num);
}
