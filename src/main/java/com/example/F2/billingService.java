package com.example.F2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class billingService {
    @Autowired
    private billingRepository billingRepository;

    public List<Billing> getAllBillings() {
        return billingRepository.findAll();
    }
    public void addBilling(Billing billing) {
        billingRepository.save(billing);
    }
    public void deleteBillingById(Long billingId) {
        Optional<Billing> optionalBilling = billingRepository.findById(billingId);
        if (optionalBilling.isPresent()) {
            billingRepository.delete(optionalBilling.get());
        } else {
            throw new IllegalArgumentException("Billing with ID " + billingId + " not found.");
        }
    }
    public Billing getBillingById(Long id) {
        Optional<Billing> optionalBilling = billingRepository.findById(id);
        return optionalBilling.orElse(null);
    }


}
