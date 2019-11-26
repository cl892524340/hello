package com.service.impl;

import com.dao.DeptDao;
import com.entity.DeptEntity;
import com.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//容器管理
public class DeptServiceImpl implements DeptService {
    @Autowired//自动注入
    public DeptDao deptDao;
    @Override
    public List<DeptEntity> getPageHelper(Integer pageNum, Integer pageSize) {
        return deptDao.getPageHelper(pageNum,pageSize);
    }

    @Override
    public boolean getInsert(DeptEntity deptEntity) {
        if (deptDao.getInsert(deptEntity)){
            System.out.println("添加成功");
            return true;
        }else {
            System.out.println("添加失败");
            return false;
        }
    }


}
