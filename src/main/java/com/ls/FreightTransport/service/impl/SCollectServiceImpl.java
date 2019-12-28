package com.ls.FreightTransport.service.impl;

import com.ls.FreightTransport.dao.SCollectMapper;
import com.ls.FreightTransport.entity.SCollect;
import com.ls.FreightTransport.service.SCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SCollectServiceImpl implements SCollectService {

    @Autowired
    private SCollectMapper sCollectMapper;

    /**
     * 删除操作 根据主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(int id) {
        return sCollectMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加操作
     *
     * @param sCollect
     * @return
     */
    @Override
    public int insert(SCollect sCollect) {
        return sCollectMapper.insert(sCollect);
    }

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    @Override
    public SCollect selectByPrimaryKey(int id) {
        return sCollectMapper.selectByPrimaryKey(id);
    }

    /**
     * 全部查询操作
     *
     * @return
     */
    @Override
    public List<SCollect> selectAll() {
        return sCollectMapper.selectAll();
    }

    /**
     * 修改操作
     *
     * @param sCollect
     * @return
     */
    @Override
    public int updateByPrimaryKey(SCollect sCollect) {
        return sCollectMapper.updateByPrimaryKey(sCollect);
    }

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public int count() {
        return sCollectMapper.count();
    }
}
