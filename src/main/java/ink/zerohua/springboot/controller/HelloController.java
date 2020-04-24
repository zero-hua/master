package ink.zerohua.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello,world";
    }

    //查处一些数据，在页面展示
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("abc","<h1>hello</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }


//    @RequestMapping("/sucess")
//    public String sucs(Map<String,Object> map){
//        map.put("aaa","<h1>hello</h1>");
//        map.put("uus", Arrays.asList("zhangsan","lisi","wangwu"));
//        return "success";//只有目标页面才能拿到该值
//    }

//    //这个index.html 必须放在 templates下面
//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "index";
//    }

}
