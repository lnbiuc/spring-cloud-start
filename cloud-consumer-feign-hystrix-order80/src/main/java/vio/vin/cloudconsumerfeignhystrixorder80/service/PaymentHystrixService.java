package vio.vin.cloudconsumerfeignhystrixorder80.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vio.vin.cloudconsumerfeignhystrixorder80.config.FeignConfig;
import vio.vin.cloudconsumerfeignhystrixorder80.fallback.FallbackFactory;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = FallbackFactory.class, configuration = FeignConfig.class)
public interface PaymentHystrixService
{
    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id);
}
