package vio.vin.cloudproviderpayment8002.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import vio.vin.cloudapicommons.entities.CommonResult;
import vio.vin.cloudapicommons.entities.Payment;
import vio.vin.cloudproviderpayment8002.service.PaymentService;

@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController
{
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService)
    {
        this.paymentService = paymentService;
    }

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("create")
    public CommonResult<Payment> create(@RequestBody Payment payment)
    {
        Payment result = paymentService.create(payment);
        if (result != null)
        {
            log.info("create payment {} : {}", serverPort, result);
            return new CommonResult<>(200, "success_" + serverPort, result);
        } else
        {
            log.error("create payment failed {}" , serverPort);
            return new CommonResult<>(500, "fail_" + serverPort);
        }
    }

    @GetMapping("get/{id}")
    public CommonResult<Payment> getById(@PathVariable Long id)
    {
        log.info("get payment by id {} : {}", serverPort, id);
        return new CommonResult<>(200, "success_" + serverPort, paymentService.getById(id));
    }
}
