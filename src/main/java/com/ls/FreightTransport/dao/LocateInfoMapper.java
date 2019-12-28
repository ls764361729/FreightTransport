package com.ls.FreightTransport.dao;

import com.ls.FreightTransport.entity.LocateInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocateInfoMapper {
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
     * 根据主键全部修改操作
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
    int updateType(@Param("id") int id, @Param("type") int type);
}