package com.ls.FreightTransport.controller;
import com.ls.FreightTransport.dao.ShipperInfoMapper;
import com.ls.FreightTransport.entity.ShipperInfo;
import com.ls.FreightTransport.service.ShipperInfoService;
import com.ls.FreightTransport.util.Result;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/shipperInfo")
public class ShipperInfoController {
    @Autowired
    private ShipperInfoService shipperInfoService;
    @Autowired
    private ShipperInfoMapper shipperInfoMapper;
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

            return shipperInfoService.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功") : Result.error("删除失败");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }

    /**
     * 添加对象shipperInfo
     *
     * @param shipperInfo
     * @return
     */
    @PostMapping("/insert")
    public Result insert(@RequestBody ShipperInfo shipperInfo) {
        try {
            return shipperInfoService.insert(shipperInfo) > 0 ? new Result().successMessage("添加成功！") : Result.error("添加失败！");
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
            ShipperInfo shipperInfo1 = shipperInfoService.selectByPrimaryKey(id);
            if (shipperInfo1 == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result().success(shipperInfo1);
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
            List<ShipperInfo> list = shipperInfoService.selectAll("","","");
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
     * @param shipperInfo
     * @return
     */
    @PostMapping(value = "/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody ShipperInfo shipperInfo) {
        try {
            return shipperInfoService.updateByPrimaryKey(shipperInfo) > 0 ? new Result().successMessage("修改成功") : Result.error("修改失败");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }


    /* 查询所有数据分页
     *
     * @return
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit,String sName,String sPhone,String sSex) {
        try {
            PageHelper.startPage(page, limit);
            List<ShipperInfo> list = shipperInfoService.selectAll(sName,sPhone,sSex);
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result(0, "ok", list, shipperInfoService.count(sName,sPhone,sSex));
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
            ShipperInfo shipperInfo = shipperInfoService.selectByPrimaryKey(id);
            if(shipperInfo != null){
                if(shipperInfo.getsPassword().equals(old)){
                    if(shipperInfoMapper.updatePassword(password,id)>0)
                        return new Result(200,"修改成功！");
                }
            }
            return new Result().error("修改失败!");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }
}
