package ink.zerohua.springboot.controller;

import ink.zerohua.springboot.domain.Dept;
import ink.zerohua.springboot.domain.Employee;
import ink.zerohua.springboot.mapper.DeptMapper;
import ink.zerohua.springboot.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//PathVariable从请求路径中拿到参数

@Controller
public class EmployeeController {

    @Autowired
    EmpMapper empMapper;

    @Autowired
    DeptMapper deptMapper;

    /*
    * Model model ,此对象里面只能存储一个对象，不过包括了集合对象
    * 方法里面的参数，只在一个page里面有用
    * */

    //c查询所有员工
    @GetMapping("/emps")
    public String findAll(Map<String,Object> map){
        List<Employee> employees = empMapper.findAllEmp();
        System.out.println("执行了查询所有员工");
        List<Dept> depts = deptMapper.findAllDept();
        System.out.println("查询了所有部门");
        map.put("emps",employees);
        map.put("dpts",depts);
        return "emp/empList";
        //大小写不能错，必须完全一样。否则找不到
    }

    @GetMapping("emps/{dName}")
    public String findOneDept(Map<String,Object> map,@PathVariable("dName") String dName){
        List<Employee> employees = empMapper.findOneDept(dName);
        System.out.println("查询了"+dName+"的所有员工");
        List<Dept> depts = deptMapper.findAllDept();
        System.out.println("查询了所有部门");
        map.put("emps",employees);
        map.put("dpts",depts);
        return "emp/empList";
    }

    @GetMapping("/emp/{id}")
    public String findEmpById(@PathVariable("id") Integer id,Model model){
        System.out.println("执行了查询一个");
        Employee employee = empMapper.findEmpById(id);
        model.addAttribute("employee",employee);
        return "empList";
    }

    @GetMapping("/emp")
    public String toAddPage(){
        System.out.println("来到增加页面");
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("执行了增加员工");
        System.out.println(employee.toString());
        empMapper.addEmp(employee);
        return "emp/empList";
    }

    @PutMapping("/emp")
    public String update(){
        System.out.println("修改了员工");
        //empMapper.updateEmp(employee);
        return "empList";
    }

    @DeleteMapping("/emp/{id}")
    public String delete(@PathVariable("id") Integer id){
        System.out.println("执行了删除");
        empMapper.deleteEmpById(id);
        return "emp/empList";
    }
}
