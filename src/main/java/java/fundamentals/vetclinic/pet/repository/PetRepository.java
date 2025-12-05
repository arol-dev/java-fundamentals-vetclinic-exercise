package java.fundamentals.vetclinic.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.fundamentals.vetclinic.pet.model.PetModel;


@Repository
public interface PetRepository extends JpaRepository<PetModel, Long> {

    PetModel findById(long id);

}
