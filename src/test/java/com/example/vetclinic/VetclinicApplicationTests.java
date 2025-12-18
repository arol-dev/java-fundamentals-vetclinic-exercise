package com.example.vetclinic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.vetclinic.dto.OwnerDTO;
import com.example.vetclinic.dto.PetDTO;
import com.example.vetclinic.dto.VisitDTO;
import com.example.vetclinic.entities.Owner;
import com.example.vetclinic.entities.Pet;
import com.example.vetclinic.entities.Visit;
import com.example.vetclinic.repositories.OwnerRpository;
import com.example.vetclinic.repositories.VisitRpository;
import com.example.vetclinic.repositories.PetRepository;
import com.example.vetclinic.servicies.OwnerService;
import com.example.vetclinic.servicies.OwnerServiceImpl;
import com.example.vetclinic.servicies.PetService;
import com.example.vetclinic.servicies.PetServiceImpl;
import com.example.vetclinic.servicies.VisitService;
import com.example.vetclinic.servicies.VisitServiceImpl;


@ExtendWith(MockitoExtension.class)
class VetclinicApplicationTests {

  @Mock
  private OwnerRpository ownerRpository;

  @Mock
  private PetRepository petRepository;

  @Mock
  private VisitRpository visitRepository;

  @InjectMocks
  private OwnerServiceImpl ownerService;

  @InjectMocks
  private PetServiceImpl petService;

  @InjectMocks
  private VisitServiceImpl visitService;

  @Test
  void createOwner_ok() {
    Owner owner = new Owner();
    owner.setId(1L);
    owner.setName("Ana");
    owner.setPhone("123");
    owner.setAddress("Calle 1");

    when(ownerRpository.save(any(Owner.class))).thenReturn(owner);

    OwnerDTO dto = new OwnerDTO(null, "Ana", "123", "Calle 1");
    OwnerDTO result = ownerService.create(dto);

    assertNotNull(result.id());
    assertEquals("Ana", result.name());
  }

  @Test
  void createPet_ok() {
    Long ownerId = 1L;

    Owner owner = new Owner();
    owner.setId(ownerId);

    when(ownerRpository.findById(ownerId)).thenReturn(Optional.of(owner));

    Pet pet = new Pet();
    pet.setId(10L);
    pet.setName("Bobby");
    pet.setType("DOG");
    pet.setBirthDate(LocalDate.of(2020, 1, 1));
    pet.setOwner(owner);

    when(petRepository.save(any(Pet.class))).thenReturn(pet);

    PetDTO dto = new PetDTO(null, "Bobby", "DOG", LocalDate.of(2020, 1, 1));
    PetDTO result = petService.create(ownerId, dto);

    assertNotNull(result.id());
    assertEquals("Bobby", result.name());
  }

  @Test
  void createVisit_ok() {
    Long petId = 10L;

    Pet pet = new Pet();
    pet.setId(petId);

    when(petRepository.findById(petId)).thenReturn(Optional.of(pet));

    Visit visit = new Visit();
    visit.setId(100L);
    visit.setDate(LocalDate.of(2025, 1, 1));
    visit.setReason("Vacuna");
    visit.setPet(pet);

    when(visitRepository.save(any(Visit.class))).thenReturn(visit);

    VisitDTO dto = new VisitDTO(null, LocalDate.of(2025, 1, 1), "Vacuna", petId);
    VisitDTO result = visitService.create(dto);

    assertNotNull(result.id());
    assertEquals("Vacuna", result.reason());
    assertEquals(petId, result.petId());
  }
}
