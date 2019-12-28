package com.ls.FreightTransport.service.impl;

import com.ls.FreightTransport.dao.ManagerMapper;
import com.ls.FreightTransport.entity.Manager;
import com.ls.FreightTransport.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;

    /**
     * 删除操作 根据主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(int id) {
        return managerMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加操作
     *
     * @param manager
     * @return
     */
    @Override
    public int insert(Manager manager) {
        return managerMapper.insert(manager);
    }

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    @Override
    public Manager selectByPrimaryKey(int id) {
        return managerMapper.selectByPrimaryKey(id);
    }

    /**
     * 全部查询操作
     *
     * @return
     */
    @Override
    public List<Manager> selectAll() {
        return managerMapper.selectAll();
    }

    /**
     * 修改操作
     *
     * @param manager
     * @return
     */
    @Override
    public int updateByPrimaryKey(Manager manager) {
        return managerMapper.updateByPrimaryKey(manager);
    }

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public int count() {
        return managerMapper.count();
    }
}
