import ca.uottawa.mybatis.mapper.DeptMapper;
import ca.uottawa.mybatis.mapper.EmpMapper;
import ca.uottawa.mybatis.pojo.Dept;
import ca.uottawa.mybatis.pojo.Emp;
import ca.uottawa.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class test {
    @Test
    public void getEmpByEmpId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpByEmpId(1);
        System.out.println(emp);
    }


    @Test
    public void getEmpJoinByEmpId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpJoinByEmpId(1);
        System.out.println(emp);
    }

    @Test
    public void twoStepManual(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Emp emp = empMapper.getEmpByEmpId(1);
        Dept dept = deptMapper.getDeptNameById(emp.getDeptId());
        System.out.println(dept);
    }

    @Test
    public void twoStep(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Emp emp = empMapper.getEmpAndDeptByStepOne(1);
        System.out.println(emp);
    }

    @Test
    public void getDeptAndEmpByDeptId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = deptMapper.getDeptAndEmpByDeptId(2);
        System.out.println(dept);
    }

    @Test
    public void addEmpInBulk(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp1 = new Emp(null, "Name1", 23, "female", null);
        Emp emp2 = new Emp(null, "Name2", 45, "male", null);
        List<Emp> list = Arrays.asList(emp1, emp2);
        int res = empMapper.addEmpInBulk(list);
        System.out.println(res);
    }

    @Test
    public void deleteEmpInBulk(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        int res = empMapper.deleteEmpInBulk(new Integer[]{8, 9, 10, 11, 12 ,13});
        System.out.println(res);
    }

    @Test
    public void tt(){
        System.out.println("Test");
    }
}
