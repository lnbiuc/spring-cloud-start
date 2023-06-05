package vio.vin.cloudconsumerorder80.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import vio.vin.cloudapicommons.entities.CommonResult;
import vio.vin.cloudapicommons.entities.Payment;

@RestController
@RequestMapping("consumer")
@Slf4j
public class OrderController
{

    private final RestTemplate template;

    public OrderController(RestTemplate template)
    {
        this.template = template;
    }

    @PostMapping("create")
    public CommonResult<Payment> create(Payment payment)
    {
        log.info("create payment: {}", payment);
        return template.postForObject("http://localhost:8001/payment/create", payment, CommonResult.class);
    }

    @GetMapping("get/{id}")
    public CommonResult<Payment> get(@PathVariable Long id)
    {
        log.info("get payment by id: {}", id);
        return template.getForObject("http://localhost:8001/payment/get/" + id, CommonResult.class);
    }
}
