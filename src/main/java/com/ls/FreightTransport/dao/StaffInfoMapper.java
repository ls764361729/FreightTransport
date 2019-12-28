package com.ls.FreightTransport.dao;

import com.ls.FreightTransport.entity.StaffInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffInfoMapper {
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
     * 根据主键全部修改操作
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