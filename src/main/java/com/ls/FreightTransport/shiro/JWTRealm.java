package com.ls.FreightTransport.shiro;

import com.ls.FreightTransport.dao.DriverInfoMapper;
import com.ls.FreightTransport.dao.ManagerMapper;
import com.ls.FreightTransport.dao.ShipperInfoMapper;
import com.ls.FreightTransport.entity.DriverInfo;
import com.ls.FreightTransport.entity.Manager;
import com.ls.FreightTransport.entity.ShipperInfo;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JWTRealm extends AuthorizingRealm {
    @Autowired
	private ManagerMapper managerMapper;

	@Autowired
	private DriverInfoMapper driverInfoMapper;

	@Autowired
	private ShipperInfoMapper shipperInfoMapper;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String mUser = JWTUtil.getUsername(principals.toString());
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Manager user = managerMapper.selectByPrimaryKey(Integer.parseInt(mUser.substring(1,mUser.length())));
		if("高级管理员".equals(user.getmRank()))
		authorizationInfo.addRole("admin");
		return authorizationInfo;
	}

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)  {
		String token = (String) authenticationToken.getPrincipal();
		String username = JWTUtil.getUsername(token);
        if(username == null){
			return null;
        }

		String bd = null;
        int id = 0;
		if(username.length()>1){
			 bd = username.substring(0,1);
			 id = Integer.parseInt(username.substring(1,username.length()));
		}else{
			return null;
		}
		if("A".equals(bd)){
			Manager Manager = managerMapper.selectByPrimaryKey(id);
			if (Manager == null){
				return null;
			}
			if (! JWTUtil.verify(token, username, Manager.getmPassword())) {
				return null;
			}
		}else if("D".equals(bd)){
			DriverInfo driverInformation = driverInfoMapper.selectByPrimaryKey(id);
			if(driverInformation == null) {
				return null;
			}
			if (! JWTUtil.verify(token, username, driverInformation.getdPassword())) {
				return null;
			}
		}else if("S".equals(bd)){
			ShipperInfo shipperInformation = shipperInfoMapper.selectByPrimaryKey(id);
			if(shipperInformation == null){
				return null;
			}
			if (! JWTUtil.verify(token, username, shipperInformation.getsPassword())) {
				return null;
			}
		}else{
			return null;
		}
		return new SimpleAuthenticationInfo(token,token,getName());
	}
}
