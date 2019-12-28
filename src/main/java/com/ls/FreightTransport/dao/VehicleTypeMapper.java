package com.ls.FreightTransport.dao;
import com.ls.FreightTransport.entity.VehicleType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleTypeMapper {
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
     * 根据主键全部修改操作
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