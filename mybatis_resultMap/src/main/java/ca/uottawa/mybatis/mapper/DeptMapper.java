package ca.uottawa.mybatis.mapper;

import ca.uottawa.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    Dept getDeptNameById(@Param("deptId") Integer deptId);

    Dept getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);

    Dept getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);

    Dept getDeptAndEmpByStepOne(@Param("deptId") Integer deptId);
}
