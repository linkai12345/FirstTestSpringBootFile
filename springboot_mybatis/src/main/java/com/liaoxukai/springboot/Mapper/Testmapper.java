package com.liaoxukai.springboot.Mapper;/*
 *@author:kai
 *@create:2019-11-2019/11/6-21:51
 */

import com.liaoxukai.springboot.Bean.user;
import org.apache.ibatis.annotations.Select;


public interface Testmapper {

    @Select("SELECT * FROM student WHERE id=#{id}")
    public user getdept(Integer id);

}
