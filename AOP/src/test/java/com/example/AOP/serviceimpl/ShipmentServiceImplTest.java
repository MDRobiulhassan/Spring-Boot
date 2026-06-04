package com.example.AOP.serviceimpl;

import com.example.AOP.service.ShipmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShipmentServiceImplTest {

    @Autowired
    private ShipmentService shipmentService;

    @Test
    void testOrderPackage(){
        shipmentService.orderPackage(1L);
    }

    @Test
    void testTrackPackage(){
        shipmentService.trackPackage(1L);
    }
}
