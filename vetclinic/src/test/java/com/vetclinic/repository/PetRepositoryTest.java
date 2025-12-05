package com.vetclinic.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.vetclinic.model.Owner;
import com.vetclinic.model.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

@DataJpaTest
class PetRepositoryTest {

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
        pet.setName("Sparky");
        pet.setBirthDate(LocalDate.now().minusYears(2));
        pet.setOwner(savedOwner);

        Pet savedPet = petRepository.save(pet);
        Optional<Pet> found = petRepository.findById(savedPet.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("Sparky");
        assertThat(found.get().getOwner().getName()).isEqualTo("Juan");
    }

    @Test
    void testDeleteById() {
        Owner owner = new Owner();
        owner.setName("David");
        owner.setPhone("987654321");
        owner.setAddress("Calle Real 456");
        Owner savedOwner = ownerRepository.save(owner);

        Pet pet = new Pet();
        pet.setName("Tomillo");
        pet.setBirthDate(LocalDate.now().minusYears(1));
        pet.setOwner(savedOwner);
        Pet savedPet = petRepository.save(pet);

        petRepository.deleteById(savedPet.getId());
        Optional<Pet> found = petRepository.findById(savedPet.getId());
        assertThat(found).isNotPresent();
    }
}
