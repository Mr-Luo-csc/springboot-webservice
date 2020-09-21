package com.luozhipeng.webservice.client;

import com.luozhipeng.webservice.service.CommonService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * @author: luozhipeng
 * @description:
 * @data: 2020/9/17
 **/
public class CxfClient {

    /**************************************/
    /** 理解:使用代理的方式调用webservice服务 */
    /**************************************/
    public static void main(String[] args) {
        client1();
    }

    //=======方法一:代理类工厂的方式,需要拿到对方的接口
    private static void client1() {

        try {
            //接口地址
            String address = "http://localhost:8080/services/CommonService?wsdl";
            //代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            //设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            //设置接口类型
            jaxWsProxyFactoryBean.setServiceClass(CommonService.class);
            //创建一个代理接口实现[todo 标记打印输出日志,debug调试看]
            CommonService commonService = (CommonService) jaxWsProxyFactoryBean.create();
            //数据准备
            String data = "I'm luozhipeng from changsha";
            //调用代理接口的方法并且返回结果[todo 标记打印输出日志,debug调试看]
            String result = commonService.sayHello(data);
            System.out.println("返回结果: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //=======方法二:动态调用方式
    private static void client2() {

        //创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8080/services/CommonService?wsdl");
        //
        Object[] obj = new Object[0];

        try {
            obj = client.invoke("sayHello", "luozhipeng");
            System.out.println("返回数据: " + obj[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
