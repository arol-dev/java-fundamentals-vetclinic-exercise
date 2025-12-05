package java.fundamentals.vetclinic.visit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.fundamentals.vetclinic.visit.model.VisitModel;

@Repository
public interface VisitRepository extends JpaRepository<VisitModel, Long> {

    VisitModel findById(long id);
}
