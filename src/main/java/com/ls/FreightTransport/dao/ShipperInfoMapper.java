package com.ls.FreightTransport.dao;

import com.ls.FreightTransport.entity.ShipperInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipperInfoMapper {
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
     * @param shipperInfo
     * @return
     */
    int insert(ShipperInfo shipperInfo);

    /**
     * 全部查询操作
     *
     * @return
     */
    List<ShipperInfo> selectAll(@Param("sName") String sName, @Param("sPhone") String sPhone, @Param("sSex") String sSex);

    /**
     * 全部查询操作
     *
     * @return
     */
    List<ShipperInfo> selectAll();

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    ShipperInfo selectByPrimaryKey(int id);
    /**
     * 根据主键全部修改操作
     *
     * @param shipperInfo
     * @return
     */
    int updateByPrimaryKey(ShipperInfo shipperInfo);

    /**
     * 修改密码
     * @return
     */
    int updatePassword(@Param("password") String password, @Param("sId") int sId);

    /**
     * 查询所有数据
     * @return
     */
    int count(@Param("sName") String sName, @Param("sPhone") String sPhone, @Param("sSex") String sSex);
    /**
     * 根据手机号码获取信息
     * @param phone
     * @return
     */
    ShipperInfo getByInfo(@Param("phone") String phone);


}