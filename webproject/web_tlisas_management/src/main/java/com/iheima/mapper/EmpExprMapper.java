package com.iheima.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.iheima.pojo.EmpExpr;

@Mapper
public interface EmpExprMapper {

    public void insertBatch(List<EmpExpr> exprList);

    public void deleteByEmpIds(List<Integer> ids);
}
