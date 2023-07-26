package vio.vin.cloudgatewaygateway9527.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig
{
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder)
    {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_vio_time", r -> r.path("/blog/time").uri("https://blog.vio.vin/api/articles/time")).build();
        routes.route("path_route_vio_filing", r -> r.path("/blog/filing").uri("https://blog.vio.vin/api/filing/filing")).build();

        return routes.build();
    }
}
