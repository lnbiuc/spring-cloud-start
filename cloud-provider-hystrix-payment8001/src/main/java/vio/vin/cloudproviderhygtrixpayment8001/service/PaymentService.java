package vio.vin.cloudproviderhygtrixpayment8001.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService
{
    public String paymentInfo_OK(Integer id)
    {
        return "OK__线程池:  " + Thread.currentThread().getName() + " " + id;
    }

    public String paymentInfo_TimeOut(Integer id)
    {
        try
        {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return "TIME_OUT__线程池:  " + Thread.currentThread().getName() + " " + id + "  耗时(秒): 2";
    }
}
