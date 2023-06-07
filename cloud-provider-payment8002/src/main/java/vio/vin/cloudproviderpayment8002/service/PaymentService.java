package vio.vin.cloudproviderpayment8002.service;

import vio.vin.cloudapicommons.entities.Payment;


public interface PaymentService
{
    Payment create(Payment payment);

    Payment getById(Long id);
}
