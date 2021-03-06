package com.ls.FreightTransport.dao;

import com.ls.FreightTransport.entity.DriverInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverInfoMapper {
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
     * @param driverInfo
     * @return
     */
    int insert(DriverInfo driverInfo);

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
     * 根据主键全部修改操作
     *
     * @param driverInfo
     * @return
     */
    int updateByPrimaryKey(DriverInfo driverInfo);

    int count();

    int updatePassword(@Param("password") String password, @Param("dId") int dId);

    List<DriverInfo> getSelectVague(@Param("dName") String dName, @Param("dPhone") String dPhone, @Param("dSex") String dSex);

    int getCountVague(@Param("dName") String dName, @Param("dPhone") String dPhone, @Param("dSex") String dSex);

    DriverInfo getByInfo(@Param("phone") String phone);

}