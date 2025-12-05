package java.fundamentals.vetclinic.visit.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.fundamentals.vetclinic.visit.DTO.VisitDTO;
import java.fundamentals.vetclinic.visit.mapper.VisitMapper;
import java.fundamentals.vetclinic.visit.model.VisitModel;
import java.fundamentals.vetclinic.visit.repository.VisitRepository;
import java.time.LocalDateTime;

@Service
public class CrudVisitAction {

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private VisitMapper visitMapper;

    public VisitDTO createVisit(VisitDTO visitDTO) {
        VisitModel visitModel = new VisitModel();
        visitMapper.toModel(visitDTO);
        visitModel.setDateTime(LocalDateTime.now());
        VisitModel savedVisit = visitRepository.save(visitModel);
        return visitMapper.toDTO(savedVisit);
    }
}
