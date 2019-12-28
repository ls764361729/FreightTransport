package com.ls.FreightTransport.service.impl;

import com.ls.FreightTransport.dao.VehicleInfoMapper;
import com.ls.FreightTransport.entity.VehicleInfo;
import com.ls.FreightTransport.service.VehicleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleInfoServiceImpl implements VehicleInfoService {

    @Autowired
    private VehicleInfoMapper vehicleInfoMapper;

    /**
     * 删除操作 根据主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(int id) {
        return vehicleInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加操作
     *
     * @param vehicleInfo
     * @return
     */
    @Override
    public int insert(VehicleInfo vehicleInfo) {
        return vehicleInfoMapper.insert(vehicleInfo);
    }

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    @Override
    public VehicleInfo selectByPrimaryKey(int id) {
        return vehicleInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 全部查询操作
     *
     * @return
     */
    @Override
    public List<VehicleInfo> selectAll(String vLicense, String id) {
        return vehicleInfoMapper.selectAll(vLicense,id);
    }

    /**
     * 修改操作
     *
     * @param vehicleInfo
     * @return
     */
    @Override
    public int updateByPrimaryKey(VehicleInfo vehicleInfo) {
        return vehicleInfoMapper.updateByPrimaryKey(vehicleInfo);
    }

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public int count(String vLicense,String id) {
        return vehicleInfoMapper.count(vLicense,id);
    }
}
