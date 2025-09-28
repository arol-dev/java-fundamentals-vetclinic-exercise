package java.fundamentals.vetclinic.owner.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.fundamentals.vetclinic.owner.DTO.OwnerDTO;
import java.fundamentals.vetclinic.owner.mapper.OwnerMapper;
import java.fundamentals.vetclinic.owner.model.OwnerModel;
import java.fundamentals.vetclinic.owner.repository.OwnerRepository;

@Service
public class CrudOwnerAction {

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    OwnerMapper ownerMapper;

    public OwnerDTO createOwner(OwnerDTO ownerDTO){
        OwnerModel ownerModel = ownerMapper.toModel(ownerDTO);
        OwnerModel savedOwner = ownerRepository.save(ownerModel);
        return ownerMapper.toDTO(savedOwner);
    }
}
