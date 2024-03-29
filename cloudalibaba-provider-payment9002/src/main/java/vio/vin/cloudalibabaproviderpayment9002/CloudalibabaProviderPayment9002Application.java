package vio.vin.cloudalibabaproviderpayment9002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudalibabaProviderPayment9002Application
{

    public static void main(String[] args)
    {
        SpringApplication.run(CloudalibabaProviderPayment9002Application.class, args);
    }

}
