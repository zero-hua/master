package ink.zerohua.springboot.mapper;

import ink.zerohua.springboot.domain.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface EmpMapper {

    //使用自动生成主键
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into employee(name,sex,birthday,email,dept) values(#{name},#{sex},#{birthday},#{email},#{dept})")
    public int addEmp(Employee employee);

    @Delete("delete from employee where id=#{id}")
    public void deleteEmpById(Integer id);

    @Update("update empployee set name=#{name},sex=#{sex},age=#{age},email=#{email},dept=#{dept} where id=#{id}")
    public void updateEmp(Employee employee);

    @Select("select * from employee")
    public List<Employee> findAllEmp();

    @Select("select * from employee where dept=#{dName}")
    public List<Employee> findOneDept(String dName);

    @Select("select * from employee where id=#{id}")
    public Employee findEmpById(Integer id);
}
