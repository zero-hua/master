package ink.zerohua.springboot.service;

import ink.zerohua.springboot.domain.User;
import ink.zerohua.springboot.mapper.UserMapper;
import ink.zerohua.springboot.utils.EnCode;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegisterService {

    @Autowired
    UserMapper userMapper;

    //注册用户
    public Boolean register(String username,String password){

        User user = userMapper.findByUsername(username);

        if(user != null){
            //用户名重复
            return false;
        }

        user = new User();

        String salt = new SecureRandomNumberGenerator().nextBytes().toString();//盐
        String encodedPassword = EnCode.getEnCodeStr(password,salt);

        System.out.printf("盐：<%s>   密码：<%s>",salt,encodedPassword);

        user.setUsername(username);
        user.setPassword(encodedPassword);
        user.setSalt(salt);
        userMapper.saveUser(user);

        return true;
    }

    //验证码功能


}
