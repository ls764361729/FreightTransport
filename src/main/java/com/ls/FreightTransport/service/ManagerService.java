package com.ls.FreightTransport.service;

import com.ls.FreightTransport.entity.Manager;

import java.util.List;

public interface ManagerService {

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
     * @param manager
     * @return
     */
    int insert(Manager manager);

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    Manager selectByPrimaryKey(int id);

    /**
     * 全部查询操作
     *
     * @return
     */
    List<Manager> selectAll();

    /**
     * 修改操作
     *
     * @param manager
     * @return
     */
    int updateByPrimaryKey(Manager manager);

    /**
     * 查询所有数据
     * @return
     */
    int count();
}