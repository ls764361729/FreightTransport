package com.ls.FreightTransport.controller;
import com.ls.FreightTransport.dao.VehicleInfoMapper;
import com.ls.FreightTransport.entity.VehicleInfo;
import com.ls.FreightTransport.service.VehicleInfoService;
import com.ls.FreightTransport.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/vehicleInfo")
public class VehicleInfoController {
    @Autowired
    private VehicleInfoService vehicleInfoService;
    @Autowired
    private VehicleInfoMapper vehicleInfoMapper;
    /**
     * 根据主键删除
     * 要求转入 aId
     *
     * @param id
     * @return
     */
    @GetMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(int id) {
        try {

            return vehicleInfoService.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功") : Result.error("删除失败");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }

    /**
     * 添加对象vehicleInfo
     *
     * @param vehicleInfo
     * @return
     */
    @PostMapping("/insert")
    public Result insert(@RequestBody VehicleInfo vehicleInfo) {
        try {
            return vehicleInfoService.insert(vehicleInfo) > 0 ? new Result().successMessage("添加成功！") : Result.error("添加失败！");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }

    }

    /**
     * 根据司机编号  最多只能返回一个对象
     *
     * @param id
     * @return
     */
    @GetMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(int id) {
        try {
            VehicleInfo vehicleInfo1 = vehicleInfoMapper.selectdId(id);
            if (vehicleInfo1 == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result().success(vehicleInfo1);
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
            List<VehicleInfo> list = vehicleInfoService.selectAll("","");
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
     * @param vehicleInfo
     * @return
     */
    @PostMapping(value = "/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody VehicleInfo vehicleInfo) {
        try {
            return vehicleInfoService.updateByPrimaryKey(vehicleInfo) > 0 ? new Result().successMessage("修改成功") : Result.error("修改失败");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }


    /* 查询所有数据分页
     *
     * @return
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit, String license,  String iId) {
        try {
            PageHelper.startPage(page, limit);
            if("".equals(iId))
                iId = null;
            List<VehicleInfo> list = vehicleInfoService.selectAll(license,iId);
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result(0, "ok", list, vehicleInfoService.count(license,iId));
            }
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }
}
