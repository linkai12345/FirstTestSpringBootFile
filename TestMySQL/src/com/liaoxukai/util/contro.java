package com.liaoxukai.util;/*
 *@author:kai
 *@create:2019-11-2019/11/7-9:06
 */

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class contro {

    @Test
    public void test(){

        String jdbcproperties="JDBC.properties";
        String QuerySql="SELECT * FROM tbl_dept WHERE dept_id=1";

        executeQuery(jdbcproperties,QuerySql);

    }

    public void executeQuery(String jdbcproperties,String QuerySql){
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            connection=getConnection(jdbcproperties);
            statement=connection.createStatement();
            resultSet=statement.executeQuery(QuerySql);

            while (resultSet.next()){

                Integer id=resultSet.getInt("dept_id");
                String name=resultSet.getString("dept_name");
                System.out.println("id:"+id);
                System.out.println("name:"+name);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {


        }


    }



    public  Connection getConnection(String jdbcproperties) throws Exception {

        Properties properties=new Properties();
        InputStream inputStream=getClass().getClassLoader().getResourceAsStream(jdbcproperties);
        properties.load(inputStream);
        String user=properties.getProperty("user");
        String password=properties.getProperty("password");
        String driver=properties.getProperty("driver");
        String jdbcUrl=properties.getProperty("jdbcUrl");
        Class.forName(driver);
        inputStream.close();
        return DriverManager.getConnection(jdbcUrl,user,password);
    }

}
