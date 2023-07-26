package vio.vin.cloudconsumerfeignhystrixorder80.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vio.vin.cloudconsumerfeignhystrixorder80.service.PaymentHystrixService;

@RestController
@Slf4j
@RequestMapping("consumer/hystrix")
@DefaultProperties(defaultFallback = "defaultFallback", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
}) // 默认的服务降级方法
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
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
//    })
    @HystrixCommand // 使用默认的服务降级方法
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        log.info("paymentInfo_TimeOut: "+result);
        return result;
    }

//    public String paymentInfo_TimeOutHandler(@PathVariable("id") Integer id)
//    {
//        log.info("paymentInfo_TimeOutHandler: " + id);
//        return "80-fallbackMethod";
//    }
//
    public String defaultFallback()
    {
        return "80-defaultFallback";
    }
}
