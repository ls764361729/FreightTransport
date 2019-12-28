package com.ls.FreightTransport.dao;

import com.ls.FreightTransport.entity.CollectFees;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectFeesMapper {
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
     * 根据主键全部修改操作
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