package ink.zerohua.springboot.mapper;

import ink.zerohua.springboot.domain.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface DeptMapper {

    @Select("select * from dept")
    public List<Dept> findAllDept();
}
