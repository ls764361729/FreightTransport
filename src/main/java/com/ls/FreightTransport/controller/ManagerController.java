package com.ls.FreightTransport.controller;
import com.ls.FreightTransport.dao.ManagerMapper;
import com.ls.FreightTransport.entity.Manager;
import com.ls.FreightTransport.service.ManagerService;
import com.ls.FreightTransport.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/_manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private ManagerMapper managerMapper;

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

            return managerService.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功") : Result.error("删除失败");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }

    /**
     * 添加对象manager
     *
     * @param manager
     * @return
     */
    @PostMapping("/insert")
    public Result insert(@RequestBody Manager manager) {
        try {
            return managerService.insert(manager) > 0 ? new Result().successMessage("添加成功！") : Result.error("添加失败！");
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
            Manager manager1 = managerService.selectByPrimaryKey(id);
            if (manager1 == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result().success(manager1);
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
            List<Manager> list = managerService.selectAll();
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
     * @param manager
     * @return
     */
    @PostMapping(value = "/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody Manager manager) {
        try {
            return managerService.updateByPrimaryKey(manager) > 0 ? new Result().successMessage("修改成功") : Result.error("修改失败");
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
            Manager manager = managerService.selectByPrimaryKey(id);
            if(manager != null){
                if(manager.getmPassword().equals(old)){
                    if(managerMapper.updatePassword(password,id)>0)
                        return new Result(200,"修改成功！");
                }
            }
            return new Result().error("修改失败!");
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
            List<Manager> list = managerService.selectAll();
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result(0, "ok", list, managerService.count());
            }
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }

}
