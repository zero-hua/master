package ink.zerohua.springboot.config;


import ink.zerohua.springboot.component.LoginHandlerInterceptor;
import ink.zerohua.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//使用 WebMvcConfigurer 来进行扩展
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer configurer = new WebMvcConfigurer() {
            //注册视图解析器
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main").setViewName("dashboard");
                registry.addViewController("/main.html").setViewName("dashboard");
                //       <a class="btn btn-sm" th:href="@{/index.html(l='zh_CN')}">中文</a>  对应！！！！！！！！！
            }
            //注册拦截器
            /**
             * 在springboot2.0版本以前拦截器会默认对静态资源不拦截，但是springboot 2.0 以后拦截器会拦截所有，
             * 所以需要重写addInterceptors方法，不管是自己的静态资源还是webjars中的资源，都要放行。
             */
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/loginCheck","/asserts/**","/webjars/**");
            }
        };
        return configurer;
    }

    //注册区域信息对象
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
