package vio.vin.cloudconsumerfeignhystrixorder80.fallback;

import org.springframework.stereotype.Component;
import vio.vin.cloudconsumerfeignhystrixorder80.service.PaymentHystrixService;

@Component
public class FallbackFactory implements PaymentHystrixService
{
    @Override
    public String paymentInfo_OK(Integer id)
    {
        return "-----PaymentFallbackService fall back-paymentInfo_OK, o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id)
    {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut, o(╥﹏╥)o";
    }
}
