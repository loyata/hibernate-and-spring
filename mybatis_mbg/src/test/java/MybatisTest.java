import ca.uottawa.mybatis.mapper.EmpMapper;
import ca.uottawa.mybatis.pojo.Emp;
import ca.uottawa.mybatis.pojo.EmpExample;
import ca.uottawa.mybatis.utils.SqlSessionUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MybatisTest {
    @Test
    public void testMBG(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);

        // 根据主键查询
//        Emp emp = empMapper.selectByPrimaryKey(1);
//        System.out.println(emp);

        // 根据条件查询, null为select *
//        List<Emp> list = empMapper.selectByExample(null);
//        list.forEach(System.out::println);

        // 根据条件查询, 指定条件(QBC, query by criterion)
//        EmpExample example = new EmpExample();
//        example.createCriteria().andGenderEqualTo("male").andAgeBetween(20, 30); // where XXX and XXX
//        example.or().andGenderEqualTo("female");//or (XXX and XXX and XXX ...) 需要几个or就得写几个example.or()
//        List<Emp> list = empMapper.selectByExample(example);
//        list.forEach(System.out::println);

        // 普通修改, 如果字段为null也会修改
//        Emp emp = new Emp(1, "Ivanka Trump", null, "female");
//        empMapper.updateByPrimaryKey(emp);

        // 选择性修改, 字段为null不会修改这个字段
        Emp emp = new Emp(1, "Ivanka Trump", null, "female");
        empMapper.updateByPrimaryKeySelective(emp);
    }

    @Test
    public void testPagination(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Page<Object> page = PageHelper.startPage(1, 3);
        List<Emp> list = mapper.selectByExample(null);
        PageInfo<Emp> pageInfo = new PageInfo<>(list, 3);// 根据总页数查询当前页的分页设计
        System.out.println(pageInfo);
        list.forEach(System.out::println);
    }

}
