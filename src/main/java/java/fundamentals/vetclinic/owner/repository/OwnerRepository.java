package java.fundamentals.vetclinic.owner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.fundamentals.vetclinic.owner.model.OwnerModel;

@Repository
public interface OwnerRepository extends JpaRepository<OwnerModel, Long> {

    OwnerModel findById(long id);
}
