package com.gasnikovma.vk;


import com.gasnikovma.vk.services.Service;
import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CacheTest {
    @Autowired
    private Service service;


    @Test
    public void get() {
        LogCaptor logCaptor = LogCaptor.forClass(Service.class);
        service.getPost(6).block();
        service.getPost(6).block();
        assertEquals(logCaptor.getLogs().size(),1);


    }


}
