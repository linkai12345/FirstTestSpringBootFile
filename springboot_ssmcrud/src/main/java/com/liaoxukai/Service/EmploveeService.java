package com.liaoxukai.Service;/*
 *@author:kai
 *@create:2019-10-2019/10/19-17:23
 */

import com.liaoxukai.Dao.EmploveeMapper;
import com.liaoxukai.bean.Emplovee;
import com.liaoxukai.bean.EmploveeExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmploveeService {

    @Resource
    private EmploveeMapper emploveeMapper;

    public Emplovee selectByPrimaryKeyWithDept(Integer empId){

        return emploveeMapper.selectByPrimaryKeyWithDept(empId);
    }

    public List<Emplovee> getAll() {
        return emploveeMapper.selectByExampleWithDept(null);
    }

    public void insert(Emplovee emplovee){
        emploveeMapper.insert(emplovee);
    }

    public Emplovee selectempname(String empname){
        return emploveeMapper.selectempname(empname);
    }

    public boolean updateByPrimaryKeySelective(Emplovee emplovee){

        return emploveeMapper.updateByPrimaryKeySelective(emplovee);
    }

    public void deleteByPrimaryKey(Integer empid){
        emploveeMapper.deleteByPrimaryKey(empid);
    }

    public void deleteBatch(List<Integer> ids){

        EmploveeExample example=new EmploveeExample();
        EmploveeExample.Criteria criteria=example.createCriteria();
        criteria.andEmpIdIn(ids);

        emploveeMapper.deleteByExample(example);
    }

}
