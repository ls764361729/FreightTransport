package com.ls.FreightTransport.service.impl;

import com.ls.FreightTransport.dao.OrderInfoMapper;
import com.ls.FreightTransport.entity.OrderInfo;
import com.ls.FreightTransport.service.OrderInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    /**
     * 删除操作 根据主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(int id) {
        return orderInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加操作
     *
     * @param orderInfo
     * @return
     */
    @Override
    public int insert(OrderInfo orderInfo) {
        return orderInfoMapper.insert(orderInfo);
    }

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    @Override
    public OrderInfo selectByPrimaryKey(int id) {
        return orderInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 全部查询操作
     *
     * @return
     */
    @Override
    public List<OrderInfo> selectAll() {
        return orderInfoMapper.selectAll();
    }

    /**
     * 修改操作
     *
     * @param orderInfo
     * @return
     */
    @Override
    public int updateByPrimaryKey(OrderInfo orderInfo) {
        return orderInfoMapper.updateByPrimaryKey(orderInfo);
    }

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public int count() {
        return orderInfoMapper.count();
    }

    @Override
    public List<OrderInfo> selectStart(String oState, String oId, String contacts,int sId,int dId) {
        return orderInfoMapper.selectStart(oState, oId, contacts,sId,dId);
    }

    @Override
    public int countStart(String oState, String oId, String contacts,int sId,int dId) {
        return orderInfoMapper.countStart(oState, oId, contacts,sId,dId);
    }

    @Override
    public int updateSet(String oId, int dId, String oState, int endDate) {
        return orderInfoMapper.updateSet(oId,dId,oState,endDate);
    }
    @Override
    public int countType(String oType,int sId, int dId) {
        return orderInfoMapper.countType(oType,sId,dId);
    }


}
