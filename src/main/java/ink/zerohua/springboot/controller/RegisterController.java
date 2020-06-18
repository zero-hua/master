package ink.zerohua.springboot.controller;

import ink.zerohua.springboot.domain.User;
import ink.zerohua.springboot.service.RegisterService;
import ink.zerohua.springboot.utils.ImageCode;
import ink.zerohua.springboot.utils.SendSmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @RequestMapping("")
    public String toRegister(){
        log.info("=========");
        return "register";
    }

    @RequestMapping("/doRegister")
    public String register(User user, Model model){

        if(registerService.register(user.getUsername(),user.getPassword())){
            model.addAttribute("msg","注册成功！");
            return "login";
        }else {
            model.addAttribute("msg","用户名重复,注册失败！");
            return "register";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/checkInputCode/{inputCode}")
    public boolean checkInputCode(@PathVariable("inputCode")String inputCode,
                                  HttpSession session){

        String code = (String) session.getAttribute("MACode");

        if (code.equals(inputCode)){
            return true;
        }else {
            return false;
        }
    }

    @ResponseBody//加上才可以ajax
    @RequestMapping("/sendCode/{phoneNumbers}")
    public Boolean sendCode(@PathVariable("phoneNumbers")String phoneNumbers,
                            Model model, HttpServletRequest request){

        String code = SendSmsService.sendSms(phoneNumbers);

        HttpSession session = request.getSession();
        session.removeAttribute("MACode");
        session.setAttribute("MACode",code);

        model.addAttribute("msg","已发送");
        return true;
    }

}
