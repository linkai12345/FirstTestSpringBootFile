package com.liaoxukai.Service;/*
 *@author:kai
 *@create:2019-10-2019/10/22-21:26
 */

import com.liaoxukai.Dao.DepartmentMapper;
import com.liaoxukai.bean.Department;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentService {

   @Resource
    private DepartmentMapper departmentMapper;

    public List<Department> getDepartment(){

        return departmentMapper.selectByExample(null);
    }

}
