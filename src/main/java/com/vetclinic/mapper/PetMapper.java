package com.vetclinic.mapper;

import org.mapstruct.*;
import com.vetclinic.dto.*;
import com.vetclinic.entity.*;

@Mapper(componentModel = "spring")
public interface PetMapper {
     PetDTO toDTO(Pet p);

     Pet toEntity(PetDTO d);
}