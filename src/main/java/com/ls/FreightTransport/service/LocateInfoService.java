package com.ls.FreightTransport.service;

import com.ls.FreightTransport.entity.LocateInfo;

import java.util.List;

public interface LocateInfoService {

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
     * @param locateInfo
     * @return
     */
    int insert(LocateInfo locateInfo);

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    LocateInfo selectByPrimaryKey(int id);

    /**
     * 全部查询操作
     *
     * @return
     */
    List<LocateInfo> selectAll();

    /**
     * 修改操作
     *
     * @param locateInfo
     * @return
     */
    int updateByPrimaryKey(LocateInfo locateInfo);

    /**
     * 查询所有数据
     * @return
     */
    int count();
}