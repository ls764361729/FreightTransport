package com.ls.FreightTransport.controller;

import com.ls.FreightTransport.service.LoginService;
import com.ls.FreightTransport.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

   /**
     *  手机号码或者账号 密码登录
     * @param phone
     * @param password
     * @return
     */
   @RequestMapping("/auth")
   public Result authLogin(String phone, String password, @RequestParam(defaultValue = "0") int sf) {
       if(sf == 0){
           return loginService.loginManager(phone,password);
       }else if(sf == 1){
           return loginService.loginShipperInfo(phone,password);
       }else {
           return loginService.loginDriverInfo(phone,password);
       }

    }
    /**
     * 退出
     */
    @GetMapping("/logout")
    public Result logout() {
        return loginService.logout();
    }
    /**
     * 身份验证不通过
     */
    @GetMapping("/verificationFailed")
    public Result verificationFailed() {
        return Result.error(502,"未登录");
    }
    /**
     * 权限不足
     */
    @GetMapping("/insufficientAuthority")
    public Result insufficientAuthority() {
        return Result.error(501,"权限不足");
    }

}
