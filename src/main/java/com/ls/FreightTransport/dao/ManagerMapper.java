package com.ls.FreightTransport.dao;

import com.ls.FreightTransport.entity.Manager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerMapper {
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
     * 根据主键全部修改操作
     *
     * @param manager
     * @return
     */
    int updateByPrimaryKey(Manager manager);
    /**
     * 根据手机号码获取信息
     * @param phone
     * @return
     */
    Manager getByInfo(@Param("phone") String phone);

    /**
     * 查询所有数据
     * @return
     */
    int count();
    //修改密码
    int updatePassword(@Param("password") String password, @Param("mId") int mId);
}