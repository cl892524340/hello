package com.dao;

import com.entity.DeptEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptDao {
    List<DeptEntity> getPageHelper(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);

    boolean getInsert(DeptEntity deptEntity);
}
