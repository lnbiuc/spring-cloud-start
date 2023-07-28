package vio.vin.cloudstreamrabbitmqprovider8801.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vio.vin.cloudstreamrabbitmqprovider8801.service.IMessageProvider;

@RestController
@Slf4j
public class SendMessageController
{
    private final IMessageProvider provider;

    public SendMessageController(IMessageProvider provider)
    {
        this.provider = provider;
    }

    @GetMapping("/sendMessage")
    public String send()
    {
        return provider.send();
    }
}
