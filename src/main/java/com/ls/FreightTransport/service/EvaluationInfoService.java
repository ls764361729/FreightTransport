package com.ls.FreightTransport.service;

import com.ls.FreightTransport.entity.EvaluationInfo;

import java.util.List;

public interface EvaluationInfoService {

    /**
     * 删除操作 根据主键
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(int id);

    /**
     * 添加操作
     *
     * @param evaluationInfo
     * @return
     */
    int insert(EvaluationInfo evaluationInfo);

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    EvaluationInfo selectByPrimaryKey(int id);

    /**
     * 全部查询操作
     *
     * @return
     */
    List<EvaluationInfo> selectAll(int sId, String sName, String dName);

    /**
     * 修改操作
     *
     * @param evaluationInfo
     * @return
     */
    int updateByPrimaryKey(EvaluationInfo evaluationInfo);

    /**
     * 查询所有数据
     * @return
     */
    int count(int sId, String sName, String dName);
}