package com.acuadrado.vetclinic.mapper;

import com.acuadrado.vetclinic.dto.OwnerDto;
import com.acuadrado.vetclinic.entity.Owner;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper {

    public OwnerDto toDto(Owner owner) {
        OwnerDto dto = new OwnerDto();
        dto.setId(owner.getId());
        dto.setName(owner.getName());
        dto.setPhone(owner.getPhone());
        dto.setAddress(owner.getAddress());
        return dto;
    }

    public Owner toEntity(OwnerDto dto) {
        Owner owner = new Owner();
        owner.setId(dto.getId());
        owner.setName(dto.getName());
        owner.setPhone(dto.getPhone());
        owner.setAddress(dto.getAddress());
        return owner;
    }
}
