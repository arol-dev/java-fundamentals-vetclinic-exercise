package com.vetclinic.mapper;

import org.mapstruct.*;
import com.vetclinic.dto.*;
import com.vetclinic.entity.*;

@Mapper(componentModel = "spring")
public interface VisitMapper {
    VisitDTO toDTO(Visit v);

    Visit toEntity(VisitDTO d);
}