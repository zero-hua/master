package ink.zerohua.springboot.service.emp.impl;

import ink.zerohua.springboot.domain.Employee;
import ink.zerohua.springboot.mapper.EmpMapper;
import ink.zerohua.springboot.service.emp.IEmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class EmpServiceImpl implements IEmpService {

    @Autowired
    EmpMapper empMapper;

    @Override
    public int addEmp(Employee employee) {
        try {
            empMapper.addEmp(employee);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            log.info("保存员工失败");
            return 0;
        }
    }

    @Override
    public int deleteEmpById(Integer id) {
        try {
            empMapper.deleteEmpById(id);
            log.info("删除ID为:"+id+"号员工成功");
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            log.info("删除ID为:"+id+"号员工失败");
            return 0;
        }
    }

    @Override
    public int updateEmp(Employee employee) {
        try {
            empMapper.updateEmp(employee);
            log.info("保存员工成功");
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            log.info("保存员工失败");
            return 0;
        }
    }

    @Override
    public List<Employee> findAllEmp() {
        List<Employee> employees = null;
        try {
            employees = empMapper.findAllEmp();
            log.info("查找所有员工成功");
        } catch (Exception e) {
            e.printStackTrace();
            log.info("查找所有员工失败");
        }
        return employees;
    }

    @Override
    public List<Employee> findOneDept(String dName) {
        List<Employee> employees = null;
        try {
            employees = empMapper.findOneDept(dName);
            log.info("查找"+dName+"所有员工成功");
        } catch (Exception e) {
            e.printStackTrace();
            log.info("查找"+dName+"所有员工失败");
        }
        return employees;
    }

    @Override
    public Employee findEmpById(Integer id) {
        Employee employee = null;
        try {
            employee = empMapper.findEmpById(id);
            log.info("查找ID为:"+id+"号员工成功");
        } catch (Exception e) {
            e.printStackTrace();
            log.info("查找ID为:"+id+"号员工成功");
        }
        return employee;
    }

    @Override
    public List<Employee> findEmpByName(String name) {
        List<Employee> employees = null;
        try {
            employees = empMapper.findEmpByName(name);
            log.info("查找姓名为："+name+"员工成功");
        } catch (Exception e) {
            e.printStackTrace();
            log.info("查找姓名为："+name+"员工失败");
        }
        return employees;
    }

}
