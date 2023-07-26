package vio.vin.cloudconsumerfeignhystrixorder80.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vio.vin.cloudconsumerfeignhystrixorder80.service.PaymentHystrixService;

@RestController
@Slf4j
@RequestMapping("consumer/hystrix")
public class OrderHystrixController
{
    private final PaymentHystrixService paymentHystrixService;

    public OrderHystrixController(PaymentHystrixService paymentHystrixService)
    {
        this.paymentHystrixService = paymentHystrixService;
    }


    @GetMapping("ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id)
    {
        String result = paymentHystrixService.paymentInfo_OK(id);
        log.info("paymentInfo_OK: "+result);
        return result;
    }

    @GetMapping("timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        log.info("paymentInfo_TimeOut: "+result);
        return result;
    }
}
