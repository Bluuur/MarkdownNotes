package com.bjpowernode.dao;

import com.bjpowernode.domain.MyStudent;
import com.bjpowernode.domain.Student;
import com.bjpowernode.vo.QueryParam;
import com.bjpowernode.vo.ViewStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {


    public Student selectStudentById(@Param("studentId") Integer id);


    List<Student> selectMultiParam(@Param("myname") String name,
                                   @Param("myage") Integer age);


    ViewStudent selectStudentReturnViewStudent(@Param("sid") Integer id);


    int countStudent();

    //定义方法返回Map
    Map<Object,Object> selectMapById(Integer id);

    /*
    *  使用resultMap定义映射关系
    * */
    List<Student> selectAllStudents();

    List<MyStudent> selectMyStudent();

    List<MyStudent> selectDiffColProperty();

    /*第一种模糊查询， 在java代码指定 like的内容*/
    List<Student> selectLikeOne(String name);

    /*name就是李值， 在mapper中拼接 like  "%" 李 "%" */
    List<Student> selectLikeTwo(String name);
}
