package com.liaoxukai.Dao;

import com.liaoxukai.bean.Emplovee;
import com.liaoxukai.bean.EmploveeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmploveeMapper {
    public long countByExample(EmploveeExample example);

    public int deleteByExample(EmploveeExample example);

    public int deleteByPrimaryKey(Integer empId);

    public int insert(Emplovee record);

    public int insertSelective(Emplovee record);

    public List<Emplovee> selectByExample(EmploveeExample example);

    public Emplovee selectByPrimaryKey(Integer empId);

    public List<Emplovee> selectByExampleWithDept(EmploveeExample example);

    public Emplovee selectByPrimaryKeyWithDept(Integer empId);

    public int updateByExampleSelective(@Param("record") Emplovee record, @Param("example") EmploveeExample example);

    public int updateByExample(@Param("record") Emplovee record, @Param("example") EmploveeExample example);

    public boolean updateByPrimaryKeySelective(Emplovee record);

    public int updateByPrimaryKey(Emplovee record);

    public Emplovee selectempname(String empname);



}