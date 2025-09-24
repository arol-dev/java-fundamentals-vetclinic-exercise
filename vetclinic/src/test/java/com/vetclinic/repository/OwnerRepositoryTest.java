package com.vetclinic.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.vetclinic.model.Owner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
class OwnerRepositoryTest {

    @Autowired
    private OwnerRepository ownerRepository;

    @Test
    void testSaveAndFindById() {
        Owner owner = new Owner();
        owner.setName("Juan");
        owner.setPhone("123456789");
        owner.setAddress("Calle Falsa 123");

        Owner saved = ownerRepository.save(owner);
        Optional<Owner> found = ownerRepository.findById(saved.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("Juan");
        assertThat(found.get().getPhone()).isEqualTo("123456789");
    }

    @Test
    void testDeleteById() {
        Owner owner = new Owner();
        owner.setName("Maria");
        owner.setPhone("987654321");
        owner.setAddress("Calle Real 456");

        Owner saved = ownerRepository.save(owner);
        ownerRepository.deleteById(saved.getId());

        Optional<Owner> found = ownerRepository.findById(saved.getId());
        assertThat(found).isNotPresent();
    }

    @Test
    void testFindAll() {
        Owner owner1 = new Owner();
        owner1.setName("A");
        owner1.setPhone("111");
        owner1.setAddress("Addr1");

        Owner owner2 = new Owner();
        owner2.setName("B");
        owner2.setPhone("222");
        owner2.setAddress("Addr2");

        ownerRepository.save(owner1);
        ownerRepository.save(owner2);

        assertThat(ownerRepository.findAll()).hasSize(2);
    }
}
