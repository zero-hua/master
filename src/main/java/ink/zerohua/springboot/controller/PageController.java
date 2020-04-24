package ink.zerohua.springboot.controller;

import ink.zerohua.springboot.domain.Dept;
import ink.zerohua.springboot.mapper.DeptMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//返回到某个页面，如员工控制页，部门控制页，，，，，，，，

@Controller
public class PageController {

//    @Autowired
//    DeptMapper deptMapper;
//
//    @GetMapping("/depts")
//    public String findAllDept(Model model){
//        List<Dept> depts = deptMapper.findAllDept();
//        model.addAttribute("depts",depts);
//        return "emp/empList";
//    }
}
