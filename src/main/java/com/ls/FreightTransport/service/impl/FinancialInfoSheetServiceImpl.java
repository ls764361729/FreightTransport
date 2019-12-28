package com.ls.FreightTransport.service.impl;

import com.ls.FreightTransport.dao.FinancialInfoSheetMapper;
import com.ls.FreightTransport.entity.FinancialInfoSheet;
import com.ls.FreightTransport.service.FinancialInfoSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialInfoSheetServiceImpl implements FinancialInfoSheetService {

    @Autowired
    private FinancialInfoSheetMapper financialInfoSheetMapper;

    /**
     * 删除操作 根据主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(int id) {
        return financialInfoSheetMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加操作
     *
     * @param financialInfoSheet
     * @return
     */
    @Override
    public int insert(FinancialInfoSheet financialInfoSheet) {
        return financialInfoSheetMapper.insert(financialInfoSheet);
    }

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    @Override
    public FinancialInfoSheet selectByPrimaryKey(int id) {
        return financialInfoSheetMapper.selectByPrimaryKey(id);
    }

    /**
     * 全部查询操作
     *
     * @return
     */
    @Override
    public List<FinancialInfoSheet> selectAll() {
        return financialInfoSheetMapper.selectAll();
    }

    /**
     * 修改操作
     *
     * @param financialInfoSheet
     * @return
     */
    @Override
    public int updateByPrimaryKey(FinancialInfoSheet financialInfoSheet) {
        return financialInfoSheetMapper.updateByPrimaryKey(financialInfoSheet);
    }

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public int count() {
        return financialInfoSheetMapper.count();
    }

    @Override
    public List<FinancialInfoSheet> selectType(String fName, String fNameType,String fType) {
        return financialInfoSheetMapper.selectType(fName,fNameType,fType);
    }

    @Override
    public int countType( String fName, String fNameType,String fType) {
        return financialInfoSheetMapper.countType(fName,fNameType,fType);
    }
}
