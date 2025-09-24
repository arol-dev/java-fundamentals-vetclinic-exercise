package com.vetclinic.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OwnerDTOTest {

    @Test
    void testOwnerDTOGettersAndSetters() {
        OwnerDTO owner = new OwnerDTO();

        owner.setId(1L);
        owner.setName("Alice");
        owner.setPhone("123456789");
        owner.setAddress("Calle Falsa 123");

        assertEquals(1L, owner.getId());
        assertEquals("Alice", owner.getName());
        assertEquals("123456789", owner.getPhone());
        assertEquals("Calle Falsa 123", owner.getAddress());

        OwnerDTO owner2 = new OwnerDTO(2L, "Bob", "987654321", "Calle Verdadera 456");
        assertEquals(2L, owner2.getId());
        assertEquals("Bob", owner2.getName());
        assertEquals("987654321", owner2.getPhone());
        assertEquals("Calle Verdadera 456", owner2.getAddress());
    }
}
