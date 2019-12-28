package com.ls.FreightTransport.service;

import com.ls.FreightTransport.entity.VehicleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VehicleInfoService {

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
     * @param vehicleInfo
     * @return
     */
    int insert(VehicleInfo vehicleInfo);

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    VehicleInfo selectByPrimaryKey(int id);

    /**
     * 全部查询操作
     *
     * @return
     */
    List<VehicleInfo> selectAll(String license,String id);

    /**
     * 修改操作
     *
     * @param vehicleInfo
     * @return
     */
    int updateByPrimaryKey(VehicleInfo vehicleInfo);

    /**
     * 查询所有数据
     * @return
     */
    int count(String license,String iId);
}