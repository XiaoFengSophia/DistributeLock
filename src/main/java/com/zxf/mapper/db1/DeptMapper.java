package com.zxf.mapper.db1;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DeptMapper {

    List<Map<String, Object>> getDept();
}
