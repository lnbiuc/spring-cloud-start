package vio.vin.cloudconsumerfeignhystrixorder80.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vio.vin.cloudconsumerfeignhystrixorder80.service.PaymentHystrixService;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderHystrixController
{
    @Resource
    private PaymentHystrixService paymentHystrixService;


    @GetMapping("/consumer/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id)
    {
        String result = paymentHystrixService.paymentInfo_OK(id);
        log.info("paymentInfo_OK: "+result);
        return result;
    }

    @GetMapping("/consumer/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        log.info("paymentInfo_TimeOut: "+result);
        return result;
    }
}
