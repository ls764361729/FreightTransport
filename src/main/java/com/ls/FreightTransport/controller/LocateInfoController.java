package com.ls.FreightTransport.controller;
import com.ls.FreightTransport.dao.LocateInfoMapper;
import com.ls.FreightTransport.entity.LocateInfo;
import com.ls.FreightTransport.service.LocateInfoService;
import com.ls.FreightTransport.service.OrderInfoService;
import com.ls.FreightTransport.util.Result;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/image/locateInfo")
public class LocateInfoController {
    @Autowired
    private LocateInfoService locateInfoService;
    @Autowired
    private LocateInfoMapper locateInfoMapper;
    @Autowired
    private OrderInfoService orderInfoService;
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

            return locateInfoService.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功") : Result.error("删除失败");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }

    /**
     * 添加对象locateInfo
     *
     * @param locateInfo
     * @return
     */
    @PostMapping("/insert")
    public Result insert(@RequestBody LocateInfo locateInfo) {
        try {
            return locateInfoService.insert(locateInfo) > 0 ? new Result().successMessage("添加成功！") : Result.error("添加失败！");
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
            LocateInfo locateInfo1 = locateInfoService.selectByPrimaryKey(id);
            if (locateInfo1 == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result().success(locateInfo1);
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
            List<LocateInfo> list = locateInfoService.selectAll();
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
     * @param locateInfo
     * @return
     */
    @PostMapping(value = "/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody LocateInfo locateInfo) {
        try {
            return locateInfoService.updateByPrimaryKey(locateInfo) > 0 ? new Result().successMessage("修改成功") : Result.error("修改失败");
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
            List<LocateInfo> list = locateInfoService.selectAll();
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result(0, "ok", list, locateInfoService.count());
            }
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }


    /* 查询所有数据分页
     *
     * @return
     */
    @GetMapping("/updatetype")
    public Result updateType(int id,int type) {
        try {
            if(locateInfoMapper.updateType(id,type)>0){
                return new Result().successMessage("ok");
            } else {
                return new Result().error("no");
            }
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }
    /* 根据订单状态进行查询
     *
     * @return
     */
    @GetMapping("/updateSet")
    public Result updateSet(String oId,@RequestParam(defaultValue = "0") int dId, String oState,@RequestParam(defaultValue = "0") int oEndDate){
        try {
            if(orderInfoService.updateSet(oId,dId,oState,oEndDate)>0){
                return new Result(200, "操作成功！");
            }
            return new Result().error("操作失败！");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }
    
}
