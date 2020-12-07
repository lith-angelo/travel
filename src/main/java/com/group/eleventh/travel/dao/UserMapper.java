package com.group.eleventh.travel.dao;

import com.group.eleventh.travel.entity.Customer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    /**
     * 查询用户名是否存在，若存在，不允许注册
     * 注解@Param(value)  若value与可变参数相同，注解可省略
     * 注解@Result    列名和字段名相同，注解可省略
     * @param username 用户名
     * @return 是否找到了
     */
    @Select(value = "select u.account, u.password from customer u where u.account = #{account}")
    @Results
            ({@Result(property = "account", column = "account"),
                @Result(property = "password", column = "password")})
    Customer finduserByName(@Param("account") String username);

    /**
     * 注册，插入一条user记录
     * @param customer  用户实例
     */
    @Insert(value = "insert into customer (account, name, password, gender, identityID, tel) " +
            "values(#{account}, #{name}, #{password}, #{gender}, #{identityID}, #{tel})")
//    加入该注解可以保存对象后，查看对象插入id
    @Options(useGeneratedKeys = true, keyProperty = "customerID", keyColumn = "customerID")
    void regist(Customer customer);

    /**
     * d登录
     * @param customer  用户实例
     * @return  customerID
     */
    @Select("select u.customerID from customer u where u.account = #{account} and password = #{password}")
    Integer login(Customer customer);

}
