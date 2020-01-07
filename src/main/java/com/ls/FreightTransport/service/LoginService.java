package com.ls.FreightTransport.service;

import com.ls.FreightTransport.util.Result;


public interface LoginService {
    Result loginDriverInfo(String phone, String password);
    Result loginShipperInfo(String phone, String password);
    Result loginManager(String phone, String password);
    Result logout();
}
