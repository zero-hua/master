package ink.zerohua.springboot.controller;

import ink.zerohua.springboot.domain.Dept;
import ink.zerohua.springboot.domain.Employee;
import ink.zerohua.springboot.service.dept.IDeptService;
import ink.zerohua.springboot.service.emp.IEmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//PathVariable从请求路径中拿到参数

@Slf4j
@Controller
public class EmployeeController {

    @Autowired
    IEmpService empService;

    @Autowired
    IDeptService deptService;

//    final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    /*
    * Model model ,此对象里面只能存储一个对象，不过包括了集合对象
    * 方法里面的参数，只在一个page里面有用
    * */

    //查询所有员工
    @GetMapping("/emps")
    public String findAll(Map<String,Object> map){
        List<Employee> employees = empService.findAllEmp();
        map.put("emps",employees);

        List<Dept> depts = deptService.findAllDept();
        map.put("dpts",depts);
        return "emp/empList";
    }

    @GetMapping("emps/{dName}")
    public String findOneDept(Map<String,Object> map,@PathVariable("dName") String dName){
        List<Employee> employees = empService.findOneDept(dName);
        map.put("emps",employees);

        List<Dept> depts = deptService.findAllDept();
        map.put("dpts",depts);
        return "emp/empList";
    }

    @GetMapping("/emp/{id}")
    public String findEmpById1(@PathVariable("id") Integer id,Map<String,Object> map){
        Employee employee = empService.findEmpById(id);
        map.put("employee",employee);

        List<Dept> depts = deptService.findAllDept();
        map.put("depts",depts);

        log.info("来到修改页面");
        return "emp/addAndChange";
    }

    @GetMapping("/emp/n/{name}")
    public String findEmpByName(@PathVariable("name")String name,Map<String,Object> map){
        List<Employee> employees = empService.findEmpByName(name);
        map.put("employee",employees);
        List<Dept> depts = deptService.findAllDept();
        map.put("depts",depts);
        return "emp/empList";
    }

    @GetMapping("/emp/i/{id}")
    public String findEmpById2(@PathVariable("id") Integer id,Map<String,Object> map){
        Employee employee = empService.findEmpById(id);
        map.put("employee",employee);
        List<Dept> depts = deptService.findAllDept();
        map.put("depts",depts);
        return "emp/addAndChange";
    }

    @GetMapping("/emp")
    public String toAddPage(Map<String,Object> map){
        log.info("来到增加页面");
        List<Dept> depts = deptService.findAllDept();
        map.put("depts",depts);
        return "emp/addAndChange";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        empService.addEmp(employee);
        return "emp/empList";
    }

    @PutMapping("/emp")
    public String update(Employee employee){
        empService.updateEmp(employee);
        return "emp/empList";
    }

    @DeleteMapping("/emp/{id}")
    public String delete(@PathVariable("id") Integer id){
        empService.deleteEmpById(id);
        return "emp/empList";
    }
}
