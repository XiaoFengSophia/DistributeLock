package com.zxf.service.impl;

import com.zxf.entity.OptResult;
import com.zxf.mapper.db1.DeptMapper;
import com.zxf.mapper.db2.EmpMapper;
import com.zxf.service.EmpService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {

    @Resource
    private EmpMapper empMapper;

    @Resource
    private DeptMapper deptMapper;

    @Override
    public OptResult getEmp() {
        OptResult result = new OptResult();
        List<Map<String, Object>> emps = empMapper.getEmp();
        result.setCode("1");
        result.setMsg("操作成功！");
        result.setData(emps);
        return result;
    }
}
