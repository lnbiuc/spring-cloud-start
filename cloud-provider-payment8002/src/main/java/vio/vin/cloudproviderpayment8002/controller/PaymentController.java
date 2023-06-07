package vio.vin.cloudproviderpayment8002.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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

    private final DiscoveryClient discoveryClient;

    public PaymentController(PaymentService paymentService, DiscoveryClient discoveryClient)
    {
        this.paymentService = paymentService;
        this.discoveryClient = discoveryClient;
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

    @GetMapping("discovery")
    public Object discovery()
    {
        discoveryClient.getServices().forEach(log::info);
        discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE").forEach(instance -> log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri()));
        return discoveryClient;
    }
}
