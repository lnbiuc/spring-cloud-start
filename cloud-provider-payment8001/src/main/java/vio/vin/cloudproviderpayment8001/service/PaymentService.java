package vio.vin.cloudproviderpayment8001.service;

import vio.vin.cloudapicommons.entities.Payment;


public interface PaymentService
{
    Payment create(Payment payment);

    Payment getById(Long id);
}
