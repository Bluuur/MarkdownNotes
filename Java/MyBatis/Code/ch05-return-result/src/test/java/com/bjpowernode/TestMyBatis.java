package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.MyStudent;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import com.bjpowernode.vo.QueryParam;
import com.bjpowernode.vo.ViewStudent;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMyBatis {

    @Test
    public void testSelectStudentById(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao  =  sqlSession.getMapper(StudentDao.class);

        Student student = dao.selectStudentById(1001);

        System.out.println("student="+student);
    }

    @Test
    public void testSelectMultiParam(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectMultiParam("李四",20);

        for(Student stu: students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();
    }


    @Test
    public void testSelectViewStudent(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao  =  sqlSession.getMapper(StudentDao.class);

        ViewStudent student = dao.selectStudentReturnViewStudent(1005);

        System.out.println("1005 student="+student);
    }

    @Test
    public void testSelectCount(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao  =  sqlSession.getMapper(StudentDao.class);

        int counts  = dao.countStudent();
        System.out.println("学生数量="+counts);
    }

    //返回Map
    @Test
    public void testSelecMap(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao  =  sqlSession.getMapper(StudentDao.class);

        Map<Object,Object> map = dao.selectMapById(1001);
        System.out.println("map=="+map);
    }

    //=======================================
    @Test
    public void testSelectAllStudents(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectAllStudents();

        for(Student stu: students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectAllStudents2(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<MyStudent> students = dao.selectMyStudent();

        for(MyStudent stu: students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectDiffColProperty(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<MyStudent> students = dao.selectDiffColProperty();

        for(MyStudent stu: students){
            System.out.println("#######学生="+stu);
        }
        sqlSession.close();
    }


    @Test
    public void testSelectLikeOne(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        //准备好like的内容
        String name = "%李%";
        List<Student> students = dao.selectLikeOne(name);

        for(Student stu: students){
            System.out.println("#######学生="+stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectLikeTwo(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        //准备好like的内容
        String name = "张";
        List<Student> students = dao.selectLikeTwo(name);

        for(Student stu: students){
            System.out.println("*******学生="+stu);
        }
        sqlSession.close();
    }
}
