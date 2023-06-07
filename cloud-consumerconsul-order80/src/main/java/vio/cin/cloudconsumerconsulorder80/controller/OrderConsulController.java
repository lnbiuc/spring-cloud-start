package vio.cin.cloudconsumerconsulorder80.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderConsulController
{
    public static final String INVOKE_URL = "http://consul-provider-payment";

    private final RestTemplate restTemplate;

    public OrderConsulController(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo()
    {
        return restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
    }
}
