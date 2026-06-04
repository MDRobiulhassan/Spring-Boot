package com.example.AOP.serviceimpl;

import com.example.AOP.service.ShipmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ShipmentServiceImpl implements ShipmentService {
    @Override
    public String orderPackage(Long orderId) {
        try {
            log.info("Processing the order.....");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Error while processing the order: {}", e.getMessage());
        }

        return "Order placed successfully for order id: " + orderId;
    }

    @Override
    public String trackPackage(Long orderId) {
        try {
            log.info("Tracking the package.....");
            Thread.sleep(500);
            throw new RuntimeException("Exception while tracking the package");
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
