package ink.zerohua.springboot.controller;


import ink.zerohua.springboot.service.user.IUserService;
import ink.zerohua.springboot.utils.ImageCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@Slf4j
//登录控制器
//@RequestMapping("/login")
public class LoginController {

    @Autowired
    IUserService userService;

    @RequestMapping("/imgCode")
    public void creatImgCode(HttpServletRequest request, HttpServletResponse response){
        try {
            response.setContentType("image/jpg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            ImageCode imageCode = new ImageCode();
            imageCode.getCode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping("/imgCodeCheck/{inputCode}")
    public boolean imgCodeCheck(@PathVariable("inputCode")String inputCode,
                                HttpSession session){

        String randCode = (String) session.getAttribute("randomCode");

        if(randCode.equals(inputCode)){
            return true;
        }else {
            return false;
        }
    }

    @PostMapping(value = "/loginCheck")
    public String loginCheck(@RequestParam("username")String username,
                             @RequestParam("password")String password,
                             HttpSession session, Map <String,Object> map){
        log.info("用户："+username+"登陆了");

        Subject user = SecurityUtils.getSubject();

        if(user.isAuthenticated() == false) {
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            try {
                user.login(token);
            } catch (AuthenticationException e) {
                e.getMessage();
                e.printStackTrace();
                //登录失败，返回登录页面并且返回错误信息
                map.put("msg", "用户名密码错误！");
                return "login";
            }
        }
        session.setAttribute("loginUser",username);

        return "redirect:/main";//重定向，防止刷新之后重复提交
        /*
         * 注意：如果是请求转发 ex:return "/main.html"; 是不会用到模板引擎的，所以会报错
         * 而重定向是会用到模板引擎的 */
    }

}
