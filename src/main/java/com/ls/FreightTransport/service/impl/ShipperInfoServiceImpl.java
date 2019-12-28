package com.ls.FreightTransport.service.impl;

import com.ls.FreightTransport.dao.ShipperInfoMapper;
import com.ls.FreightTransport.entity.ShipperInfo;
import com.ls.FreightTransport.service.ShipperInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipperInfoServiceImpl implements ShipperInfoService {

    @Autowired
    private ShipperInfoMapper shipperInfoMapper;

    /**
     * 删除操作 根据主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(int id) {
        return shipperInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加操作
     *
     * @param shipperInfo
     * @return
     */
    @Override
    public int insert(ShipperInfo shipperInfo) {
        return shipperInfoMapper.insert(shipperInfo);
    }

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    @Override
    public ShipperInfo selectByPrimaryKey(int id) {
        return shipperInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 全部查询操作
     *
     * @return
     */
    @Override
    public List<ShipperInfo> selectAll(@Param("sName") String sName, @Param("dPhone") String sPhone, @Param("sSex") String sSex ) {
        return shipperInfoMapper.selectAll(sName,sPhone,sSex);
    }

    /**
     * 修改操作
     *
     * @param shipperInfo
     * @return
     */
    @Override
    public int updateByPrimaryKey(ShipperInfo shipperInfo) {
        return shipperInfoMapper.updateByPrimaryKey(shipperInfo);
    }

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public int count(String sName, String sPhone,String sSex ){
        return shipperInfoMapper.count(sName,sPhone,sSex);
    }
}
