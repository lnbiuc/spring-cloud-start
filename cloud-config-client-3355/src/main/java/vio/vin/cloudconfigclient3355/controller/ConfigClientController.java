package vio.vin.cloudconfigclient3355.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
