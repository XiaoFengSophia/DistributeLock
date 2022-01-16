package com.zxf.controller;


import com.zxf.entity.OptResult;
import com.zxf.service.EmpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/emp")
public class EmpController {

    @Resource
    private EmpService empService;

    @GetMapping("/getEmp")
    public OptResult getEmp(){

        return empService.getEmp();
    }
}
