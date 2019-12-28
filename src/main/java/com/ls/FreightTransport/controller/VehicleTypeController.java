package com.ls.FreightTransport.controller;
import com.ls.FreightTransport.entity.VehicleType;
import com.ls.FreightTransport.service.VehicleTypeService;
import com.ls.FreightTransport.util.Result;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/vehicleType")
public class VehicleTypeController {
    @Autowired
    private VehicleTypeService vehicleTypeService;

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

            return vehicleTypeService.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功") : Result.error("删除失败");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }

    /**
     * 添加对象vehicleType
     *
     * @param vehicleType
     * @return
     */
    @PostMapping("/insert")
    public Result insert(@RequestBody VehicleType vehicleType) {
        try {
            return vehicleTypeService.insert(vehicleType) > 0 ? new Result().successMessage("添加成功！") : Result.error("添加失败！");
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
            VehicleType vehicleType1 = vehicleTypeService.selectByPrimaryKey(id);
            if (vehicleType1 == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result().success(vehicleType1);
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
            List<VehicleType> list = vehicleTypeService.selectAll("");
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
     * @param vehicleType
     * @return
     */
    @PostMapping(value = "/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody VehicleType vehicleType) {
        try {
            return vehicleTypeService.updateByPrimaryKey(vehicleType) > 0 ? new Result().successMessage("修改成功") : Result.error("修改失败");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }


    /* 查询所有数据分页
     *
     * @return
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit,String vName) {
        try {
            PageHelper.startPage(page, limit);
            List<VehicleType> list = vehicleTypeService.selectAll(vName);
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result(0, "ok", list, vehicleTypeService.count(vName));
            }
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }
    /* 查询所有数据分页
     *
     * @return
     */
    @GetMapping("/selectGroup")
    public Result selectGroup() {
        try {
            List<VehicleType> list = vehicleTypeService.selectGroup();
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result(0, "ok", list);
            }
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }
}
