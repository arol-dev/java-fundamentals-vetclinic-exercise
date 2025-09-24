package com.vetclinic.dto;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VisitDTOTest {

    @Test
    void testVisitDTOGettersAndSetters() {
        VisitDTO visit = new VisitDTO();

        visit.setId(1L);
        visit.setDate(LocalDate.of(2023, 9, 24));
        visit.setReason("Checkup");
        visit.setPetId(5L);

        assertEquals(1L, visit.getId());
        assertEquals(LocalDate.of(2023, 9, 24), visit.getDate());
        assertEquals("Checkup", visit.getReason());
        assertEquals(5L, visit.getPetId());

        VisitDTO visit2 = new VisitDTO(2L, LocalDate.of(2024, 1, 15), "Vaccination", 10L);
        assertEquals(2L, visit2.getId());
        assertEquals(LocalDate.of(2024, 1, 15), visit2.getDate());
        assertEquals("Vaccination", visit2.getReason());
        assertEquals(10L, visit2.getPetId());
    }
}
