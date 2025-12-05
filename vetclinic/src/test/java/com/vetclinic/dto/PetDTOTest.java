package com.vetclinic.dto;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PetDTOTest {

    @Test
    void testPetDTOGettersAndSetters() {
        PetDTO pet = new PetDTO();

        pet.setId(1L);
        pet.setName("Fido");
        pet.setBirthDate(LocalDate.of(2020, 1, 1));
        pet.setType("Dog");
        pet.setOwnerId(10L);

        assertEquals(1L, pet.getId());
        assertEquals("Fido", pet.getName());
        assertEquals(LocalDate.of(2020, 1, 1), pet.getBirthDate());
        assertEquals("Dog", pet.getType());
        assertEquals(10L, pet.getOwnerId());

        PetDTO pet2 = new PetDTO(2L, "Whiskers", "Gato", LocalDate.of(2019, 5, 10), 20L);
        assertEquals(2L, pet2.getId());
        assertEquals("Whiskers", pet2.getName());
        assertEquals(LocalDate.of(2019, 5, 10), pet2.getBirthDate());
        assertEquals("Gato", pet2.getType());
        assertEquals(20L, pet2.getOwnerId());
    }
}

