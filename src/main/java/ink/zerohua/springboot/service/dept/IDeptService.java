package ink.zerohua.springboot.service.dept;

import ink.zerohua.springboot.domain.Dept;

import java.util.List;

public interface IDeptService {

    //查找所有部门
    public List<Dept> findAllDept();
}
