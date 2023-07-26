package vio.vin.cloudproviderhygtrixpayment8001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker // 开启服务降级
public class CloudProviderHystrixPayment8001Application
{

    public static void main(String[] args)
    {
        SpringApplication.run(CloudProviderHystrixPayment8001Application.class, args);
    }

}
