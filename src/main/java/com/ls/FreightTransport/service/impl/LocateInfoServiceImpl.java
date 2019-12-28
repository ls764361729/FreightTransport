package com.ls.FreightTransport.service.impl;

import com.ls.FreightTransport.dao.LocateInfoMapper;
import com.ls.FreightTransport.entity.LocateInfo;
import com.ls.FreightTransport.service.LocateInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocateInfoServiceImpl implements LocateInfoService {

    @Autowired
    private LocateInfoMapper locateInfoMapper;

    /**
     * 删除操作 根据主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(int id) {
        return locateInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加操作
     *
     * @param locateInfo
     * @return
     */
    @Override
    public int insert(LocateInfo locateInfo) {
        return locateInfoMapper.insert(locateInfo);
    }

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    @Override
    public LocateInfo selectByPrimaryKey(int id) {
        return locateInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 全部查询操作
     *
     * @return
     */
    @Override
    public List<LocateInfo> selectAll() {
        return locateInfoMapper.selectAll();
    }

    /**
     * 修改操作
     *
     * @param locateInfo
     * @return
     */
    @Override
    public int updateByPrimaryKey(LocateInfo locateInfo) {
        return locateInfoMapper.updateByPrimaryKey(locateInfo);
    }

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public int count() {
        return locateInfoMapper.count();
    }
}
