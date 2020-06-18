package ink.zerohua.springboot.service.user;

import ink.zerohua.springboot.domain.User;

public interface IUserService {

    public User findUser(String username);

    public Boolean saveUser(User user);
}
