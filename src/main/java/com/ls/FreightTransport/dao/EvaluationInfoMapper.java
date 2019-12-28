package com.ls.FreightTransport.dao;

import com.ls.FreightTransport.entity.EvaluationInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationInfoMapper {
    /**
     * 根据主键删除操作
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

    List<EvaluationInfo> selectAll(@Param("sId") int sId,@Param("sName")  String sName,@Param("dName")  String dName);

    /**
     * 根据主键全部修改操作
     *
     * @param evaluationInfo
     * @return
     */
    int updateByPrimaryKey(EvaluationInfo evaluationInfo);

    /**
     * 查询所有数据
     * @return
     */
    int count(@Param("sId") int sId, @Param("sName")  String sName, @Param("dName")  String dName);
    /**
     * 根据订单查询操作
     *
     * @param oId
     * @return
     */
    EvaluationInfo selectOId(String oId);
}