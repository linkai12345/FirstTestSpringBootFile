package com.liaoxukai.Dao;

import com.liaoxukai.bean.Department;
import com.liaoxukai.bean.DepartmentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {

    public long countByExample(DepartmentExample example);

    public int deleteByExample(DepartmentExample example);

    public int deleteByPrimaryKey(Integer deptId);

    public int insert(Department record);

    public int insertSelective(Department record);

    public List<Department> selectByExample(DepartmentExample example);

    public Department selectByPrimaryKey(Integer deptId);

    public int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    public int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    public int updateByPrimaryKeySelective(Department record);

    public int updateByPrimaryKey(Department record);
}