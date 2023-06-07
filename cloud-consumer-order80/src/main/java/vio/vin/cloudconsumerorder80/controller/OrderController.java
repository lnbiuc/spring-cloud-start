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

    private final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @PostMapping("create")
    public CommonResult<Payment> create(Payment payment)
    {
        log.info("create payment: {}", payment);
        return template.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("get/{id}")
    public CommonResult<Payment> get(@PathVariable Long id)
    {
        log.info("get payment by id: {}", id);
        return template.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
}
