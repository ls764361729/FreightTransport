package com.ls.FreightTransport.controller;
import com.ls.FreightTransport.entity.OrderInfo;
import com.ls.FreightTransport.service.OrderInfoService;
import com.ls.FreightTransport.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/orderInfo")
public class OrderInfoController {
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
    public Result deleteByPrimaryKey(String id) {
        try {

            return orderInfoService.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功") : Result.error("删除失败");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }

    /**
     * 添加对象orderInfo
     *
     * @param orderInfo
     * @return
     */
    @PostMapping("/insert")
    public Result insert(@RequestBody OrderInfo orderInfo) {
        try {
            orderInfo.setoId(String.valueOf(System.currentTimeMillis()));
            return orderInfoService.insert(orderInfo) > 0 ? new Result().successMessage(orderInfo.getoId()) : Result.error("添加失败！");
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
    public Result selectByPrimaryKey(String id) {
        try {
            OrderInfo orderInfo1 = orderInfoService.selectByPrimaryKey(id);
            if (orderInfo1 == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result().success(orderInfo1);
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
            List<OrderInfo> list = orderInfoService.selectAll();
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
     * @param orderInfo
     * @return
     */
    @PostMapping(value = "/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody OrderInfo orderInfo) {
        try {
            return orderInfoService.updateByPrimaryKey(orderInfo) > 0 ? new Result().successMessage("修改成功") : Result.error("修改失败");
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
            List<OrderInfo> list = orderInfoService.selectAll();
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result(0, "ok", list, orderInfoService.count());
            }
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }
    /* 根据订单状态进行查询
     *
     * @return
     */
    @GetMapping("/selectStart")
    public Result selectPage(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit, String oStart, String oId, String oContacts, @RequestParam(defaultValue = "0") int sId,@RequestParam(defaultValue = "0") int dId) {
        try {
            PageHelper.startPage(page, limit);
            List<OrderInfo> list = orderInfoService.selectStart(oStart,oId,oContacts,sId,dId);
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result(0, "ok", list, orderInfoService.countStart(oStart,oId,oContacts,sId,dId));
            }
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }
    /* 根据订单状态进行查询
     *
     * @return
     */
    @GetMapping("/getCount")
    public Result getCount(@RequestParam(defaultValue = "0")int sId, @RequestParam(defaultValue = "0")int dId) {
        try {
            int wyc = orderInfoService.countType("已完成",sId,dId);
            int ysz = orderInfoService.countType("运输中",sId,dId);
            int dys = orderInfoService.countType("待运输",sId,dId);
            Map<String,String> map = new HashMap<>();
            map.put("ywc",String.valueOf(wyc));
            map.put("ysz",String.valueOf(ysz));
            map.put("dys",String.valueOf(dys));
            return new Result(0, "ok", map);
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
