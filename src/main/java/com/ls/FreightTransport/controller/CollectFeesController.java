package com.ls.FreightTransport.controller;
import com.ls.FreightTransport.entity.CollectFees;
import com.ls.FreightTransport.service.CollectFeesService;
import com.ls.FreightTransport.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/collectFees")
public class CollectFeesController {
    @Autowired
    private CollectFeesService collectFeesService;

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

            return collectFeesService.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功") : Result.error("删除失败");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }

    /**
     * 添加对象collectFees
     *
     * @param collectFees
     * @return
     */
    @PostMapping("/insert")
    public Result insert(@RequestBody CollectFees collectFees) {
        try {
            return collectFeesService.insert(collectFees) > 0 ? new Result().successMessage("添加成功！") : Result.error("添加失败！");
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
            CollectFees collectFees1 = collectFeesService.selectByPrimaryKey(id);
            if (collectFees1 == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result().success(collectFees1);
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
            List<CollectFees> list = collectFeesService.selectAll();
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
     * @param collectFees
     * @return
     */
    @PostMapping(value = "/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody CollectFees collectFees) {
        try {
            return collectFeesService.updateByPrimaryKey(collectFees) > 0 ? new Result().successMessage("修改成功") : Result.error("修改失败");
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
            List<CollectFees> list = collectFeesService.selectAll();
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result(0, "ok", list, collectFeesService.count());
            }
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }
}
