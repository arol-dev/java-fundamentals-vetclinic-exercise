package com.vetclinic.mapper;

import org.mapstruct.Mapper;
import com.vetclinic.dto.*;
import com.vetclinic.entity.*;

@Mapper(componentModel = "spring")
public interface OwnerMapper {
    OwnerDTO toDTO(Owner o);

    Owner toEntity(OwnerDTO d);
}