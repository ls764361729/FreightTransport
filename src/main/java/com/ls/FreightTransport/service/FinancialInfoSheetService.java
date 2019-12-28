package com.ls.FreightTransport.service;

import com.ls.FreightTransport.entity.FinancialInfoSheet;

import java.util.List;

public interface FinancialInfoSheetService {

    /**
     * 删除操作 根据主键
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(int id);

    /**
     * 添加操作
     *
     * @param financialInfoSheet
     * @return
     */
    int insert(FinancialInfoSheet financialInfoSheet);

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    FinancialInfoSheet selectByPrimaryKey(int id);

    /**
     * 全部查询操作
     *
     * @return
     */
    List<FinancialInfoSheet> selectAll();

    /**
     * 修改操作
     *
     * @param financialInfoSheet
     * @return
     */
    int updateByPrimaryKey(FinancialInfoSheet financialInfoSheet);

    /**
     * 查询所有数据
     * @return
     */
    int count();
    /**
     * 根据交易类型查询操作
     *
     * @return
     */
    List<FinancialInfoSheet> selectType(String fName, String fNameType,String fType) ;

    /**
     * 获取数量
     * @return
     */
    int countType(String fName, String fNameType,String fType) ;
}