package ink.zerohua.springboot.service.dept.impl;

import ink.zerohua.springboot.domain.Dept;
import ink.zerohua.springboot.mapper.DeptMapper;
import ink.zerohua.springboot.service.dept.IDeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DeptServiceImpl implements IDeptService {

    @Autowired
    DeptMapper deptMapper;

    @Override
    public List<Dept> findAllDept() {
        List<Dept> depts = null;
        try {
            depts = deptMapper.findAllDept();
            log.info("查找所有部门成功");
        } catch (Exception e) {
            e.printStackTrace();
            log.info("查找所有部门失败");
        }
        return depts;
    }
}
