package com.ls.FreightTransport.controller;
import com.ls.FreightTransport.dao.EvaluationInfoMapper;
import com.ls.FreightTransport.entity.EvaluationInfo;
import com.ls.FreightTransport.service.EvaluationInfoService;
import com.ls.FreightTransport.util.Result;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/evaluationInfo")
public class EvaluationInfoController {
    @Autowired
    private EvaluationInfoService evaluationInfoService;
    @Autowired
    private EvaluationInfoMapper evaluationInfoMapper;
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

            return evaluationInfoService.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功") : Result.error("删除失败");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }

    /**
     * 添加对象evaluationInfo
     *
     * @param evaluationInfo
     * @return
     */
    @PostMapping("/insert")
    public Result insert(@RequestBody EvaluationInfo evaluationInfo) {
        try {
            return evaluationInfoService.insert(evaluationInfo) > 0 ? new Result().successMessage("添加成功！") : Result.error("添加失败！");
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
            EvaluationInfo evaluationInfo1 = evaluationInfoService.selectByPrimaryKey(id);
            if (evaluationInfo1 == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result().success(evaluationInfo1);
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
            List<EvaluationInfo> list = evaluationInfoService.selectAll(0,"","");
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
     * @param evaluationInfo
     * @return
     */
    @PostMapping(value = "/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody EvaluationInfo evaluationInfo) {
        try {
            return evaluationInfoService.updateByPrimaryKey(evaluationInfo) > 0 ? new Result().successMessage("修改成功") : Result.error("修改失败");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }


    /* 查询所有数据分页
     *
     * @return
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit,int fsid, String sName, String dName) {
        try {
            PageHelper.startPage(page, limit);
            List<EvaluationInfo> list = evaluationInfoService.selectAll(fsid,sName,dName);
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result(0, "ok", list, evaluationInfoService.count(fsid,sName,dName));
            }
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }
    /**
     * 根据订单查找对象  最多只能返回一个对象
     *
     * @param oId
     * @return
     */
    @GetMapping("/selectOId")
    public Result selectoId(String OId) {
        try {
            EvaluationInfo evaluationInformation1 = evaluationInfoMapper.selectOId(OId);
            if (evaluationInformation1 == null) {
                return new Result().error("无数据");
            } else {
                return new Result().success(evaluationInformation1);
            }
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }
}
