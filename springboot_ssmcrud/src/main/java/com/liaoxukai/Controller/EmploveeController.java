package com.liaoxukai.Controller;/*
 *@author:kai
 *@create:2019-10-2019/10/20-9:42
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liaoxukai.Service.EmploveeService;
import com.liaoxukai.bean.Emplovee;
import com.liaoxukai.bean.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/emps")
@Controller
public class EmploveeController {

    @Resource
    private EmploveeService emploveeService;

    @ResponseBody
    @RequestMapping(value = "/All",method = RequestMethod.GET)
    public Msg getAllJson(@RequestParam(value = "pn",defaultValue = "1") Integer pn){

        PageHelper.startPage(pn,8);
        PageHelper.orderBy("emp_id asc");
        List<Emplovee> list=emploveeService.getAll();
        PageInfo page=new PageInfo(list,5);
        System.out.println("进来了，初始化");
        return Msg.success().add("pageInfo",page);
    }

    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Msg add(Emplovee emplovee){

        emploveeService.insert(emplovee);

        return Msg.success();
    }


    @ResponseBody
    @RequestMapping(value = "/prove",method = RequestMethod.GET)
    public Msg prove(@RequestParam(value="empname") String empname){
        Emplovee emplovee=emploveeService.selectempname(empname);
        if (emplovee!=null)
            return Msg.success();
        else
            return Msg.fail();
    }

    @ResponseBody
    @RequestMapping(value = "/selectedit",method = RequestMethod.GET)
    public Msg selectByPrimaryKeyWithDept(@RequestParam(value = "id") Integer ids){

        Emplovee emplovee=emploveeService.selectByPrimaryKeyWithDept(ids);

        return Msg.success().add("emp",emplovee);
    }

    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Msg updateByPrimaryKeySelective(Emplovee emplovee){

        String email=emplovee.getEmail();
        String emailjy="^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";


        emploveeService.updateByPrimaryKeySelective(emplovee);

        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "/edit_delet/{empids}",method = RequestMethod.DELETE)
    public Msg edit_delet(@PathVariable("empids") String empids){

        if (empids.contains("-")){
            String[] ids=empids.split("-");
            List<Integer> list=new ArrayList<>();
            for (String s:ids){
                list.add(Integer.parseInt(s));
            }
            emploveeService.deleteBatch(list);
        }else {
            Integer empid=Integer.parseInt(empids);
            emploveeService.deleteByPrimaryKey(empid);
        }
        return Msg.success();
    }



}
