package vio.vin.cloudconsumerorder80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import vio.vin.rule.RibbonRule;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = RibbonRule.class)
public class CloudConsumerOrder80Application
{

    public static void main(String[] args)
    {
        SpringApplication.run(CloudConsumerOrder80Application.class, args);
    }

}
