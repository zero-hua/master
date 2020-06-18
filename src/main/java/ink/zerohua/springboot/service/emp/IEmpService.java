package ink.zerohua.springboot.service.emp;

import ink.zerohua.springboot.domain.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IEmpService {

    //增加员工
    public int addEmp(Employee employee);

    //删除员工
    public int deleteEmpById(Integer id);

    //修改员工
    public int updateEmp(Employee employee);

    //查找所有员工
    public List<Employee> findAllEmp();

    //查找某个部门所有员工
    public List<Employee> findOneDept(String dName);

    //查找员工通过Id
    public Employee findEmpById(Integer id);

    //查找员工通过姓名
    public List<Employee> findEmpByName(String name);
}
