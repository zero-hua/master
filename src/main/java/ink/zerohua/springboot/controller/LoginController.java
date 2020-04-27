package ink.zerohua.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@Slf4j
//登录控制器
public class LoginController {

    @PostMapping(value = "/loginCheck")
    public String loginCheck(@RequestParam("username")String username,
                             @RequestParam("password")String password,
                             HttpSession session, Map <String,Object> map){
        log.info("用户："+username+"登陆了");
        if(!username.isEmpty() && password.equals("123456")){
            session.setAttribute("loginUser",username);
            //return "/main.html";
            return "redirect:/main";//重定向，防止刷新之后重复提交
            /*
            * 注意：如果是请求转发 ex:return "/main.html"; 是不会用到模板引擎的，所以会报错
            * 而重定向是会用到模板引擎的 */

        }else{
            //登录失败，返回登录页面并且返回错误信息
            map.put("msg","用户名密码错误！");
            return "login";
        }
    }
}
