package ink.zerohua.springboot.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//登录拦截器，需要加入IOC容器中才能起作用
public class LoginHandlerInterceptor implements HandlerInterceptor {

    //判断是否登录
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");//注意参数大小写!!!!!!!!!
        if(loginUser==null){
            //没有登录，返回登录页面并且设置错误信息
            request.setAttribute("msg","请先登录！");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
            return true;
        }
    }
}
