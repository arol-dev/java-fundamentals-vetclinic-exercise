package java.fundamentals.vetclinic.owner.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.fundamentals.vetclinic.owner.DTO.OwnerDTO;
import java.fundamentals.vetclinic.owner.mapper.OwnerMapper;
import java.fundamentals.vetclinic.owner.repository.OwnerRepository;

@Service
public class LoadOwnerAction {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private OwnerMapper ownerMapper;

    public OwnerDTO getOwnerById(long id) {
        return ownerMapper.toDTO(ownerRepository.findById(id));
    }
}
