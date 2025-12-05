package com.jdart.VetClinic.service;

import com.jdart.VetClinic.dto.OwnerDTO;
import com.jdart.VetClinic.model.Owner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class OwnerServiceTest {
    @Autowired
    private OwnerService ownerService;

    @Test
    public void testSaveOwner() {
        Owner owner = new Owner();
        owner.setName("Juan");
        OwnerDTO saved = ownerService.saveOwner(owner);
        assertNotNull(saved.getId());
    }
}
