package com.example.AOP.serviceimpl;

import com.example.AOP.service.ShipmentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ShipmentServiceImplTest {

    @Autowired
    private ShipmentService shipmentService;

    @Test
    void testOrderPackage(){
        String orderId = shipmentService.orderPackage(-1L);
        log.info("orderId:{}",orderId);
    }

    @Test
    void testTrackPackage(){
        shipmentService.trackPackage(1L);
    }
}
