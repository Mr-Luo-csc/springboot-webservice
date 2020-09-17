package com.luozhipeng.webservice.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @author: luozhipeng
 * @description:
 * @data: 2020/9/17
 **/
@WebService(name = "CommonService",
        targetNamespace = "http://service.webservice.luozhipeng.com/"
)
public interface CommonService {
    @WebMethod
    @WebResult(name = "String", targetNamespace = "")
    public String sayHello(@WebParam(name = "userName") String userName);

}
