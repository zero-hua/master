package ink.zerohua.springboot.mapper;

import ink.zerohua.springboot.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {

    @Select("select * from user where username=#{username}")
    public User findByUsername(String username);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into user(username,password,salt) values(#{username},#{password},#{salt})")
    public Boolean saveUser(User user);

}
