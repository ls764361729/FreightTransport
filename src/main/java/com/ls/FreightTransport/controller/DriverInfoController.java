package com.ls.FreightTransport.controller;
import com.ls.FreightTransport.dao.DriverInfoMapper;
import com.ls.FreightTransport.entity.DriverInfo;
import com.ls.FreightTransport.service.DriverInfoService;
import com.ls.FreightTransport.util.Result;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/driverInfo")
public class DriverInfoController {
    @Autowired
    private DriverInfoService driverInfoService;
    @Autowired
    private DriverInfoMapper driverInfoMapper;

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

            return driverInfoService.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功") : Result.error("删除失败");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }

    /**
     * 添加对象DriverInfo
     *
     * @param DriverInfo
     * @return
     */
    @PostMapping("/insert")
    public Result insert(@RequestBody DriverInfo DriverInfo) {
        try {
            return driverInfoService.insert(DriverInfo) > 0 ? new Result().successMessage("添加成功！") : Result.error("添加失败！");
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
            DriverInfo DriverInfo1 = driverInfoService.selectByPrimaryKey(id);
            if (DriverInfo1 == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result().success(DriverInfo1);
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
            List<DriverInfo> list = driverInfoService.selectAll();
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
     * @param DriverInfo
     * @return
     */
    @PostMapping(value = "/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody DriverInfo DriverInfo) {
        try {
            return driverInfoService.updateByPrimaryKey(DriverInfo) > 0 ? new Result().successMessage("修改成功") : Result.error("修改失败");
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
            List<DriverInfo> list = driverInfoService.selectAll();
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result(0, "ok", list, driverInfoService.count());
            }
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }
    /* 模糊查询
     *
     * @return
     */
    @GetMapping("/selectVague")
    public Result selectVague(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit,String dName, String dPhone, String dSex) {
        try {
            PageHelper.startPage(page, limit);
            List<DriverInfo> list = driverInfoService.getSelectVague(dName,dPhone,dSex);
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result(0, "ok", list, driverInfoService.getCountVague(dName,dPhone,dSex));
            }
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }

    /* 修改密码
     *
     * @return
     */
    @GetMapping("/updatePassword")
    public Result updatePassword(String password,String old, int id) {
        try {
            DriverInfo DriverInfo = driverInfoService.selectByPrimaryKey(id);
            if(DriverInfo != null){
                if(DriverInfo.getdPassword().equals(old)){
                    if(driverInfoMapper.updatePassword(password,id)>0)
                        return new Result(200,"修改成功！");
                }
            }
            return new Result().error("修改失败!");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }
}
