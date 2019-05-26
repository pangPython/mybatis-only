package cn.pangpython;

import cn.pangpython.mybatisonly.dao.EmployeMapper;
import cn.pangpython.mybatisonly.model.Employe;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("mybatis only");
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            EmployeMapper mapper = sqlSession.getMapper(EmployeMapper.class);
            Employe employe = mapper.selectByPrimaryKey(10001);
            System.out.printf(employe.toString());
        } finally {
            sqlSession.close();
        }
    }
}
