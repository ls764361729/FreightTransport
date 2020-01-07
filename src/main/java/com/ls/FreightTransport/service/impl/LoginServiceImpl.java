package com.ls.FreightTransport.service.impl;
import com.ls.FreightTransport.dao.DriverInfoMapper;
import com.ls.FreightTransport.dao.ManagerMapper;
import com.ls.FreightTransport.dao.ShipperInfoMapper;
import com.ls.FreightTransport.entity.DriverInfo;
import com.ls.FreightTransport.entity.Manager;
import com.ls.FreightTransport.entity.ShipperInfo;
import com.ls.FreightTransport.service.LoginService;
import com.ls.FreightTransport.shiro.JWTUtil;
import com.ls.FreightTransport.util.LoginDo;
import com.ls.FreightTransport.util.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
   
 
    @Autowired
    private ManagerMapper managerMapper;
    @Autowired
    private DriverInfoMapper driverInfoMapper;
    @Autowired
    private ShipperInfoMapper shipperInfoMapper;
    /**
     * 使用司机手机号码 密码 验证条件 登录
     * @param dPhone
     * @param Password
     * @return
     */
    @Override
    public Result loginDriverInfo(String dPhone, String Password) {
            DriverInfo driverInfo = driverInfoMapper.getByInfo(dPhone);
            if(driverInfo == null){
                return Result.error("账号无效");
            }
            if(driverInfo.getdPassword().equals(Password)){
                return Result.successMessage(1028,"登录成功", loginDoDriverInfo(driverInfo));
            }
            return Result.error("用户名密码错误");

    }
    /**
     * 货主根据手机号码 密码 验证条件 获取信息
     * @return
     */
    @Override
    public Result loginShipperInfo(String dPhone, String Password) {
            ShipperInfo shipperInfo = shipperInfoMapper.getByInfo(dPhone);
            if(shipperInfo == null){
                return Result.error("账号无效");
            }
            if(shipperInfo.getsPassword().equals(Password)){
                return Result.successMessage(1028,"登录成功", loginDoShipperInfo(shipperInfo));
            }
            return Result.error("用户名密码错误");

    }

    /**
     * 管理员根据手机号码或者账号 密码 验证条件
     * @param dPhone
     * @return
     */
    @Override
    public Result loginManager(String dPhone, String Password) {

            Manager manager = managerMapper.getByInfo(dPhone);
            if(manager == null){
                return Result.error("账号无效");
            }
            if(manager.getmPassword().equals(Password)){
                return Result.successMessage(1028,"登录成功", loginDomanager(manager));
            }
            return Result.error("用户名密码错误");
    }

    //司机
    private static LoginDo loginDoDriverInfo(DriverInfo driverInfo){
        LoginDo loginDo = new LoginDo();
        loginDo.setmName(driverInfo.getdName());
        loginDo.setmUser(driverInfo.getdId().toString());
        loginDo.setSign(JWTUtil.sign("D"+driverInfo.getdId().toString(), driverInfo.getdPassword()));
        return loginDo;
    }
    //客户
    private static LoginDo loginDoShipperInfo(ShipperInfo shipperInfo){
        LoginDo loginDo = new LoginDo();
        loginDo.setmName(shipperInfo.getsName());
        loginDo.setmUser(shipperInfo.getsId().toString());
        loginDo.setSign(JWTUtil.sign("S"+shipperInfo.getsId().toString(), shipperInfo.getsPassword()));
        return loginDo;
    }
    //管理员
    private static LoginDo loginDomanager(Manager manager){
        LoginDo loginDo = new LoginDo();
        loginDo.setmName(manager.getmAccount());
        loginDo.setmUser(manager.getmId().toString());
        loginDo.setSign(JWTUtil.sign("A"+manager.getmId().toString(), manager.getmPassword()));
        return loginDo;
    }
    @Override
    public Result logout() {
        try {
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.logout();
        } catch (Exception e) {
            return Result.successMessage("退出成功");
        }
        return Result.successMessage("退出成功");
    }
}
