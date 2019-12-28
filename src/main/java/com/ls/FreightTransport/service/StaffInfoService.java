package com.ls.FreightTransport.service;

import com.ls.FreightTransport.entity.StaffInfo;

import java.util.List;

public interface StaffInfoService {

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
     * @param staffInfo
     * @return
     */
    int insert(StaffInfo staffInfo);

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    StaffInfo selectByPrimaryKey(int id);

    /**
     * 全部查询操作
     *
     * @return
     */
    List<StaffInfo> selectAll();

    /**
     * 修改操作
     *
     * @param staffInfo
     * @return
     */
    int updateByPrimaryKey(StaffInfo staffInfo);

    /**
     * 查询所有数据
     * @return
     */
    int count();
}