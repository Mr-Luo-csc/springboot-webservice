package com.luozhipeng.webservice.config;

import com.luozhipeng.webservice.service.CommonService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @author: luozhipeng
 * @description:
 * @data: 2020/9/17
 **/
@Configuration
public class CxfConfig {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private Bus bus;

    @Autowired
    private CommonService commonService;

    /**
     * JAX-WS
     **/
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, commonService);
        endpoint.publish("CommonService");
        return endpoint;
    }
}
