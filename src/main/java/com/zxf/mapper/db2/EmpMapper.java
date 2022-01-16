package com.zxf.mapper.db2;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {

    List<Map<String, Object>> getEmp();
}
