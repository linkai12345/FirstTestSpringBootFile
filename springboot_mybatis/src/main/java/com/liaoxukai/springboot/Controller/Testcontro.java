package com.liaoxukai.springboot.Controller;
/*
 *@author:kai
 *@create:2019-11-2019/11/6-21:50
 */
import com.liaoxukai.springboot.Bean.user;
import com.liaoxukai.springboot.Mapper.Testmapper;
import com.liaoxukai.springboot.Mapper.XmlConfigmapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Map;

//@RestController
@Controller
public class Testcontro {

    @Resource
    private Testmapper testmapper;

    @Resource
    private XmlConfigmapper xmlConfigmapper;

    @GetMapping(value = "/selectdept")
    public user getdept(@RequestParam("id") Integer id){

        return testmapper.getdept(id);
    }


    @GetMapping(value = "/getuser")
    public String getuser(Map<String,Object> map){

        map.put("list",xmlConfigmapper.getuser());

        return "ListUser";
    }


}
