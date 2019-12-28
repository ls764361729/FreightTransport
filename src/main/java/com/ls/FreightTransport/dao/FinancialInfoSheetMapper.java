package com.ls.FreightTransport.dao;

import com.ls.FreightTransport.entity.FinancialInfoSheet;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancialInfoSheetMapper {
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
     * 根据主键全部修改操作
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
    List<FinancialInfoSheet> selectType(@Param("fName") String fName, @Param("fNameType") String fNameType, @Param("fType") String fType);

    /**
     * 根据交易类型查询操作
     * @return
     */
    int countType(@Param("fName") String fName,@Param("fNameType") String fNameType,@Param("fType") String fType);

}