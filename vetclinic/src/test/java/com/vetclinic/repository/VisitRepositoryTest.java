package com.vetclinic.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.vetclinic.model.Owner;
import com.vetclinic.model.Pet;
import com.vetclinic.model.Visit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

@DataJpaTest
class VisitRepositoryTest {

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Test
    void testSaveAndFindById() {
        Owner owner = new Owner();
        owner.setName("Juan");
        owner.setPhone("123456789");
        owner.setAddress("Calle Falsa 123");
        Owner savedOwner = ownerRepository.save(owner);

        Pet pet = new Pet();
        pet.setName("Firulais");
        pet.setBirthDate(LocalDate.now().minusYears(2));
        pet.setOwner(savedOwner);
        Pet savedPet = petRepository.save(pet);

        Visit visit = new Visit();
        visit.setDate(LocalDate.now());
        visit.setReason("Vacunación");
        visit.setPet(savedPet);

        Visit savedVisit = visitRepository.save(visit);
        Optional<Visit> found = visitRepository.findById(savedVisit.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getReason()).isEqualTo("Vacunación");
        assertThat(found.get().getPet().getName()).isEqualTo("Firulais");
    }

    @Test
    void testDeleteById() {
        Owner owner = new Owner();
        owner.setName("Maria");
        owner.setPhone("987654321");
        owner.setAddress("Calle Real 456");
        Owner savedOwner = ownerRepository.save(owner);

        Pet pet = new Pet();
        pet.setName("Pelusa");
        pet.setBirthDate(LocalDate.now().minusYears(1));
        pet.setOwner(savedOwner);
        Pet savedPet = petRepository.save(pet);

        Visit visit = new Visit();
        visit.setDate(LocalDate.now());
        visit.setReason("Revisión general");
        visit.setPet(savedPet);
        Visit savedVisit = visitRepository.save(visit);

        visitRepository.deleteById(savedVisit.getId());
        Optional<Visit> found = visitRepository.findById(savedVisit.getId());
        assertThat(found).isNotPresent();
    }
}
