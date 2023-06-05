package vio.vin.cloudproviderpayment8001.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import vio.vin.cloudapicommons.entities.CommonResult;
import vio.vin.cloudapicommons.entities.Payment;
import vio.vin.cloudproviderpayment8001.service.PaymentService;

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

    @PostMapping("create")
    public CommonResult<Payment> create(@RequestBody Payment payment)
    {
        Payment result = paymentService.create(payment);
        if (result != null)
        {
            log.info("create payment: {}", result);
            return new CommonResult<>(200, "success", result);
        } else {
            log.error("create payment failed");
            return new CommonResult<>(500, "fail");
        }
    }

    @GetMapping("get/{id}")
    public CommonResult<Payment> getById(@PathVariable Long id)
    {
        log.info("get payment by id: {}", id);
        return new CommonResult<>(200, "success", paymentService.getById(id));
    }
}
