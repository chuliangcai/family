package com.family.spring.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface StudentMapper {

    @Select("SELECT id,first_name,last_name,age FROM student WHERE id = #{id}")
    @ResultMap("baseResultMap")
    Student findById(@Param("id") Long id);

    @Select("select id,first_name,last_name,age FROM student WHERE age > #{age}")
    @Results(id = "baseAnnotationResultMap", value = {
            @Result(column = "first_name", property = "firstName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "last_name", property = "lastName", jdbcType = JdbcType.VARCHAR)})
    List<Student> findByAge(@Param("age") Integer age);

    List<Student> findAll();
}
