package vio.vin.cloudalibabaproviderpayment9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudalibabaProviderPayment9001Application
{

    public static void main(String[] args)
    {
        SpringApplication.run(CloudalibabaProviderPayment9001Application.class, args);
    }

}
