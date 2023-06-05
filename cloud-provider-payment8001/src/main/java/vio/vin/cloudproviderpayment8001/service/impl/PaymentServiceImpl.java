package vio.vin.cloudproviderpayment8001.service.impl;

import cn.hutool.core.util.IdUtil;
import org.springframework.stereotype.Service;
import vio.vin.cloudapicommons.entities.Payment;
import vio.vin.cloudproviderpayment8001.mapper.PaymentMapper;
import vio.vin.cloudproviderpayment8001.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService
{
    private final PaymentMapper paymentMapper;

    public PaymentServiceImpl(PaymentMapper paymentMapper)
    {
        this.paymentMapper = paymentMapper;
    }

    @Override
    public Payment create(Payment payment)
    {
        long id = IdUtil.getSnowflake().nextId();
        payment.setId(id);
        int insert = paymentMapper.insert(payment);
        if (insert > 0)
        {
            return payment;
        }
        return null;
    }

    @Override
    public Payment getById(Long id)
    {
        return paymentMapper.selectById(id);
    }
}
