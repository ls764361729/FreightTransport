package com.ls.FreightTransport.controller;
import com.ls.FreightTransport.entity.FinancialInfoSheet;
import com.ls.FreightTransport.service.FinancialInfoSheetService;
import com.ls.FreightTransport.util.Result;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/financialInfoSheet")
public class FinancialInfoSheetController {
    @Autowired
    private FinancialInfoSheetService financialInfoSheetService;

    /**
     * 根据主键删除
     * 要求转入 aId
     *
     * @param id
     * @return
     */
    @GetMapping("/deleteByPrimaryKey")
    @RequiresRoles("admin")
    public Result deleteByPrimaryKey(int id) {
        try {

            return financialInfoSheetService.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功") : Result.error("删除失败");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }

    /**
     * 添加对象financialInfoSheet
     *
     * @param financialInfoSheet
     * @return
     */
    @PostMapping("/insert")
    public Result insert(@RequestBody FinancialInfoSheet financialInfoSheet) {
        try {
            return financialInfoSheetService.insert(financialInfoSheet) > 0 ? new Result().successMessage("添加成功！") : Result.error("添加失败！");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }

    }

    /**
     * 根据主键查找对象  最多只能返回一个对象
     *
     * @param id
     * @return
     */
    @GetMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(int id) {
        try {
            FinancialInfoSheet financialInfoSheet1 = financialInfoSheetService.selectByPrimaryKey(id);
            if (financialInfoSheet1 == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result().success(financialInfoSheet1);
            }
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }

    /**
     * 查询所有数据
     *
     * @return
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        try {
            List<FinancialInfoSheet> list = financialInfoSheetService.selectAll();
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result().success(list);
            }
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }

    /**
     * 根据主键修改全部字段
     *
     * @param financialInfoSheet
     * @return
     */
    @PostMapping(value = "/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody FinancialInfoSheet financialInfoSheet) {
        try {
            return financialInfoSheetService.updateByPrimaryKey(financialInfoSheet) > 0 ? new Result().successMessage("修改成功") : Result.error("修改失败");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }
    
    
     /* 查询所有数据分页
     *
     * @return
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
        try {
            PageHelper.startPage(page, limit);
            List<FinancialInfoSheet> list = financialInfoSheetService.selectAll();
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result(0, "ok", list, financialInfoSheetService.count());
            }
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }
    /* 根据类型查询
     *
     * @return
     */
    @GetMapping("/selectType")
    public Result selectType(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit,String fName,String fNameType,String fType) {
        try {
            PageHelper.startPage(page, limit);
            List<FinancialInfoSheet> list = financialInfoSheetService.selectType(fName,fNameType,fType);
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result(0, "ok", list, financialInfoSheetService.countType(fName,fNameType,fType));
            }
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }
}
