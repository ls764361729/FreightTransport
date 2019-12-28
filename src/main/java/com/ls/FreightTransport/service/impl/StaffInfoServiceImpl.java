package com.ls.FreightTransport.service.impl;

import com.ls.FreightTransport.dao.StaffInfoMapper;
import com.ls.FreightTransport.entity.StaffInfo;
import com.ls.FreightTransport.service.StaffInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffInfoServiceImpl implements StaffInfoService {

    @Autowired
    private StaffInfoMapper staffInfoMapper;

    /**
     * 删除操作 根据主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(int id) {
        return staffInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加操作
     *
     * @param staffInfo
     * @return
     */
    @Override
    public int insert(StaffInfo staffInfo) {
        return staffInfoMapper.insert(staffInfo);
    }

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    @Override
    public StaffInfo selectByPrimaryKey(int id) {
        return staffInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 全部查询操作
     *
     * @return
     */
    @Override
    public List<StaffInfo> selectAll() {
        return staffInfoMapper.selectAll();
    }

    /**
     * 修改操作
     *
     * @param staffInfo
     * @return
     */
    @Override
    public int updateByPrimaryKey(StaffInfo staffInfo) {
        return staffInfoMapper.updateByPrimaryKey(staffInfo);
    }

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public int count() {
        return staffInfoMapper.count();
    }
}
