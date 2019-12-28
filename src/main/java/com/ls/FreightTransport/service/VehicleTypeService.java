package com.ls.FreightTransport.service;

import com.ls.FreightTransport.entity.VehicleType;

import java.util.List;

public interface VehicleTypeService {

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
     * @param vehicleType
     * @return
     */
    int insert(VehicleType vehicleType);

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    VehicleType selectByPrimaryKey(int id);

    /**
     * 全部查询操作
     *
     * @return
     */
    List<VehicleType> selectAll(String vName);

    /**
     * 修改操作
     *
     * @param vehicleType
     * @return
     */
    int updateByPrimaryKey(VehicleType vehicleType);

    /**
     * 查询所有数据
     * @return
     */
    int count(String vName);
    List<VehicleType> selectGroup();
}