package com.liaoxukai.Controller;/*
 *@author:kai
 *@create:2019-10-2019/10/22-21:27
 */

import com.liaoxukai.Service.DepartmentService;
import com.liaoxukai.bean.Department;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/emp")
@Controller
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;

    @ResponseBody
    @RequestMapping(value = "/getDepartment",method = RequestMethod.GET)
    public List<Department> getDepartment(){

        for (Department department:departmentService.getDepartment()){
            System.out.println(department.toString());
        }

        return departmentService.getDepartment();
    }

}
