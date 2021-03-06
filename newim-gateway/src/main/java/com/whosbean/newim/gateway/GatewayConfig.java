package com.whosbean.newim.gateway;

import com.whosbean.newim.config.AbstractConfig;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by yaming_deng on 14-9-9.
 */
@Component
public class GatewayConfig extends AbstractConfig {

    public static GatewayConfig current = null;

    private String gatewayHost;
    private Integer gatewayPort;
    private String gatewaySig;

    @Override
    public String getConfName() {
        return "gateway";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        super.afterPropertiesSet();
        current = this;
        this.initGatewayInfo();
    }

    private void initGatewayInfo(){
        Map server = this.get(Map.class, "websocket");
        gatewayHost = (String)server.get("ip");
        gatewayPort = (Integer)server.get("port");
        gatewaySig = gatewayHost+":"+ gatewayPort;
    }

    public String getGatewayHost() {
        return gatewayHost;
    }

    public Integer getGatewayPort() {
        return gatewayPort;
    }

    public String getGatewaySig() {
        return gatewaySig;
    }

}
