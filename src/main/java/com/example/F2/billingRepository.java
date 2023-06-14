package com.example.F2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface billingRepository extends JpaRepository<Billing, Long> {
}
