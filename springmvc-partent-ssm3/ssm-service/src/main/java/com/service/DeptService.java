package com.service;

import com.entity.DeptEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptService {
    List<DeptEntity> getPageHelper(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);

    boolean getInsert(DeptEntity deptEntity);
}
