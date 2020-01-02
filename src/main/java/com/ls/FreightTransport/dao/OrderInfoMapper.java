package com.ls.FreightTransport.dao;

import com.ls.FreightTransport.entity.OrderInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderInfoMapper {
    /**
     * 根据主键删除操作
     *
     * @param oId
     * @return
     */
    int deleteByPrimaryKey(String oId);

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
     * @param oId
     * @return
     */
    OrderInfo selectByPrimaryKey(String oId);

    /**
     * 全部查询操作
     *
     * @return
     */
    List<OrderInfo> selectAll();

    /**
     * 根据主键全部修改操作
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
    //根据订单状态查询、订单编号、联系人号码查询
    List<OrderInfo> selectStart(@Param("oState") String oState, @Param("oId") String oId, @Param("oContacts") String oContacts, @Param("sId") int sId, @Param("dId") int dId);
    //根据订单状态查询、订单编号、联系人号码查询
    int countStart(@Param("oState") String oState,@Param("oId") String oId,@Param("oContacts") String oContacts,@Param("sId") int sId,@Param("dId") int dId);

    int countType(@Param("oType") String oType,@Param("sId") int sId,@Param("dId")  int dId);

    //订单号、司机id、订单状态、完成时间
    int updateSet(@Param("oId") String oId,@Param("dId") int dId,@Param("oState") String oState,@Param("oEndDate") int oEndDate);
}