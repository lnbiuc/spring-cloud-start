package vio.vin.cloudconfigclient3355.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope // 动态刷新 config.info 的值 (需要发送 POST 请求到 http://localhost:3355/actuator/refresh) curl -X POST "http://localhost:3355/actuator/refresh"
public class ConfigClientController
{
    @Value("${config.info}") // config.info is from gitee repo: springcloud-start-config/config-dev.yml
    private String configInfo;

    @GetMapping("/config_info")
    public String getConfigInfo()
    {
        return configInfo;
    }
}
