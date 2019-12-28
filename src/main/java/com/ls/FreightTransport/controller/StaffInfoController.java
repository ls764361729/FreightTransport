package com.ls.FreightTransport.controller;
import com.ls.FreightTransport.entity.StaffInfo;
import com.ls.FreightTransport.service.StaffInfoService;
import com.ls.FreightTransport.util.Result;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/staffInfo")
public class StaffInfoController {
    @Autowired
    private StaffInfoService staffInfoService;

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

            return staffInfoService.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功") : Result.error("删除失败");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }

    /**
     * 添加对象staffInfo
     *
     * @param staffInfo
     * @return
     */
    @PostMapping("/insert")
    public Result insert(@RequestBody StaffInfo staffInfo) {
        try {
            return staffInfoService.insert(staffInfo) > 0 ? new Result().successMessage("添加成功！") : Result.error("添加失败！");
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
            StaffInfo staffInfo1 = staffInfoService.selectByPrimaryKey(id);
            if (staffInfo1 == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result().success(staffInfo1);
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
            List<StaffInfo> list = staffInfoService.selectAll();
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
     * @param staffInfo
     * @return
     */
    @PostMapping(value = "/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody StaffInfo staffInfo) {
        try {
            return staffInfoService.updateByPrimaryKey(staffInfo) > 0 ? new Result().successMessage("修改成功") : Result.error("修改失败");
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
            List<StaffInfo> list = staffInfoService.selectAll();
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result(0, "ok", list, staffInfoService.count());
            }
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }
}
