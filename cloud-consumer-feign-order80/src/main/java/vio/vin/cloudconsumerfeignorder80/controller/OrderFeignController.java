package vio.vin.cloudconsumerfeignorder80.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import vio.vin.cloudapicommons.entities.CommonResult;
import vio.vin.cloudapicommons.entities.Payment;
import vio.vin.cloudconsumerfeignorder80.service.PaymentFeignService;

@RestController
@Slf4j
@RequestMapping("consumer")
public class OrderFeignController
{
    private final PaymentFeignService paymentFeignService;

    public OrderFeignController(PaymentFeignService paymentFeignService)
    {
        this.paymentFeignService = paymentFeignService;
    }

    @GetMapping(value = "get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id)
    {
        log.info("getPaymentById: " + id);
        return paymentFeignService.getPaymentById(id);
    }

    @PostMapping("create")
    public CommonResult<Payment> create(Payment payment)
    {
        log.info("create: " + payment);
        return paymentFeignService.create(payment);
    }
}
