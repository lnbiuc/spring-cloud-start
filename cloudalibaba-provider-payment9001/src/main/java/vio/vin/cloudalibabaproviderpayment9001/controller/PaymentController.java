package vio.vin.cloudalibabaproviderpayment9001.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vio.vin.cloudapicommons.entities.CommonResult;

@RestController
public class PaymentController
{
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/nacos/{id}")
    public CommonResult<String> getPayment(@PathVariable("id") Integer id)
    {
        return new CommonResult<>(200, null, "nacos registry, serverPort: " + serverPort + "\t id" + id);
    }
}
