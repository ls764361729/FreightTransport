package com.ls.FreightTransport.service.impl;

import com.ls.FreightTransport.dao.DriverInfoMapper;
import com.ls.FreightTransport.entity.DriverInfo;
import com.ls.FreightTransport.service.DriverInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverInfoServiceImpl implements DriverInfoService {

    @Autowired
    private DriverInfoMapper DriverInfoMapper;

    /**
     * 删除操作 根据主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(int id) {
        return DriverInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加操作
     *
     * @param DriverInfo
     * @return
     */
    @Override
    public int insert(DriverInfo DriverInfo) {
        return DriverInfoMapper.insert(DriverInfo);
    }

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    @Override
    public DriverInfo selectByPrimaryKey(int id) {
        return DriverInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 全部查询操作
     *
     * @return
     */
    @Override
    public List<DriverInfo> selectAll() {
        return DriverInfoMapper.selectAll();
    }

    /**
     * 修改操作
     *
     * @param DriverInfo
     * @return
     */
    @Override
    public int updateByPrimaryKey(DriverInfo DriverInfo) {
        return DriverInfoMapper.updateByPrimaryKey(DriverInfo);
    }

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public int count() {
        return DriverInfoMapper.count();
    }

    @Override
    public List<DriverInfo> getSelectVague(String dName, String dPhone, String dSex) {
        return DriverInfoMapper.getSelectVague(dName,dPhone,dSex);
    }

    @Override
    public int getCountVague(String dName, String dPhone, String dSex) {
        return DriverInfoMapper.getCountVague(dName,dPhone,dSex);
    }
}
