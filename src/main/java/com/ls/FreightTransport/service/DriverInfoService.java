package com.ls.FreightTransport.service;

import com.ls.FreightTransport.entity.DriverInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DriverInfoService {

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
     * @param DriverInfo
     * @return
     */
    int insert(DriverInfo DriverInfo);

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    DriverInfo selectByPrimaryKey(int id);

    /**
     * 全部查询操作
     *
     * @return
     */
    List<DriverInfo> selectAll();

    /**
     * 修改操作
     *
     * @param DriverInfo
     * @return
     */
    int updateByPrimaryKey(DriverInfo DriverInfo);

    /**
     * 查询所有数据
     * @return
     */
    int count();

    List<DriverInfo> getSelectVague(String dName,String dPhone,String dSex );

    int getCountVague(String dName,String dPhone,String dSex );
}