package com.itheima.oracle;

import org.junit.Test;

import java.sql.*;

public class OracleDemo {

    @Test
    public void javaCallOracle() throws Exception {
        //加载数据库驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //得到connection连接
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "itheima", "itheima");
        //得到预编译的statement对象
        PreparedStatement pstm = connection.prepareStatement("select * from emp where empno=?");
        //给参数赋值
        pstm.setObject(1, "7788");
        //执行数据库查询操作
        ResultSet rs = pstm.executeQuery();
        //输出结果
        while (rs.next()) {
            System.out.println(rs.getString("ename"));
        }
        //释放资源
        rs.close();
        pstm.close();
        connection.close();
    }
}
