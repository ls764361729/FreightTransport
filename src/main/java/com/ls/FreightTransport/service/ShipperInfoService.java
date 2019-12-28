package com.ls.FreightTransport.service;

import com.ls.FreightTransport.entity.ShipperInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShipperInfoService {

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
     * @param shipperInfo
     * @return
     */
    int insert(ShipperInfo shipperInfo);

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    ShipperInfo selectByPrimaryKey(int id);

    /**
     * 全部查询操作
     *
     * @return
     */
    List<ShipperInfo> selectAll(@Param("sName") String sName, @Param("dPhone") String sPhone, @Param("sSex") String sSex );

    /**
     * 修改操作
     *
     * @param shipperInfo
     * @return
     */
    int updateByPrimaryKey(ShipperInfo shipperInfo);

    /**
     * 查询所有数据
     * @return
     */
    public int count(@Param("sName") String sName, @Param("dPhone") String sPhone, @Param("sSex") String sSex );

}