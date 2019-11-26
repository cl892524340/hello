package com.controller;

import com.entity.DeptEntity;
import com.github.pagehelper.PageInfo;
import com.service.DeptService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller//容器管理
public class DeptController {
    @Autowired//自动注入
    private DeptService deptService;

    @RequestMapping("index")
    public PageInfo getAll(Integer pageNum){
        List<DeptEntity> entities=deptService.getPageHelper(pageNum,6);
        PageInfo pageInfo=new PageInfo(entities,5);
        return pageInfo;
    }
}
