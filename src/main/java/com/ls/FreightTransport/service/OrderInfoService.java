package com.ls.FreightTransport.service;

import com.ls.FreightTransport.entity.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderInfoService {

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
     * @param orderInfo
     * @return
     */
    int insert(OrderInfo orderInfo);

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    OrderInfo selectByPrimaryKey(int id);

    /**
     * 全部查询操作
     *
     * @return
     */
    List<OrderInfo> selectAll();

    /**
     * 修改操作
     *
     * @param orderInfo
     * @return
     */
    int updateByPrimaryKey(OrderInfo orderInfo);

    /**
     * 查询所有数据
     * @return
     */
    int count();

    //根据订单状态查询
    List<OrderInfo> selectStart(String oState, String oId, String contacts,int sId,int dId);

    int countStart(String oState, String oId, String contacts,int sId,int dId);

    //订单号、司机id、订单状态、完成时间
    int updateSet(@Param("oId") String oId, @Param("dId") int dId, @Param("oState") String oState, @Param("endDate") int endDate);

    int countType(String oType,int sId, int dId);

}