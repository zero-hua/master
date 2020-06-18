package ink.zerohua.springboot.shiro;

import ink.zerohua.springboot.domain.User;
import ink.zerohua.springboot.mapper.UserMapper;
import ink.zerohua.springboot.utils.EnCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = new String(token.getPassword());
        log.info("验证了："+username);

        User user = userMapper.findByUsername(username);

//        String salt = user.getSalt();
//        String enCodePassword = EnCode.getEnCodeStr(password,salt);

        if(user == null){
            throw new AuthenticationException("靓仔，错了");
        }

        //此处随后会调用交给AuthenticatingRealm使用CredentialsMatcher
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                username,
                user.getPassword(),
                //salt=username+salt
                ByteSource.Util.bytes(user.getSalt()),
                getName());
        return info;
    }
}
