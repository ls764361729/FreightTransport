package com.ls.FreightTransport.service;

import com.ls.FreightTransport.entity.CollectFees;

import java.util.List;

public interface CollectFeesService {

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
     * @param collectFees
     * @return
     */
    int insert(CollectFees collectFees);

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    CollectFees selectByPrimaryKey(int id);

    /**
     * 全部查询操作
     *
     * @return
     */
    List<CollectFees> selectAll();

    /**
     * 修改操作
     *
     * @param collectFees
     * @return
     */
    int updateByPrimaryKey(CollectFees collectFees);

    /**
     * 查询所有数据
     * @return
     */
    int count();
}