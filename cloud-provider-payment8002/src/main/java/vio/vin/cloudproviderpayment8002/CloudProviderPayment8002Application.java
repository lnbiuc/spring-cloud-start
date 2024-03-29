package vio.vin.cloudproviderpayment8002;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("vio.vin.cloudproviderpayment8002.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
public class CloudProviderPayment8002Application {

	public static void main(String[] args) {
		SpringApplication.run(CloudProviderPayment8002Application.class, args);
	}

}
