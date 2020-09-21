package com.luozhipeng.webservice.service.impl;

import com.luozhipeng.webservice.service.CommonService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * @author: luozhipeng
 * @description:
 * @data: 2020/9/17
 **/
@SuppressWarnings("WSReferenceInspection")
@WebService(serviceName = "CommonService",
        targetNamespace = "http://webservice.luozhipeng.com/",
        endpointInterface = "com.luozhipeng.webservice.service.CommonService")
@Component
public class CommonServiceImpl implements CommonService {

    @Override
    public String sayHello(String userName) {
        return "Hello: " + userName;
    }

}
