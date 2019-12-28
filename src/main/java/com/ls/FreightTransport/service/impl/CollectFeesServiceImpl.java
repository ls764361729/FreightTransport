package com.ls.FreightTransport.service.impl;

import com.ls.FreightTransport.dao.CollectFeesMapper;
import com.ls.FreightTransport.entity.CollectFees;
import com.ls.FreightTransport.service.CollectFeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectFeesServiceImpl implements CollectFeesService {

    @Autowired
    private CollectFeesMapper collectFeesMapper;

    /**
     * 删除操作 根据主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(int id) {
        return collectFeesMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加操作
     *
     * @param collectFees
     * @return
     */
    @Override
    public int insert(CollectFees collectFees) {
        return collectFeesMapper.insert(collectFees);
    }

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    @Override
    public CollectFees selectByPrimaryKey(int id) {
        return collectFeesMapper.selectByPrimaryKey(id);
    }

    /**
     * 全部查询操作
     *
     * @return
     */
    @Override
    public List<CollectFees> selectAll() {
        return collectFeesMapper.selectAll();
    }

    /**
     * 修改操作
     *
     * @param collectFees
     * @return
     */
    @Override
    public int updateByPrimaryKey(CollectFees collectFees) {
        return collectFeesMapper.updateByPrimaryKey(collectFees);
    }

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public int count() {
        return collectFeesMapper.count();
    }
}
