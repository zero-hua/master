package ink.zerohua.springboot.service.user.impl;

import ink.zerohua.springboot.domain.User;
import ink.zerohua.springboot.mapper.UserMapper;
import ink.zerohua.springboot.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findUser(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public Boolean saveUser(User user) {
        return userMapper.saveUser(user);
    }
}
