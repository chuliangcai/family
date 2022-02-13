package com.family.spring.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper {
    @Select("SELECT * FROM CITY WHERE state = #{state}")
    Student findByState(@Param("state") String state);
}
