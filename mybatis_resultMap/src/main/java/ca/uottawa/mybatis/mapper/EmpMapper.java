package ca.uottawa.mybatis.mapper;

import ca.uottawa.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    Emp getEmpByEmpId(@Param("empId") int empId);

    Emp getEmpJoinByEmpId(@Param("empId") int empId);

    Emp getEmpAndDeptByStepOne(@Param("empId") int empId);

    List<Emp> getDeptAndEmpByStepTwo(@Param("deptId") Integer deptId);

    int addEmpInBulk(List<Emp> emps);

    int deleteEmpInBulk(@Param("empIds") Integer[] empIds);
}
