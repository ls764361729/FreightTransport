package com.ls.FreightTransport.service.impl;

import com.ls.FreightTransport.dao.EvaluationInfoMapper;
import com.ls.FreightTransport.entity.EvaluationInfo;
import com.ls.FreightTransport.service.EvaluationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationInfoServiceImpl implements EvaluationInfoService {

    @Autowired
    private EvaluationInfoMapper evaluationInfoMapper;

    /**
     * 删除操作 根据主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(int id) {
        return evaluationInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加操作
     *
     * @param evaluationInfo
     * @return
     */
    @Override
    public int insert(EvaluationInfo evaluationInfo) {
        return evaluationInfoMapper.insert(evaluationInfo);
    }

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    @Override
    public EvaluationInfo selectByPrimaryKey(int id) {
        return evaluationInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 全部查询操作
     *
     * @return
     */
    @Override
    public List<EvaluationInfo> selectAll(int sId, String sName, String dName) {
        return evaluationInfoMapper.selectAll(sId, sName, dName);
    }

    /**
     * 修改操作
     *
     * @param evaluationInfo
     * @return
     */
    @Override
    public int updateByPrimaryKey(EvaluationInfo evaluationInfo) {
        return evaluationInfoMapper.updateByPrimaryKey(evaluationInfo);
    }

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public int count(int sId, String sName, String dName) {
        return evaluationInfoMapper.count(sId, sName, dName);
    }
}
